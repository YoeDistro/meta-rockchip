# Copyright (C) 2015 Romain Perier
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY = "rk3288"
RK_KERNEL_FITIMAGE ?= "False"

require conf/machine/include/soc-family.inc
require conf/machine/include/rockchip-defaults.inc
require conf/machine/include/arm/armv7a/tune-cortexa17.inc

SERIAL_CONSOLES = "115200;ttyS2"

KBUILD_DEFCONFIG ?= "multi_v7_defconfig"

# Set UBOOT_SUFFIX to "itb" if you are going to use OP-TEE
UBOOT_SUFFIX ?= "img"

ENABLE_STATELESS_VPU_GST ?= "1"
