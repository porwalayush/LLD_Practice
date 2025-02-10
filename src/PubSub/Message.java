package PubSub;

public class Message {
    private final String content;
    Message(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
}
