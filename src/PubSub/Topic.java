package PubSub;

import java.util.HashSet;
import java.util.Set;

public class Topic {
    private final String name;
    Set<Subscriber> subscribers;
    public Topic(String name) {
        this.name = name;
        subscribers = new HashSet<>();
    }
    void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    void publishMessage(Message message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.onMessage(message);
        }
    }
}
