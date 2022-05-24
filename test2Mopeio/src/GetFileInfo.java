import java.io.File;  // Import the File class

public class GetFileInfo { 
  public static void main(String[] args) {
    File hPReader = new File("HP Level");
    if (hPReader.exists()) {
      System.out.println("File name: " + hPReader.getName());
      System.out.println("Absolute path: " + hPReader.getAbsolutePath());
      System.out.println("Writeable: " + hPReader.canWrite());
      System.out.println("Readable " + hPReader.canRead());
      System.out.println("File size in bytes " + hPReader.length());
    } else {
      System.out.println("The file does not exist.");
    }
  }
}
