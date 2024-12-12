FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE:orangepi-5-plus = "orangepi-5-plus"
COMPATIBLE_MACHINE:radxa-zero-3 = "radxa-zero-3"

SRC_URI:append:orangepi-5-plus = " file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta"
SRC_URI:append:radxa-zero-3 = " file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta"
