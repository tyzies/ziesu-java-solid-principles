package latihan1_srp.good;

// TANGGUNG JAWAB 2: Format message
public class MessageFormatter {

    // TODO: Uncomment dan implementasikan method format
    // Method ini harus:
    // 1. Ubah message ke uppercase
    // 2. Tambahkan timestamp dengan format: [SENT AT: ...]
    // 3. Print "[Formatter] Message formatted: ..."
    // 4. Return formatted message

    public String format(String message) {
        String formatted = message.toUpperCase() + " [SENT AT: " +
                          System.currentTimeMillis() + "]";
        System.out.println("[Formatter] Message formatted: " + formatted);
        return formatted;
    }
}
