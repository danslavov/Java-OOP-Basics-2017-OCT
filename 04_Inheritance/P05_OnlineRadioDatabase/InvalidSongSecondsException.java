package P05_OnlineRadioDatabase;

public class InvalidSongSecondsException extends InvalidSongLengthException {
    InvalidSongSecondsException(String message) {
        super(message);
    }
}
