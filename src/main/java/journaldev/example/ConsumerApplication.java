package journaldev.example;

import javax.inject.Inject;

public class ConsumerApplication {
//    private final MessageService messageService;
    @Inject private MessageService messageService;

//    @Inject
//    public ConsumerApplication(MessageService messageService) {
//        this.messageService = messageService;
//    }

    //setter method injector
//    @Inject
//    public void setService(MessageService messageService){
//        this.messageService = messageService;
//    }

    public boolean sendMessage() {
        return this.messageService.sendMessage("Hola", "juancho@abc.com");
    }
}
