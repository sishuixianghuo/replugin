#!/bin/bash



gradle="/Users/$USER/.gradle/wrapper/dists/gradle-4.1-all/bzyivzo6n839fup2jbap0tjew/gradle-4.1/bin/gradle"


$gradle  clean
$gradle   assembleDebug
#
#

for var in `find  app/build/outputs/apk  -name "**.apk" `
do
	echo $var
#	adb install -r -t  $var
	adb push $var  /mnt/sdcard/app-release.apk
done



#
#
#adb shell reboot
#
##echo  "the end "