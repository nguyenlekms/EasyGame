package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class HashMapVisualization {
    private static final Logger LOGGER = Logger.getLogger(HashMapVisualization.class.getName());
    public static void main(String[] args) {
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new CustomFormatter());
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(consoleHandler);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(10, "ten");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            LOGGER.info("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        LOGGER.info("Internal Structure:");
        map.forEach((key, value) -> {
            int bucket = key.hashCode() % 4;
            LOGGER.info("Bucket[" + bucket + "] -> Key: " + key + ", Value: " + value);
        });
    }

    // Format log on console -> Green instead of default
    static class CustomFormatter extends Formatter {
        private static final String GREEN = "\u001B[32m";
        private static final String RESET = "\u001B[0m";

        @Override
        public String format(LogRecord record) {
            return GREEN + formatMessage(record) + RESET + "\n";
        }
    }
}
