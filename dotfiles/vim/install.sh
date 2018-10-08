#!/usr/bin/env bash
# 安装vim，并添加默认配置
# 检测vim是否已经安装
if test ! $(rpm -qa | grep vim-enhanced)
then
	echo "start install vim."
	yum -y install vim-enhanced.x86_64 >> install-log.txt
	if test $(grep "error" install-log.txt)
	then
		echo "install failed."
	else
		echo "install success."
		rm -rf install-log.txt

		if test -e ~/.vimrc
		then
		    echo ".vimrc exist, rename as .vimrc-default"
		    mv ~/.vimrc ~/.vimrc-default

		    cp .vimrc ~/.vimrc
		fi

		cp .vimrc ~/.vimrc
		echo "install and config success."
	fi
else
	echo "you have installed vim"

fi
exit 0
