# SPDX-License-Identifier: MIT
# SPDX-FileCopyrightText: Grygorii Tertychnyi

DESCRIPTION = "Butterfly Linux Kernel for Raspberry Pi"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

PV = "${LINUX_VERSION}+git${SRCPV}"

DEPENDS += "elfutils-native openssl-native util-linux-native"

inherit kernel
inherit kernel-yocto

SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=https;branch=${RPI_KBRANCH}"

KCONFIG_MODE = "--alldefconfig"

KERNEL_DTC_FLAGS += "-@ -H epapr"

LINUX_VERSION_EXTENSION ?= ""

COMPATIBLE_MACHINE ?= "^$"
