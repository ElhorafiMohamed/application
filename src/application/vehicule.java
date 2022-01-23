package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;

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

public class vehicule extends JPanel implements ActionListener, ListSelectionListener {

	JButton ajoute, modifier, remove;

	String column[] = { "Matricule", "Type", "Marque", "Kilometrage", "disponible", "prixlocation" };
	DefaultTableModel model = new DefaultTableModel(column, 0);
	// Créer la table
	JTable jt = new JTable(model);
	ListSelectionModel listModel = jt.getSelectionModel();

	String Matr, Marq, Module, Kilo, dispon, prix;

	/**
	 * Create the panel.
	 */
	public vehicule() {
		setSize(750, 800);
		setLayout(null);
		setBackground(new Color(0, 128, 128));

		Label txtLBLRes = new Label("LES VEHICULES");
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

		JScrollPane pane = new JScrollPane(jt);

		remove = new JButton("supprime");
		remove.setBounds(310, 600, 140, 50);
		remove.setBackground(new Color(47, 79, 79));
		remove.setForeground(Color.white);
		remove.setFont(new Font("Dialog", Font.BOLD, 18));
		add(remove);

		modifier = new JButton("modifier");
		modifier.setBounds(460, 600, 140, 50);
		modifier.setBackground(new Color(47, 79, 79));
		modifier.setForeground(Color.white);
		modifier.setFont(new Font("Dialog", Font.BOLD, 18));
		add(modifier);

		ajoute = new JButton("ajouter");
		ajoute.setBounds(160, 600, 140, 50);
		ajoute.setBackground(new Color(47, 79, 79));
		ajoute.setForeground(Color.white);
		ajoute.setFont(new Font("Dialog", Font.BOLD, 18));
		add(ajoute);

		panel.add(pane);
		add(panel);

		fonctions.acctualise(model, "vehicule");

		ajoute.addActionListener(this);
		modifier.addActionListener(this);
		remove.addActionListener(this);

//Listener pour tableau 

		listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel.addListSelectionListener(this);

	}

	public void valueChanged(ListSelectionEvent e) {
		int[] sel;

		if (!e.getValueIsAdjusting()) {
			sel = jt.getSelectedRows();
			if (sel.length > 0) {
				TableModel tm = jt.getModel();

				Matr = (String) tm.getValueAt(sel[0], 0);
				Module = (String) tm.getValueAt(sel[0], 1);
				Marq = (String) tm.getValueAt(sel[0], 2);
				Kilo = (String) tm.getValueAt(sel[0], 3);
				dispon = (String) tm.getValueAt(sel[0], 4);
				prix = (String) tm.getValueAt(sel[0], 5);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		JFrame m = new JFrame("Ajoute Vehicule");
		m.setBounds(500, 200, 400, 400);
		// m.setUndecorated(true);
		m.setVisible(true);

		JPanel panelajoute = new JPanel();
		panelajoute.setBackground(new Color(0, 128, 128));
		panelajoute.setBounds(0, 0, 400, 400);
		panelajoute.setLayout(null);
		m.add(panelajoute);

		Label Matricule = new Label("Matricule :");
		Matricule.setFont(new Font("Algerian", Font.BOLD, 14));
		Matricule.setForeground(Color.WHITE);
		Matricule.setBounds(10, 20, 120, 22);
		Matricule.setBackground(new Color(0, 128, 128));
		panelajoute.add(Matricule);

		JTextField txtpMatricule = new JTextField("");
		txtpMatricule.setBounds(150, 20, 150, 25);
		txtpMatricule.setBackground(UIManager.getColor("Button.highlight"));
		txtpMatricule.setToolTipText("");
		txtpMatricule.setColumns(10);
		panelajoute.add(txtpMatricule);

		Label Marque = new Label("Marque :");
		Marque.setFont(new Font("Algerian", Font.BOLD, 14));
		Marque.setForeground(Color.WHITE);
		Marque.setBounds(10, 70, 120, 22);
		Marque.setBackground(new Color(0, 128, 128));
		panelajoute.add(Marque);

		JTextField txtpMarque = new JTextField("");
		txtpMarque.setBounds(150, 70, 150, 25);
		txtpMarque.setBackground(UIManager.getColor("Button.highlight"));
		txtpMarque.setToolTipText("");
		txtpMarque.setColumns(10);
		panelajoute.add(txtpMarque);

		Label module = new Label("Module :");
		module.setFont(new Font("Algerian", Font.BOLD, 14));
		module.setForeground(Color.WHITE);
		module.setBounds(10, 120, 120, 22);
		module.setBackground(new Color(0, 128, 128));
		panelajoute.add(module);

		JTextField txtmodule = new JTextField("");
		txtmodule.setBounds(150, 120, 150, 25);
		txtmodule.setBackground(UIManager.getColor("Button.highlight"));
		txtmodule.setToolTipText("");
		txtmodule.setColumns(10);
		panelajoute.add(txtmodule);

		Label Kilometrage = new Label("Kilometrage :");
		Kilometrage.setFont(new Font("Algerian", Font.BOLD, 14));
		Kilometrage.setForeground(Color.WHITE);
		Kilometrage.setBounds(10, 170, 120, 22);
		Kilometrage.setBackground(new Color(0, 128, 128));
		panelajoute.add(Kilometrage);

		JTextField txtpKilometrage = new JTextField("");
		txtpKilometrage.setBounds(150, 170, 150, 25);
		txtpKilometrage.setBackground(UIManager.getColor("Button.highlight"));
		txtpKilometrage.setToolTipText("");
		txtpKilometrage.setColumns(10);
		panelajoute.add(txtpKilometrage);

		Label disponible = new Label("disponible :");
		disponible.setFont(new Font("Algerian", Font.BOLD, 14));
		disponible.setForeground(Color.WHITE);
		disponible.setBounds(10, 220, 120, 22);
		disponible.setBackground(new Color(0, 128, 128));
		panelajoute.add(disponible);

		JTextField txtpdisponible = new JTextField("");
		txtpdisponible.setBounds(150, 220, 150, 25);
		txtpdisponible.setBackground(UIManager.getColor("Button.highlight"));
		txtpdisponible.setToolTipText("");
		txtpdisponible.setColumns(10);
		panelajoute.add(txtpdisponible);

		Label PrixdeLocattion = new Label("Prix location :");
		PrixdeLocattion.setFont(new Font("Algerian", Font.BOLD, 14));
		PrixdeLocattion.setForeground(Color.WHITE);
		PrixdeLocattion.setBounds(10, 270, 120, 22);
		PrixdeLocattion.setBackground(new Color(0, 128, 128));
		panelajoute.add(PrixdeLocattion);

		JTextField txtprixLocation = new JTextField("");
		txtprixLocation.setBounds(150, 270, 150, 25);
		txtprixLocation.setBackground(UIManager.getColor("Button.highlight"));
		txtprixLocation.setToolTipText("");
		txtprixLocation.setColumns(10);
		panelajoute.add(txtprixLocation);

		JButton ajouteToTableau = new JButton();
		ajouteToTableau.setBounds(80, 300, 200, 50);
		ajouteToTableau.setBackground(new Color(47, 79, 79));
		ajouteToTableau.setForeground(Color.white);
		ajouteToTableau.setFont(new Font("Dialog", Font.BOLD, 18));

		// Ajoute les donnes dans une tableau
		if (e.getSource() == ajoute) {
			m.setTitle("AJOUTER VEHICULE");
			ajouteToTableau.setText("ajoute vehicule");
			panelajoute.add(ajouteToTableau);
			ajouteToTableau.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Ajouter les données du formulaire
					fonctions.ajouteveh("vehicule", txtpMatricule.getText(), txtpMarque.getText(), txtmodule.getText(),
							txtpKilometrage.getText(), txtpdisponible.getText(), txtprixLocation.getText());

					fonctions.acctualise(model, "vehicule");
				}

			});
		}

		if (e.getSource() == modifier || e.getSource() == remove) {
			txtpMatricule.setText(Matr);
			txtmodule.setText(Module);
			txtpMarque.setText(Marq);
			txtpKilometrage.setText(Kilo);
			txtpdisponible.setText(dispon);
			txtprixLocation.setText(prix);
			m.setTitle("detalis Reservation");

			// Supprime les donnes dans une tableau
			if (e.getSource() == remove) {
				txtpMatricule.setEditable(false);
				txtmodule.setEditable(false);
				txtpMarque.setEditable(false);
				txtpKilometrage.setEditable(false);
				txtpdisponible.setEditable(false);
				txtprixLocation.setEditable(false);

				m.setTitle("Supprime Vehicule");
				ajouteToTableau.setText("SUPPRIMER");
				panelajoute.add(ajouteToTableau);
				ajouteToTableau.setText("Supprime LE VIHECULE");
				panelajoute.add(ajouteToTableau);
				ajouteToTableau.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						fonctions.RemoveRow("vehicule", "Matricule", Matr);
						fonctions.acctualise(model, "vehicule");
					}
				});

			}
		}

		// modification les donnes dans une tableau
		if (e.getSource() == modifier) {
			m.setTitle("Modifier Vehicule");
			panelajoute.add(ajouteToTableau);
			ajouteToTableau.setText("Eng les modifications");
			ajouteToTableau.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					fonctions.RemoveRow("vehicule", "Matricule", Matr);

					fonctions.ajouteveh("vehicule", txtpMatricule.getText(), txtpMarque.getText(), txtmodule.getText(),
							txtpKilometrage.getText(), txtpdisponible.getText(), txtprixLocation.getText());

					fonctions.acctualise(model, "vehicule");

				}
			});
		}
	}
}
