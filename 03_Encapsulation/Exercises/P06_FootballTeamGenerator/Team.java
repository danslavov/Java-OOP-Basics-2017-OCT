package Exercises.P06_FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;

public class Team {
    private String name;
    private Map<String, Player> players;

    public Team(String name) {
        setName(name);
        this.players = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || " ".equals(name)) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private double getRating() {
        double sum = 0.0;
        for (Player player : players.values()) {
            sum += player.getAverage();
        }
        return sum / players.size();
    }

    public void addPlayer(Player player) {
        this.players.put(player.getName(), player);
    }

    public void removePlayer(String playerName) {
        if (!this.players.containsKey(playerName)) {
            throw new IllegalArgumentException(String.format(
                    "Player %s is not in %s team.", playerName, this.name));
        }
        this.players.remove(playerName);
    }

    @Override
    public String toString() {
        return this.getName() + " - " + Math.round(this.getRating());
    }


}
