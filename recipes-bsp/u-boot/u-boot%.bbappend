do_compile:append:rock2-square () {
	# copy to default search path
	if [ "${SPL_BINARY}" = "u-boot-spl-dtb.bin" ]; then
		cp ${B}/spl/${SPL_BINARY} ${B}
	fi
}

ATF_DEPENDS ??= ""

EXTRA_OEMAKE:append:rk3588s = " \
	BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3588.elf \
	ROCKCHIP_TPL=${DEPLOY_DIR_IMAGE}/ddr-rk3588.bin \
	"
ATF_DEPENDS:rk3588s = " rockchip-rkbin:do_deploy"

EXTRA_OEMAKE:append:rk3399 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3399.elf"
ATF_DEPENDS:rk3399 = " trusted-firmware-a:do_deploy"
EXTRA_OEMAKE:append:rk3328 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3328.elf"
ATF_DEPENDS:rk3328 = " trusted-firmware-a:do_deploy"
EXTRA_OEMAKE:append:px30 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-px30.elf"
ATF_DEPENDS:px30 = " trusted-firmware-a:do_deploy"

do_compile[depends] .= "${ATF_DEPENDS}"

