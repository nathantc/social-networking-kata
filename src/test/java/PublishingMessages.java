import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PublishingMessages {

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
        return timeline.getMessages();
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
    public void summaryContainsMessageTextAndElapsedTime() {
        setElapsedMinutes(15);
        publishMessage("Are you going to the game?");
        setElapsedMinutes(25);
        publishMessage("??");

        setElapsedMinutes(30);
        List<Message> messages = getPublishedMessages();
        assertThat(messages.get(0).getSummary()).isEqualTo("?? (5 minutes ago)");
        assertThat(messages.get(1).getSummary()).isEqualTo("Are you going to the game? (15 minutes ago)");
    }

    private void publishMessage(String messageText1) {
        timeline.publish(messageText1);
    }

    private void setElapsedMinutes(int elapsedMinutes) {
        testCalendar.set(2020, 5, 31, 7, elapsedMinutes, 0);
    }
}
