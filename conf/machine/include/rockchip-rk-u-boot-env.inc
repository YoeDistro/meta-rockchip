# 'rk-u-boot-env' indicates the user wants to be able to save their U-Boot
# environment back to the drive from which the device was booted
MACHINEOVERRIDES .= "${@bb.utils.contains('MACHINE_FEATURES', 'rk-u-boot-env', ':rk-u-boot-env', '', d)}"
IMAGE_INSTALL:append:rk-u-boot-env = " u-boot-fw-utils u-boot-env"
