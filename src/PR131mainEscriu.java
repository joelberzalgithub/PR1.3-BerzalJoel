import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;

public class PR131mainEscriu {
	
	public static PR131hashmap PR131 = new PR131hashmap();
	public static HashMap map = PR131.getMap();
	
	public PR131mainEscriu(PR131hashmap PR131) {
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
			
			FileOutputStream fos = new FileOutputStream(rutaArxiu);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			for (Iterator i = getMap().keySet().iterator(); i.hasNext();) {
		    	
				String k = (String)i.next();
				String v = Integer.toString((Integer)getMap().get(k));
				
				oos.writeObject(new Objecte(k, v));
			}
			
			oos.close();
			fos.close();
				
		} catch (IOException e) { e.printStackTrace(); }
	}
}
