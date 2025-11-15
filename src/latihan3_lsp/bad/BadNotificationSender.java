package latihan3_lsp.bad;

// Parent class untuk semua notification sender
// Masalah: Kontrak tidak jelas, memungkinkan subclass melanggar LSP
public abstract class BadNotificationSender {
    protected String senderName;

    public BadNotificationSender(String senderName) {
        this.senderName = senderName;
    }

    // Method yang HARUS diimplementasikan oleh subclass
    // Tapi tidak ada guarantee bahwa subclass akan follow kontrak
    public abstract boolean send(String recipient, String message);

    public String getType() {
        return senderName;
    }
}
