package test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import driver.PixelSortDriver;
import struct.Bounds;
import struct.HsbBounds;
import util.ImageFileFunctions;

public class CommandLineIncrement {

    final static String originalFilename = "/Users/alexanderpeters/Documents/Pictures/IMG_0857.jpeg";
    final static String writtenDirectory = originalFilename + "_sortedImages/";

    static long writtenImageNum = 0;
    static long fps = 30;
    static long seconds = 5;

    static Bounds intensity = new Bounds(0, 10);

    final static HsbBounds hsbBounds = new HsbBounds(
        new Bounds(0, 5), // hue
        new Bounds(0, 100), // saturation
        new Bounds(60, 100)  // brightness
    );

    final static int jumpSize = 5;

    public static void main(String [] args) {
        BufferedImage img = readImage(originalFilename);
        PixelSortDriver sorter = new PixelSortDriver(img);

        ImageFileFunctions.createDirectory(writtenDirectory); // create output directory

        String writtenFilename;
        for (int i=0; i<fps*seconds; i++) {
            img = sorter.pullDown(intensity, hsbBounds, jumpSize);
            writtenFilename = writtenDirectory + writtenImageNum + ".png";
            System.out.println("writing " + writtenFilename + "...");
            writeImage(img, writtenFilename);
            writtenImageNum++;
            // if (i % 10 == 0) {
            //     intensity.setCeiling(intensity.getCeiling() + 1);
            // }
        }
    }

    private static BufferedImage readImage(String filename) {
        try {
            return ImageFileFunctions.readImageFromFile(filename);
        } catch (IOException e) {
            System.out.println("could not read image from file. quitting...");
            System.exit(1);
        }
        return null;
    }

    private static void writeImage(BufferedImage img, String filename) {
        try {
            ImageFileFunctions.writeBufferedImageToPng(img, filename);
        } catch (IOException e) {
            System.out.println("could not write image to file. quitting...");
            System.exit(1);
        }
    }

    private static void openImage(String filename) {
        try {
            ImageFileFunctions.openImage(filename);
        } catch (IOException e) {
            System.out.println("could not open image. quitting...");
            System.exit(1);
        }
    }

}