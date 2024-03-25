package chatSystem.model;

public class Message {
    private String message;
    private Personne sender;

    public Message(String message, Personne sender) {
        this.message = message;
        this.sender = sender;
    }

    public String getMessage() {
        return this.message;
    }

    public Personne getSender() {
        return this.sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSender(Personne sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return this.sender + " : " + this.message;
    }
}
