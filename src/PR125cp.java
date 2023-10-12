import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class PR125cp {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEscriu la ruta de l'arxiu a copiar: ");
		File origen = new File(sc.next());
		
		if (!origen.exists()) {
            System.out.println("El path no existeix.");
        }
		
		else if (!origen.isFile()) {
            System.out.println("El path no correspon a un arxiu.");
        }
		
		else {
			
			System.out.print("Escriu la ruta de destinacio de la copia: ");
			File desti = new File(sc.next());
			
			if (!desti.exists()) {
	            System.out.println("El path no existeix.");
	        }
			
			else if (!desti.isDirectory()) {
	            System.out.println("El path no correspon a una carpeta.");
	        }
			
			else {
			
				try {
					Files.copy(origen.toPath(), new File(desti, origen.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
