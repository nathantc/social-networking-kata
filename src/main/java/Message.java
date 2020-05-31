import java.util.concurrent.TimeUnit;

public class Message {

    private String text;
    private long timeStamp;

    public Message(String text) {
        this.text = text;
        this.timeStamp = SystemCalendar.getInstance().getTimeInMillis();
    }

    public String getText() {
        return text;
    }

    public long getElapsedMinutes() {
        return TimeUnit.MILLISECONDS.toMinutes(SystemCalendar.currentTimeMillis() - timeStamp);
    }

    public String getSummary() {
        return String.format("%s (%s minutes ago)", getText(), getElapsedMinutes());
    }
}
