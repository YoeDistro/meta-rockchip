# 'RK_RAUC_DEMO' indicates the user wants to use the
# rauc demo configuration from this layer
OVERRIDES .= "${@ ':rk-rauc-demo' if bb.utils.to_boolean(d.getVar('RK_RAUC_DEMO'), False) else ''}"
IMAGE_INSTALL:append:rk-rauc-demo = " abd-partition"
IMAGE_INSTALL:append:rk-rauc-demo = " ${@ 'data-partition-overlay' if bb.utils.to_boolean(d.getVar('RK_OVERLAY_DEMO'), False) else ''}"
