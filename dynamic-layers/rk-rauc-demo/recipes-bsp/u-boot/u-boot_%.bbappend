inherit rk-rauc-demo-features-check

FILESEXTRAPATHS:prepend:rk-rauc-demo := "${THISDIR}/files:"

DEPENDS:append:rk-rauc-demo = " u-boot-mkimage-native"
SRC_URI:append:rk-rauc-demo = " \
	file://uboot-rauc.cfg \
	file://boot.cmd.in \
	"

do_compile:append:rk-rauc-demo() {
	# create boot script
	sed -e 's|@@KERNEL_BOOTFILE@@|${UBOOT_EXTLINUX_KERNEL_IMAGE}|' \
	    "${UNPACKDIR}/boot.cmd.in" > "${UNPACKDIR}/boot.cmd"
	mkimage -A ${UBOOT_ARCH} -T script -C none -n "Boot script" -d "${UNPACKDIR}/boot.cmd" ${UNPACKDIR}/boot.scr

	# tweak environment
	echo "bootmeths=script extlinux" >> ${B}/u-boot-initial-env
	echo "bootargsbase=${UBOOT_EXTLINUX_KERNEL_ARGS} ${UBOOT_EXTLINUX_CONSOLE}" >> ${B}/u-boot-initial-env
}

do_install:append:rk-rauc-demo() {
	install -d ${D}/boot
	install -m 0644 ${UNPACKDIR}/boot.scr ${D}/boot
}
FILES:${PN}-extlinux += "/boot/boot.scr"
