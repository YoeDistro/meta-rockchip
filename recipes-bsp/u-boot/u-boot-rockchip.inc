BL31:rockchip:aarch64 = "${DEPLOY_DIR_IMAGE}/bl31-${SOC_FAMILY}.elf"
# SOC_FAMILY for RK3588S is rk3588s but it should use the binaries from rk3588
BL31:rk3588s = "${DEPLOY_DIR_IMAGE}/bl31-rk3588.elf"
EXTRA_OEMAKE:append:rockchip:aarch64 = " BL31=${BL31}"

TFA_DEPENDS ??= ""
TFA_DEPENDS:rockchip:aarch64 = " trusted-firmware-a:do_deploy"
do_compile[depends] .= "${TFA_DEPENDS}"

# No open-source TPL (yet)
EXTRA_OEMAKE:append:rk3308 = " ROCKCHIP_TPL=${DEPLOY_DIR_IMAGE}/ddr-rk3308.bin"
EXTRA_OEMAKE:append:rk3568 = " ROCKCHIP_TPL=${DEPLOY_DIR_IMAGE}/ddr-rk3568.bin"
EXTRA_OEMAKE:append:rk3588s = " ROCKCHIP_TPL=${DEPLOY_DIR_IMAGE}/ddr-rk3588.bin"

INIT_FIRMWARE_DEPENDS ??= ""
INIT_FIRMWARE_DEPENDS:rk3308 = " rockchip-rkbin:do_deploy"
INIT_FIRMWARE_DEPENDS:rk3568 = " rockchip-rkbin:do_deploy"
INIT_FIRMWARE_DEPENDS:rk3588s = " rockchip-rkbin:do_deploy"
do_compile[depends] .= "${INIT_FIRMWARE_DEPENDS}"
