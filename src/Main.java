import java.io.IOException;
import java.util.*;

public class Main {
	static Scanner in = new Scanner(System.in); // System.in és global
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		boolean running = true;
		
		while (running) {
			
			System.out.println("Escull una opcio:\n\n0) PR120ReadFile\n1) PR121Files\n2) PR122cat\n3) PR123sobreescriu" +
							   "\n4) PR123append\n5) PR124linies\n6) PR125cp\n7) PR1310mainPersonesHashmap\n8) PR131mainEscriu" +
							   "\n9) PR131mainLlegeix\n10) PR132main\n11) PR133mainTreballadors\n12) PR134estudiantsManager\n100) Sortir\n");
			
			try {
				
				int opcio = Integer.valueOf(llegirLinia("Opcio: "));
				
				switch (opcio) {
					case 0: PR120ReadFile.main(args);
							break;
					case 1: PR121Files.main(args);
							break;
					case 2: PR122cat.main(args);
							break;
					case 3: PR123sobreescriu.main(args);
							break;
					case 4: PR123append.main(args);
							break;
					case 5: PR124linies.main(args);
							break;
					case 6: PR125cp.main(args);
							break;
					case 7: PR130mainPersonesHashmap.main(args);
							break;
					case 8: PR131mainEscriu.main(args);
							break;
					case 9: PR131mainLlegeix.main(args);
							break;
					case 10: PR132main.main(args);
							break;
					case 11: PR133mainTreballadors.main(args);
							break;
					case 12: PR134estudiantsManager.main(args);
							break;
					case 100: running = false;
							break;
					default: System.out.println("\nOpcio fora del rang!");
							break;
				}
				
				System.out.println("\n******************************************************************************************************\n");
				
			} catch (Exception e) {
				System.out.println("\nOpcio no numerica!\n\n******************************************************************************************************\n");
			}
		}
		in.close();
	}
	
	public static String llegirLinia (String text) {
		System.out.print(text);
		return in.nextLine();
    }
}
