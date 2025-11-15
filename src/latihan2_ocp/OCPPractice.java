package latihan2_ocp;

import latihan2_ocp.bad.*;
import latihan2_ocp.good.*; // Uncomment setelah refactoring selesai
import java.util.*;

public class OCPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 2: OPEN/CLOSED PRINCIPLE (OCP)
         *
         * Definisi:
         * "Software entities should be open for extension, but closed for modification."
         *
         * Tujuan Latihan:
         * 1. Memahami masalah if-else chains
         * 2. Menggunakan interface untuk extensibility
         * 3. Menambah fitur baru tanpa modify existing code
         * 4. Menerapkan dependency injection pattern
         */

        // ===== PART 1: BAD PRACTICE - Melanggar OCP =====
        System.out.println("=== BAD PRACTICE: Melanggar OCP ===\n");

        BadNotificationService badService = new BadNotificationService();
        badService.sendNotification("Hello", "EMAIL", "user@example.com");
        badService.sendNotification("Hello", "SMS", "081234567890");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("Bagaimana kalau kita ingin menambah channel baru (WhatsApp)?");
        System.out.println("❌ Harus modify method sendNotification()");
        System.out.println("❌ Harus tambah else if baru");
        System.out.println("❌ Risk merusak existing functionality");
        System.out.println("❌ Setiap channel baru = modify existing code");
        System.out.println("\nIni MELANGGAR OCP: tidak bisa extend tanpa modify!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti OCP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti OCP ===\n");

        /*
         * INSTRUKSI REFACTORING:
         *
         * 1. Buka folder good/
         * 2. Lengkapi class-class berikut:
         *
         *    a. NotificationSender.java (Interface)
         *       - Method: send(String recipient, String message)
         *       - Method: getType()
         *
         *    b. EmailSender.java (implements NotificationSender)
         *       - Implementasi send untuk EMAIL
         *
         *    c. SmsSender.java (implements NotificationSender)
         *       - Implementasi send untuk SMS
         *
         *    d. WhatsAppSender.java (implements NotificationSender)
         *       - Implementasi send untuk WhatsApp
         *       - INI CHANNEL BARU! Tapi tidak perlu modify NotificationService
         *
         *    e. NotificationService.java
         *       - Menerima List<NotificationSender> via constructor
         *       - Loop through senders untuk kirim notification
         *
         * 3. Setelah selesai, uncomment code di bawah untuk testing
         */

        // UNCOMMENT CODE DI BAWAH SETELAH REFACTORING SELESAI

        // Setup senders
        List<NotificationSender> senders = new ArrayList<>();
        senders.add(new EmailSender());
        senders.add(new SmsSender());
        senders.add(new WhatsAppSender()); // NEW channel! Zero modification needed

        NotificationService goodService = new NotificationService(senders);
        goodService.sendNotification("Hello", "user@example.com");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Extensible - Mudah tambah channel baru");
        System.out.println("✓ Stable - Code existing tidak dimodifikasi");
        System.out.println("✓ Safe - Risiko bug di fitur existing sangat kecil");
        System.out.println("✓ Scalable - Bisa unlimited channels");
        System.out.println("\nMenambah WhatsAppSender:");
        System.out.println("  → Buat class baru WhatsAppSender");
        System.out.println("  → Add ke list senders");
        System.out.println("  → ZERO modification ke NotificationService");

        /*
         * EKSPEKTASI OUTPUT:
         *
         * === BAD PRACTICE: Melanggar OCP ===
         *
         * Sending EMAIL to: user@example.com
         * Content: Hello
         * Sending SMS to: 081234567890
         * Content: Hello
         *
         * --- Analisis Masalah ---
         * Bagaimana kalau kita ingin menambah channel baru (WhatsApp)?
         * ❌ Harus modify method sendNotification()
         * ❌ Harus tambah else if baru
         * ❌ Risk merusak existing functionality
         * ❌ Setiap channel baru = modify existing code
         *
         * Ini MELANGGAR OCP: tidak bisa extend tanpa modify!
         *
         * ======================================================================
         *
         * === GOOD PRACTICE: Mengikuti OCP ===
         *
         * [EMAIL] Sending to: user@example.com | Content: Hello
         * [SMS] Sending to: user@example.com | Content: Hello
         * [WhatsApp] Sending to: user@example.com | Content: Hello
         *
         * --- Keuntungan Setelah Refactoring ---
         * ✓ Extensible - Mudah tambah channel baru
         * ✓ Stable - Code existing tidak dimodifikasi
         * ✓ Safe - Risiko bug di fitur existing sangat kecil
         * ✓ Scalable - Bisa unlimited channels
         *
         * Menambah WhatsAppSender:
         *   → Buat class baru WhatsAppSender
         *   → Add ke list senders
         *   → ZERO modification ke NotificationService
         */
    }
}
