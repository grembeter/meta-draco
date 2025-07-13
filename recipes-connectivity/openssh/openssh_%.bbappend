# SPDX-License-Identifier: MIT
# SPDX-FileCopyrightText: Grygorii Tertychnyi

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append:fly = " \
  file://ssh_host_rsa_key \
  file://ssh_host_rsa_key.pub \
  file://ssh_host_ecdsa_key \
  file://ssh_host_ecdsa_key.pub \
  file://ssh_host_ed25519_key \
  file://ssh_host_ed25519_key.pub \
"

do_install:append:fly () {
    sed -i "/HostKey/d" ${D}${sysconfdir}/ssh/sshd_config

    echo "HostKey ${sysconfdir}/ssh/ssh_host_rsa_key" >> ${D}${sysconfdir}/ssh/sshd_config
    echo "HostKey ${sysconfdir}/ssh/ssh_host_ecdsa_key" >> ${D}${sysconfdir}/ssh/sshd_config
    echo "HostKey ${sysconfdir}/ssh/ssh_host_ed25519_key" >> ${D}${sysconfdir}/ssh/sshd_config

    install -d ${D}${sysconfdir}/ssh
    install -m 0600 ${WORKDIR}/ssh_host_rsa_key ${D}${sysconfdir}/ssh/
    install -m 0640 ${WORKDIR}/ssh_host_rsa_key.pub ${D}${sysconfdir}/ssh/
    install -m 0600 ${WORKDIR}/ssh_host_ecdsa_key ${D}${sysconfdir}/ssh/
    install -m 0640 ${WORKDIR}/ssh_host_ecdsa_key.pub ${D}${sysconfdir}/ssh/
    install -m 0600 ${WORKDIR}/ssh_host_ed25519_key ${D}${sysconfdir}/ssh/
    install -m 0640 ${WORKDIR}/ssh_host_ed25519_key.pub ${D}${sysconfdir}/ssh/
}
