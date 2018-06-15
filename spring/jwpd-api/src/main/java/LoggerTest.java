import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yuanweipeng
 */
public class LoggerTest {

    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(LoggerTest.class);
        logger.error("logger test.xml");
    }
}
