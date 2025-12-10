SUMMARY = "Overlay Logic onto the /data partition"
LICENSE = "OSL-3.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/OSL-3.0;md5=438ec6d864bbb958a49df939a56511cf"

inherit rk-rauc-demo-features-check systemd

SYSTEMD_SERVICE:${PN} = "etc.mount home.mount"

S = "${UNPACKDIR}"

SRC_URI = " \
        file://etc.mount \
        file://home.mount \
	"

do_install() {
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${UNPACKDIR}/etc.mount ${D}${systemd_system_unitdir}
	install -m 0644 ${UNPACKDIR}/home.mount ${D}${systemd_system_unitdir}
}

RDEPENDS:${PN} += "abd-partition"
