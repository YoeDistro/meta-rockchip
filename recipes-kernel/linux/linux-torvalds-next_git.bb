FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto-dev:"

DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

ERROR_QA:remove = "buildpaths"
DEFAULT_PREFERENCE = "-1"
COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:radxa-zero-3 = "radxa-zero-3"

LINUX_VERSION = "6.10-rc3"
KERNEL_VERSION_SANITY_SKIP = "1"
PV = "${LINUX_VERSION}+git${SRCPV}"
SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/next/linux-next.git;protocol=https;nobranch=1 \
	file://rockchip-kmeta;type=kmeta;name=rockchip-kmeta;destsuffix=rockchip-kmeta \
	"
# this is tag 'next-20240611'
SRCREV = "a957267fa7e9159d3d2ee1421359ebf228570c68"

inherit kernel
inherit kernel-yocto
require recipes-kernel/linux/linux-yocto.inc
