
public class Entree extends Plat {
	
	public Entree (String codeRef,String nomPlat,double prix) {
		super(codeRef,nomPlat,prix);		
	}

	@Override
	public String toString() {
		//return "Entree [codeRef=" + codeRef + ", nomPlat=" + nomPlat + ", prix=" + prix +", ce plat est commande="+ codeins + "]";
		return "Entree"+ super.toString();
	}



}
