package entities.cells.microbes;

public class Virus extends Microbe {

    public Virus(String id, int health, int positionRow,
                    int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + super.getVirulence();
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]\n" +
                        "--------Health: %d | Virulence: %d | Energy: %d",
                super.getId(), super.getPositionRow(), super.getPositionCol(),
                super.getHealth(), super.getVirulence(), this.getEnergy());
    }
}
