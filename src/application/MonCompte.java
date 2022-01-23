package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MonCompte extends JPanel {

	Image IconClient = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/homme.png").getImage()
			.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

	String x1, x2, x3, x4, x5, x6, x7, x8;

	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public MonCompte() {
		setSize(750, 800);
		setLayout(null);
		setBackground(new Color(0, 128, 128));

		Label txtLBLRes = new Label("MON COMPTE");
		txtLBLRes.setBounds(0, 0, 750, 40);
		txtLBLRes.setBackground(new Color(47, 79, 79));
		txtLBLRes.setForeground(Color.white);
		txtLBLRes.setAlignment(Label.CENTER);
		txtLBLRes.setFont(new Font("Dialog", Font.BOLD, 30));
		add(txtLBLRes);

		// les infos
		// nom user
		Label nomcomplet = new Label("Nom d'utilisateur :");
		nomcomplet.setBounds(30, 420, 170, 50);
		nomcomplet.setBackground(new Color(0, 128, 128));
		nomcomplet.setForeground(Color.white);
		nomcomplet.setAlignment(Label.LEFT);
		nomcomplet.setFont(new Font("Dialog", Font.BOLD, 18));
		add(nomcomplet);

		JTextField txtnomcomplet = new JTextField(fonctions.acctualiseMonCompte(1));
		txtnomcomplet.setBounds(215, 432, 150, 25);
		txtnomcomplet.setBackground(UIManager.getColor("Button.highlight"));
		txtnomcomplet.setToolTipText("");
		txtnomcomplet.setColumns(10);
		add(txtnomcomplet);

		// nom de user
		Label nom = new Label("Nom :");
		nom.setBounds(30, 480, 170, 50);
		nom.setBackground(new Color(0, 128, 128));
		nom.setForeground(Color.white);
		nom.setAlignment(Label.LEFT);
		nom.setFont(new Font("Dialog", Font.BOLD, 18));
		add(nom);

		JTextField txtnom = new JTextField(fonctions.acctualiseMonCompte(3));
		txtnom.setBounds(215, 492, 150, 25);
		txtnom.setBackground(UIManager.getColor("Button.highlight"));
		txtnom.setToolTipText("");
		txtnom.setColumns(10);
		add(txtnom);

		// prenom user
		Label prenom = new Label("Prenom :");
		prenom.setBounds(410, 480, 160, 50);
		prenom.setBackground(new Color(0, 128, 128));
		prenom.setForeground(Color.white);
		prenom.setAlignment(Label.LEFT);
		prenom.setFont(new Font("Dialog", Font.BOLD, 18));
		add(prenom);

		JTextField txtprenom = new JTextField(fonctions.acctualiseMonCompte(4));
		add(txtprenom);
		txtprenom.setBounds(570, 492, 150, 25);
		txtprenom.setBackground(UIManager.getColor("Button.highlight"));
		txtprenom.setToolTipText("");
		txtprenom.setColumns(10);

		// CIN user
		Label cin = new Label("CIN :");
		cin.setBounds(30, 540, 170, 50);
		cin.setBackground(new Color(0, 128, 128));
		cin.setForeground(Color.white);
		cin.setAlignment(Label.LEFT);
		cin.setFont(new Font("Dialog", Font.BOLD, 18));
		add(cin);

		JTextField txtcin = new JTextField(fonctions.acctualiseMonCompte(5));
		txtcin.setBounds(215, 552, 150, 25);
		txtcin.setBackground(UIManager.getColor("Button.highlight"));
		txtcin.setToolTipText("");
		txtcin.setColumns(10);
		add(txtcin);

		// Telephone User
		Label ntelephone = new Label("N de telephone :");
		ntelephone.setBounds(30, 600, 170, 50);
		ntelephone.setBackground(new Color(0, 128, 128));
		ntelephone.setForeground(Color.white);
		ntelephone.setAlignment(Label.LEFT);
		ntelephone.setFont(new Font("Dialog", Font.BOLD, 18));
		add(ntelephone);

		JTextField txttel = new JTextField(fonctions.acctualiseMonCompte(6));
		add(txttel);
		txttel.setBounds(215, 612, 150, 25);
		txttel.setBackground(UIManager.getColor("Button.highlight"));
		txttel.setToolTipText("");
		txttel.setColumns(10);

		// Mot de passe User
		Label motdepasse = new Label("Mot de passe :");
		motdepasse.setBounds(410, 420, 160, 50);
		motdepasse.setBackground(new Color(0, 128, 128));
		motdepasse.setForeground(Color.white);
		motdepasse.setAlignment(Label.LEFT);
		motdepasse.setFont(new Font("Dialog", Font.BOLD, 18));
		add(motdepasse);

		JPasswordField txtmedepasse = new JPasswordField(fonctions.acctualiseMonCompte(2));
		add(txtmedepasse);
		txtmedepasse.setBounds(570, 432, 150, 25);
		txtmedepasse.setBackground(UIManager.getColor("Button.highlight"));
		txtmedepasse.setToolTipText("");
		txtmedepasse.setColumns(10);

		// addresse User
		Label Add = new Label("Addresse :");
		Add.setBounds(410, 540, 160, 50);
		Add.setBackground(new Color(0, 128, 128));
		Add.setForeground(Color.white);
		Add.setAlignment(Label.LEFT);
		Add.setFont(new Font("Dialog", Font.BOLD, 18));
		add(Add);

		JTextField txtpADD = new JTextField(fonctions.acctualiseMonCompte(8));
		txtpADD.setBounds(570, 552, 150, 25);
		txtpADD.setBackground(UIManager.getColor("Button.highlight"));
		txtpADD.setToolTipText("");
		txtpADD.setColumns(10);
		add(txtpADD);

		// Email User
		Label Email = new Label("Email :");
		Email.setBounds(410, 600, 160, 50);
		Email.setBackground(new Color(0, 128, 128));
		Email.setForeground(Color.white);
		Email.setAlignment(Label.LEFT);
		Email.setFont(new Font("Dialog", Font.BOLD, 18));
		add(Email);

		JTextField txtpEmail = new JTextField(fonctions.acctualiseMonCompte(7));
		txtpEmail.setBounds(570, 612, 150, 25);
		txtpEmail.setBackground(UIManager.getColor("Button.highlight"));
		txtpEmail.setToolTipText("");
		txtpEmail.setColumns(10);
		add(txtpEmail);

		// image and name of person
		JLabel image = new JLabel();
		image.setBounds(260, 80, 250, 250);
		image.setBackground(Color.white);
		image.setIcon(new ImageIcon(IconClient));
		add(image);

		// Nom complet
		Label NAME = new Label(fonctions.acctualiseMonCompte(3) + " " + fonctions.acctualiseMonCompte(4));
		NAME.setBounds(260, 340, 250, 25);
		NAME.setBackground(new Color(0, 128, 128));
		NAME.setForeground(Color.white);
		NAME.setAlignment(Label.CENTER);
		NAME.setFont(new Font("Dialog", Font.BOLD, 18));
		add(NAME);

		// button pour lenregistreent des donnee
		JButton enr = new JButton("ENREGISTRE");
		enr.setBounds(260, 700, 250, 50);
		enr.setBackground(new Color(47, 79, 79));
		enr.setForeground(Color.white);
		enr.setFont(new Font("Dialog", Font.BOLD, 18));
		enr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fonction pour change DATA de User
				fonctions.ModifierDetailsDeUser(txtnomcomplet.getText(), txtmedepasse.getPassword(), txtnom.getText(),
						txtprenom.getText(), txtcin.getText(), txttel.getText(), txtpEmail.getText(),
						txtpADD.getText());
				NAME.setText(txtnom.getText() + " " + txtprenom.getText());
			}
		});
		add(enr);

	}
}