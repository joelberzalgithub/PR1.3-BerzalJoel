import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PR120ReadFile {
	
	public static void main(String args[]) {
		
		int numeroLinia = 1;
		File text = new File("src/PR120ReadFile.java");
		
		try {
			
			Scanner sc = new Scanner(text);
			System.out.println("");
			
			while (sc.hasNextLine()) {
				String linia = sc.nextLine();
				System.out.println(linia + " (Linia " + numeroLinia + ")");
				numeroLinia ++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
