package demoLog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class myTimerLoggings {

    private static final Logger logger = LogManager.getLogger(myTimerLoggings.class);

    public static void main(String[] args) throws InterruptedException {
        myTimerLoggings timerLog = new myTimerLoggings();
        timerLog.startLogging();
    }

    public void startLogging() throws InterruptedException {
        while (true) {
            logWithInterval(LogLevel.DEBUG, 1000); // 1 Second
            logWithInterval(LogLevel.INFO, 60000); // 1 Minute
            logWithInterval(LogLevel.ERROR, 3600000); // 1 Hour
        }
    }

    private void logWithInterval(LogLevel level, long interval) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            switch (level) {
                case DEBUG:
                    logger.debug("Debug Time: " + java.time.LocalTime.now());
                    break;
                case INFO:
                    logger.info("Info Time: " + java.time.LocalTime.now().withSecond(0).withNano(0));
                    break;
                case ERROR:
                    logger.error("Error Time: " + java.time.LocalTime.now().withMinute(0).withSecond(0).withNano(0));
                    break;
            }
            Thread.sleep(interval);
        }
    }

    private enum LogLevel {
        DEBUG, INFO, ERROR
    }
}
