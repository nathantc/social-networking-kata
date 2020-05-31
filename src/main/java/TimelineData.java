import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class TimelineData {

    private static Map<String, Timeline> timelineData;

    static {
        timelineData = new HashMap<>();
    }

    public static Timeline getTimeline(String user) {
        Timeline timeline = timelineData.get(user);
        if (timeline == null) {
            timeline = new Timeline();
            timelineData.put(user, timeline);
        }
        return timeline;
    }
}
