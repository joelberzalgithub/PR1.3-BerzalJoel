import java.io.File;
import java.io.IOException;

public class PR121Files {
	
	public static void main(String args[]) {
		
		try {
			// Crea una carpeta anomenada "myFiles".
			
			File carpeta = new File("myFiles");
			carpeta.mkdir();
			
			// Dins d'aquesta carpeta, crea dos arxius: "file1.txt" i "file2.txt".
			
			File text_1 = new File("myFiles/file1.txt");
			text_1.createNewFile();
			
			File text_2 = new File("myFiles/file2.txt");
			text_2.createNewFile();
			
			// Renombra l'arxiu "file2.txt" a "renamedFile.txt".
			
			File text_3 = new File("myFiles/renamedFile.txt");
			text_2.renameTo(text_3);
			
			// Mostra un llistat dels arxius dins de la carpeta "myFiles" amb el missatge: "Els arxius de la carpeta són:".
			
			String[] llista = carpeta.list();
			System.out.println("\nEls arxius de la carpeta son:");
			
			for (int i=0; i < llista.length; i++) {
				System.out.println(llista[i]);
			}
			
			// Elimina l'arxiu "file1.txt".
			
			text_1.delete();
			
			// Torna a mostrar un llistat dels arxius dins de la carpeta "myFiles" amb el missatge: "Els arxius de la carpeta són:".
			
			llista = carpeta.list();
			System.out.println("\nEls arxius de la carpeta son:");
			
			for (int i=0; i < llista.length; i++) {
				System.out.println(llista[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
