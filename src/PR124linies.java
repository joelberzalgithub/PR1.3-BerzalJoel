import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PR124linies {
	
	public static void main(String args[]) {
		
		try {
			
			File text = new File("numeros.txt");
			
			FileWriter writer = new FileWriter("numeros.txt");
			
			for (int i=0; i<10; i++) {
				int numeroAleatori = (int) ((Math.random() * (100 - 1 + 1)) + 1);
				writer.append(Integer.toString(numeroAleatori) + "\n");
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
