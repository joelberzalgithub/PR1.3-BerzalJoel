import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;

public class PR130mainPersonesHashmap {
	
	public static void main(String[] args) {
		
		// Crea un HashMap<String, Integer> amb el nom i l’edat de 5 persones (dades predefinides)
		
		HashMap<String, Integer> persones = new HashMap<String, Integer>();
		
		persones.put("A", 10);
		persones.put("B", 20);
		persones.put("C", 30);
		persones.put("D", 40);
		persones.put("E", 50);
		
		String rutaBase = System.getProperty("user.dir") + "/data/";
		String rutaArxiu = rutaBase + "PR132people.dat";
		
		// Crear la carpeta 'data' si no existeix
		
        File dir = new File("data");
        
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                System.out.println("Error en la creacio de la carpeta 'data'");
            }
        }
        
		// Empra DataOutputStream per guardar aquestes dades en un arxiu PR130persones.dat
		
		try {
			
			FileOutputStream fos = new FileOutputStream(rutaArxiu);
		    DataOutputStream dos = new DataOutputStream(fos);
		    
		    for (Iterator i = persones.keySet().iterator(); i.hasNext();) {
		    	
				String k = (String)i.next();
				Integer v = (Integer)persones.get(k);
				
				dos.writeUTF(k);
				dos.writeInt(v);
			}
		    
		    Objecte obj  = new Objecte("Escriptori", "Estudiar");
			writeSerializableObject(obj, dos);
		    
		    dos.flush();
		    fos.close();
		    dos.close();
		    
		} catch (IOException e) { e.printStackTrace(); }
		
		// Llegeix PR130persones.dat amb DataInputStream i mostra el seu contingut per pantalla
		
		try {
			
			FileInputStream fis = new FileInputStream(rutaArxiu);
			DataInputStream dis = new DataInputStream(fis);
			
			String nom_1 = dis.readUTF();
			int edat_1 = dis.readInt();
			
			String nom_2 = dis.readUTF();
			int edat_2 = dis.readInt();
			
			String nom_3 = dis.readUTF();
			int edat_3 = dis.readInt();
			
			String nom_4 = dis.readUTF();
			int edat_4 = dis.readInt();
			
			String nom_5 = dis.readUTF();
			int edat_5 = dis.readInt();
			
			Object obj = (Object) readSerializableObject(dis);
			
			System.out.println("\nPersona 1 [Nom: " + nom_1 + ", Edat: " + edat_1 + "]");
			System.out.println("Persona 2 [Nom: " + nom_2 + ", Edat: " + edat_2 + "]");
			System.out.println("Persona 3 [Nom: " + nom_3 + ", Edat: " + edat_3 + "]");
			System.out.println("Persona 4 [Nom: " + nom_4 + ", Edat: " + edat_4 + "]");
			System.out.println("Persona 5 [Nom: " + nom_5 + ", Edat: " + edat_5 + "]");
			
			fis.close();
			dis.close();
			
		} catch(IOException e) { e.printStackTrace(); }
	}
	
	public static void writeSerializableObject (Object obj, DataOutputStream dos) {
		
		try {
			
			// Transforma l'objecte a bytes[]
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			byte[] data = bos.toByteArray();
			
			// Guarda la longitud de l'array
			dos.writeInt(data.length);
			
			// Guarda els bytes de l'objecte
			dos.write(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static Object readSerializableObject (DataInputStream dis) {
		
		try {
			
			// LLegeix la longitud de l'array
			
			int longitud = dis.readInt();
			byte[] data = new byte[longitud];
			
			// LLegeix l'array que conté l'objecte
			dis.readFully(data, 0, longitud);
			
			// Transforma l'array de bytes en objecte
			
			ByteArrayInputStream bais = new  ByteArrayInputStream(data);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new java.lang.AbstractMethodError();
	}
}
