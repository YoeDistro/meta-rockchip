# Copyright (C) 2020 Garmin Ltd. or its subsidaries
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY = "rk3399"

DEFAULTTUNE ?= "cortexa72-cortexa53-crypto"

require conf/machine/include/soc-family.inc
require conf/machine/include/rockchip-defaults.inc
require conf/machine/include/arm/armv8a/tune-cortexa72-cortexa53.inc
require conf/machine/include/rockchip-wic.inc

KBUILD_DEFCONFIG ?= "defconfig"

TFA_PLATFORM = "rk3399"
TFA_BUILD_TARGET = "bl31"

UBOOT_SUFFIX ?= "itb"
UBOOT_ENTRYPOINT ?= "0x06000000"

ENABLE_STATELESS_VPU_GST ?= "1"
