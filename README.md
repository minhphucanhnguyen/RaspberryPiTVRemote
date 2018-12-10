# Raspberry Pi TV Remote

## Getting Started 
In this project, Raspberry Pi will be used to connect to Firebase and control the IR LED as just like what a TV Remote does. An Android app is built to help control the remote that requires Internet connection to operate.

Application on Raspberry Pi is coded with Python so Raspbian OS is recommended to run on Raspberry Pi.

## System Architecture

![alt text](https://github.com/minhphucanhnguyen/RaspberryPiTVRemote/blob/master/Photos/SystemArchitecture.JPG)

## Hardware

### Components for Raspberry Pi setup:

* Raspberry Pi 3
* IR LED
* 660 or 1k Ohm registor
* NPN transistor
* Wires

### How to connect

With NPN transistor, connect Emitter to 5V output from Raspberry Pi, connect Collector to GPIO23 (BCM23) with a 660/1k ohm registor between, connect Base to anode pin of IR LED (the long lead) and cathode pin of IR LED is connected to Ground pin of Raspberry Pi. 

![alt_text](https://github.com/minhphucanhnguyen/RaspberryPiTVRemote/blob/master/Photos/CircuitImage.jpg)

## Running

Connect Raspberry Pi to the Internet, open the terminal and get to the directory of the project. Then run RaspberryRemoteIR.py.

```bash
sudo python RaspberryRemoteIR.py
```

Launch Android app included in the project. On the top of the screen is the section to choose TV brand and particular TV remote model. 

The app is also supported with controlling by voice, just press the button with micro symbol and give command like "Turn on TV" or "Turn off TV" for controlling.

![alt_text](https://github.com/minhphucanhnguyen/RaspberryPiTVRemote/blob/master/Photos/AndroidAppLayout.JPG)
