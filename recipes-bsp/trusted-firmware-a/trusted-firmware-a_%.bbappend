# Rockchip RK3399 compiles some M0 firmware which requires an arm-none-eabi GCC
# toolchain
DEPENDS:append:rk3399 = " virtual/arm-none-eabi-gcc-native"

COMPATIBLE_MACHINE:append:rk3399 = "|rk3399"
COMPATIBLE_MACHINE:append:rk3328 = "|rk3328"
COMPATIBLE_MACHINE:append:px30 = "|px30"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "\
    file://0001-dram-Fix-build-with-gcc-11.patch \
    file://0001-plat_macros.S-Use-compatible-.asciz-asm-directive.patch \
    file://0001-pmu-Do-not-mark-already-defined-functions-as-weak.patch \
"


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

do_patch[postfuncs] += "fixup_baudrate"
