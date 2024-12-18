package Messages;

import java.util.*;

import user.User;

public abstract class Message {
	private User sender;
	private Date date;
	private String content;
	
	public Message() {
		this.date = new Date();
	}

	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getDate() {
		return this.date;
	}

}
