SOC_FAMILY = "rk3308"

DEFAULTTUNE ?= "cortexa35-crypto"

ROCKCHIP_CLOSED_TPL ?= "1"

require conf/machine/include/soc-family.inc
require conf/machine/include/rockchip-defaults.inc
require conf/machine/include/arm/armv8a/tune-cortexa35.inc
require conf/machine/include/rockchip-wic.inc

SERIAL_CONSOLES = "1500000;ttyS0"

KBUILD_DEFCONFIG ?= "defconfig"

UBOOT_SUFFIX ?= "itb"
UBOOT_ENTRYPOINT ?= "0x06000000"

PREFERRED_PROVIDER_trusted-firmware-a = "${@bb.utils.contains('RKBIN_RK3308_LATEST', '1', 'rockchip-rkbin-tf-a', 'rk3308-rkbin', d)}"
PREFERRED_PROVIDER_rockchip-rkbin-ddr = "${@bb.utils.contains('RKBIN_RK3308_LATEST', '1', 'rockchip-rkbin-ddr', 'rk3308-rkbin', d)}"
PREFERRED_PROVIDER_rockchip-rkbin-tf-a = "${@bb.utils.contains('RKBIN_RK3308_LATEST', '1', 'rockchip-rkbin-tf-a', 'rk3308-rkbin', d)}"
PREFERRED_PROVIDER_rockchip-rkbin-optee-os = "${@bb.utils.contains('RKBIN_RK3308_LATEST', '1', 'rockchip-rkbin-optee-os', 'rk3308-rkbin', d)}"
