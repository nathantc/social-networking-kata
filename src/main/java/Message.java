import java.util.concurrent.TimeUnit;

public class Message {

    private String text;
    private long timeStamp;

    public Message(String text, long timeStamp) {
        this.text = text;
        this.timeStamp = timeStamp;
    }

    public String getText() {
        return text;
    }

    public long getElapsedMinutes() {
        return TimeUnit.MILLISECONDS.toMinutes(SystemCalendar.currentTimeMillis() - timeStamp);
    }
}
