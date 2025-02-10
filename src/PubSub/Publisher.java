package PubSub;

import java.util.HashSet;
import java.util.Set;

public class Publisher {

    Set<Topic> topics;
    public Publisher() {
        topics = new HashSet<>();
    }
    public void registerTopic(Topic topic) {
        topics.add(topic);
    }

    public void publishMessage(Message message, Topic topic) {
        if(!topics.contains(topic)) {
            System.out.println("First register the topic for publisher: " + topic);
            return;
        }
        topic.publishMessage(message);
    }
}
