import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;

public class PR131mainLlegeix {

	public static PR131hashmap PR131 = new PR131hashmap();
	public static HashMap map = PR131.getMap();
	
	public PR131mainLlegeix(PR131hashmap PR131) {
		super();
		this.PR131 = PR131;
	}
	
	public static HashMap getMap() {
		return map;
	}
	
	public static void main(String[] args) {
		
		String rutaBase = System.getProperty("user.dir") + "/data/";
		String rutaArxiu = rutaBase + "PR131HashMapData.ser";
		
		// Crear la carpeta 'data' si no existeix
		
		File dir = new File(rutaBase);
		if (!dir.exists()) {
			if (!dir.mkdirs()) {
				System.out.println("Error en la creacio de la carpeta 'data'");
			}
		}
		
		try {
			
			FileInputStream fis = new FileInputStream(rutaArxiu);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			for (Iterator i = getMap().keySet().iterator(); i.hasNext();) {
				System.out.println(ois.readObject());
			}
			
			ois.close();
			fis.close();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) { e.printStackTrace(); }
	}
}
