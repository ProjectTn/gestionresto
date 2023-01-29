import java.util.Scanner;


public class Plat {
	protected String codeRef ; 
	protected String nomPlat;
	protected double prix;
	protected int codeins;
	
	
	public String getCodeRef() {
		return codeRef;
	}
	public void setCodeRef(String codeRef) {
		this.codeRef = codeRef;
	}
	public String getNomPlat() {
		return nomPlat;
	}
	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getCodeins() {
		return codeins;
	}
	public void setCodeins(int codeins) {
		this.codeins = codeins;
	}
	
	public  Plat (String codeRef,String nomPlat,double prix) {
		this.nomPlat = nomPlat;
		this.prix = prix;
		this.codeRef = codeRef;
		this.codeins=0;
	}
	
	@Override
	public String toString() {
		return "Plat [codeRef=" + codeRef + ", nomPlat=" + nomPlat + ", prix=" + prix +", ce plat est commande "+ codeins + "fois ]";
	}
	
	//toString()
	

}
