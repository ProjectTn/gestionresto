import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private ArrayList<Plat> list_Plat;
	private ArrayList<Table> list_Table;
    private ArrayList<Commande> list_commande ;
    public RestoApp app;
    int code =0;
    String msg="";
    String type;
    String id;
    String nomPlat;
	double prix;
	String ref;
	int nbAss;
	String mode; 
	String date1;
	String date2;
	int codeCmd;
	int idTable;
    
    public Menu() {
    	list_Plat = new ArrayList<Plat>();
    	list_Table=new ArrayList<Table>();
        list_commande = new ArrayList<Commande>();
        
    	};    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
   	
    
    //Gestion des plats 
    
    //methode recherche plat 
    public Plat recherche_Plat(String ref) {
    	 for (int i = 0; i < list_Plat.size(); i++) {
             if ( list_Plat.get(i).getCodeRef().equals(ref))
                 return list_Plat.get(i);
         }
         return null;
         }
    
    
    //ajout plat entree
    public void ajout_Entree() {
        
        if (recherche_Plat(id) != null) {
            msg="le plat existe deja dans les entrees !\n";
        } else {
        	msg="plat ajout�\n";
        	list_Plat.add(new Entree(id,nomPlat,prix));
        }
    }
    
    //ajout plat suite
    public void ajout_Suite() {
        
        if (recherche_Plat(id ) != null) {
            msg="le plat existe deja dans les suites !\n";
        } else {
        	msg="plat ajout�\n";
        	list_Plat.add(new Suite(id,nomPlat,prix));
        }
    }
   
    //ajout plat dessert
    public void ajout_Dessert() {
        
        if (recherche_Plat(id ) != null) {
            msg="le plat existe deja dans les desserts !\n";

        } else {
        	msg="plat ajout�\n";
        	list_Plat.add(new Dessert(id,nomPlat,prix));
        	
        }
    }
    
    
    //ajout plat
    public void ajout_Plat() {  
    	switch(type) {
    	 	case "entree":ajout_Entree();break;
    	 	case "suite":ajout_Suite();break;
    	 	case "dessert":ajout_Dessert();break;
    	 }
    }

    
    //modifier plat 
    public void modifierPlat() {
          Plat pt =recherche_Plat(id ) ;
          if(pt != null) {
        	  String intitule=nomPlat;
        	  double nvPrix=prix;
        	  pt.setNomPlat(intitule);
        	  pt.setPrix(nvPrix);
        	  msg=" Détails plat modifiés avec succès\n";
          }
          msg="code du plat introuvable ! impossible du modifier des details inexistantes !\n";
          }
    
    
    //affichage plats par categorie avec un ordre croissant selon les refs
    public void affichageListDesPlats() {
    	Collections.sort(list_Plat,new RefCompar());
    	 msg="--------la liste des plats--------\n----------------------------------\n-----------les entrees------------\n";
    	 for(int i=0;i<list_Plat.size();i++)
         { if(list_Plat.get(i) instanceof Entree)
        	 msg=msg+list_Plat.get(i).toString()+"\n";
         }
    	 msg=msg+"------------les suites------------\n";
    	 for(int i=0;i<list_Plat.size();i++)
         { if(list_Plat.get(i) instanceof Suite)
        	 msg=msg+ list_Plat.get(i).toString()+"\n";
         }
    	 msg=msg+"-----------les desserts------------\n";
    	 for(int i=0;i<list_Plat.size();i++)
         { if(list_Plat.get(i) instanceof Dessert)
        	 msg=msg+list_Plat.get(i).toString()+"\n";
         }
    	 msg=msg+"----------------------------------\n";
    	 System.out.println(msg);
    }
    
    
    
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    //Gestion des tables du resto
    public Table recherche_Table(int num) {
   	 for (int i = 0; i < list_Table.size(); i++) {
            if ( list_Table.get(i).getNumTable()== num)
                return list_Table.get(i);
        }
        return null;
        }
    
    public void ajout_Table() {
        if (recherche_Table(idTable) != null) {
            msg="la table deja existe !\n";

        } else {
        	list_Table.add(new Table(idTable));
        	msg="la table ajoute avec succes !\n";
        }
    }
    
    public Table Reserver_table () {
    	Table tb = null;
    	
      	 for (int i = 0; i < list_Table.size(); i++) {
             if ( list_Table.get(i).isTabDispo()) {
                 tb= list_Table.get(i);
             	tb.setTabDispo(false);
             }
      	 } 	
    	return tb;   	
    }
    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    //Gestion des commandes
    
    
    // creer une commande
    public  void  creer_commande()
    {
    	// on verifie la disponibilte du table avant tout
    	Table tb =Reserver_table();
    	if(tb == null) {
    		msg="Desole cher client pas de table disponible pour le moment!\n";
    	}else {
    	//ajout du ligne dans la commande
    	ArrayList<LigneCommande> list=new ArrayList<LigneCommande>();
        Plat pt =recherche_Plat(ref);
        if(pt != null) {
        	
        	list.add(new LigneCommande(pt, nbAss));
        	msg="Commande créer avec succes \n";
        }else{
        	msg="Verifier la reference du plat !\n";
        	}
        Commande cmd=new Commande(code,tb,list,mode);
         this.list_commande.add(cmd);
         
         //j'incrémente pour la prochaine commande
         this.code++;
        }
    }
    
    
    
    //recherche du commande a travers el code incremental
    public Commande recherche_Cmd(int id) {
   	 for (int i = 0; i < list_commande.size(); i++) {
            if ( list_commande.get(i).getCodeInc()==id)
                return list_commande.get(i);
        }
        return null;
        }
   
   
    //ajout ligne commande dans une commande deja cree
    public void Ajouter_Ligne() {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Entrer le numero de table ");
    	int numTe = sc.nextInt();
    	Table tableRech = recherche_Table(numTe);
    	
    	if (tableRech!=null && (tableRech.isTabDispo()==false)) {
    		System.out.println("Entrer le code de la commande ");
    		int code = 0;
    		Commande cmd=recherche_Cmd(code);
    			if(cmd != null) {
    					System.out.println("choisir votre plat en donnant son reference et merci:");
    					String ref=app.textRef_1.getText();
    					Plat pt =recherche_Plat(ref);
    						if(pt != null) {
    								System.out.println("Combien d'assiettes à commander et merci:");
    								int nbAss=(Integer)app.spinner.getValue();
    								cmd.getListLigneCmd().add(new LigneCommande(pt, nbAss));
    						}else{
    								System.out.println("Verifier la reference du plat !");
    			}}else {
            	 System.out.println("Verifier le code du client !");
          }
    			}else {
             System.out.println("Table vide ! impossible d'ajouter la ligne les cilents ont deja quitte!!!");
             }
    }
    
    
    //affichage details commande
    public void affichageDetailsCmd() {
		Commande cmd=recherche_Cmd(codeCmd);
		if(cmd != null) {
			msg=cmd.toString();
		}else {
			msg="verifier le code du la commande\n";
		}
    }
    
    //cloturer une commande
    public void clotureCmd() {;
		Commande cmd=recherche_Cmd(codeCmd);
		if(cmd != null) {
			cmd.setCloturee(true);
			cmd.getTab().setTabDispo(true);
			msg="Commande cloturee";
		}
		else {
			msg="verifier le code du la commande\n";
		}
    }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   //Gestion du la caisse
    
    // recette journalliere a un date specifique
    public void recette_journaliere(LocalDate d)
    {
    double montant=0.0;
    for(int i=0;i<this.list_commande.size();i++)
    {
    if(this.list_commande.get(i).getDateCmd().isEqual(d))
    {

    montant=montant+this.list_commande.get(i).calcule_montant();
    }
    }
    msg="La recette journaliere est = "+montant+"\n";

    }
    
    // recette journalliere pendant une periode specifique    
    public void recette_journaliere_Periode() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDate date_deb = LocalDate.parse(date1, formatter);
        LocalDate date_fin;
        do{
        date_fin= LocalDate.parse(date2, formatter);
        } while(date_deb.isAfter(date_fin)); 
        
        for(LocalDate date=date_deb;date.isBefore(date_fin);date=date.plusDays(1)) {
        	recette_journaliere(date);
        }
        
        double montant=0.0;  
        for(int i=0;i<list_commande.size();i++)
        {
        	if(list_commande.get(i).getDateCmd().isBefore(date_deb)&&list_commande.get(i).getDateCmd().isAfter(date_fin)) {
        		montant=montant+list_commande.get(i).calcule_montant();
        	}
        }
        
        msg="La recette journaliere est = "+montant+"\n";
    
    	}
    
	//le plat le plus commande
	public void LePlusCommande() {
		Plat max=list_Plat.get(0);
		 for(int i=0;i<list_Plat.size();i++) {
			 if(max.getCodeins()<list_Plat.get(i).getCodeins()) {
				 max=list_Plat.get(i);
			 }
		 }
	        msg="le plat le plus commande :: "+max.toString()+"\n";
	}
      
}



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

