# Rockchip RK3399 compiles some M0 firmware which requires an arm-none-eabi GCC
# toolchain
DEPENDS:append:rk3399 = " gcc-arm-none-eabi-native"

COMPATIBLE_MACHINE:append:rk3399 = "|rk3399"
COMPATIBLE_MACHINE:append:rk3328 = "|rk3328"
COMPATIBLE_MACHINE:append:px30 = "|px30"
COMPATIBLE_MACHINE:append:rk3566 = "|rk3566"
COMPATIBLE_MACHINE:append:rk3568 = "|rk3568"
COMPATIBLE_MACHINE:append:rk3588s = "|rk3588s"

# code bloats with clang and results in error below now
# | aarch64-yoe-linux-musl-ld: region `PMUSRAM' overflowed by 3928 bytes
# this needs fixing until then use gcc
TOOLCHAIN:rk3399 = "gcc"

fixup_baudrate() {
	:
}

fixup_baudrate:rk3399() {
	sed -i "s/#define RK3399_BAUDRATE\s\+.*/#define RK3399_BAUDRATE ${RK_CONSOLE_BAUD}/" ${S}/plat/rockchip/rk3399/rk3399_def.h
}

fixup_baudrate:px30() {
	sed -i "s/#define PX30_BAUDRATE\s\+.*/#define PX30_BAUDRATE ${RK_CONSOLE_BAUD}/" ${S}/plat/rockchip/px30/px30_def.h
}

# This is not a typo, rk3566 and rk3568 are supported by the same code base.
fixup_baudrate:rk3566() {
	sed -i "s/#define FPGA_BAUDRATE\s\+.*/#define FPGA_BAUDRATE ${RK_CONSOLE_BAUD}/" ${S}/plat/rockchip/rk3568/rk3568_def.h
}

fixup_baudrate:rk3568() {
	sed -i "s/#define FPGA_BAUDRATE\s\+.*/#define FPGA_BAUDRATE ${RK_CONSOLE_BAUD}/" ${S}/plat/rockchip/rk3568/rk3568_def.h
}

fixup_baudrate:rk3588s() {
	sed -i "s/#define RK_DBG_UART_BAUDRATE\s\+.*/#define RK_DBG_UART_BAUDRATE ${RK_CONSOLE_BAUD}/" ${S}/plat/rockchip/rk3588/rk3588_def.h
}

# Only required for U-Boot configuration for which SPL_ATF_NO_PLATFORM_PARAM
# symbol is enabled. This symbol is required for TF-A < 2.4-rc0, which is
# unfortunately what Rockchip is using for their blob.
# With upstream TF-A and SPL_ATF_NO_PLATFORM_PARAM disabled in U-Boot, TF-A will
# get which console to use and at which baudrate from U-Boot directly.
# If you use upstream U-Boot with SPL_ATF_NO_PLATFORM_PARAM disabled, you can
# simply override this function to do nothing.
do_patch[postfuncs] += "fixup_baudrate"

do_deploy() {
    :
}
do_deploy:rk3328() {
    cp -rf ${D}/firmware/trusted-firmware-a/bl31.elf ${DEPLOYDIR}/bl31-rk3328.elf
}
do_deploy:rk3399() {
    cp -rf ${D}/firmware/trusted-firmware-a/bl31.elf ${DEPLOYDIR}/bl31-rk3399.elf
}
addtask deploy after do_install
