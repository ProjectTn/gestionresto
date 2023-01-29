import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.time.LocalDate;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RestoApp {

	public static JFrame frame;
	public JTextField textRef;
	public JTextField textNom;
	public JTextField textPrix;
	public JTextField textRef_1;
	public JTextArea Affichage;
	public JButton btnFaireunecommande;
	public JButton btnAjouterPlat;
	public JButton btnModifier_plat;
	public JButton btnAfficherLesPlats;
	public JButton btnAffichierCloturer;
	public JButton btnAjoutTable;
	public JButton btnRecette;
	public JButton btnperiode;
	public JButton btnLeplus;
	public JComboBox Type;
	public JButton btnAjouter;
	public JButton btnModifier;
	public JComboBox Mode;
	public JButton btnCommander;
	public JSpinner spinner;
	public JPanel panelPlat ;
	public JPanel panelMenu ;
	public JPanel panelCommande;
	public JPanel panelPeriode;
	public JTextField textDebut;
	public JTextField textFin;
	public JButton btnVerifier;
	public JLabel lblDebut;
	public JLabel lblFin;
	private JPanel panelCode;
	private JTextField textCode;
	private JButton btnAfficher;
	private JButton btnCloturer;
	private JLabel lblCode;
	private JButton btnAjouter_1;
	


	/**
	 * Create the application.
	 */
	public RestoApp(Menu gestionnaire) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					Actions(gestionnaire);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 797, 821);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelPlat = new JPanel();
		panelMenu = new JPanel();
		panelCommande = new JPanel();
		panelPeriode = new JPanel();
		panelCode = new JPanel();
		GroupLayout gl_panelPlat = new GroupLayout(panelPlat);
		GroupLayout gl_panelPeriode = new GroupLayout(panelPeriode);
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		GroupLayout gl_panelCode = new GroupLayout(panelCode);
		GroupLayout gl_panelCommande = new GroupLayout(panelCommande);
		panelPeriode.setLayout(gl_panelPeriode);
		panelPlat.setLayout(gl_panelPlat);
		panelMenu.setLayout(gl_panelMenu);
		frame.getContentPane().setLayout(groupLayout);
		panelCode.setLayout(gl_panelCode);
		panelCommande.setLayout(gl_panelCommande);
		
		
		panelCode.setVisible(false);
		panelPlat.setVisible(false);
		panelCommande.setVisible(false);
		panelPeriode.setVisible(false);
		
		
		Affichage = new JTextArea();
		Affichage.setEditable(false);
		Affichage.setFont(new Font("Tahoma", Font.BOLD, 12));
		Affichage.setText("~~~~~~~~~~~~~~~BIENVENUE DANS NOTRE RESTO~~~~~~~~~~~~~~~\r\nVeuillez choisir l'operation que vous voulez effectuer\n");
		
		
		btnFaireunecommande = new JButton("Faire une commande");
		btnAjouterPlat = new JButton("Ajouter un Plat");
		btnModifier_plat = new JButton("Modifier les caracteristques un plat");
		btnAfficherLesPlats = new JButton("Afficher les plats");
		btnAffichierCloturer = new JButton("Afficher/Cloturer commande");
		btnAjoutTable = new JButton("Ajouter une table");
		btnRecette = new JButton("recette journalliere");
		btnperiode = new JButton("recette journalliere pendant une periode");
		btnLeplus = new JButton("le plat le plus command\u00E9");
		
		
		
		//Partie Plat
		Type = new JComboBox();
		Type.setFont(new Font("Tahoma", Font.BOLD, 12));
		Type.setModel(new DefaultComboBoxModel(new String[] {"Type", "entree", "suite", "dessert"}));
		
		textRef = new JTextField();
		textRef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textRef.setColumns(10);
		
		
		textNom = new JTextField();
		textNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNom.setColumns(10);
		
		textPrix = new JTextField();
		textPrix.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPrix.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRef = new JLabel("Ref :");
		lblRef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnAjouter = new JButton("Ajouter");
		btnModifier = new JButton("Modifier");
		
		//Partie Commande
		textRef_1 = new JTextField();
		textRef_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textRef_1.setColumns(10);
		
		JLabel lblRef_1 = new JLabel("Ref :");
		lblRef_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMode = new JLabel("Mode de paiement :");
		lblMode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		Mode = new JComboBox();
		Mode.setModel(new DefaultComboBoxModel(new String[] {"cheque", "CB", "espece"}));
		Mode.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnCommander = new JButton("Commander");
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		
		JLabel lblNombreDassiettes = new JLabel("Nombre d'assiettes :");
		lblNombreDassiettes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		//Partie Recette
		textDebut = new JTextField();
		textDebut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDebut.setColumns(10);
		textFin = new JTextField();
		textFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFin.setColumns(10);
		lblDebut = new JLabel("Debut :");
		lblDebut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFin = new JLabel("Fin");
		lblFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerifier = new JButton("Verifier");
		
		//Partie Code
		textCode = new JTextField();
		textCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCode.setColumns(10);
		
		btnAfficher = new JButton("Afficher");
		btnAjouter_1 = new JButton("Ajouter");
		btnCloturer = new JButton("Cloturer");
		
		lblCode = new JLabel("Code :");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		gl_panelPlat.setHorizontalGroup(
			gl_panelPlat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPlat.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPlat.createParallelGroup(Alignment.LEADING)
						.addComponent(lblType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblRef, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelPlat.createParallelGroup(Alignment.LEADING)
						.addComponent(Type, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textRef, 180, 180, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelPlat.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNom, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addComponent(lblPrix, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelPlat.createParallelGroup(Alignment.LEADING)
						.addComponent(textNom, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(textPrix, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addGroup(gl_panelPlat.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelPlat.createSequentialGroup()
							.addGap(113)
							.addComponent(btnAjouter, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
						.addGroup(gl_panelPlat.createSequentialGroup()
							.addGap(113)
							.addComponent(btnModifier, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelPlat.setVerticalGroup(
			gl_panelPlat.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelPlat.createSequentialGroup()
					.addGroup(gl_panelPlat.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelPlat.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblType, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelPlat.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panelPlat.createParallelGroup(Alignment.BASELINE)
								.addGroup(gl_panelPlat.createSequentialGroup()
									.addGap(1)
									.addComponent(Type, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
								.addComponent(lblNom, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
								.addGroup(gl_panelPlat.createSequentialGroup()
									.addGap(1)
									.addGroup(gl_panelPlat.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAjouter, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
										.addComponent(textNom, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelPlat.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelPlat.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panelPlat.createSequentialGroup()
								.addGap(2)
								.addComponent(textRef, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
							.addComponent(lblRef, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPrix, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panelPlat.createSequentialGroup()
								.addGap(2)
								.addComponent(textPrix, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
						.addGroup(gl_panelPlat.createSequentialGroup()
							.addGap(2)
							.addComponent(btnModifier, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		
		gl_panelMenu.setHorizontalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAjouterPlat, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnAfficherLesPlats, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnLeplus, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnFaireunecommande, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnAffichierCloturer, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnAjoutTable, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnModifier_plat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRecette, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnperiode, GroupLayout.PREFERRED_SIZE, 199, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(Affichage, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panelMenu.setVerticalGroup(
			gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMenu.createSequentialGroup()
							.addComponent(btnAjouterPlat, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(btnAfficherLesPlats, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(btnLeplus, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(btnFaireunecommande, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(btnAffichierCloturer, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(btnAjoutTable, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(btnModifier_plat, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(btnRecette, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(btnperiode, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
						.addComponent(Affichage, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
					.addGap(5))
		);
			
		gl_panelPeriode.setHorizontalGroup(
				gl_panelPeriode.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelPeriode.createSequentialGroup()
						.addGap(10)
						.addComponent(lblDebut, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
						.addGap(29)
						.addComponent(textDebut, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addGap(11)
						.addComponent(lblFin, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textFin, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addGap(65)
						.addComponent(btnVerifier, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_panelPeriode.setVerticalGroup(
				gl_panelPeriode.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelPeriode.createSequentialGroup()
						.addGap(10)
						.addComponent(lblDebut, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addGap(12))
					.addGroup(gl_panelPeriode.createSequentialGroup()
						.addGap(11)
						.addComponent(textDebut, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addGap(12))
					.addGroup(gl_panelPeriode.createSequentialGroup()
						.addGap(11)
						.addGroup(gl_panelPeriode.createParallelGroup(Alignment.BASELINE)
							.addGroup(gl_panelPeriode.createSequentialGroup()
								.addGap(2)
								.addComponent(textFin, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
							.addGroup(gl_panelPeriode.createSequentialGroup()
								.addGap(2)
								.addComponent(btnVerifier, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
						.addGap(9))
					.addGroup(gl_panelPeriode.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblFin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
				
			groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(panelPlat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(10, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelCommande, GroupLayout.PREFERRED_SIZE, 761, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelPeriode, GroupLayout.PREFERRED_SIZE, 761, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelCode, GroupLayout.PREFERRED_SIZE, 761, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(panelPlat, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelCommande, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelPeriode, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelCode, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(6))
				);
					
					
				gl_panelCode.setHorizontalGroup(
					gl_panelCode.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCode.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCode, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(textCode, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(btnAjouter_1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnAfficher, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnCloturer, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addGap(10))
				);
				gl_panelCode.setVerticalGroup(
					gl_panelCode.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCode.createSequentialGroup()
							.addGap(11)
							.addComponent(lblCode, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_panelCode.createSequentialGroup()
							.addGap(12)
							.addComponent(textCode, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_panelCode.createSequentialGroup()
							.addGap(11)
							.addComponent(btnAjouter_1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_panelCode.createSequentialGroup()
							.addGap(11)
							.addComponent(btnAfficher, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_panelCode.createSequentialGroup()
							.addGap(11)
							.addComponent(btnCloturer, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addGap(14))
				);
					
				gl_panelCommande.setHorizontalGroup(
					gl_panelCommande.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCommande.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panelCommande.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCommande.createSequentialGroup()
									.addComponent(lblRef_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(textRef_1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(lblNombreDassiettes, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
								.addGroup(gl_panelCommande.createSequentialGroup()
									.addComponent(lblMode, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(Mode, 0, 180, Short.MAX_VALUE)
									.addGap(46)
									.addComponent(btnCommander, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
							.addGap(232))
				);
				gl_panelCommande.setVerticalGroup(
					gl_panelCommande.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCommande.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_panelCommande.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCommande.createSequentialGroup()
									.addComponent(lblRef_1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
									.addGap(2))
								.addGroup(gl_panelCommande.createSequentialGroup()
									.addGap(3)
									.addComponent(textRef_1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
								.addGroup(gl_panelCommande.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNombreDassiettes, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
								.addGroup(gl_panelCommande.createSequentialGroup()
									.addGap(3)
									.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
							.addGap(9)
							.addGroup(gl_panelCommande.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMode, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelCommande.createSequentialGroup()
									.addGap(1)
									.addComponent(Mode, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelCommande.createSequentialGroup()
									.addGap(2)
									.addComponent(btnCommander, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
							.addGap(20))
				);
					
		
	}


	public void Actions(Menu gestionnaire) {
		btnFaireunecommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPlat.setVisible(false);
				panelCommande.setVisible(true);
				panelCode.setVisible(false);
				panelPeriode.setVisible(false);
				gestionnaire.affichageListDesPlats();
                Affichage.append(gestionnaire.msg);
				Affichage.append("Veuillez remplir la reference du plat, le nombre d'assiettes et le mode du paiement\n");
			}
		});
		
		btnAjouterPlat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPlat.setVisible(true);
				panelCommande.setVisible(false);
				panelPeriode.setVisible(false);
				panelCode.setVisible(false);
				Affichage.append("Veuillez remplir le type, la reference, le nom et le prix du plat\n");
			}
		});
		
		btnModifier_plat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPlat.setVisible(true);
				panelCommande.setVisible(false);
				panelPeriode.setVisible(false);
				panelCode.setVisible(false);
				Affichage.append("Veuillez la reference, le nom et le prix du plat � modifier\n");
				
			}
		});
		
		
		
		btnAfficherLesPlats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPlat.setVisible(false);
				panelCommande.setVisible(false);
				panelPeriode.setVisible(false);
				panelCode.setVisible(false);
				gestionnaire.affichageListDesPlats();
				Affichage.append(gestionnaire.msg);
			}
		});
		
		btnAffichierCloturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPlat.setVisible(false);
				panelCommande.setVisible(false);
				panelPeriode.setVisible(false);
				panelCode.setVisible(true);
				Affichage.append("Entrer le code de la commande\n");
			}
		});
		
		btnAjoutTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPlat.setVisible(false);
				panelCommande.setVisible(false);
				panelPeriode.setVisible(false);
				panelCode.setVisible(true);
				Affichage.append("Entrer le code de la table\n");
			}
		});
		
		btnRecette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPlat.setVisible(false);
				panelCommande.setVisible(false);
				panelPeriode.setVisible(false);
				panelCode.setVisible(false);
				LocalDate d =LocalDate.now();
        		gestionnaire.recette_journaliere(d);
        		Affichage.append(gestionnaire.msg);
			}
		});
		
		btnperiode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPlat.setVisible(false);
				panelCommande.setVisible(false);
				panelPeriode.setVisible(true);
				panelCode.setVisible(false);
				Affichage.append("Donner la date de début et la date de fin\n");
			}
		});
		
		btnLeplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPeriode.setVisible(false);
				panelPlat.setVisible(false);
				panelCommande.setVisible(false);
				panelCode.setVisible(false);
				gestionnaire.LePlusCommande();
				Affichage.append(gestionnaire.msg);
				
			}
		});
		
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionnaire.type=(String)Type.getSelectedItem();
				gestionnaire.id=textRef.getText();
				gestionnaire.prix=Double.parseDouble(textPrix.getText());
				gestionnaire.nomPlat=textNom.getText();
				gestionnaire.ajout_Plat();
				Affichage.append(gestionnaire.msg);
			}
		});
		
		btnAjouter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionnaire.idTable=Integer.parseInt(textCode.getText());
				gestionnaire.ajout_Table();
				Affichage.append(gestionnaire.msg);
			}
		});

		
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionnaire.id=textRef.getText();
				gestionnaire.prix=Double.parseDouble(textPrix.getText());
				gestionnaire.nomPlat=textNom.getText();
				gestionnaire.modifierPlat();
				Affichage.append(gestionnaire.msg);
			}
		});
		
		btnCommander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionnaire.ref=textRef_1.getText();
				gestionnaire.nbAss=(Integer)spinner.getValue();
				gestionnaire.mode=(String)Mode.getSelectedItem();
				gestionnaire.creer_commande();
				Affichage.append(gestionnaire.msg);
			}
		});
		
		btnVerifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionnaire.date1=textDebut.getText();
				gestionnaire.date2=textFin.getText();
				gestionnaire.recette_journaliere_Periode();
				Affichage.append(gestionnaire.msg);
			}
		});
		
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionnaire.codeCmd=Integer.parseInt(textCode.getText());
				gestionnaire.affichageDetailsCmd();
				Affichage.append(gestionnaire.msg);
			}
		});
		
		btnCloturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestionnaire.codeCmd=Integer.parseInt(textCode.getText());
				gestionnaire.clotureCmd();
				Affichage.append(gestionnaire.msg);
			}
		});
	}
}