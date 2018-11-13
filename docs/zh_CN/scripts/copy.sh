#!/bin/bash
# FileName:   copy.sh
# Author:     Fasion Chan
# @contact:   fasionchan@gmail.com
# @version:   $Id$
#
# Description:
#
# Changelog:
#
#

SELF_PATH=`realpath "$0"`
SCRIPT_DIR_PATH=`dirname "$SELF_PATH"`
DOC_PATH=`dirname "$SCRIPT_DIR_PATH"`

for item in .misc Makefile  _fragments  _static  _templates  about  conf.py  index.rst  make.bat  scripts; do
    cp -r "$DOC_PATH/$item" "$1"
done
