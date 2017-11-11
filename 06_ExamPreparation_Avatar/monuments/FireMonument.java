package monuments;

public class FireMonument extends Monument {

    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.setFireAffinity(fireAffinity);
    }

    private int getFireAffinity() {
        return this.fireAffinity;
    }

    private void setFireAffinity(int fireAffinity) {
        this.fireAffinity = fireAffinity;
    }

    @Override
    public int getAffinity() {
        return this.fireAffinity;
    }

    @Override
    public String toString() {
        return String.format("###Fire Monument: %s, Fire Affinity: %d",
                super.getName(), this.getFireAffinity());
    }
}
