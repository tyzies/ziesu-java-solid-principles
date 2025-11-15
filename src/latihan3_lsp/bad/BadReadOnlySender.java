package latihan3_lsp.bad;

// Implementation yang MELANGGAR LSP
// Class ini throw exception padahal parent expect send() to work
public class BadReadOnlySender extends BadNotificationSender {

    public BadReadOnlySender() {
        super("READONLY");
    }

    @Override
    public boolean send(String recipient, String message) {
        // MASALAH 1: Throw exception - not following parent contract
        // Parent class tidak promise bahwa send() bisa throw exception
        throw new UnsupportedOperationException("This sender is read-only!");

        // MASALAH 2: Tidak bisa substitute parent class
        // Code yang expect NotificationSender.send() akan crash
    }
}
