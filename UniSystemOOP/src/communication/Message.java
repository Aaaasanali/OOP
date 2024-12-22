package communication;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import user.User;

public class Message implements Serializable {

	private String content;
	private User sender;
	LocalDateTime localDateTime;

	public Message() {

	}

	public Message(User sender, String content) {
		this.content = content;
		this.sender = sender;
		this.localDateTime.now();
	}

	public User getSender() {
		return sender;
	}

	private void setSender(User sender) {
		this.sender = sender;
	}

	public String getContent() {
		return this.content;
	}

	private void setContent(String content) {
		this.content = content;
	}

	private LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	private void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String toString() {
		return "Sender: " + sender.getName() + " " + sender.getSurname() + "/nContent" + content + "/nTime: "
				+ localDateTime;
	}

}

/*
 * public class Message { private User sender; private User recipient; private
 * String content; private LocalDateTime timestamp;
 * 
 * public Message(User sender, User recipient, String content, LocalDateTime
 * timestamp) { this.sender = sender; this.recipient = recipient; this.content =
 * content; this.timestamp = timestamp; }
 */