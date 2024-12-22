package documents;

import java.io.Serializable;

import communication.Message;

public class Request extends Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private String content;
	private boolean isSignedByDean;
	private boolean isSignedByRector;

	private String senderName;
	private String senderSurname;

//    public Request(String content) {
//        this.content = content;
//        this.isSignedByDean = false;
//        this.isSignedByRector = false;
//    }

	public Request(String content, String senderName, String senderSurname) {
		this.content = content;
		this.senderName = senderName;
		this.senderSurname = senderSurname;
		this.isSignedByDean = false;
		this.isSignedByRector = false;
	}

	public String getContent() {
		return content;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderSurname() {
		return senderSurname;
	}

	public boolean isSignedByDean() {
		return isSignedByDean;
	}

	public boolean isSignedByRector() {
		return isSignedByRector;
	}

	public void signByDean() {
		if (!isSignedByDean) {
			isSignedByDean = true;
			System.out.println("Dean has signed the request.");
		}
	}

	public void signByRector() {
		if (!isSignedByRector) {
			isSignedByRector = true;
			System.out.println("Rector has signed the request.");
		}
	}

	public String toString() {
		return "Request. " + "Content: '" + content + "'" + " | sender: " + senderName + " " + senderSurname;// +
//                " | isSignedByDean: " + isSignedByDean+
//                " | isSignedByRector: " + isSignedByRector;

	}
}