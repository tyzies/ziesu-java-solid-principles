package latihan1_srp.good;

// TANGGUNG JAWAB 1: Validasi message
public class MessageValidator {

    // TODO: Uncomment dan implementasikan method validate
    // Method ini harus:
    // 1. Check apakah message null
    // 2. Check apakah message empty
    // 3. Throw IllegalArgumentException jika tidak valid
    // 4. Print "[Validator] Message validated successfully" jika valid

    public void validate(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        System.out.println("[Validator] Message validated successfully");
    }
}
