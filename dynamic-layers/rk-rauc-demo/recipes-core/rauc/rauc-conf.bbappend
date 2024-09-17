inherit rk-rauc-demo-features-check

FILESEXTRAPATHS:prepend:rk-rauc-demo := "${THISDIR}/files:"

do_install:prepend:rk-rauc-demo() {
	sed -ie 's!@MACHINE@!${MACHINE}!g' ${UNPACKDIR}/system.conf
}