package Messages;

import user.User;

public class SimpleMessage extends Message{
	private User receiver;
	public SimpleMessage() {}
	
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	public void send() {
		this.receiver.receiveMessage(this);
	}
}
