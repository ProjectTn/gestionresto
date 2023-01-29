import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class Commande {
	
private int codeInc;
private Table Tab;
private LocalDate dateCmd;
private LocalTime heureCmd;
private ArrayList<LigneCommande>listLigneCmd;
private String modePaiement;
private boolean cloturee;




public int getCodeInc() {
	return codeInc;
}
public void setCodeInc(int codeInc) {
	this.codeInc = codeInc;
}
public Table getTab() {
	return Tab;
}
public void setTab(Table tab) {
	Tab = tab;
}
public LocalDate getDateCmd() {
	return dateCmd;
}
public void setDateCmd(LocalDate dateCmd) {
	this.dateCmd = dateCmd;
}
public LocalTime getHeureCmd() {
	return heureCmd;
}
public void setHeureCmd(LocalTime heureCmd) {
	this.heureCmd = heureCmd;
}
public ArrayList<LigneCommande> getListLigneCmd() {
	return listLigneCmd;
}
public void setListLigneCmd(ArrayList<LigneCommande> listLigneCmd) {
	this.listLigneCmd = listLigneCmd;
}
public String getModePaiement() {
	return modePaiement;
}
public void setModePaiement(String modePaiement) {
	this.modePaiement = modePaiement;
}
public boolean isCloturee() {
	return cloturee;
}
public void setCloturee(boolean cloturee) {
	this.cloturee = cloturee;
}


public Commande(int codeInc,Table Table, ArrayList<LigneCommande>listLigneCmd, String modePaiement) {
	this.codeInc = codeInc;
	this.Tab = Table;
	this.dateCmd = LocalDate.now() ;
	this.heureCmd =LocalTime.now();
	this.modePaiement = modePaiement;
	this.listLigneCmd = listLigneCmd;
	
	this.cloturee = false; //debut order 

}


public String afficherListLigneCmd()
{
    String list="";
    for(int i=0;i<=listLigneCmd.size();i++)
    {
        list=list+("le ligne numéro"+i+listLigneCmd.get(i).toString());
    }
    return list;
}

@Override
public String toString()
{
    DateTimeFormatter FormatDate= DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter FormatHour= DateTimeFormatter.ofPattern("HHmmss");
    String  formattedDate=dateCmd.format(FormatDate);
    String  formattedHour=heureCmd.format(FormatHour);
    return("code de la commande "+this.codeInc+": Table concerné: "+this.Tab.getNumTable()+
    		"est disponible:"+this.Tab.isTabDispo() +"Passée le:+ "+ formattedDate +" en "+ formattedHour+
    	  "\n contient : \n"+afficherListLigneCmd() +"\n mode de Paiement:" + modePaiement+ 
    	  "Commande cloturée:" + cloturee);
}


public double calcule_montant()
{  
	double montant=0 ;
    for(int i=0;i<listLigneCmd.size();i++)
    {
        montant=montant+listLigneCmd.get(i).calculeMontant();
    }
    return montant;
}



}
