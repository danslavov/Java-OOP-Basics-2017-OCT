package P05_OnlineRadioDatabase;

public class InvalidArtistNameException extends InvalidSongException {
    InvalidArtistNameException(String message) {
        super(message);
    }
}
