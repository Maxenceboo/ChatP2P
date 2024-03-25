package chatSystem.model;

public class MessagePrivate extends Message {
    private Personne receiver;

    public MessagePrivate(String message, Personne sender, Personne receiver) {
        super(message, sender);
        this.receiver = receiver;
    }

    public Personne getReceiver() {
        return this.receiver;
    }

    public void setReceiver(Personne receiver) {
        this.receiver = receiver;
    }

    public String toString() {
        return this.getSender() + " -> " + this.receiver + " : " + this.getMessage();
    }
}
