import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PR132main {
	
	public static void main(String args[]) {
		
		String rutaBase = System.getProperty("user.dir") + "/data/";
		String rutaArxiu = rutaBase + "PR132people.dat";
		
		// Crear la carpeta 'data' si no existeix
		
		File dir = new File(rutaBase);
		if (!dir.exists()) {
			if (!dir.mkdirs()) {
				System.out.println("Error en la creacio de la carpeta 'data'");
			}
		}
		
		try {
			
			// Empra ObjectOutputStream per guardar aquestes dades en un arxiu PR132people.dat
			
			FileOutputStream fos = new FileOutputStream(rutaArxiu);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new PR132persona("Maria", "Lopez", 36));
			oos.writeObject(new PR132persona("Gustavo", "Ponts", 63));
			oos.writeObject(new PR132persona("Irene", "Sales", 54));
			
			oos.close();
			fos.close();
			
			// Llegeix PR132people.dat amb ObjectInputStream i mostra el seu contingut per pantalla
			
			FileInputStream fis = new FileInputStream(rutaArxiu);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			PR132persona persona_1 = (PR132persona) ois.readObject();
			PR132persona persona_2 = (PR132persona) ois.readObject();
			PR132persona persona_3 = (PR132persona) ois.readObject();
			
			System.out.println("\nPersona 1 [Nom: " + persona_1.getNom() + ", Cognom: " + persona_1.getCognom() + ", Edat: " + persona_1.getEdat() + "]");
			System.out.println("Persona 2 [Nom: " + persona_2.getNom() + ", Cognom: " + persona_2.getCognom() + ", Edat: " + persona_2.getEdat() + "]");
			System.out.println("Persona 3 [Nom: " + persona_3.getNom() + ", Cognom: " + persona_3.getCognom() + ", Edat: " + persona_3.getEdat() + "]");
			
			ois.close();
			fis.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
	}
}
