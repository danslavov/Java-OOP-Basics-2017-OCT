package P05_OnlineRadioDatabase;

public class Song {
    private String singer;
    private String name;
    private int minutes;
    private int seconds;

    Song(String singer, String name, int minutes, int seconds) throws InvalidSongException {
        setSinger(singer);
        setName(name);
        setLength(minutes, seconds);
    }

    private void setSinger(String singer) throws InvalidArtistNameException {
        if (singer.length() < 3 || singer.length() > 20) {
            throw new InvalidArtistNameException(
                    "Artist name should be between 3 and 20 symbols.");
        }
        this.singer = singer;
    }

    private void setName(String name) throws InvalidSongNameException {
        if (name.length() < 3 || name.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.name = name;
    }

    private void setLength(int minutes, int seconds) throws InvalidSongLengthException {
        int length = minutes + seconds;
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        if (length < 0 || length > 899) {
            throw new InvalidSongLengthException("Invalid song length.");
        }
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getLengthinSeconds() {
        return this.minutes * 60 + this.seconds;
    }
}
