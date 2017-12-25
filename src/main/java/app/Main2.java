package app;

import domain.PropertyFileApplicationContext;
import org.springframework.context.ApplicationContext;
import quoters.Quoter;

/**
 * @author Vitalii Myroniuk
 */
public class Main2 {

    public static void main(String[] args) {
        ApplicationContext context = new PropertyFileApplicationContext("config.properties");
        context.getBean(Quoter.class).sayQuote();
    }

}
