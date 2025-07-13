# SPDX-License-Identifier: MIT
# SPDX-FileCopyrightText: Grygorii Tertychnyi

LINUX_VERSION ?= "6.12.25"

require linux-butterfly.inc

SRC_URI += "file://defconfig"

RPI_KBRANCH ?= "rpi-6.12.y"
SRCREV ?= "3dd2c2c507c271d411fab2e82a2b3b7e0b6d3f16"

COMPATIBLE_MACHINE .= "|rpi"
