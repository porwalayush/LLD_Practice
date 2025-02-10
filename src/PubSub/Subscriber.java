package PubSub;

public interface Subscriber {
    void onMessage(Message message);
}
