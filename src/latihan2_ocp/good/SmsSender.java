package latihan2_ocp.good;

// Implementation untuk SMS channel
public class SmsSender implements NotificationSender {

    // TODO: Uncomment dan implementasikan
    // Class ini harus:
    // 1. Implement method send()
    // 2. Print "[SMS] Sending to: ... | Content: ..."
    // 3. Implement method getType() return "SMS"

    @Override
    public void send(String recipient, String message) {
        System.out.println("[SMS] Sending to: " + recipient + " | Content: " + message);
    }

    @Override
    public String getType() {
        return "SMS";
    }
}
