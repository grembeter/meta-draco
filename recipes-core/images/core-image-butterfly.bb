# SPDX-License-Identifier: MIT
# SPDX-FileCopyrightText: Grygorii Tertychnyi

SUMMARY = "Simple rootfs image"

APPLICATION ?= "fly-application"
SYSTEM_SHELL ?= "${BUTTERFLY_SYSTEM_SHELL}"

IMAGE_INSTALL = " \
  packagegroup-core-boot \
  \
  ${SYSTEM_SHELL} \
  \
  ${APPLICATION} \
  \
  atftpd \
  bzip2 \
  ckermit \
  coreutils \
  cpio \
  dosfstools \
  e2fsprogs \
  ethtool \
  evtest \
  file \
  gawk \
  gdbserver \
  gptfdisk \
  hdparm \
  htop \
  i2c-tools \
  iperf3 \
  iputils \
  jq \
  ldd \
  libiio-tests \
  mg \
  mmc-utils \
  mtd-utils \
  pciutils \
  phytool \
  procps \
  python3 \
  rsync \
  socat \
  spidev-test \
  spitools \
  sysfsutils \
  systemd-analyze \
  strace \
  tar \
  tcpdump \
  trace-cmd \
  usbutils \
  util-linux \
  wget \
"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

PV = "1.0"
PR = "r0"

IMAGE_FEATURES += "ssh-server-openssh read-only-rootfs allow-empty-password empty-root-password allow-root-login"

IMAGE_FSTYPES = "tar.bz2 wic.bz2 wic.bmap"

IMAGE_MACHINE_SUFFIX = ""

IMAGE_ROOTFS_MAXSIZE = "3145728"

WKS_FILE = "sdcard.wks.in"

do_rootfs[depends] += "virtual/kernel:do_deploy"

inherit extrausers

EXTRA_USERS_PARAMS = " usermod -s /bin/ash root; "
