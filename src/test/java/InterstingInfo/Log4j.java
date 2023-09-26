package InterstingInfo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;


public class Log4j {

    public Logger log = LogManager.getLogger(this.getClass());

    @Test
    public void LogTest(){
        log.info("method");
        log.error("error");
        log.fatal("fatal");
    }
}
