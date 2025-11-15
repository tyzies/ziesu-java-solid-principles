package latihan3_lsp;

import latihan3_lsp.bad.BadNotificationSender;
import latihan3_lsp.bad.BadEmailSender;
import latihan3_lsp.bad.BadReadOnlySender;
import latihan3_lsp.good.*; // Uncomment setelah refactoring selesai

public class LSPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 3: LISKOV SUBSTITUTION PRINCIPLE (LSP)
         *
         * Definisi:
         * "Objects of a superclass should be replaceable with objects of
         *  a subclass without breaking the application."
         *
         * Tujuan Latihan:
         * 1. Memahami violation dari LSP
         * 2. Mengidentifikasi masalah: throwing unexpected exceptions
         * 3. Memahami kontrak dari parent class
         * 4. Mendesain proper abstraction
         */

        // ===== PART 1: BAD PRACTICE - Melanggar LSP =====
        System.out.println("=== BAD PRACTICE: Melanggar LSP ===\n");

        // Polymorphic code - menggunakan parent class reference
        BadNotificationSender sender1 = new BadEmailSender();
        BadNotificationSender sender2 = new BadReadOnlySender(); // PROBLEM!

        // Test sender1 (EmailSender)
        System.out.println("Testing EmailSender:");
        processNotification(sender1, "user@example.com", "Hello");

        // Test sender2 (ReadOnlySender)
        System.out.println("\nTesting ReadOnlySender:");
        try {
            processNotification(sender2, "user@example.com", "Hello");
        } catch (Exception e) {
            System.out.println("❌ Exception thrown: " + e.getClass().getSimpleName() +
                    ": " + e.getMessage());
            System.out.println("❌ Program crashed!");
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("ReadOnlySender melanggar LSP karena:");
        System.out.println("1. Parent NotificationSender promise: bisa send notification");
        System.out.println("2. ReadOnlySender: throw exception instead");
        System.out.println("3. Cannot substitute parent class safely");
        System.out.println("4. Breaks polymorphic code");
        System.out.println("\nIni MELANGGAR LSP: subclass tidak bisa replace parent!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti LSP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti LSP ===\n");

        /*
         * INSTRUKSI REFACTORING:
         *
         * 1. Buka folder good/
         * 2. Lengkapi class-class berikut:
         *
         *    a. NotificationSender.java (Abstract class dengan clear contract)
         *       - Method send() harus mengirim notification
         *       - Precondition: recipient dan message tidak null
         *       - Postcondition: return true jika berhasil, false jika gagal
         *       - TIDAK BOLEH throw exception
         *
         *    b. EmailSender.java (follows contract)
         *       - Implement send() properly
         *       - Return true
         *
         *    c. SmsSender.java (follows contract)
         *       - Implement send() properly
         *       - Return true
         *
         * 3. Setelah selesai, uncomment code di bawah untuk testing
         */

        // UNCOMMENT CODE DI BAWAH SETELAH REFACTORING SELESAI

        System.out.println("Testing dengan semua implementation:");

        NotificationSender goodSender1 = new EmailSender();
        NotificationSender goodSender2 = new SmsSender();

        // Semua sender bisa digunakan secara polymorphic dengan aman
        testSender(goodSender1, "user@example.com", "Hello");
        testSender(goodSender2, "081234567890", "Hello");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Predictable - Semua child class berperilaku sesuai ekspektasi");
        System.out.println("✓ Reliable - Tidak ada surprise behavior");
        System.out.println("✓ Interchangeable - Bisa ganti child class dengan aman");
        System.out.println("✓ Safe - Polymorphic code bekerja tanpa masalah");

        /*
         * EKSPEKTASI OUTPUT:
         *
         * === BAD PRACTICE: Melanggar LSP ===
         *
         * Testing EmailSender:
         * ✓ Notification sent via EMAIL to user@example.com
         *
         * Testing ReadOnlySender:
         * ❌ Exception thrown: UnsupportedOperationException: This sender is read-only!
         * ❌ Program crashed!
         *
         * --- Analisis Masalah ---
         * ReadOnlySender melanggar LSP karena:
         * 1. Parent NotificationSender promise: bisa send notification
         * 2. ReadOnlySender: throw exception instead
         * 3. Cannot substitute parent class safely
         * 4. Breaks polymorphic code
         *
         * Ini MELANGGAR LSP: subclass tidak bisa replace parent!
         *
         * ======================================================================
         *
         * === GOOD PRACTICE: Mengikuti LSP ===
         *
         * Testing dengan semua implementation:
         * [EmailSender] ✓ Notification sent to: user@example.com
         * [SmsSender] ✓ Notification sent to: 081234567890
         *
         * --- Keuntungan Setelah Refactoring ---
         * ✓ Predictable - Semua child class berperilaku sesuai ekspektasi
         * ✓ Reliable - Tidak ada surprise behavior
         * ✓ Interchangeable - Bisa ganti child class dengan aman
         * ✓ Safe - Polymorphic code bekerja tanpa masalah
         */
    }

    // Helper method untuk demonstrasi polymorphic code
    private static void processNotification(BadNotificationSender sender,
                                            String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("✓ Notification sent successfully");
        } else {
            System.out.println("✗ Failed to send notification");
        }
    }

    // UNCOMMENT SETELAH REFACTORING GOOD SELESAI

    private static void testSender(NotificationSender sender,
                                  String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("  → Success!");
        }
    }
}
