package latihan2_ocp.good;

// Implementation untuk WhatsApp channel
// INI CHANNEL BARU! Tapi kita tidak perlu modify NotificationService
// Ini adalah demonstrasi OCP: OPEN for extension, CLOSED for modification
public class WhatsAppSender implements NotificationSender {

    // TODO: Uncomment dan implementasikan
    // Class ini harus:
    // 1. Implement method send()
    // 2. Print "[WhatsApp] Sending to: ... | Content: ..."
    // 3. Implement method getType() return "WhatsApp"

    @Override
    public void send(String recipient, String message) {
        System.out.println("[WhatsApp] Sending to: " + recipient + " | Content: " + message);
    }

    @Override
    public String getType() {
        return "WhatsApp";
    }
}
