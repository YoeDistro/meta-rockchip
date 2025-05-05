DESCRIPTION = "Rockchip Firmware for DDR init (TPL in U-Boot terms)"

require rockchip-rkbin.inc

DDRBIN_DIR:rk3308 ?= "bin/rk33/"
DDRBIN_VERS:rk3308 ?= "v2.10"
DDRBIN_FILE:rk3308 ?= "rk3308_ddr_589MHz_uart4_m0_${DDRBIN_VERS}.bin"
DDRBIN_DEPLOY_FILENAME:rk3308 ?= "ddr-rk3308.bin"
DDRBIN_TOOL_SOC:rk3308 ?= "rk3308"

do_deploy:rk3308() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/${DDRBIN_DIR}${DDRBIN_FILE} ${DEPLOYDIR}/${DDRBIN_DEPLOY_FILENAME}
}

DDRBIN_DIR:rk3566 ?= "bin/rk35/"
DDRBIN_VERS:rk3566 ?= "v1.23"
DDRBIN_FILE:rk3566 ?= "rk3566_ddr_1056MHz_${DDRBIN_VERS}.bin"
DDRBIN_DEPLOY_FILENAME:rk3566 ?= "ddr-rk3566.bin"
DDRBIN_TOOL_SOC:rk3566 ?= "rk356x"

do_deploy:rk3566() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/${DDRBIN_DIR}${DDRBIN_FILE} ${DEPLOYDIR}/${DDRBIN_DEPLOY_FILENAME}
}

DDRBIN_DIR:rk3568 ?= "bin/rk35/"
DDRBIN_VERS:rk3568 ?= "v1.23"
DDRBIN_FILE:rk3568 ?= "rk3568_ddr_1560MHz_${DDRBIN_VERS}.bin"
DDRBIN_DEPLOY_FILENAME:rk3568 ?= "ddr-rk3568.bin"
DDRBIN_TOOL_SOC:rk3568 ?= "rk356x"

do_deploy:rk3568() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/${DDRBIN_DIR}${DDRBIN_FILE} ${DEPLOYDIR}/${DDRBIN_DEPLOY_FILENAME}
}

DDRBIN_DIR:rk3588s ?= "bin/rk35/"
DDRBIN_VERS:rk3588s ?= "v1.18"
DDRBIN_FILE:rk3588s ?= "rk3588_ddr_lp4_2112MHz_lp5_2400MHz_${DDRBIN_VERS}.bin"
DDRBIN_DEPLOY_FILENAME:rk3588s ?= "ddr-rk3588.bin"
DDRBIN_TOOL_SOC:rk3588s ?= "rk3588"

do_deploy:rk3588s() {
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/${DDRBIN_DIR}${DDRBIN_FILE} ${DEPLOYDIR}/${DDRBIN_DEPLOY_FILENAME}
}

# The following is only required if DDR bin blob needs to be modified
# (e.g. different UART controller, UART mux, or baudrate)
# RKBIN_DDR_RECONFIGURE = "1" if it needs to be modified, all below logic needs to
# depend on that value be 1, and not run if 0.
RKBIN_DDR_RECONFIGURE ?= "0"

# The tool (ddrbin_tool.py) for modifying the DDR bin is from rockchip-rkbin-native...
DEPENDS += "${@'rockchip-rkbin-native' if d.getVar('RKBIN_DDR_RECONFIGURE') == '1' else ''}"

# ... and it expects a file as input, which is named ddrbin_param.txt in the tree.
SRC_URI += "${@'file://ddrbin_param.txt' if d.getVar('RKBIN_DDR_RECONFIGURE') == '1' else ''}"

python __anonymous() {
    # Because rockchip-rkbin.inc inherits bin_package and we need to run some step before
    # the install task re-enable do_configure task.
    # We could use
    #  do_configure[noexec] = "${@'0' if d.getVar('RKBIN_DDR_RECONFIGURE') == '1' else '1'}"
    # but this spams the console with deprecation warnings, see
    # https://bugzilla.yoctoproject.org/show_bug.cgi?id=13808
    if d.getVar('RKBIN_DDR_RECONFIGURE') == '1':
        d.delVarFlag("do_configure", "noexec")
}

do_configure() {
	if [ "${RKBIN_DDR_RECONFIGURE}" = "1" ]; then
		# ddrbin_tool.py always modifies a date in the DDR blob, based on current time.
		# This is bad for reproducibility and hashequiv usage, so use the commit author
		# date of the last change made to the DDR bin.
		# DATE must be max 17-character long!
		RKBIN_DDR_DATE=$(git log --pretty=format:"%ad" --date=format:"%Y%m%d-%H:%M:%S" -1 -- ${S}/${DDRBIN_DIR}${DDRBIN_FILE})
		# DDRBIN_TOOL_SOC is mostly useless except for rk3528 for now. It needs to match one string in the global
		# chip_list array in ddrbin_tool.py.
		if [ -z "${DDRBIN_TOOL_SOC}" ]; then
			bbfatal "Non-empty DDRBIN_TOOL_SOC:<MACHINE> required!"
		fi
		# Modify blob with appropriate settings stored in ddrbin_params.txt
		ddrbin_tool.py ${DDRBIN_TOOL_SOC} ${UNPACKDIR}/ddrbin_param.txt ${S}/${DDRBIN_DIR}${DDRBIN_FILE} --verinfo_editable "${RKBIN_DDR_DATE}"
	fi
}
