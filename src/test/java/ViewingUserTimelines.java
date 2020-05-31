import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewingUserTimelines {

    private User alice;
    private User bob;

    @Before
    public void before() {
        TimelineData.initialize();

        alice = new User("Alice");
        alice.publish("I love the weather today!");

        bob = new User("Bob");
        bob.publish("We lost!");
        bob.publish("Good game though!");
    }

    @Test
    public void aliceMayViewBobsMessages() {
        Timeline timeline = alice.requestTimeline("Bob");
        List<Message> messages = timeline.getTimelineData();
        assertThat(messages.size()).isEqualTo(2);
        assertThat(messages.get(0).getText()).isEqualTo("Good game though!");
        assertThat(messages.get(1).getText()).isEqualTo("We lost!");
    }

    @Test
    public void bobCannotAddMessagesToAlicesTimeline() {
        Timeline alicesTimeline = bob.requestTimeline("Alice");
        assertThat(alicesTimeline.getTimelineData().size()).isEqualTo(1);
        assertThat(alicesTimeline.getOwner()).isEqualTo("Alice");

        alicesTimeline.getTimelineData().add(new Message("Bob is cooler than me."));
        assertThat(alicesTimeline.getTimelineData().size()).isEqualTo(1);
    }
}
