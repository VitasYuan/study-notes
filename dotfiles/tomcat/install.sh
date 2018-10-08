#!/usr/bin/env bash
wget https://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-7/v7.0.91/bin/apache-tomcat-7.0.91.tar.gz

tar zxf apache-tomcat-7.0.91.tar.gz -C /root/yuanweipeng
echo 'CATALINA_HOME=/root/yuanweipeng/apache-tomcat-7.0.91
 PATH=$CATALINA_HOME/bin:$PATH:$HOME/bin' > /root/.bashrc

# 开启防火墙端口
firewall-cmd --zone=public --add-port=8080/tcp --permanent