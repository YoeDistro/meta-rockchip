DESCRIPTION = "Rockchip Trusted-Firmware-A (BL31) blob"

require rockchip-rkbin.inc

PROVIDES += "trusted-firmware-a"

# Must match the naming and path used in
# meta-arm/recipes-bsp/trusted-firmware-a/ trusted-firmware-a recipes (see also
# do_deploy() in meta-arm/classes-recipes/firmware.bbclass)
RKBIN_DEPLOY_FILENAME = "trusted-firmware-a/bl31.elf"

RKBIN_BINVERS:rk3308 ?= "v2.26"
RKBIN_BINFILE:rk3308 ?= "rk3308_bl31_${RKBIN_BINVERS}.elf"

RKBIN_BINVERS_RK356x ?= "v1.44"
RKBIN_BINVERS:rk3566 ?= "${RKBIN_BINVERS_RK356x}"
# NOTE: the following are not typos
#       the rk3566 uses the same bl31 as the rk3568
RKBIN_BINFILE:rk3566 ?= "rk3568_bl31_${RKBIN_BINVERS}.elf"

RKBIN_BINVERS:rk3568 ?= "${RKBIN_BINVERS_RK356x}"
RKBIN_BINFILE:rk3568 ?= "rk3568_bl31_${RKBIN_BINVERS}.elf"

RKBIN_BINVERS:rk3588s ?= "v1.48"
RKBIN_BINFILE:rk3588s ?= "rk3588_bl31_${RKBIN_BINVERS}.elf"
