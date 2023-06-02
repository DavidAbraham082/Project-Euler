import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Helpers
{
  public static String[] GetFileContents(String fileName) throws FileNotFoundException
  {
    Vector<String> output = new Vector<String>();
    
    Scanner scanner = new Scanner(new File(fileName));
    while (scanner.hasNextLine())
    {
      output.add(scanner.nextLine());
    }

    return (String[])output.toArray();
  }
}