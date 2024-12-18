package messages;

import java.util.Date;

import user.User;

public class Message {

	String content;
	private Date date;

	public Message() {

	}

	public Message(String content) {
		this.content = content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShortInfo() {
        return "Simple Message: " + (content != null ? content.substring(0, Math.min(10, content.length())) + "..." : "No Content");
    }

    public String getFullInfo() {
        return "Simple Message Content: " + (content != null ? content : "No Content");
    }
	
	public String toString() {
		return content;
	}

}
