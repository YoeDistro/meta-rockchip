DESCRIPTION = "Rockchip Firmware and Tool Binaries"

require rockchip-rkbin.inc

PROVIDES += "trusted-firmware-a"
PROVIDES += "optee-os"

do_deploy:rk3308() {
	# Prebuilt TF-A
	install -m 644 ${S}/bin/rk33/rk3308_bl31_v*.elf ${DEPLOYDIR}/bl31-rk3308.elf
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk33/rk3308_bl32_v*.bin ${DEPLOYDIR}/tee-rk3308.bin
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk33/rk3308_ddr_589MHz_uart?_m0_v*.bin ${DEPLOYDIR}/ddr-rk3308.bin
}

# NOTE: the following are not typos
#       the rk3566 uses the same bl31/2 as the rk3568
do_deploy:rk3566() {
	# Prebuilt TF-A
	install -m 644 ${S}/bin/rk35/rk3568_bl31_v*.elf ${DEPLOYDIR}/bl31-rk3566.elf
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3568_bl32_v*.bin ${DEPLOYDIR}/tee-rk3566.bin
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/rk3566_ddr_1056MHz_v1.21.bin ${DEPLOYDIR}/ddr-rk3566.bin
}

do_deploy:rk3568() {
	# Prebuilt TF-A
	install -m 644 ${S}/bin/rk35/rk3568_bl31_v*.elf ${DEPLOYDIR}/bl31-rk3568.elf
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3568_bl32_v*.bin ${DEPLOYDIR}/tee-rk3568.bin
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/rk3568_ddr_1560MHz_v1.21.bin ${DEPLOYDIR}/ddr-rk3568.bin
}

do_deploy:rk3588s() {
	# Prebuilt TF-A
	install -m 644 ${S}/bin/rk35/rk3588_bl31_v*.elf ${DEPLOYDIR}/bl31-rk3588.elf
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3588_bl32_v*.bin ${DEPLOYDIR}/tee-rk3588.bin
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/rk3588_ddr_lp4_2112MHz_lp5_2400MHz_v1.16.bin ${DEPLOYDIR}/ddr-rk3588.bin
}
