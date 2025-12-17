# Copyright (C) 2015 Romain Perier
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY  = "rk3188"
RK_KERNEL_FITIMAGE ?= "False"

require conf/machine/include/soc-family.inc
require conf/machine/include/rockchip-defaults.inc
require conf/machine/include/arm/armv7a/tune-cortexa9.inc

SERIAL_CONSOLES = "115200;ttyFIQ0"

KBUILD_DEFCONFIG = "multi_v7_defconfig"

ENABLE_STATELESS_VPU_GST ?= "1"
