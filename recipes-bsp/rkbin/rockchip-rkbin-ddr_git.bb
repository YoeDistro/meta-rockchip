DESCRIPTION = "Rockchip Firmware for DDR init (TPL in U-Boot terms)"

require rockchip-rkbin.inc

do_deploy:rk3308() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk33/rk3308_ddr_589MHz_uart?_m0_v*.bin ${DEPLOYDIR}/ddr-rk3308.bin
}

do_deploy:rk3566() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/rk3566_ddr_1056MHz_v1.21.bin ${DEPLOYDIR}/ddr-rk3566.bin
}

do_deploy:rk3568() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/rk3568_ddr_1560MHz_v1.21.bin ${DEPLOYDIR}/ddr-rk3568.bin
}

do_deploy:rk3588s() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/rk3588_ddr_lp4_2112MHz_lp5_2400MHz_v1.16.bin ${DEPLOYDIR}/ddr-rk3588.bin
}
