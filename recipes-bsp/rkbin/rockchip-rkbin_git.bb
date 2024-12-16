DESCRIPTION = "Rockchip Firmware and Tool Binaries"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=11e3673115959bf596feaaa6ea7ce9a5"

SRC_URI = "git://github.com/rockchip-linux/rkbin;protocol=https;branch=master"
SRCREV = "7c35e21a8529b3758d1f051d1a5dc62aae934b2b"

PROVIDES += "trusted-firmware-a"
PROVIDES += "optee-os"

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

DDRBIN_VERS:rk3308 ?= "v2.10"
DDRBIN_FILE:rk3308 ?= "rk3308_ddr_589MHz_uart4_m0_${DDRBIN_VERS}.bin"

do_deploy:rk3308() {
	# Prebuilt TF-A
	install -m 644 ${S}/bin/rk33/rk3308_bl31_v*.elf ${DEPLOYDIR}/bl31-rk3308.elf
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk33/rk3308_bl32_v*.bin ${DEPLOYDIR}/tee-rk3308.bin
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk33/${DDRBIN_FILE} ${DEPLOYDIR}/ddr-rk3308.bin
}

DDRBIN_VERS:rk3566 ?= "v1.23"
DDRBIN_FILE:rk3566 ?= "rk3566_ddr_1056MHz_${DDRBIN_VERS}.bin"

# NOTE: the following are not typos
#       the rk3566 uses the same bl31/2 as the rk3568
do_deploy:rk3566() {
	# Prebuilt TF-A
	install -m 644 ${S}/bin/rk35/rk3568_bl31_v*.elf ${DEPLOYDIR}/bl31-rk3566.elf
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3568_bl32_v*.bin ${DEPLOYDIR}/tee-rk3566.bin
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/${DDRBIN_FILE} ${DEPLOYDIR}/ddr-rk3566.bin
}

DDRBIN_VERS:rk3568 ?= "v1.23"
DDRBIN_FILE:rk3568 ?= "rk3568_ddr_1560MHz_${DDRBIN_VERS}.bin"

do_deploy:rk3568() {
	# Prebuilt TF-A
	install -m 644 ${S}/bin/rk35/rk3568_bl31_v*.elf ${DEPLOYDIR}/bl31-rk3568.elf
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3568_bl32_v*.bin ${DEPLOYDIR}/tee-rk3568.bin
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/${DDRBIN_FILE} ${DEPLOYDIR}/ddr-rk3568.bin
}

DDRBIN_VERS:rk3588s ?= "v1.18"
DDRBIN_FILE:rk3588s ?= "rk3588_ddr_lp4_2112MHz_lp5_2400MHz_${DDRBIN_VERS}.bin"

do_deploy:rk3588s() {
	# Prebuilt TF-A
	install -m 644 ${S}/bin/rk35/rk3588_bl31_v*.elf ${DEPLOYDIR}/bl31-rk3588.elf
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3588_bl32_v*.bin ${DEPLOYDIR}/tee-rk3588.bin
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/${DDRBIN_FILE} ${DEPLOYDIR}/ddr-rk3588.bin
}

do_deploy() {
	bbfatal "COMPATIBLE_MACHINE requires a corresponding do_deploy:<MACHINE>() override"
}

addtask deploy after do_install
