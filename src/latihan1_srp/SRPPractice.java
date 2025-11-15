package latihan1_srp;

import latihan1_srp.bad.*;
import latihan1_srp.good.*; // Uncomment setelah refactoring selesai

public class SRPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 1: SINGLE RESPONSIBILITY PRINCIPLE (SRP)
         *
         * Definisi:
         * "A class should have one, and only one, reason to change."
         *
         * Tujuan Latihan:
         * 1. Memahami masalah multiple responsibilities dalam satu class
         * 2. Belajar mengidentifikasi different concerns
         * 3. Memisahkan responsibilities menjadi class-class focused
         * 4. Merasakan benefits dari SRP
         */

        // ===== PART 1: BAD PRACTICE - Melanggar SRP =====
        System.out.println("=== BAD PRACTICE: Melanggar SRP ===\n");

        BadNotificationService badService = new BadNotificationService();
        badService.sendNotification("Hello World", "EMAIL", "user@example.com");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("NotificationService memiliki TERLALU BANYAK tanggung jawab:");
        System.out.println("1. Validasi message");
        System.out.println("2. Format message");
        System.out.println("3. Kirim via EMAIL");
        System.out.println("4. Kirim via SMS");
        System.out.println("5. Logging");
        System.out.println("6. Simpan ke database");
        System.out.println("\nSatu class, BANYAK alasan untuk berubah = MELANGGAR SRP!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti SRP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti SRP ===\n");

        /*
         * INSTRUKSI REFACTORING:
         *
         * 1. Buka folder good/
         * 2. Lengkapi class-class berikut dengan uncomment dan isi implementation:
         *
         *    a. MessageValidator.java
         *       - Tanggung jawab: Validasi message (null check, empty check)
         *       - Method: validate(String message)
         *
         *    b. MessageFormatter.java
         *       - Tanggung jawab: Format message dengan timestamp
         *       - Method: format(String message)
         *
         *    c. EmailSender.java
         *       - Tanggung jawab: Kirim email saja
         *       - Method: send(String recipient, String message)
         *
         *    d. SmsSender.java
         *       - Tanggung jawab: Kirim SMS saja
         *       - Method: send(String recipient, String message)
         *
         *    e. NotificationLogger.java
         *       - Tanggung jawab: Logging saja
         *       - Method: log(String type, String recipient)
         *
         *    f. NotificationRepository.java
         *       - Tanggung jawab: Save ke database saja
         *       - Method: save(String type, String recipient, String message)
         *
         *    g. NotificationService.java (Orchestrator)
         *       - Tanggung jawab: Koordinasi semua class di atas
         *       - Method: sendNotification(String message, String type, String recipient)
         *
         * 3. Setelah selesai, uncomment code di bawah untuk testing
         */

        // UNCOMMENT CODE DI BAWAH SETELAH REFACTORING SELESAI

        MessageValidator validator = new MessageValidator();
        MessageFormatter formatter = new MessageFormatter();
        EmailSender emailSender = new EmailSender();
        SmsSender smsSender = new SmsSender();
        NotificationLogger logger = new NotificationLogger();
        NotificationRepository repository = new NotificationRepository();

        NotificationService goodService = new NotificationService(
            validator, formatter, emailSender, smsSender, logger, repository
        );

        goodService.sendNotification("Hello World", "EMAIL", "user@example.com");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Easy to understand - Setiap class punya fokus jelas");
        System.out.println("✓ Easy to test - Bisa test setiap komponen terpisah");
        System.out.println("✓ Easy to maintain - Perubahan di satu area tidak affect yang lain");
        System.out.println("✓ Reusable - MessageFormatter bisa dipakai di tempat lain");
        System.out.println("✓ Low coupling - Komponen tidak saling bergantung berlebihan");

        /*
         * EKSPEKTASI OUTPUT:
         *
         * === BAD PRACTICE: Melanggar SRP ===
         *
         * Sending EMAIL to: user@example.com
         * Content: HELLO WORLD [SENT AT: 1234567890]
         * LOG: Notification sent - Type: EMAIL
         * DB: Saving notification record...
         *
         * --- Analisis Masalah ---
         * NotificationService memiliki TERLALU BANYAK tanggung jawab:
         * 1. Validasi message
         * 2. Format message
         * 3. Kirim via EMAIL
         * 4. Kirim via SMS
         * 5. Logging
         * 6. Simpan ke database
         *
         * Satu class, BANYAK alasan untuk berubah = MELANGGAR SRP!
         *
         * ======================================================================
         *
         * === GOOD PRACTICE: Mengikuti SRP ===
         *
         * [Validator] Message validated successfully
         * [Formatter] Message formatted: HELLO WORLD [SENT AT: 1234567890]
         * [EmailSender] Sending EMAIL to: user@example.com
         * [EmailSender] Content: HELLO WORLD [SENT AT: 1234567890]
         * [Logger] LOG: Notification sent - Type: EMAIL
         * [Repository] DB: Saving notification record...
         *
         * --- Keuntungan Setelah Refactoring ---
         * ✓ Easy to understand - Setiap class punya fokus jelas
         * ✓ Easy to test - Bisa test setiap komponen terpisah
         * ✓ Easy to maintain - Perubahan di satu area tidak affect yang lain
         * ✓ Reusable - MessageFormatter bisa dipakai di tempat lain
         * ✓ Low coupling - Komponen tidak saling bergantung berlebihan
         */
    }
}
