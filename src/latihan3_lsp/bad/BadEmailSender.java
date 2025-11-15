package latihan3_lsp.bad;

// Implementation yang BENAR - follows parent contract
public class BadEmailSender extends BadNotificationSender {

    public BadEmailSender() {
        super("EMAIL");
    }

    @Override
    public boolean send(String recipient, String message) {
        // Implementasi yang proper - benar-benar mengirim
        System.out.println("✓ Notification sent via EMAIL to " + recipient);
        return true;
    }
}
