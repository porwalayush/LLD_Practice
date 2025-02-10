package PubSub;

public class PubSubDemo {
    public static void main(String[] args) {
        Publisher pub1 = new Publisher();
        Publisher pub2 = new Publisher();

        Subscriber subscriber1 = new PrintSubscriber("subscriber1");
        Subscriber subscriber2 = new PrintSubscriber("subscriber2");

        Topic topic1 = new Topic("topic1");
        Topic topic2 = new Topic("topic2");

        topic1.addSubscriber(subscriber1);
        topic1.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber1);

        pub1.registerTopic(topic1);
        pub2.registerTopic(topic2);

        pub1.publishMessage(new Message("Ayush is learning LLD"), topic1);
        pub2.publishMessage(new Message("Ayush is learning HLD Also"), topic2);

        topic1.removeSubscriber(subscriber1);

        pub1.publishMessage(new Message("Ayush is learning LLD"), topic1);
        pub2.publishMessage(new Message("Ayush is learning HLD Also"), topic2);
    }
}
