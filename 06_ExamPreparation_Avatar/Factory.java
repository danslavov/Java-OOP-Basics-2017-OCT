import benders.*;
import monuments.*;

public class Factory {

    public static Bender createBender(String params[]) {
        String type = params[1];
        String name = params[2];
        int power = Integer.parseInt(params[3]);
        double secPar = Double.parseDouble(params[4]);

        switch (type) {
            case "Air":
                return new AirBender(name, power, secPar);
            case "Earth":
                return new EarthBender(name, power, secPar);
            case "Fire":
                return new FireBender(name, power, secPar);
            case "Water":
                return new WaterBender(name, power, secPar);
            default:
                return null;
        }
    }

    public static Monument createMonument(String params[]) {
        String type = params[1];
        String name = params[2];
        int secPar = Integer.parseInt(params[3]);

        switch (type) {
            case "Air":
                return new AirMonument(name, secPar);
            case "Earth":
                return new EarthMonument(name, secPar);
            case "Fire":
                return new FireMonument(name, secPar);
            case "Water":
                return new WaterMonument(name, secPar);
            default:
                return null;
        }
    }
}
