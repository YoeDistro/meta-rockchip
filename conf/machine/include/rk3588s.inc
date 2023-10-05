MACHINEOVERRIDES =. "rk3588s:"
DEFAULTTUNE ?= "cortexa76-cortexa55-crypto"

require conf/machine/include/arm/armv8-2a/tune-cortexa76-cortexa55.inc
require conf/machine/include/rockchip-defaults.inc
require conf/machine/include/rockchip-wic.inc

KBUILD_DEFCONFIG ?= "defconfig"
KERNEL_CLASSES = "kernel-fitimage"
KERNEL_IMAGETYPE = "fitImage"

PREFERRED_PROVIDER_trusted-firmware-a = "rockchip-rkbin"
PREFERRED_PROVIDER_optee-os = "rockchip-rkbin"

UBOOT_SUFFIX ?= "itb"
UBOOT_ENTRYPOINT ?= "0x06000000"
