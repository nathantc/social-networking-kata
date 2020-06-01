import java.util.List;

public class User {

    private final Publisher publisher;
    private final Timeline timeline;

    public User(String user) {
        List<Message> timelineData = TimelineData.getTimelineData(user);
        timeline = new Timeline(user, timelineData);
        publisher = new Publisher(timelineData);
    }

    public void publish(String message) {
        publisher.publish(message);
    }

    public Timeline requestTimeline(String user) {
        return new Timeline(user, TimelineData.getTimelineData(user));
    }

    public List<Message> getTimeline() {
        return timeline.getTimelineData();
    }
}
