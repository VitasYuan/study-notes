#!/usr/bin/env bash
# 安装jdk8
if test ! $(which java)
then
	echo "start install jdk.."
	if test ! $(which wget)
	then
		yum -y install wget.x86_64 >> install-log.txt
	fi

	wget -c http://111.1.50.14/files/7194000006F691AA/download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-linux-x64.rpm >> install-log.txt
	rpm -ivh jdk-8u181-linux-x64.rpm

	if test $(which java)
	then
		echo "install finished"
	else
		echo "install failed"
		grep "error" install-log.txt
	fi
else
	echo "java is already installed."

fi