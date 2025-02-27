inherit rk-rauc-demo-features-check

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILESEXTRAPATHS:prepend:rk-rauc-demo := "${THISDIR}/files:"

do_install:prepend:rk-rauc-demo() {
	sed -ie 's!@MACHINE@!${MACHINE}!g' ${WORKDIR}/system.conf
}
