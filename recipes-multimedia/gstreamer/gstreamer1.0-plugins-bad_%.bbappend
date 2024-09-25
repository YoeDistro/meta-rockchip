PACKAGECONFIG:append:rockchip = "${@' v4l2codecs' if bb.utils.to_boolean(d.getVar('ENABLE_STATELESS_VPU_GST'), False) else ''}"
