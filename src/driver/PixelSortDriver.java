package driver;

import util.HsbColor;

import java.awt.image.BufferedImage;
import java.util.Random;

import struct.Bounds;
import struct.HsbBounds;

public class PixelSortDriver {

    private BufferedImage baseImage;
    private int imageWidth, imageHeight;

    private Bounds intensity = new Bounds(0, 10);

    private HsbBounds hsbBounds = new HsbBounds(
        new Bounds(0, 100), 
        new Bounds(0, 100), 
        new Bounds(0, 100)
    );
    
    private int jumpSize = 10;

    public PixelSortDriver() {
        this.baseImage = null;
    }

    public PixelSortDriver(BufferedImage baseImage) {
        this.baseImage = baseImage;
        this.imageWidth = this.baseImage.getWidth();
        this.imageHeight = this.baseImage.getHeight();
    }

    // MARK: getters/setters
    public BufferedImage getBaseImage() {
        return this.baseImage;
    }

    public void setBaseImage(BufferedImage baseImage) {
        this.baseImage = baseImage;
        if (this.baseImage == null) {
            this.imageWidth = 0;
            this.imageHeight = 0;
            return;
        }
        this.imageWidth = this.baseImage.getWidth();
        this.imageHeight = this.baseImage.getHeight();
    }

    // MARK: pull pixels vertical
    public BufferedImage pullDown(Bounds intensity, HsbBounds hsbBounds, int jumpSize) {
        this.intensity = new Bounds(intensity);
        this.hsbBounds = new HsbBounds(hsbBounds);
        this.jumpSize = jumpSize;

        for (int w=0; w<this.imageWidth; w++) {
            for (int h=0; h<this.imageHeight; h+=this.jumpSize) {
                HsbColor col = new HsbColor(this.baseImage.getRGB(w, h));

                if (this.pixelQualifies(col))
                    this.pullPixelDown(w, h);
            }
        }
        return this.baseImage;
    }

    // MARK: private functions
    private boolean pixelQualifies(HsbColor color) {
        if (this.hsbBounds.getHueBounds().isWithinBounds(color.getHue())) {
            if (this.hsbBounds.getSaturationBounds().isWithinBounds(color.getSaturation())) {
                if (this.hsbBounds.getBrightnessBounds().isWithinBounds(color.getBrightness())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void pullPixelDown(int x, int y) {
        Random rand = new Random();
        HsbColor col = new HsbColor(this.baseImage.getRGB(x, y));

        int intensity = rand.nextInt(this.intensity.getCeiling() - this.intensity.getFloor() + 1) + this.intensity.getFloor();
        
        for (int offset=y; offset<y+intensity; offset++) {
            if (offset == this.imageHeight-1)
                break;
            this.baseImage.setRGB(x, offset, col.getRGB());
        }
    }

}