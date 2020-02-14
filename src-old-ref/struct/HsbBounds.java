package struct;

public class HsbBounds {

    private Bounds hueBounds;
    private Bounds saturationBounds;
    private Bounds brightnessBounds;

    public HsbBounds(Bounds hueBounds, Bounds saturationBounds, Bounds brightnessBounds) {
        this.hueBounds = new Bounds(hueBounds);
        this.saturationBounds = new Bounds(saturationBounds);
        this.brightnessBounds = new Bounds(brightnessBounds);
    }

    // copy constructor
    public HsbBounds(HsbBounds other) {
        this.hueBounds = new Bounds(other.getHueBounds());
        this.saturationBounds = new Bounds(other.getSaturationBounds());
        this.brightnessBounds = new Bounds(other.getBrightnessBounds());
    }

    // MARK: getters/setters
    public Bounds getHueBounds() {
        return this.hueBounds;
    }

    public void setHueBounds(Bounds hueBounds) {
        this.hueBounds = new Bounds(hueBounds);
    }

    public Bounds getSaturationBounds() {
        return this.saturationBounds;
    }

    public void setSaturationBounds(Bounds saturationBounds) {
        this.saturationBounds = new Bounds(saturationBounds);
    }

    public Bounds getBrightnessBounds() {
        return this.brightnessBounds;
    }

    public void setBrightnessBounds(Bounds brightnessBounds) {
        this.brightnessBounds = new Bounds(brightnessBounds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("H[" + this.hueBounds + "], ");
        sb.append("S[" + this.saturationBounds + "], ");
        sb.append("B[" + this.brightnessBounds + "]");
        return sb.toString();
    }
}