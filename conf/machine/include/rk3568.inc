SOC_FAMILY = "rk3568"

DEFAULTTUNE ?= "cortexa55"

ROCKCHIP_CLOSED_TPL ?= "1"

require conf/machine/include/soc-family.inc
require conf/machine/include/rockchip-defaults.inc
require conf/machine/include/arm/armv8-2a/tune-cortexa55.inc
require conf/machine/include/rockchip-wic.inc

KBUILD_DEFCONFIG ?= "defconfig"
KERNEL_FEATURES:append:rk3568 = " bsp/rockchip/remove-non-rockchip-arch-arm64.scc"
KERNEL_CLASSES = "kernel-fitimage"
KERNEL_IMAGETYPE ?= "fitImage"

PREFERRED_PROVIDER_trusted-firmware-a = "rockchip-rkbin-tf-a"
PREFERRED_PROVIDER_optee-os = "rockchip-rkbin-optee-os"

UBOOT_SUFFIX ?= "itb"
UBOOT_ENTRYPOINT ?= "0x06000000"

TFA_PLATFORM = "rk3568"
TFA_BUILD_TARGET = "bl31"

ENABLE_STATELESS_VPU_GST ?= "1"
