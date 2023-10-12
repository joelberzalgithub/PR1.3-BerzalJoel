import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PR122cat {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEscriu la ruta d'un arxiu de text: ");
		
		File text = new File(sc.next());
		
		if (!text.exists()) {
			System.out.println("\nEl path no existeix");
		}
		
		else if (text.isDirectory()) {
			System.out.println("\nEl path no correspon a un arxiu, sino a una carpeta");
		}
		
		else {
			
			try {
				
				sc = new Scanner(text);
				System.out.println("");
				
				while (sc.hasNextLine()) {
					String linia = sc.nextLine();
					System.out.println(linia);;
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
