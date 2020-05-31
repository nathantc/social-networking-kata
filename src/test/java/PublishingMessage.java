import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PublishingMessage {

    @Test
    public void timelineReturnListOfMessages() {
        Timeline timeline = new Timeline();
        List<Message> messages = timeline.getMessage();
        assertThat(messages.size()).isEqualTo(0);
    }

    @Test
    public void test() {
        Timeline timeline = new Timeline();
        String text = "I love the weather today.";
        timeline.publish(text);

        List<Message> messages = timeline.getMessage();
        assertThat(messages.size()).isEqualTo(1);
        assertThat(messages.get(0).getText()).isEqualTo(text);
    }
}
