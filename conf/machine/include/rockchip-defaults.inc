# meta-rockchip default settings
MACHINEOVERRIDES =. "${@bb.utils.contains('ROCKCHIP_CLOSED_TPL', '1', 'closed-tpl:', '', d)}"
MACHINEOVERRIDES =. "rockchip:"

# kernel
# RK_KERNEL_FITIMAGE needs to be set before the next "require ..."
RK_KERNEL_FITIMAGE ?= "True"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto"
KCONFIG_MODE ?= "alldefconfig"
MACHINE_ESSENTIAL_EXTRA_RDEPENDS_KERNEL = "kernel-devicetree"
MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "${MACHINE_ESSENTIAL_EXTRA_RDEPENDS_KERNEL}"
require ${@ 'conf/machine/include/rockchip-fitimage.inc' if bb.utils.to_boolean(d.getVar('RK_KERNEL_FITIMAGE')) else ''}
KERNEL_IMAGETYPE ?= "zImage"

# xserver
XSERVER = " \
	xserver-xorg \
	xserver-xorg-utils \
	xserver-xorg-xvfb \
	xserver-xorg-extension-glx \
	xserver-xorg-module-libwfb \
	xserver-xorg-module-exa \
	xf86-video-modesetting \
	xf86-input-evdev \
	"

# misc
SERIAL_CONSOLES ?= "1500000;ttyS2"
RK_CONSOLE_BAUD ?= "${@d.getVar('SERIAL_CONSOLES').split(';')[0]}"
RK_CONSOLE_DEVICE ?= "${@d.getVar('SERIAL_CONSOLES').split(';')[1].split()[0]}"

# Discoverable Partitions Specification (DPS)
ROOT_DPS:arm = "69dad710-2ce4-4e3c-b16c-21a1d49abed3"
ROOT_DPS:aarch64 = "b921b045-1df0-41c3-af44-4c6f280d3fae"
