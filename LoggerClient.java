enum LogLevel {
    DEBUG, INFO, ERROR;
}

// Abstract processor
abstract class LogProcessor {
    private LogProcessor nextLogger;

    LogProcessor(LogProcessor nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(LogLevel level, String message) {
        if (nextLogger != null) {
            nextLogger.log(level, message);
        }
    }
}

// Concrete processors
class InfoLogProcessor extends LogProcessor {
    InfoLogProcessor(LogProcessor nextLogger) { super(nextLogger); }

    @Override
    public void log(LogLevel level, String message) {
        if (level == LogLevel.INFO)
            System.out.println("INFO: " + message);
        else
            super.log(level, message);
    }
}

class DebugLogProcessor extends LogProcessor {
    DebugLogProcessor(LogProcessor nextLogger) { super(nextLogger); }

    @Override
    public void log(LogLevel level, String message) {
        if (level == LogLevel.DEBUG)
            System.out.println("DEBUG: " + message);
        else
            super.log(level, message);
    }
}

class ErrorLogProcessor extends LogProcessor {
    ErrorLogProcessor(LogProcessor nextLogger) { super(nextLogger); }

    @Override
    public void log(LogLevel level, String message) {
        if (level == LogLevel.ERROR)
            System.out.println("ERROR: " + message);
        else
            super.log(level, message);
    }
}

// Singleton Logger
class Logger {
    private static Logger instance;
    private final LogProcessor logProcessor;

    private Logger() {
        // build chain inside constructor
        this.logProcessor = new InfoLogProcessor(
                                new DebugLogProcessor(
                                    new ErrorLogProcessor(null)));
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(LogLevel level, String message) {
        logProcessor.log(level, message);
    }
}

// Client
public class LoggerClient {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log(LogLevel.ERROR, "Exception Happened");
        logger.log(LogLevel.DEBUG, "Need to debug this");
        logger.log(LogLevel.INFO, "Just for info");
    }
}