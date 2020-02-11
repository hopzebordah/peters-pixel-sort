package util;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.awt.Desktop;

// A class with static functions to r/w images from filesystem
public class ImageFileFunctions
{
    public static BufferedImage readImageFromFile(String filename) throws IOException
    {
        BufferedImage img = null;
        img = ImageIO.read(new File(filename));
        return img;
    }

    public static List<HsbColor> imageToHsbColorArray(BufferedImage img, int width, int height)
    {
        List<HsbColor> arr = new ArrayList<HsbColor>();
        for (int w=0; w<width; w++) {
            for (int h=0; h<height; h++) {
                arr.add(new HsbColor(img.getRGB(w, h)));
            }
        }
        return arr;
    }

    public static void writeBufferedImageToPng(BufferedImage img, String filename) throws IOException
    {
        ImageIO.write(img, "png", new File(filename));
    }

    public static void writeHsbColorArrayToFile(List<HsbColor> arr, int width, int height, String filename) throws IOException
    {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int w=0; w<width; w++) {
           for (int h=0; h<height; h++) {
              img.setRGB(w, h, arr.get(h*width + w).getRGB());
           }
        }
        ImageIO.write(img, "png", new File(filename));
    }

    public static boolean createDirectory(String dirPath) {
        File directory = new File(dirPath);
        if (directory.exists()) {           // if the directory exists,
            if (!directory.delete()) {      // nuke it. if unsuccessful, 
                return false;               // return false
            }
        }
        if (directory.mkdir()) {            // we made it down here bc successful. so make a directory
            return true;                    // return true if successful
        }
        return false;                       // else return false
    }

    public static void openImage(String filename) throws IOException
    {
        Desktop.getDesktop().open(new File(filename));
    }
}