# common meta-rockchip wic/wks items

SPL_BINARY ?= "idbloader.img"

IMAGE_FSTYPES += "wic wic.bmap"
WKS_FILE = "rockchip.wks"
WKS_FILE_DEPENDS ?= " \
	mtools-native \
	dosfstools-native \
	e2fsprogs-native \
	virtual/bootloader \
	virtual/kernel \
	"
# KERNEL_DEVICETREE follows the pattern of 'rockchip/${SOC_FAMILY}-${BOARD}.dtb'
# but is placed in the deploy directory as simply '${SOC_FAMILY}-${BOARD}.dtb'
# therefore we have to strip off the 'rockchip/' for IMAGE_BOOT_FILES
NONFITDT="${@d.getVar('KERNEL_DEVICETREE').split('/')[1]}"
IMAGE_BOOT_FILES = " \
	${KERNEL_IMAGETYPE} \
	${@bb.utils.contains('KERNEL_IMAGETYPE', 'fitImage', '', '${NONFITDT}', d)} \
	"

# use the first-defined <baud>;<device> pair in SERIAL_CONSOLES
# for the console parameter in the wks files
RK_CONSOLE_BAUD ?= "${@d.getVar('SERIAL_CONSOLES').split(';')[0]}"
RK_CONSOLE_DEVICE ?= "${@d.getVar('SERIAL_CONSOLES').split(';')[1].split()[0]}"

WICVARS:append = " \
	RK_CONSOLE_BAUD \
	RK_CONSOLE_DEVICE \
	SPL_BINARY \
	UBOOT_SUFFIX \
	"
