import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Helpers
{
  public static ArrayList<String> GetFileContents(String fileName) throws FileNotFoundException
  {
    ArrayList<String> output = new ArrayList<String>();
    
    Scanner scanner = new Scanner(new File(fileName));
    while (scanner.hasNextLine())
    {
      output.add(scanner.nextLine());
    }

    return output;
  }
}
