FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_rock-pi-4 = " file://0001-Revert-regulator-resolve-supply-after-creating-regul.patch"

