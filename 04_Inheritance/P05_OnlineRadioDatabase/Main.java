package P05_OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PlayList pl = new PlayList();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] songData = reader.readLine().split(";");

            String singer = songData[0];
            String name = songData[1];
            String[] length = songData[2].split(":");
            int minutes = 0;
            int seconds = 0;
            try {
                try {
                    minutes = Integer.parseInt(length[0]);
                    seconds = Integer.parseInt(length[1]);
                } catch (NumberFormatException nfe) {
                    throw new InvalidSongLengthException("Invalid song length.");
                }
                Song song = new Song(singer, name, minutes, seconds);
                pl.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(pl);
    }
}
