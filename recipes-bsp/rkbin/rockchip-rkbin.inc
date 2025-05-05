SRC_URI = "git://github.com/rockchip-linux/rkbin;protocol=https;branch=master"
SRCREV = "f43a462e7a1429a9d407ae52b4745033034a6cf9"
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

RKBIN_BINDIR:rk3308 ?= "bin/rk33/"
RKBIN_BINDIR:rk3566 ?= "bin/rk35/"
RKBIN_BINDIR:rk3568 ?= "bin/rk35/"
RKBIN_BINDIR:rk3588s ?= "bin/rk35/"

do_deploy() {
	if [ -z "${RKBIN_BINDIR}" ]; then
		bbfatal "Non-empty RKBIN_BINDIR:<MACHINE> required!"
	fi

	if [ -z "${RKBIN_BINFILE}" ]; then
		bbfatal "Non-empty RKBIN_BINFILE:<MACHINE> required!"
	fi

	if [ -z "${RKBIN_DEPLOY_FILENAME}" ]; then
		bbfatal "Non-empty RKBIN_DEPLOY_FILENAME:<MACHINE> required!"
	fi

	install -m 644 ${S}/${RKBIN_BINDIR}${RKBIN_BINFILE} ${DEPLOYDIR}/${RKBIN_DEPLOY_FILENAME}
}

addtask deploy after do_install
