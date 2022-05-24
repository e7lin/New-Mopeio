import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {
	static Animal test = new Animal();
	 public static int returnAnimalHP(Animal test) {
   	    return test.getHP();
     }
  public static void main(String[] args) {
    try {
      FileWriter myWriter = new FileWriter("HP Level");
      
      myWriter.write(returnAnimalHP(test) + ": This is the HP Level");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}