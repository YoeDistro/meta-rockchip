SRC_URI = "git://github.com/rockchip-linux/rkbin;protocol=https;branch=master"
SRCREV = "7c35e21a8529b3758d1f051d1a5dc62aae934b2b"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=11e3673115959bf596feaaa6ea7ce9a5"

inherit bin_package deploy

INHIBIT_DEFAULT_DEPS = "1"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:rk3308 = "rk3308"
COMPATIBLE_MACHINE:rk3566 = "rk3566"
COMPATIBLE_MACHINE:rk3568 = "rk3568"
COMPATIBLE_MACHINE:rk3588s = "rk3588s"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	# Nothing in this recipe is useful in a filesystem
	:
}

PACKAGES = "${PN}"
ALLOW_EMPTY:${PN} = "1"

do_deploy() {
	bbfatal "COMPATIBLE_MACHINE requires a corresponding do_deploy:<MACHINE>() override"
}

addtask deploy after do_install
