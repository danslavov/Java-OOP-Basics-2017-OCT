import benders.Bender;
import monuments.Monument;

import java.util.LinkedList;
import java.util.List;

class Nation {

    private List<Bender> benders;
    private List<Monument> monuments;

    Nation() {
        this.benders = new LinkedList<>();
        this.monuments = new LinkedList<>();
    }

    List<Bender> getBenders() {
        return this.benders;
    }

    List<Monument> getMonuments() {
        return monuments;
    }

    void addBender(Bender bender) {
        this.benders.add(bender);
    }

    void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    double calculatePower() {
        double benderPower = 0d;
        for (Bender bender : this.getBenders()) {
            benderPower += bender.calculateTotalPower();
        }
        int monumentFactor = 0;
        for (Monument monument : this.getMonuments()) {
            monumentFactor += monument.getAffinity();
        }
        return benderPower + (benderPower * monumentFactor / 100);
    }

    void clearBendersAndMonuments() {
        this.getBenders().clear();
        this.getMonuments().clear();
    }
}
