import benders.Bender;
import monuments.Monument;

import java.util.List;

class Controller {

    private static Nation airNation = new Nation();
    private static Nation earthNation = new Nation();
    private static Nation fireNation = new Nation();
    private static Nation waterNation = new Nation();

    private static Nation getNation(String nationName) {
        switch (nationName) {
            case "Air":
                return Controller.airNation;
            case "Earth":
                return Controller.earthNation;
            case "Fire":
                return Controller.fireNation;
            case "Water":
                return Controller.waterNation;
            default:
                return null;
        }
    }

    static void addBender(String[] params) {
        Bender bender = Factory.createBender(params);
        switch (params[1]) {
            case "Air":
                airNation.addBender(bender);
                break;
            case "Earth":
                earthNation.addBender(bender);
                break;
            case "Fire":
                fireNation.addBender(bender);
                break;
            case "Water":
                waterNation.addBender(bender);
                break;
        }
    }

    static void addMonument(String[] params) {
        Monument monument = Factory.createMonument(params);
        switch (params[1]) {
            case "Air":
                airNation.addMonument(monument);
                break;
            case "Earth":
                earthNation.addMonument(monument);
                break;
            case "Fire":
                fireNation.addMonument(monument);
                break;
            case "Water":
                waterNation.addMonument(monument);
                break;
        }
    }

    static StringBuilder showStatus(String nationName) {
        StringBuilder result = new StringBuilder();
        result.append(nationName).append(" Nation").append(System.lineSeparator());

        // append all benders
        result.append("Benders:");
        List<Bender> benders = getNation(nationName).getBenders();
        if (benders.size() == 0) {
            result.append(" None");
        } else {
            for (Bender bender : benders) {
                result.append(System.lineSeparator());
                result.append(bender);
            }
        }
        result.append(System.lineSeparator());

        // append all monuments
        result.append("Monuments:");
        List<Monument> monuments = getNation(nationName).getMonuments();
        if (monuments.size() == 0) {
            result.append(" None");
        } else {
            for (Monument monument : monuments) {
                result.append(System.lineSeparator());
                result.append(monument);
            }
        }
        return result;
    }

    static void beginWar() {
        // find the one nation with max power
        boolean airIsBest = airNation.calculatePower() > earthNation.calculatePower() &&
                airNation.calculatePower() > fireNation.calculatePower() &&
                airNation.calculatePower() > waterNation.calculatePower();
        boolean earthIsBest = earthNation.calculatePower() > airNation.calculatePower() &&
                earthNation.calculatePower() > fireNation.calculatePower() &&
                earthNation.calculatePower() > waterNation.calculatePower();
        boolean fireIsBest = fireNation.calculatePower() > earthNation.calculatePower() &&
                fireNation.calculatePower() > airNation.calculatePower() &&
                fireNation.calculatePower() > waterNation.calculatePower();
        if (airIsBest) {
            clearBendersAndMonuments(new String[] {"Earth", "Fire", "Water"});
        } else if (earthIsBest) {
            clearBendersAndMonuments(new String[] {"Air", "Fire", "Water"});
        } else if (fireIsBest) {
            clearBendersAndMonuments(new String[] {"Earth", "Air", "Water"});
        } else {
            clearBendersAndMonuments(new String[] {"Earth", "Air", "Fire"});
        }
    }

    static void clearBendersAndMonuments(String[] nationNames) {
        for (String name : nationNames) {
            getNation(name).clearBendersAndMonuments();
        }
    }
}
