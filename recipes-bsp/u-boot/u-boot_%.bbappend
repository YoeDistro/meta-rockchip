FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:rk-u-boot-env = " file://rockchip-enable-environment-mmc.cfg"
SRCREV:rk-u-boot-env = "cdfcc37428e06f4730ab9a17cc084eeb7676ea1a"

DEPENDS:append:rk3308 = " u-boot-tools-native"
DEPENDS:append:rock-pi-4 = " gnutls-native"
DEPENDS:append:rk-u-boot-env = " u-boot-mkenvimage-native"

EXTRA_OEMAKE:append:px30 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-px30.elf"
EXTRA_OEMAKE:append:rk3308 = " \
	BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3308.elf \
	ROCKCHIP_TPL=${DEPLOY_DIR_IMAGE}/ddr-rk3308.bin \
	"
EXTRA_OEMAKE:append:rk3328 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3328.elf"
EXTRA_OEMAKE:append:rk3399 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3399.elf"
EXTRA_OEMAKE:append:rk3568 = " \
	BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3568.elf \
	ROCKCHIP_TPL=${DEPLOY_DIR_IMAGE}/ddr-rk3568.bin \
	"
EXTRA_OEMAKE:append:rk3588s = " \
	BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3588.elf \
	ROCKCHIP_TPL=${DEPLOY_DIR_IMAGE}/ddr-rk3588.bin \
	"

INIT_FIRMWARE_DEPENDS ??= ""
INIT_FIRMWARE_DEPENDS:px30 = " trusted-firmware-a:do_deploy"
INIT_FIRMWARE_DEPENDS:rk3308 = " ${@bb.utils.contains('RKBIN_RK3308_LATEST', '1', 'rockchip-rkbin', 'rk3308-rkbin', d)}:do_deploy"
INIT_FIRMWARE_DEPENDS:rk3328 = " trusted-firmware-a:do_deploy"
INIT_FIRMWARE_DEPENDS:rk3399 = " trusted-firmware-a:do_deploy"
INIT_FIRMWARE_DEPENDS:rk3568 = " rockchip-rkbin:do_deploy"
INIT_FIRMWARE_DEPENDS:rk3588s = " rockchip-rkbin:do_deploy"
do_compile[depends] .= "${INIT_FIRMWARE_DEPENDS}"

do_compile:append:rock2-square () {
	# copy to default search path
	if [ "${SPL_BINARY}" = "u-boot-spl-dtb.bin" ]; then
		cp ${B}/spl/${SPL_BINARY} ${B}
	fi
}

python rk_no_env() {
    if bb.utils.contains('MACHINE_FEATURES', 'rk-u-boot-env', True, False, d):
        bb.warn("the rk-u-boot-env MACHINE_FEATURE is not supported for this build")
}

rk_generate_env() {
	if [ ! -f "${B}/.config" ]; then
		echo "U-Boot .config not found, can't determine environment size"
		return 1
	fi
	cat ${B}/.config | grep "^CONFIG_ENV_SIZE=" > /dev/null
	if [ $? -ne 0 ]; then
		echo "can not find CONFIG_ENV_SIZE value in U-Boot .config"
		return 1
	fi

	UBOOT_ENV_SIZE="$(cat ${B}/.config | grep "^CONFIG_ENV_SIZE=" | cut -d'=' -f2)"

	# linux user-space U-Boot env config file
	echo "/dev/disk/by-partlabel/uboot_env 0x0000 ${UBOOT_ENV_SIZE}" > ${WORKDIR}/fw_env.config

	# convert text-based environment to binary suitable for image
	if [ "${@bb.utils.to_boolean(d.getVar('RK_IMAGE_INCLUDES_UBOOT_ENV'), False)}" = "True" ]; then
		if [ ! -f ${B}/u-boot-initial-env ]; then
			echo "initial, text-formatted U-Boot environment file \"${B}/u-boot-initial-env\" not found"
			return 1
		fi
		mkenvimage -s ${UBOOT_ENV_SIZE} ${B}/u-boot-initial-env -o ${WORKDIR}/u-boot.env
	fi
}
do_compile[postfuncs] += "${@'rk_generate_env' if 'rk-u-boot-env' in d.getVar('MACHINEOVERRIDES').split(':') else 'rk_no_env'}"

do_deploy:append:rk-u-boot-env() {
	if [ -f ${WORKDIR}/u-boot.env -a "${@bb.utils.to_boolean(d.getVar('RK_IMAGE_INCLUDES_UBOOT_ENV'),False)}" = "True" ]; then
		install -d ${DEPLOYDIR}
		install -m 0644 ${WORKDIR}/u-boot.env ${DEPLOYDIR}
	fi
}
