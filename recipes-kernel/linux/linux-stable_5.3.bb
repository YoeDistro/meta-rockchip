FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "5.3.5"
KBRANCH ?= "linux-5.3.y"
SRCREV ?= "dc073f193b70176b16ae3e6e8afccee07a13df90"

require linux-stable.inc
