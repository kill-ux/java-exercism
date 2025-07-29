public class LogLine {

    private LogLevel log;
    private String msg;

    public LogLine(String logLine) {
        this.log = switch (logLine.substring(1, 4)) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
        this.msg = logLine.substring(7);
    }

    public LogLevel getLogLevel() {
        return log;
    }

    public String getOutputForShortLog() {
        return "" + this.log.nbr + ":" + this.msg;
    }
}


