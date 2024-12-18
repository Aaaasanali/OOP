package messages;

import enumerations.MessageType;

public class MessageFactory {

	public Message createMessage(MessageType messageType) {
		Message message = null;

		switch(messageType) {
		case SIMPLE:
			message = new SimpleMessage();
			break;
		case REQUEST:
			message = new Request();
			break;
		case COMPLAINT:
			message = new Complaint();
			break;
		default:
			throw new IllegalArgumentException("Invalid MessageType: " + messageType);
		}

		return message;

	}
}
