#/bin/bash
# SPDX-License-Identifier: OSL-3.0
#
# a program that can take a wic file and dump out the contents
# of the U-Boot environment in canonical hex+ascii format
# (assuming the "rockchip" layout specified in this layer's wic file)

# check for programs
check_pgm() {
	$1 --help > /dev/null 2>&1
	if [ $? -ne 0 ]; then
		echo "required program \"$1\" not found"
		exit 1
	fi
}
check_pgm dd
check_pgm hexdump

if [ $# -ne 1 ]; then
	echo "required param missing: yocto wic image"
	exit 1
fi
if [ ! -f "$1" ]; then
	echo "specified file \"$1\" not found"
	exit 1
fi

SKIP=$(( 8128 * 512 ))
dd if="$1" ibs=1 skip=$SKIP count=32k 2> /dev/null | hexdump -C
