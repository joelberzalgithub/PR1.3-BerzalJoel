import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PR133mainTreballadors {
	
	public static void main(String args[]) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			String rutaBase = System.getProperty("user.dir") + "/data/";
			String rutaArxiu = rutaBase + "PR133treballadors.csv";
			
			// Crear la carpeta 'data' si no existeix
			
			File dir = new File(rutaBase);
			if (!dir.exists()) {
				if (!dir.mkdirs()) {
					System.out.println("Error en la creacio de la carpeta 'data'");
				}
			}
			
			// Demanar a l'usuari l'identificador del treballador
			
			int id = 0;
			boolean validId = false;
			
			while (!validId) {
				try {
					System.out.print("\nEscriu l'identificador d'un treballador: ");
					id = sc.nextInt();
					validId = true;
				} catch (java.util.InputMismatchException e) {
					System.out.println("L'identificador ha de ser un nombre enter");
					sc.nextLine();
	            }
			}
			
			// Demanar a l'usuari una dada per modificar
			
			String dada = "";
			boolean validDada = false;
			
			while (!validDada) {
				
				System.out.print("\nQuina dada vols modificar? ");
				dada = sc.next();
				
				if (dada.equals("Nom") || dada.equals("Cognom") || dada.equals("Departament") || dada.equals("Salari")) {
					validDada = true;
				}
				
				else {
					System.out.println("Nomes hi han 4 tipus de dades: Nom, Cognom, Departament o Salari");
					sc.nextLine();
				}
			}
			
			// Demanar a l'usuari el nou valor de la dada anterior
			
			String valor = "";
			boolean validValor = false;
			
			while (!validValor) {
				try {
					System.out.print("\nEscriu el nou " + dada + ": ");
					valor = sc.next();
					if (dada.equals("Departament")) { Integer.parseInt(valor); }
					else if (dada.equals("Salari")) { Float.parseFloat(valor); }
					validValor = true;
					
				} catch (NumberFormatException e) {
					System.out.println("Tant el departament com el salari han de ser valors numerics");
					sc.nextLine();
				}
			}
			
			// Crear un fitxer temporal per guardar les dades modificades
			
			File arxiu = new File(rutaArxiu);
			File arxiuTemporal = new File(rutaBase + "PR133treballadors_temp.csv");
			
			BufferedReader br = new BufferedReader(new FileReader(rutaArxiu));
			BufferedWriter bw = new BufferedWriter(new FileWriter(arxiuTemporal));
			
			// Modificar la dada corresponent
			
			String line;
			
			while ((line = br.readLine()) != null) {	
				
				String[] parts = line.split(",");
				
				if (id == Integer.parseInt(parts[0].trim())) {
					
					if (dada.equalsIgnoreCase("Nom")) { parts[1] = valor; }
					else if (dada.equalsIgnoreCase("Cognom")) { parts[2] = valor; }
					else if (dada.equalsIgnoreCase("Departament")) { parts[3] = valor; }
					else if (dada.equalsIgnoreCase("Salari")) { parts[4] = valor; }
					
					line = String.join(",", parts);
				}
				bw.write(line);
				bw.newLine();
			}
			br.close();
			bw.close();
			
			// Eliminar l'arxiu original i canviar el nom del fitxer temporal
			
			arxiu.delete();
			arxiuTemporal.renameTo(arxiu);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
