package BE;


public class Inquiry {
    private User sender;
    private String message;
    private String reply;

    public Inquiry(User sender, String message) {
        this.sender = sender;
        this.message = message;
        this.reply = null; // Initialize reply as null
    }

    public User getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

}
