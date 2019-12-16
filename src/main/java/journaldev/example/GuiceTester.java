package journaldev.example;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class GuiceTester {
    public static void main(String[] args) {
        try {
            Injector injector = Guice.createInjector(new AppInjector());
            ConsumerApplication consumerApplication = injector.getInstance(ConsumerApplication.class);
            consumerApplication.sendMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

