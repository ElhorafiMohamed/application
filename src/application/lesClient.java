package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class lesClient extends JPanel implements ActionListener, ListSelectionListener {

	JButton ajoute, modifier, remove;

	String column[] = { "NomComplet", "CIN", "Addresse", "Permis", "N_Permis", "Email", "NumTel" };
	DefaultTableModel model = new DefaultTableModel(column, 0);

	// Créer la table
	JTable jt = new JTable(model);
	ListSelectionModel listModel = jt.getSelectionModel();

	// variable pour Selection
	String nomcomplet, cin, addresse, permit, n_permis, email, nTel;

	public lesClient() {
		setSize(750, 800);
		setLayout(null);
		setBackground(new Color(0, 128, 128));

		// Title fenetre CLIENT
		Label txtLBLRes = new Label("LES CLIENTS");
		txtLBLRes.setBounds(0, 0, 750, 40);
		txtLBLRes.setBackground(new Color(47, 79, 79));
		txtLBLRes.setForeground(Color.white);
		txtLBLRes.setAlignment(Label.CENTER);
		txtLBLRes.setFont(new Font("Dialog", Font.BOLD, 30));
		add(txtLBLRes);

		JPanel panel = new JPanel();
		panel.setBounds(80, 120, 600, 500);
		panel.setBackground(new Color(0, 128, 128));
		jt.setBounds(80, 120, 600, 500);
		add(jt);

		JScrollPane pane = new JScrollPane(jt);

		// BUTTON REMOVE
		remove = new JButton("supprime");
		remove.setBounds(310, 600, 140, 50);
		remove.setBackground(new Color(47, 79, 79));
		remove.setForeground(Color.white);
		remove.setFont(new Font("Dialog", Font.BOLD, 18));
		add(remove);

		// BUTTON MODIFIER
		modifier = new JButton("modifier");
		modifier.setBounds(460, 600, 140, 50);
		modifier.setBackground(new Color(47, 79, 79));
		modifier.setForeground(Color.white);
		modifier.setFont(new Font("Dialog", Font.BOLD, 18));
		add(modifier);

		// BUTTON AJOUTER
		ajoute = new JButton("ajouter");
		ajoute.setBounds(160, 600, 140, 50);
		ajoute.setBackground(new Color(47, 79, 79));
		ajoute.setForeground(Color.white);
		ajoute.setFont(new Font("Dialog", Font.BOLD, 18));
		add(ajoute);

		panel.add(pane);
		add(panel);

		// initialise le tableau d'apres DATA
		fonctions.acctualise(model, "clients");

		ajoute.addActionListener(this);
		remove.addActionListener(this);
		modifier.addActionListener(this);

		// Listener pour tableau

		listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel.addListSelectionListener(this);
	}

	// fonction qui return row select in tableau
	public void valueChanged(ListSelectionEvent e) {
		int[] sel;

		if (!e.getValueIsAdjusting()) {
			sel = jt.getSelectedRows();
			if (sel.length > 0) {
				TableModel tm = jt.getModel();
				nomcomplet = (String) tm.getValueAt(sel[0], 0);
				cin = (String) tm.getValueAt(sel[0], 1);
				addresse = (String) tm.getValueAt(sel[0], 2);
				permit = (String) tm.getValueAt(sel[0], 3);
				n_permis = (String) tm.getValueAt(sel[0], 4);
				email = (String) tm.getValueAt(sel[0], 5);
				nTel = (String) tm.getValueAt(sel[0], 6);
			}
		}
	}

	// apres clique a n'importe quel button
	public void actionPerformed(ActionEvent e) {
		// affichage de frame contien les label et les textFlied
		JFrame m = new JFrame();
		m.setBounds(500, 200, 400, 400);
		// m.setUndecorated(true);
		m.setVisible(true);

		JPanel panelajoute = new JPanel();
		panelajoute.setBackground(new Color(0, 128, 128));
		panelajoute.setBounds(0, 0, 400, 400);
		panelajoute.setLayout(null);
		m.add(panelajoute);

		// nom de client
		Label nomcompletLBL = new Label("nom de client :");
		nomcompletLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		nomcompletLBL.setForeground(Color.WHITE);
		nomcompletLBL.setBounds(10, 20, 120, 22);
		nomcompletLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(nomcompletLBL);

		JTextField nomcomplettxt = new JTextField("");
		nomcomplettxt.setBounds(150, 20, 150, 25);
		nomcomplettxt.setBackground(UIManager.getColor("Button.highlight"));
		nomcomplettxt.setToolTipText("");
		nomcomplettxt.setColumns(10);
		panelajoute.add(nomcomplettxt);

		// cin de client
		Label cinLBL = new Label("Cin de client :");
		cinLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		cinLBL.setForeground(Color.WHITE);
		cinLBL.setBounds(10, 60, 120, 22);
		cinLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(cinLBL);

		JTextField cintxt = new JTextField("");
		cintxt.setBounds(150, 60, 150, 25);
		cintxt.setBackground(UIManager.getColor("Button.highlight"));
		cintxt.setToolTipText("");
		cintxt.setColumns(10);
		panelajoute.add(cintxt);

		// addresse de client
		Label adresseLBL = new Label("Addresse :");
		adresseLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		adresseLBL.setForeground(Color.WHITE);
		adresseLBL.setBounds(10, 100, 120, 22);
		adresseLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(adresseLBL);

		JTextField adressetxt = new JTextField("");
		adressetxt.setBounds(150, 100, 150, 25);
		adressetxt.setBackground(UIManager.getColor("Button.highlight"));
		adressetxt.setToolTipText("");
		adressetxt.setColumns(10);
		panelajoute.add(adressetxt);

		// permit de client
		Label permitLBL = new Label("permis(temps):");
		permitLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		permitLBL.setForeground(Color.WHITE);
		permitLBL.setBounds(10, 140, 120, 22);
		permitLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(permitLBL);

		JTextField permittxt = new JTextField("");
		permittxt.setBounds(150, 140, 150, 25);
		permittxt.setBackground(UIManager.getColor("Button.highlight"));
		permittxt.setToolTipText("");
		permittxt.setColumns(10);
		panelajoute.add(permittxt);

		// numero de permis de client
		Label n_permisLBL = new Label("N de Permis :");
		n_permisLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		n_permisLBL.setForeground(Color.WHITE);
		n_permisLBL.setBounds(10, 180, 120, 22);
		n_permisLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(n_permisLBL);

		JTextField n_permistxt = new JTextField("");
		n_permistxt.setBounds(150, 180, 150, 25);
		n_permistxt.setBackground(UIManager.getColor("Button.highlight"));
		n_permistxt.setToolTipText("");
		n_permistxt.setColumns(10);
		panelajoute.add(n_permistxt);

		// email de client
		Label EmailLBL = new Label("Email :");
		EmailLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		EmailLBL.setForeground(Color.WHITE);
		EmailLBL.setBounds(10, 220, 120, 22);
		EmailLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(EmailLBL);

		JTextField Emailtxt = new JTextField("");
		Emailtxt.setBounds(150, 220, 150, 25);
		Emailtxt.setBackground(UIManager.getColor("Button.highlight"));
		Emailtxt.setToolTipText("");
		Emailtxt.setColumns(10);
		panelajoute.add(Emailtxt);

		// numero de telephone de client
		Label TelLBL = new Label("N de phone :");
		TelLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		TelLBL.setForeground(Color.WHITE);
		TelLBL.setBounds(10, 260, 120, 22);
		TelLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(TelLBL);

		JTextField Teltxt = new JTextField("");
		Teltxt.setBounds(150, 260, 150, 25);
		Teltxt.setBackground(UIManager.getColor("Button.highlight"));
		Teltxt.setToolTipText("");
		Teltxt.setColumns(10);
		panelajoute.add(Teltxt);

		// button pour ajoute/supprime/update les donnes saisir au DATA
		JButton ajouteToTableau = new JButton();
		ajouteToTableau.setBounds(80, 300, 200, 50);
		ajouteToTableau.setBackground(new Color(47, 79, 79));
		ajouteToTableau.setForeground(Color.white);
		ajouteToTableau.setFont(new Font("Dialog", Font.BOLD, 18));

		if (e.getSource() == ajoute) {
			m.setTitle("ajoute client");
			ajouteToTableau.setText("ajoute");
			panelajoute.add(ajouteToTableau);
			ajouteToTableau.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Ajouter les données du formulaire
					fonctions.ajouteclient(nomcomplettxt.getText(), cintxt.getText(), adressetxt.getText(),
							permittxt.getText(), n_permistxt.getText(), Emailtxt.getText(), Teltxt.getText());
					fonctions.acctualise(model, "clients");

				}
			});
		}

		if (e.getSource() == remove || e.getSource() == modifier) {

			nomcomplettxt.setText(nomcomplet);
			cintxt.setText(cin);
			adressetxt.setText(addresse);
			permittxt.setText(permit);
			n_permistxt.setText(n_permis);
			Emailtxt.setText(email);
			Teltxt.setText(nTel);
			m.setTitle("detalis Client");

			if (e.getSource() == remove) {
				nomcomplettxt.setEditable(false);
				cintxt.setEditable(false);
				adressetxt.setEditable(false);
				permittxt.setEditable(false);
				n_permistxt.setEditable(false);
				Emailtxt.setEditable(false);
				Teltxt.setEditable(false);

				m.setTitle("Supprime client");
				ajouteToTableau.setText("Supprime");
				panelajoute.add(ajouteToTableau);
				ajouteToTableau.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						fonctions.RemoveRow("clients", "CIN", cin);
						fonctions.acctualise(model, "clients");
					}
				});

			}

			if (e.getSource() == modifier) {

				m.setTitle("Modifier");
				ajouteToTableau.setText("Eng les modification");
				panelajoute.add(ajouteToTableau);
				ajouteToTableau.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						fonctions.RemoveRow("clients", "CIN", cin);
						fonctions.ajouteclient(nomcomplettxt.getText(), cintxt.getText(), adressetxt.getText(),
								permittxt.getText(), n_permistxt.getText(), Emailtxt.getText(), Teltxt.getText());
						fonctions.acctualise(model, "clients");

					}
				});
			}
		}
	}

}
