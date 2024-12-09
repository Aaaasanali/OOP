package oop.Documents;

import java.time.LocalDateTime;

import oop.User;

public class Message {
	private User sender;
    private User recipient;
    private String content;
    private LocalDateTime timestamp;

    public Message(User sender, User recipient, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.timestamp = timestamp;
    }
    
    
    
    
    
    
}
