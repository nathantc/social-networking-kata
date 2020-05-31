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
        List<Message> messages = timeline.getMessage();
        assertThat(messages.size()).isEqualTo(0);
    }

    @Test
    public void timelineReturnsPublishedMessage() {
        String text = "I love the weather today.";
        timeline.publish(text);

        List<Message> messages = timeline.getMessage();
        assertThat(messages.size()).isEqualTo(1);
        assertThat(messages.get(0).getText()).isEqualTo(text);
    }

    @Test
    public void messagesReturnedInReverseChronologicalOrder() {
        String messageText1 = "We lost!";
        timeline.publish(messageText1);
        String messageText2 = "Good game though!";
        timeline.publish(messageText2);

        List<Message> messages = timeline.getMessage();
        Message message2 = messages.get(0);
        assertThat(message2.getText()).isEqualTo(messageText2);
        Message message1 = messages.get(1);
        assertThat(message1.getText()).isEqualTo(messageText1);
    }

    @Test
    public void messagesReturnElapsedMinutesFromPublishedDate() {
        setElapsedMinutes(15);
        publishMessage("??");
        setElapsedMinutes(25);
        publishMessage("Are you going to the game?");

        setElapsedMinutes(30);
        List<Message> messages = timeline.getMessage();
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
