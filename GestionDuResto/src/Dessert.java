
public class Dessert extends Plat {
	
	public Dessert (String codeRef,String nomPlat,double prix) {
		super(codeRef,nomPlat,prix);		
	}

	@Override
	public String toString() {
		//return "Dessert [codeRef=" + codeRef + ", nomPlat=" + nomPlat + ", prix=" + prix + "]";
		return "Dessert"+ super.toString();
	}
	
}