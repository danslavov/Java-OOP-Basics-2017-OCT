package P05_OnlineRadioDatabase;

public class InvalidSongMinutesException extends InvalidSongLengthException {
    InvalidSongMinutesException(String message) {
        super(message);
    }
}
