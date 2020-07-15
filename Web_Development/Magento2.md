# Installation with Docker

Follow [this](https://www.magemodule.com/all-things-magento/magento-2-tutorials/docker-magento-2-development/) link for the complete installation tutorial.

To install `php7.3` version and have multiversion __php__ insallations because latest version is not supported by Mangento, enter following commands:
```bash
$ sudo apt install software-properties-common OR
$ sudo apt install python-software-properties
```
then
```bash
$ sudo add-apt-repository ppa:ondrej/php
$ sudo apt-get update
$ sudo apt install php7.3   [PHP 7.3]
```
To set the default __php__ version and find the default loaded php configuration file:
```bash
$ sudo update-alternatives --set php /usr/bin/php7.3
$ php -i | grep "Loaded Configuration File"
```
Fix Missing Repos. e.g
```bash
$ sudo apt install php7.3-bcmath
$ sudo apt install php7.3-curl
$ sudo apt install php7.3-cli php7.3-xml php7.3-mysql
$ sudo apt install php7.3-gd
$ sudo apt install php7.3-intl
$ sudo apt install php7.3-mbstring
$ sudo apt install php7.3-soap
$ sudo apt install php7.3-xsl
$ sudo apt install php7.3-zip

$ sudo apt-get update
$ sudo apt-get upgrade
```
# To be continued
---
---
---

# Magento Cloud Installation

