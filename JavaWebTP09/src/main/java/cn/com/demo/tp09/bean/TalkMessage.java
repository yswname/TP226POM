package cn.com.demo.tp09.bean;

public class TalkMessage {
    private String sender;
    private String content;
    
    public TalkMessage(String sender, String content) {
    	this.sender = sender;
    	this.content = content;
    }
    
	public String getSender() {
		return sender;
	}
	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return this.sender + " 说:" + this.content;
	}
	
	
}
