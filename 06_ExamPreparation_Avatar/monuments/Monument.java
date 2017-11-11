package monuments;

public abstract class Monument {

    private String name;

    Monument(String name) {
        setName(name);
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public abstract int getAffinity();

    @Override
    public abstract String toString();
}
