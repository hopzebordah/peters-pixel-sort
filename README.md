# PetersPixelSort

open this project in your fav IDE (i use vscode and just press run on one of the main()s in src/test/

you will also need to change the <filename> string in main, no GUI written for this version yet

the following command uses ffmpeg to compile a video at 30fps: 

`ffmpeg -r 60 -i %d.png -vcodec libx264 -crf 25  -pix_fmt yuv420p ~/Documents/Videos/test.mp4`
