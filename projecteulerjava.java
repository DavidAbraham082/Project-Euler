import java.io.FileNotFoundException;

import Problems.*;

public class projecteulerjava {
	public static void main(String[] args) {
		try
		{
			_021_To_030.nameScores();
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("File not found");
		}
	}
}
