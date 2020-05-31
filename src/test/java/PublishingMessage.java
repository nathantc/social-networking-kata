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
}
