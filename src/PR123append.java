import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PR123append {
	
	public static void main(String args[]) {
		
		try {
			
			File text = new File("frasesMatrix.txt");
			
			FileWriter writer = new FileWriter("frasesMatrix.txt", true);
			
			writer.write("Yo sólo puedo mostrarte la puerta");
			writer.write("Tú eres quien la tiene que atravesar");
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
