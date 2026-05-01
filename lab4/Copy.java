import java.io.*;
public class Copy {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";
        try (
                InputStream in = new FileInputStream(sourceFile);
                OutputStream out = new FileOutputStream(destFile)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            System.out.println("File copied successfully.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading or writing the file: " + e.getMessage());
        }
    }
}
