DESCRIPTION = "Rockchip OP-TEE OS (BL32) blob"

require rockchip-rkbin.inc

PROVIDES += "optee-os"

do_deploy:rk3308() {
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk33/rk3308_bl32_v*.bin ${DEPLOYDIR}/tee-rk3308.bin
}

# NOTE: the following are not typos
#       the rk3566 uses the same bl32 as the rk3568
do_deploy:rk3566() {
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3568_bl32_v*.bin ${DEPLOYDIR}/tee-rk3566.bin
}

do_deploy:rk3568() {
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3568_bl32_v*.bin ${DEPLOYDIR}/tee-rk3568.bin
}

do_deploy:rk3588s() {
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3588_bl32_v*.bin ${DEPLOYDIR}/tee-rk3588.bin
}
