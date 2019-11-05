package test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import driver.PixelSortDriver;
import struct.Bounds;
import struct.HsbBounds;
import util.ImageFileFunctions;

public class CommandLineSingle {

    final static String filename = "/Users/alexanderpeters/Documents/Pictures/IMG_0857.jpeg";
    final static String writtenFilename = filename + ".sorted.png";

    final static Bounds intensity = new Bounds(0, 25);

    final static HsbBounds hsbBounds = new HsbBounds(
        new Bounds(0, 5), // hue
        new Bounds(0, 100), // saturation
        new Bounds(60, 100)  // brightness
    );

    final static int jumpSize = 10;

    public static void main(String [] args) {
        BufferedImage img = readImage(filename);
        PixelSortDriver sorter = new PixelSortDriver(img);
        img = sorter.pullDown(intensity, hsbBounds, jumpSize);
        writeImage(img, writtenFilename);
        openImage(writtenFilename);
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
            ImageFileFunctions.writeBufferedImageToPng(img, writtenFilename);
        } catch (IOException e) {
            System.out.println("could not write image to file. quitting...");
            System.exit(1);
        }
    }

    private static void openImage(String filename) {
        try {
            ImageFileFunctions.openImage(writtenFilename);
        } catch (IOException e) {
            System.out.println("could not open image. quitting...");
            System.exit(1);
        }
    }

}