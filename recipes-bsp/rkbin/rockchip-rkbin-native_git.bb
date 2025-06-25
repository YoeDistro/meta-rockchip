DESCRIPTION = "Rockchip native tools related to their rkbin blobs, e.g. ddrbin_tool.py"

SRC_URI = "git://github.com/rockchip-linux/rkbin;protocol=https;branch=master"
SRCREV = "f43a462e7a1429a9d407ae52b4745033034a6cf9"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=11e3673115959bf596feaaa6ea7ce9a5"

inherit native

S = "${UNPACKDIR}/${BP}/tools"

# ddrbin_tool.py only uses python and core modules.
# Yocto depends on a host python anyway so we can simply ignore that dependency
# and have ddrbin_tool.py run with the host's python instead of building python
# natively.
# DEPENDS = "python3-native"

do_install() {
	install -d "${D}${bindir}"
	install -m 0755 ddrbin_tool.py "${D}${bindir}"
}
