SUMMARY = "A/B+D partition definition for systemd's repart mechanism"
LICENSE = "OSL-3.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/OSL-3.0;md5=438ec6d864bbb958a49df939a56511cf"

inherit rk-rauc-demo-features-check systemd

SYSTEMD_SERVICE:${PN} = "data.mount"

S = "${UNPACKDIR}"

SRC_URI = " \
	file://data.mount \
	file://25-rootfsA.conf \
	file://35-rootfsB.conf \
	file://45-data.conf \
	"

do_install() {
	install -d ${D}${sysconfdir}/repart.d/
	install -m 0644 ${UNPACKDIR}/25-rootfsA.conf ${D}${sysconfdir}/repart.d/
	install -m 0644 ${UNPACKDIR}/35-rootfsB.conf ${D}${sysconfdir}/repart.d/
	install -m 0644 ${UNPACKDIR}/45-data.conf ${D}${sysconfdir}/repart.d/

	install -d ${D}${sysconfdir}/systemd/system
	install -m 0644 ${UNPACKDIR}/data.mount ${D}${sysconfdir}/systemd/system/
}
