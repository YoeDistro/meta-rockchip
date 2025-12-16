FILESEXTRAPATHS:prepend := "${THISDIR}/linux-rockchip:"

SRC_URI:append:rockchip = " file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta"
