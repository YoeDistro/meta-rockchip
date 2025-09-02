FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:rockchip = " file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta"
