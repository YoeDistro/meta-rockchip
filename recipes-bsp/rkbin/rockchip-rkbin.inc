SRC_URI = "git://github.com/rockchip-linux/rkbin;protocol=https;branch=master"
SRCREV = "a2a0b89b6c8c612dca5ed9ed8a68db8a07f68bc0"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=15faa4a01e7eb0f5d33f9f2bcc7bff62"

inherit bin_package deploy

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
