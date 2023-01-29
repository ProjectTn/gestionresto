import java.util.Scanner;

public class LigneCommande {
	
	private Plat platCommande;
	private int nbeAssiett ;
	
	
	
	public Plat getPlatCommande() {
		return platCommande;
	}
	public void setPlatCommande(Plat platCommande) {
		this.platCommande = platCommande;
	}
	public int getNbeAssiett() {
		return nbeAssiett;
	}
	public void setNbeAssiett(int nbeAssiett) {
		this.nbeAssiett = nbeAssiett;
	}
	
	
	public LigneCommande(Plat pt,int nbreAss) {
		pt.setCodeins(pt.getCodeins()+1); //lorsque on commande ce plat le code d'utilisation incremante (utiiser pour determiner le plat le plus commandee
		this.platCommande=pt;
		this.nbeAssiett=nbreAss;	
		
	}
	

	@Override
	public String toString() {
		return "LigneCommande [platCommande=" + platCommande + ", nbeAssiett=" + nbeAssiett + "]";
		
	}
	
	
	// cet methode du calcul nous aide apres lors du calcul du cout de la commande
	public double calculeMontant()
	{
		return platCommande.getPrix()*nbeAssiett; 
	}
	
	
}
