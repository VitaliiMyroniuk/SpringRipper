package domain;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Vitalii Myroniuk
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {

    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader definitionReader = new PropertiesBeanDefinitionReader(this);
        int i = definitionReader.loadBeanDefinitions(fileName);
        System.out.println("Found " + i +  " beans\n");
        refresh();
    }

}
