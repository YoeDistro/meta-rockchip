MACHINEOVERRIDES =. "radxa-zero-3:"

require conf/machine/include/rk3566.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-torvalds-next"
MACHINE_EXTRA_RRECOMMENDS += "kernel-modules"

UBOOT_MACHINE = "radxa-zero-3-rk3566_defconfig"
