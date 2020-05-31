import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimelineData {

    private static Map<String, List<Message>> timelineData;

    static {
        initialize();
    }

    public static List<Message> getTimelineData(String user) {
        List<Message> timeline = timelineData.get(user);
        if (timeline == null) {
            timeline = new ArrayList<Message>();
            timelineData.put(user, timeline);
        }
        return timeline;
    }

    public static void initialize() {
        timelineData = new HashMap<>();
    }
}
