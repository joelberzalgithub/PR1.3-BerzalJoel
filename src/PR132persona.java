import java.io.Serializable;

public class PR132persona implements Serializable {
	
	public String nom;
	public String cognom;
	public int edat;
	
	public PR132persona(String nom, String cognom, int edat) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.edat = edat;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getCognom() {
		return cognom;
	}
	
	public int getEdat() {
		return edat;
	}
}
