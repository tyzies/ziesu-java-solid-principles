package latihan2_ocp.good;

import java.util.List;

// Service yang MENGIKUTI OCP
// Class ini TIDAK PERLU DIMODIFIKASI ketika ada channel baru
public class NotificationService {

    // TODO: Uncomment dan implementasikan
    // Class ini harus:
    // 1. Menerima List<NotificationSender> via constructor
    // 2. Method sendNotification loop through semua senders
    // 3. Panggil send() untuk setiap sender

    private List<NotificationSender> senders;

    public NotificationService(List<NotificationSender> senders) {
        this.senders = senders;
    }

    public void sendNotification(String message, String recipient) {
        // Loop through semua registered senders
        for (NotificationSender sender : senders) {
            sender.send(recipient, message);
        }
    }
}
