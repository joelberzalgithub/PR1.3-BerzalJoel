import java.io.Serializable;
import java.util.HashMap;

public class PR131hashmap implements Serializable {
	
	public HashMap map = new HashMap();
	
	public PR131hashmap() {}
	
	public PR131hashmap(HashMap map) {
		super();
		this.map = map;
	}
	
	public HashMap getMap() {
		return map;
	}
	
	public void setMap(HashMap map) {
		this.map = map;
	}
}
