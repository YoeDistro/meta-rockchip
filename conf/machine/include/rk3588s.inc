SOC_FAMILY ?= "rk3588s"
MACHINEOVERRIDES =. "rk3588s:"
DEFAULTTUNE ?= "cortexa76-cortexa55-crypto"

ROCKCHIP_CLOSED_TPL ?= "1"

require conf/machine/include/rockchip-defaults.inc
require conf/machine/include/arm/armv8-2a/tune-cortexa76-cortexa55.inc
require conf/machine/include/rockchip-wic.inc

KBUILD_DEFCONFIG ?= "defconfig"

PREFERRED_PROVIDER_trusted-firmware-a = "rockchip-rkbin-tf-a"
PREFERRED_PROVIDER_optee-os = "rockchip-rkbin-optee-os"

UBOOT_SUFFIX ?= "itb"
UBOOT_ENTRYPOINT ?= "0x06000000"

TFA_PLATFORM = "rk3588"
TFA_BUILD_TARGET = "bl31"

ENABLE_STATELESS_VPU_GST ?= "1"
