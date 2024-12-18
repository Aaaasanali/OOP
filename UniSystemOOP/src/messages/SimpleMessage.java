package messages;

public class SimpleMessage extends Message {
	
	public String getShortInfo() {
        return "Simple Message: " + (content != null ? content.substring(0, Math.min(10, content.length())) + "..." : "No Content");
    }

    public String getFullInfo() {
        return "Simple Message Content: " + (content != null ? content : "No Content");
    }
	
}
