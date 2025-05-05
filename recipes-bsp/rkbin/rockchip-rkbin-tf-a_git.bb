DESCRIPTION = "Rockchip Trusted-Firmware-A (BL31) blob"

require rockchip-rkbin.inc

PROVIDES += "trusted-firmware-a"

RKBIN_BINVERS:rk3308 ?= "v2.26"
RKBIN_BINFILE:rk3308 ?= "rk3308_bl31_${RKBIN_BINVERS}.elf"
RKBIN_DEPLOY_FILENAME:rk3308 ?= "bl31-rk3308.elf"

RKBIN_BINVERS_RK356x ?= "v1.44"
RKBIN_BINVERS:rk3566 ?= "${RKBIN_BINVERS_RK356x}"
# NOTE: the following are not typos
#       the rk3566 uses the same bl31 as the rk3568
RKBIN_BINFILE:rk3566 ?= "rk3568_bl31_${RKBIN_BINVERS}.elf"
RKBIN_DEPLOY_FILENAME:rk3566 ?= "bl31-rk3566.elf"

RKBIN_BINVERS:rk3568 ?= "${RKBIN_BINVERS_RK356x}"
RKBIN_BINFILE:rk3568 ?= "rk3568_bl31_${RKBIN_BINVERS}.elf"
RKBIN_DEPLOY_FILENAME:rk3568 ?= "bl31-rk3568.elf"

RKBIN_BINVERS:rk3588s ?= "v1.47"
RKBIN_BINFILE:rk3588s ?= "rk3588_bl31_${RKBIN_BINVERS}.elf"
RKBIN_DEPLOY_FILENAME:rk3588s ?= "bl31-rk3588.elf"
