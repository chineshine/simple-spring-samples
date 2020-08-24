#!/bin/bash

# define the data dir
DATA_DIR = "${DATA_DIR:/data}"

mkdir -p DATA_DIR
chcon -Rt svirt_sandbox_file_t /data

# mysql
mkdir -p /data/mariadb/conf 
cp ./config/mariadb/my.cnf /data/mariadb/conf/