package util;

import java.awt.Color;
import java.lang.Comparable;

// this is a subclass of the default awt.Color class that implements Comparable for sorting and 
// contains a getHue function that allows for color comparison
public class HsbColor extends Color implements Comparable<HsbColor> {

   private static final long serialVersionUID = 5494984795023972157L;
   private float[] hsv = new float[3];

   // MARK: constructors
   public HsbColor(int r, int g, int b) {
      super(r, g, b);
      RGBtoHSB(getRed(), getGreen(), getBlue(), this.hsv);
   }

   public HsbColor(int rgb) {
      super(rgb);
      RGBtoHSB(getRed(), getGreen(), getBlue(), this.hsv);
   }

   // MARK: public methods
   // get hue method uses the inbuilt HSB func and multiplies the hue val
   public int getHue() {
      return (int)(this.hsv[0]*100);
   }

   public int getSaturation() {
      return (int)(this.hsv[1]*100);
   }

   public int getBrightness() {
      return (int)(this.hsv[2]*100);
   }

   public int getHueZone() {
      int hue = getHue();
      int extra = hue % 100;
      return hue - extra;
   }

   @Override
   public int compareTo(HsbColor a) {
      return this.getHue() - a.getHue();
   }
}