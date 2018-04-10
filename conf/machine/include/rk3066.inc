# Copyright (C) 2014 NEO-Technologies
# Released under the MIT license (see COPYING.MIT for the terms)

DEFAULTTUNE = "cortexa9-neon"
require conf/machine/include/tune-cortexa9.inc

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"

XSERVER = "xserver-xorg \
           xf86-video-fbturbo \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-input-keyboard"

PREFERRED_PROVIDER_virtual/kernel = "linux-rockchip"

KERNEL_IMAGETYPE = "zImage"

IMAGE_FSTYPES += "ext4"

SERIAL_CONSOLES ?= "115200;ttyFIQ0"
KBUILD_DEFCONFIG = "multi_v7_defconfig"

