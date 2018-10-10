#!/usr/bin/env bash
if test ! $(rpm -qa | grep mysql)
then
	echo "start install mysql..."
	echo "start install mysql repository..."
	yum -y localinstall https://dev.mysql.com/get/mysql57-community-release-el7-11.noarch.rpm >> install.log
	if test ! $(grep "完毕" install.log)
	then
		echo "install mysql yum repository failed..."
		grep "error" install.log
	else
		echo "install mysql yum repository success.."
		echo "install mysql"
		yum -y install mysql-community-server > installmysql.log
		if test ! $(grep "完毕" installmysql.log)
		then
			echo "install mysql failed.."
			grep "error" install.log
		else
			echo "install mysql succeed..."
			echo "start mysql server..."
			sudo service mysqld start
			echo "init password is:"
			sudo grep 'temporary password' /var/log/mysqld.log
		fi
	fi

else
	echo "mysql has bean installed..."
fi