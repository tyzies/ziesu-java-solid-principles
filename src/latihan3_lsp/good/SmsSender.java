package latihan3_lsp.good;

// Implementation yang FOLLOWS contract
public class SmsSender extends NotificationSender {

    // TODO: Uncomment dan implementasikan
    // Class ini harus:
    // 1. Call super constructor dengan "SMS"
    // 2. Implement send() yang follow contract:
    //    - Validate recipient dan message (return false jika null)
    //    - Print "[SmsSender] ✓ Notification sent to: ..."
    //    - Return true

    public SmsSender() {
        super("SMS");
    }

    @Override
    public boolean send(String recipient, String message) {
        if (recipient == null || message == null) {
            return false;
        }
        System.out.println("[SmsSender] ✓ Notification sent to: " + recipient);
        return true;
    }
}
