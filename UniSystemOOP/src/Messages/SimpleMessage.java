package Messages;

import user.User;

public class SimpleMessage extends Message {
    private User receiver;
    private String subject; 
    private String timestamp;

  

    public SimpleMessage(User sender, User receiver, String content) {
        super(sender, content); 
        this.timestamp = java.time.LocalDateTime.now().toString(); 
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTimestamp() {
        return timestamp;
    }

    
    public void send() {

        if (receiver != null) {
            this.receiver.receiveMessage(this);
            System.out.println("Message sent to " + receiver);
        } else {
            System.out.println("Receiver is not specified.");
        }
    }


    public String getShortInfo() {
        return "Message to: " + receiver + "\nSubject: " + subject + "\nSent at: " + timestamp + "\nContent: " + getContent();
    }
}
