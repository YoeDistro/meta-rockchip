FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
COMPATIBLE_MACHINE:rock-5b = "rock-5b"
SRC_URI:append:rock-5b = " file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta"
