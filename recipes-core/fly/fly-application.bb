# SPDX-License-Identifier: MIT
# SPDX-FileCopyrightText: Grygorii Tertychnyi

SUMMARY = "Fly application (entry point)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
  file://fly.sh \
  file://eth0.network \
"

PV = "1.0"
PR = "r0"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/fly.sh ${D}${bindir}/fly

    install -d ${D}${systemd_unitdir}/network
    install -m 0644 ${WORKDIR}/eth0.network ${D}${systemd_unitdir}/network/71-eth0.network
}

FILES:${PN} = " \
  ${bindir}/fly \
  ${systemd_unitdir}/network/71-eth0.network \
"

GSTREAMER_PKGS = " \
  gstreamer1.0 \
  gstreamer1.0-plugins-bad \
  gstreamer1.0-plugins-base-app \
  gstreamer1.0-plugins-base-videoconvertscale \
  gstreamer1.0-plugins-base-videotestsrc \
  gstreamer1.0-plugins-good \
  gstreamer1.0-plugins-good-autodetect \
"

RDEPENDS:${PN} += " \
  ${GSTREAMER_PKGS} \
  libgpiod \
  libgpiod-tools \
  opencv \
"
