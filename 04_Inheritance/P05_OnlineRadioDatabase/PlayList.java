package P05_OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Song> playList;

    PlayList() {
        this.playList = new ArrayList<>();
    }

    public void addSong(Song song) {
        playList.add(song);
    }

    public String calculateLength() {
        int lengthInSeconds = 0;
        for (Song song : playList) {
            lengthInSeconds += song.getLengthinSeconds();
        }
        int hours = lengthInSeconds / 3600;
        int minutes = (lengthInSeconds % 3600) / 60;
        int seconds = (lengthInSeconds % 3600) % 60;

        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("Songs added: %d%nPlaylist length: %s",
                this.playList.size(), this.calculateLength());
    }
}
