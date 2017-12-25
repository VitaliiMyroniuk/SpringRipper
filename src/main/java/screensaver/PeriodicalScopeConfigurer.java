package screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vitalii Myroniuk
 */
public class PeriodicalScopeConfigurer implements Scope {

    private Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String beanName, ObjectFactory<?> objectFactory) {
        if (map.containsKey(beanName)) {
            Pair<LocalTime, Object> pair = map.get(beanName);
            int duration = LocalTime.now().getSecond() - pair.getKey().getSecond();
            if (duration > 5) {
                map.put(beanName, new Pair<>(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            map.put(beanName, new Pair<>(LocalTime.now(), objectFactory.getObject()));
        }
        return map.get(beanName).getValue();
    }

    @Override
    public Object remove(String beanName) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String beanName, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String beanName) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

}
