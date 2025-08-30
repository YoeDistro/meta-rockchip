FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE:orangepi-5-plus = "orangepi-5-plus"
COMPATIBLE_MACHINE:nanopc-t6 = "nanopc-t6"

SRC_URI:append:orangepi-5-plus = " file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta"
SRC_URI:append:nanopc-t6 = " file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta"
