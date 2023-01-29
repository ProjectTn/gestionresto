
public class Suite extends Plat {
	
	public Suite (String codeRef,String nomPlat,double prix) {
		super(codeRef,nomPlat,prix);		
	}

	@Override
	public String toString() {
		//return "Suite [codeRef=" + codeRef + ", nomPlat=" + nomPlat + ", prix=" + prix + "]";
		return "Suite"+ super.toString();
	}

}
