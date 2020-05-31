import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PublishingMessage {

    private Timeline timeline;

    @Before
    public void before() {
        timeline = new Timeline();
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
}
