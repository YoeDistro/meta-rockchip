FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.19.78"
KBRANCH ?= "linux-4.19.y"
SRCREV ?= "58fce20645303bee01d74144ec00e405be43b1ca"

require linux-stable.inc
