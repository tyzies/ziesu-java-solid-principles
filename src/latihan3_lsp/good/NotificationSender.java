package latihan3_lsp.good;

// Parent class dengan CLEAR CONTRACT
// Semua subclass HARUS follow contract ini
public abstract class NotificationSender {
    protected String senderName;

    public NotificationSender(String senderName) {
        this.senderName = senderName;
    }

    // TODO: Uncomment dan perhatikan contract-nya
    /*
     * Method send() dengan clear contract:
     *
     * Precondition:
     * - recipient tidak boleh null
     * - message tidak boleh null
     *
     * Postcondition:
     * - Return true jika berhasil kirim notification
     * - Return false jika gagal (tapi TIDAK THROW EXCEPTION)
     * - Harus benar-benar mengirim atau simulate sending
     *
     * Contract ini HARUS diikuti oleh semua subclass!
     */

    public abstract boolean send(String recipient, String message);

    public String getType() {
        return senderName;
    }
}
