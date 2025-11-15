package latihan2_ocp.good;

// Implementation untuk EMAIL channel
public class EmailSender implements NotificationSender {

    // TODO: Uncomment dan implementasikan
    // Class ini harus:
    // 1. Implement method send()
    // 2. Print "[EMAIL] Sending to: ... | Content: ..."
    // 3. Implement method getType() return "EMAIL"

    @Override
    public void send(String recipient, String message) {
        System.out.println("[EMAIL] Sending to: " + recipient + " | Content: " + message);
    }

    @Override
    public String getType() {
        return "EMAIL";
    }
}
