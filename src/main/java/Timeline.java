import java.util.ArrayList;
import java.util.List;

public class Timeline {

    private String owner;
    private List<Message> timelineData;

    public Timeline(String owner, List<Message> timelineData) {
        this.owner = owner;
        this.timelineData = timelineData;
    }

    public List<Message> getTimelineData() {
        return new ArrayList<>(timelineData);
    }

    public String getOwner() {
        return owner;
    }
}
