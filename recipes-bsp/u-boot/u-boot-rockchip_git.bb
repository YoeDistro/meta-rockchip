# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Copyright (C) 2017 Trevor Woerner <twoerner@gmail.com>
# Copyright (C) 2017 Romain Perier <romain.perier@collabora.com>
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc
require recipes-bsp/u-boot/u-boot-common_2018.01.inc

DESCRIPTION = "Rockchip next-dev U-Boot"
COMPATIBLE_MACHINE = "(firefly-rk3288|rock2-square|veyron-speedy)"

DEPENDS = "dtc-native bc-native"

SRC_URI = " \
	git://github.com/rockchip-linux/u-boot.git;branch=release; \
	file://binutils-2.28-ld-fix.patch \
	"
SRCREV = "${AUTOREV}"
PV = "v2017.07+git${SRCPV}"

do_compile_append () {
    # copy to default search path
    cp ${B}/spl/${SPL_BINARY} ${B}/
}
