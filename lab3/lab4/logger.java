import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class logger {
    private static final String LOG_FILE = "error_log.txt";

    public static void log(Exception e) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("[" + LocalDateTime.now() + "] Caught exception: " + e.toString());
        } catch (IOException ioException) {
            System.err.println("Could not write to log file: " + ioException.getMessage());
        }
    }
}
