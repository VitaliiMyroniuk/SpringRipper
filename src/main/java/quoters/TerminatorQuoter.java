package quoters;

import annotations.DeprecatedClass;
import annotations.InjectRandomInt;
import annotations.PostProxy;
import annotations.Profiling;
import javax.annotation.PostConstruct;

/**
 * @author Vitalii Myroniuk
 */
@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1: constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2: init()");
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3: PostProxy");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }
}
