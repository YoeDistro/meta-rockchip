#Copyright (C) Trifork A/S 2024
# Released under the MIT license (see COPYING.MIT for the terms)

# Common override for basing a SOQuartz design on
# https://wiki.pine64.org/wiki/SOQuartz

MACHINEOVERRIDES =. "soquartz:"

require conf/machine/include/rk3566.inc

# A machine using this baseboard could use these options or overload them
# UBOOT_MACHINE ?= "soquartz-cm4-rk3566_defconfig"
# KERNEL_DEVICETREE ?= "rockchip/rk3566-soquartz-cm4.dtb"

MACHINE_EXTRA_RRECOMMENDS += "kernel-modules"
