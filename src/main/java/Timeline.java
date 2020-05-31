import java.util.ArrayList;
import java.util.List;

public class Timeline {

    private ArrayList<Message> messages;

    public Timeline() {
        messages = new ArrayList();
    }

    public List<Message> getMessage() {
        return messages;
    }

    public void publish(String text) {
        messages.add(0, new Message(text));
    }
}
