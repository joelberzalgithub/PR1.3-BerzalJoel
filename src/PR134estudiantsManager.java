import java.io.IOException;
import java.io.RandomAccessFile;

public class PR134estudiantsManager {
	
	private static final int RECORD_SIZE = 4; // Longitud màxima en bytes del número de registre
	private static final int NAME_SIZE = 20; // Longitud màxima en caràcters del nom
	private static final int GRADE_SIZE = 4; // Longitud màxima en bytes de la nota
	
	public static void afegirEstudiant(String rutaArxiu, Estudiant estudiant) {
		
		try (RandomAccessFile raf = new RandomAccessFile(rutaArxiu, "rw")) {
			
			long posicio = (estudiant.getRegistre() - 1) * (RECORD_SIZE + NAME_SIZE + GRADE_SIZE);
			raf.seek(posicio);
			raf.writeInt(estudiant.getRegistre());
			raf.writeChars(String.format("%-20s", estudiant.getNom()));
			raf.writeFloat(estudiant.getNota());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Estudiant consultarEstudiant(String rutaArxiu, int registre) {
		
		Estudiant estudiant = null;
		
		try (RandomAccessFile raf = new RandomAccessFile(rutaArxiu, "r")) {
		
			long posicio = (registre - 1) * (RECORD_SIZE + NAME_SIZE + GRADE_SIZE);
			raf.seek(posicio);
			int numeroRegistre = raf.readInt();
			
			if (numeroRegistre == registre) {
				char[] nameChars = new char[NAME_SIZE];
				for (int i = 0; i < NAME_SIZE; i++) {
				    nameChars[i] = raf.readChar();
				}
				String nom = new String(nameChars).trim();
				float nota = raf.readFloat();
				estudiant = new Estudiant(registre, nom, nota);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return estudiant;
	}
	
	public static void actualitzarNotaEstudiant(String rutaArxiu, int registre, float novaNota) {
		
		Estudiant estudiant = consultarEstudiant(rutaArxiu, registre);
		
		if (estudiant != null) {
			estudiant.setNota(novaNota);
			afegirEstudiant(rutaArxiu, estudiant);
		}
		else {
			System.out.println("L'estudiant amb el numero de registre " + registre + " no existeix");
		}
	}
	
	public static void main(String[] args) {
		
		// Afegir un estudiant
		
		Estudiant estudiant_1 = new Estudiant(1, "A", 2.5f);
		
		afegirEstudiant("./data/estudiants.dat", estudiant_1);
		
		// Consultar i mostrar un estudiant afegit
		
		Estudiant estudiantConsultat_1 = consultarEstudiant("./data/estudiants.dat", 1);
		
		if (estudiantConsultat_1 != null) {
			System.out.println("Estudiant trobat --> [Nom: " + estudiantConsultat_1.getNom() + ", Nota: " + estudiantConsultat_1.getNota() + "]");
		}
		else {
			System.out.println("L'estudiant no existeix");
		}
		
		// Consultar i mostrar un estudiant que no existeix
		
		Estudiant estudiantConsultat_2 = consultarEstudiant("./data/estudiants.dat", 2);
		
		if (estudiantConsultat_2 != null) {
			System.out.println("Estudiant trobat --> [Nom: " + estudiantConsultat_2.getNom() + ", Nota: " + estudiantConsultat_2.getNota() + "]");
		}
		else {
			System.out.println("L'estudiant no existeix");
		}
		
		// Actualitzar la nota d'un estudiant
		actualitzarNotaEstudiant("./data/estudiants.dat", 1, 5);
		
		// Actualitzar la nota d'un estudiant que no existeix
		actualitzarNotaEstudiant("./data/estudiants.dat", 2, 5);
		
		// Consultar i mostrar l'estudiant actualitzat
		
		Estudiant estudiantConsultat_3 = consultarEstudiant("./data/estudiants.dat", 1);
		if (estudiantConsultat_3 != null) {
			System.out.println("Estudiant trobat --> [Nom: " + estudiantConsultat_3.getNom() + ", Nota: " + estudiantConsultat_3.getNota() + "]");
		}
		else {
			System.out.println("L'estudiant no existeix");
		}
	}
}

class Estudiant {
	
	public int registre;
	public String nom;
	public float nota;
	
	public Estudiant(int registre, String nom, float nota) {
		super();
		this.registre = registre;
		this.nom = nom;
		this.nota = nota;
	}
	
	public int getRegistre() {
		return registre;
	}
	
	public void setRegistre(int registre) {
		this.registre = registre;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		this.nota = nota;
	}
}
