package journaldev.example;

import javax.inject.Singleton;

@Singleton
public class FacebookService implements MessageService {

    public boolean sendMessage(String msg, String recipient) {
        //some fancy code to send email
        System.out.println("Message sent to Facebook user " + recipient + " with message=" + msg);
        return true;
    }

}
