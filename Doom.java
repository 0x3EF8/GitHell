import java.io.*;
import java.util.Date;

public class Doom {

    public static void main(String[] args) {
        try {
            File folder = new File("gen");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File file = new File("gen/README.yml");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("Generated at: " + new Date().toString() + " - Time’s up. The abyss consumes all.");
                System.out.println("The file has been forged in the darkest depths of GitHell: " + file.getAbsolutePath());
            }

            logToFile("git-commit-log.txt", "Commit made at: " + new Date().toString() + " - The end draws closer.");

        } catch (Exception e) {
            System.err.println("An error occurred... but you can't escape GitHell: " + e.getMessage());
        }
    }

    private static void logToFile(String filename, String message) {
        try {
            FileWriter logWriter = new FileWriter(filename, true);
            BufferedWriter logBuffer = new BufferedWriter(logWriter);
            logBuffer.write(message);
            logBuffer.newLine();
            logBuffer.close();
        } catch (IOException e) {
            System.err.println("Error logging commit: " + e.getMessage());
        }
    }
}
