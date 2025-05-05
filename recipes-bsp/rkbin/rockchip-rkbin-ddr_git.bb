DESCRIPTION = "Rockchip Firmware for DDR init (TPL in U-Boot terms)"

require rockchip-rkbin.inc

DDRBIN_DIR:rk3308 ?= "bin/rk33/"
DDRBIN_VERS:rk3308 ?= "v2.10"
DDRBIN_FILE:rk3308 ?= "rk3308_ddr_589MHz_uart4_m0_${DDRBIN_VERS}.bin"

do_deploy:rk3308() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/${DDRBIN_DIR}${DDRBIN_FILE} ${DEPLOYDIR}/ddr-rk3308.bin
}

DDRBIN_DIR:rk3566 ?= "bin/rk35/"
DDRBIN_VERS:rk3566 ?= "v1.23"
DDRBIN_FILE:rk3566 ?= "rk3566_ddr_1056MHz_${DDRBIN_VERS}.bin"

do_deploy:rk3566() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/${DDRBIN_DIR}${DDRBIN_FILE} ${DEPLOYDIR}/ddr-rk3566.bin
}

DDRBIN_DIR:rk3568 ?= "bin/rk35/"
DDRBIN_VERS:rk3568 ?= "v1.23"
DDRBIN_FILE:rk3568 ?= "rk3568_ddr_1560MHz_${DDRBIN_VERS}.bin"

do_deploy:rk3568() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/${DDRBIN_DIR}${DDRBIN_FILE} ${DEPLOYDIR}/ddr-rk3568.bin
}

DDRBIN_DIR:rk3588s ?= "bin/rk35/"
DDRBIN_VERS:rk3588s ?= "v1.18"
DDRBIN_FILE:rk3588s ?= "rk3588_ddr_lp4_2112MHz_lp5_2400MHz_${DDRBIN_VERS}.bin"

do_deploy:rk3588s() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/${DDRBIN_DIR}${DDRBIN_FILE} ${DEPLOYDIR}/ddr-rk3588.bin
}
