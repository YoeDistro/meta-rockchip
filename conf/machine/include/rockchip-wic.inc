# common meta-rockchip wic/wks items

require conf/machine/include/rockchip-extlinux.inc

SPL_BINARY ?= "idbloader.img"

IMAGE_FSTYPES += "wic wic.bmap"
WKS_FILE ?= "rockchip.wks"
WKS_FILE_DEPENDS ?= " \
	e2fsprogs-native \
	virtual/bootloader \
	"

WICVARS:append = " \
	SPL_BINARY \
	UBOOT_SUFFIX \
	"
