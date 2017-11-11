package monuments;

public class EarthMonument extends Monument {

    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.setEarthAffinity(earthAffinity);
    }

    private int getEarthAffinity() {
        return this.earthAffinity;
    }

    private void setEarthAffinity(int earthAffinity) {
        this.earthAffinity = earthAffinity;
    }

    @Override
    public int getAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Earth Monument: %s, Earth Affinity: %d",
                super.getName(), this.getEarthAffinity());
    }
}
