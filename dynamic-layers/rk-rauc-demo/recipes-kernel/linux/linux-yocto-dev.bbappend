require ${@ 'recipes-kernel/linux/linux-yocto_rauc.inc' if bb.utils.to_boolean(d.getVar('RK_RAUC_DEMO'), False) else ''}
