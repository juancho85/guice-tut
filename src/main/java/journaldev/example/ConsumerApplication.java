package journaldev.example;

import javax.inject.Inject;

public class ConsumerApplication {
    private final MessageService messageService;

    @Inject
    public ConsumerApplication(MessageService messageService) {
        this.messageService = messageService;
    }

    public boolean sendMessage() {
        return this.messageService.sendMessage("Hola", "juancho@abc.com");
    }
}
