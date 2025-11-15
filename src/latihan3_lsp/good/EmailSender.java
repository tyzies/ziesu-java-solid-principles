package latihan3_lsp.good;

// Implementation yang FOLLOWS contract
public class EmailSender extends NotificationSender {

    // TODO: Uncomment dan implementasikan
    // Class ini harus:
    // 1. Call super constructor dengan "EMAIL"
    // 2. Implement send() yang follow contract:
    //    - Validate recipient dan message (return false jika null)
    //    - Print "[EmailSender] ✓ Notification sent to: ..."
    //    - Return true

    public EmailSender() {
        super("EMAIL");
    }

    @Override
    public boolean send(String recipient, String message) {
        if (recipient == null || message == null) {
            return false;
        }
        System.out.println("[EmailSender] ✓ Notification sent to: " + recipient);
        return true;
    }
}
