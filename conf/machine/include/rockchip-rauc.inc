# 'RK_RAUC_DEMO' indicates the user wants to use the
# rauc demo configuration from this layer
OVERRIDES .= "${@ ':rk-rauc-demo' if bb.utils.to_boolean(d.getVar('RK_RAUC_DEMO'), False) else ''}"
IMAGE_INSTALL:append:rk-rauc-demo = " abd-partition"
