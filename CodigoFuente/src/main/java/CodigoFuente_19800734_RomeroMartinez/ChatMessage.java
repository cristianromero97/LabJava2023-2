package CodigoFuente_19800734_RomeroMartinez;

import java.util.Date;

public class ChatMessage {
    private String sender;
    private String content;
    private Date timestamp;

    // Constructor
    public ChatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = new Date();
    }

    // Getter methods
    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender + ": " + content;
    }
}