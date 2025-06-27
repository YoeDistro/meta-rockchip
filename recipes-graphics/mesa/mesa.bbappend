MALI_DRIVER = "panfrost"
# MALI 400
MALI_DRIVER:rk3066 = "lima"
MALI_DRIVER:rk3188 = "lima"
# MALI 450
MALI_DRIVER:rk3328 = "lima"
# No GPU
MALI_DRIVER:rk3308 = ""

PACKAGECONFIG:append:rockchip = " ${@bb.utils.filter('MALI_DRIVER', 'lima panfrost', d)}"
PACKAGECONFIG:append:rockchip = "${@bb.utils.contains('MALI_DRIVER', 'panfrost', ' libclc', '', d)}"

# Mali Gen10 (Valhall, supported by Panthor) requires a firmware blob
RRECOMMENDS:mesa-megadriver:append:rk3588s = " linux-firmware-mali-csffw-arch108"
