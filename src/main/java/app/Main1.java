package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.Quoter;

/**
 * @author Vitalii Myroniuk
 */
public class Main1 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        context.getBean(Quoter.class).sayQuote();
    }

}
