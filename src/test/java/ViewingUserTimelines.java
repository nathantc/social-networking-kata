import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewingUserTimelines {

    @Test
    public void test() {
        User alice = new User("Alice");
        alice.publish("I love the weather today!");

        User bob = new User("Bob");
        bob.publish("We lost!");
        bob.publish("Good game though!");

        Timeline timeline = alice.requestTimeline("Bob");
        List<Message> messages = timeline.getMessages();
        assertThat(messages.size()).isEqualTo(2);
        assertThat(messages.get(0).getText()).isEqualTo("Good game though!");
        assertThat(messages.get(1).getText()).isEqualTo("We lost!");
    }
}
