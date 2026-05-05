public class Message {
    private Message message;
    private String payload;

    public Message(Message message, String payload){
        this.message = message;
        this.payload = payload;
    }

    // Getter
    public Message getMessage(){
        return this.message;
    }

    public String getPayload(){
        return this.payload;
    }


}
