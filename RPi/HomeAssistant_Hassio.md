# Installation Setup
> [Tuturial URL](https://www.juanmtech.com/guide-to-home-assistant)

1. Goto [Home Assistance Installation Page](https://www.home-assistant.io/hassio/installation/) and download image for respective platform.
1. Using BalenaEtcher, install the image on SD card.
1. A drive __hassos-boot__ will be created, to setup wifi creadentials, open the drive and create a new folder __CONFIG__, inside this folder, create another folder __network__ and inside this folder create a new file __my-network.txt__, use following template (best to get updated template from the Tutorial URL):

    ```
    [connection]
    id=my-network
    uuid=YOUR_UUID_NUMBER
    type=802-11-wireless

    [802-11-wireless]
    mode=infrastructure
    ssid=YOUR_WIFI_NAME
    #Uncomment below if your SSID is not broadcasted
    #hidden=true

    [802-11-wireless-security]
    auth-alg=open
    key-mgmt=wpa-psk
    psk=YOUR_WIFI_PASSWORD

    [ipv4]
    method=auto

    [ipv6]
    addr-gen-mode=stable-privacy
    method=auto
    ```
    Go to [UUID Generator Website](https://www.uuidgenerator.net/) and paste the newly generated UUID in the field __uuid__, thene enter wifi credentials in __ssid__ and __psk__.

1. Now eject the SD card from PC, insert in Raspberry Pi and boot it.
1. After sometime, use browser and open the link http://homeassistant.local:8123/. It will show the installation page of the Hassio and will take almost 20 minutes to install the OS on the SD card. Wait until it finishes.

1. When installation finishes, reload the page. You will be greeted with basic questions, enter __username__, __password__ and __location__ etc. Then dashboard for home assistant will load up.

1. In order to configure home assistant, a file editor is required, you can either install __File Editor__ addon from Supervisor in the dashboard or use __Samba Share__ addon server to edit files on PC.
> To map network drive use __\\\\homeassistant\\config__.

> For DNS and remote connection configuration, follow tutorial.

> Download android or apple application for more functionality.

# ESP Home Integration
>  For ESP8266 or ESP32

* Follow the tutorial on [this](https://esphome.io/guides/getting_started_hassio.html) link and watch video tutorial on [this](https://www.youtube.com/watch?v=soKuma8DJWQ) link.