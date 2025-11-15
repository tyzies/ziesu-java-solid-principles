package latihan1_srp.good;

// TANGGUNG JAWAB 7: Orchestration (koordinasi semua class)
// Class ini HANYA mengkoordinasikan, tidak melakukan detail implementation
public class NotificationService {

    // TODO: Uncomment dan lengkapi
    // Class ini bertanggung jawab untuk:
    // 1. Menerima dependencies via constructor
    // 2. Mengkoordinasikan semua class untuk mengirim notification

    private MessageValidator validator;
    private MessageFormatter formatter;
    private EmailSender emailSender;
    private SmsSender smsSender;
    private NotificationLogger logger;
    private NotificationRepository repository;

    public NotificationService(MessageValidator validator,
                             MessageFormatter formatter,
                             EmailSender emailSender,
                             SmsSender smsSender,
                             NotificationLogger logger,
                             NotificationRepository repository) {
        this.validator = validator;
        this.formatter = formatter;
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.logger = logger;
        this.repository = repository;
    }

    public void sendNotification(String message, String type, String recipient) {
        // 1. Validate
        validator.validate(message);

        // 2. Format
        String formattedMessage = formatter.format(message);

        // 3. Send based on type
        if (type.equals("EMAIL")) {
            emailSender.send(recipient, formattedMessage);
        } else if (type.equals("SMS")) {
            smsSender.send(recipient, formattedMessage);
        }

        // 4. Log
        logger.log(type, recipient);

        // 5. Save to database
        repository.save(type, recipient, formattedMessage);
    }
}
