package documents;

import java.io.Serializable;

public class Request implements Serializable{
    private String content;
    private boolean isSignedByDean;
    private boolean isSignedByRector;

    public Request(String content) {
        this.content = content;
        this.isSignedByDean = false;
        this.isSignedByRector = false;
    }

    public String getContent() {
        return content;
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
}