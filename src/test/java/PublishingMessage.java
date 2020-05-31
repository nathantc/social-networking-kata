import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PublishingMessage {

    private Timeline timeline;
    private Calendar testCalendar;

    @Before
    public void before() {
        timeline = new Timeline();
        testCalendar = Calendar.getInstance();
        SystemCalendar.override(testCalendar);
    }

    @Test
    public void timelineInitializedWithZeroMessages() {
        List<Message> messages = getPublishedMessages();
        assertThat(messages.size()).isEqualTo(0);
    }

    private List<Message> getPublishedMessages() {
        return timeline.getMessage();
    }

    @Test
    public void timelineReturnsPublishedMessage() {
        publishMessage("I love the weather today.");

        List<Message> messages = getPublishedMessages();
        assertThat(messages.size()).isEqualTo(1);
        assertThat(messages.get(0).getText()).isEqualTo("I love the weather today.");
    }

    @Test
    public void messagesReturnedInReverseChronologicalOrder() {
        publishMessage("We lost!");
        publishMessage("Good game though!");

        List<Message> messages = getPublishedMessages();
        assertThat(messages.get(0).getText()).isEqualTo("Good game though!");
        assertThat(messages.get(1).getText()).isEqualTo("We lost!");
    }

    @Test
    public void messagesReturnElapsedMinutesFromPublishedDate() {
        setElapsedMinutes(15);
        publishMessage("??");
        setElapsedMinutes(25);
        publishMessage("Are you going to the game?");

        setElapsedMinutes(30);
        List<Message> messages = getPublishedMessages();
        assertThat(messages.get(0).getElapsedMinutes()).isEqualTo(5);
        assertThat(messages.get(1).getElapsedMinutes()).isEqualTo(15);
    }

    private void publishMessage(String messageText1) {
        timeline.publish(messageText1);
    }

    private void setElapsedMinutes(int elapsedMinutes) {
        testCalendar.set(2020, 5, 31, 7, elapsedMinutes, 0);
    }
}
