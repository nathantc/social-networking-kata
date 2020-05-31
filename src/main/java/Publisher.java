import java.util.List;

public class Publisher {

    private List<Message> timelineData;

    public Publisher(List<Message> timelineData) {
        this.timelineData = timelineData;
    }

    public void publish(String text) {
        timelineData.add(0, new Message(text));
    }

}
