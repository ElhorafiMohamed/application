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

public class Contrat extends JPanel implements ActionListener, ListSelectionListener {

	JButton ajoute, remove, modifier;
	String column[] = { "N_de_Contrat", "N_reservation", "Cin_Client", "Matricule", "Date_Contrat", "NbrJour",
			"prixVehicule", "Montant", "reste" };
	DefaultTableModel model = new DefaultTableModel(column, 0);
	// Créer la table
	JTable jt = new JTable(model);
	ListSelectionModel listModel = jt.getSelectionModel();

	String N_de_Contrat, N_reservation, Cin_Client, Matricule, Date_Contrat, NbrJour, prixVehicule, Montant, reste;

	/**
	 * Create the panel.
	 */
	public Contrat() {
		setSize(750, 800);
		setLayout(null);
		setBackground(new Color(0, 128, 128));

		Label txtLBLRes = new Label("LES CONTRATS");
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

		fonctions.acctualise(model, "contrat");

		ajoute.addActionListener(this);
		modifier.addActionListener(this);
		remove.addActionListener(this);

//Listener pour tableau 

		listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel.addListSelectionListener(this);

	}

	// N_de_Contrat, N_reservation, Cin_Client, Matricule, Date_Contrat, NbrJour,
	// prixVehicule, Montant;
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int[] sel;

		if (!e.getValueIsAdjusting()) {
			sel = jt.getSelectedRows();
			if (sel.length > 0) {
				TableModel tm = jt.getModel();

				N_de_Contrat = (String) tm.getValueAt(sel[0], 0);
				N_reservation = (String) tm.getValueAt(sel[0], 1);
				Cin_Client = (String) tm.getValueAt(sel[0], 2);
				Matricule = (String) tm.getValueAt(sel[0], 3);
				Date_Contrat = (String) tm.getValueAt(sel[0], 4);
				NbrJour = (String) tm.getValueAt(sel[0], 5);
				prixVehicule = (String) tm.getValueAt(sel[0], 6);
				Montant = (String) tm.getValueAt(sel[0], 7);
				reste = (String) tm.getValueAt(sel[0], 8);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		JFrame m = new JFrame();
		m.setBounds(500, 200, 400, 400);
		// m.setUndecorated(true);
		m.setVisible(true);

		JPanel panelajoute = new JPanel();
		panelajoute.setBackground(new Color(0, 128, 128));
		panelajoute.setBounds(0, 0, 400, 400);
		panelajoute.setLayout(null);
		m.add(panelajoute);
		// ,"Date Contrat","Date d'echeance","N reservation","Matricule","CIN"

		Label NcontratLBL = new Label("N Contrat :");
		NcontratLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		NcontratLBL.setForeground(Color.WHITE);
		NcontratLBL.setBounds(10, 20, 120, 22);
		NcontratLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(NcontratLBL);

		JTextField NcontratTXT = new JTextField("");
		NcontratTXT.setBounds(170, 20, 150, 25);
		NcontratTXT.setBackground(UIManager.getColor("Button.highlight"));
		NcontratTXT.setToolTipText("");
		NcontratTXT.setColumns(10);
		panelajoute.add(NcontratTXT);

		Label NReservationLBL = new Label("N Reservation :");
		NReservationLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		NReservationLBL.setForeground(Color.WHITE);
		NReservationLBL.setBounds(10, 70, 120, 22);
		NReservationLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(NReservationLBL);

		JTextField NReservationTXT = new JTextField("");
		NReservationTXT.setBounds(170, 70, 150, 25);
		NReservationTXT.setBackground(UIManager.getColor("Button.highlight"));
		NReservationTXT.setToolTipText("");
		NReservationTXT.setColumns(10);
		panelajoute.add(NReservationTXT);
		//

		Label DateCont = new Label("Date de Contrat :");
		DateCont.setFont(new Font("Algerian", Font.BOLD, 14));
		DateCont.setForeground(Color.WHITE);
		DateCont.setBounds(10, 120, 120, 22);
		DateCont.setBackground(new Color(0, 128, 128));
		panelajoute.add(DateCont);

		JTextField txtpDTCont = new JTextField("");
		txtpDTCont.setBounds(170, 120, 150, 25);
		txtpDTCont.setBackground(UIManager.getColor("Button.highlight"));
		txtpDTCont.setToolTipText("");
		txtpDTCont.setColumns(10);
		panelajoute.add(txtpDTCont);

		//
		//

		JButton ajouteToTableau = new JButton();
		ajouteToTableau.setBounds(80, 300, 200, 50);
		ajouteToTableau.setBackground(new Color(47, 79, 79));
		ajouteToTableau.setForeground(Color.white);
		ajouteToTableau.setFont(new Font("Dialog", Font.BOLD, 18));

		if (e.getSource() == ajoute) {
			m.setTitle("AJOUTER ");
			ajouteToTableau.setText("AJOUTE ");
			panelajoute.add(ajouteToTableau);
			ajouteToTableau.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Ajouter les données du formulaire
					fonctions.ajouteContrat(NcontratTXT.getText(), txtpDTCont.getText(), NReservationTXT.getText());

					fonctions.acctualise(model, "contrat");

				}
			});
		}

		if (e.getSource() == remove || e.getSource() == modifier) {
			NcontratTXT.setText(N_de_Contrat);
			txtpDTCont.setText(Date_Contrat);
			NReservationTXT.setText(N_reservation);
			NcontratTXT.setEditable(false);

			if (e.getSource() == remove) {
				txtpDTCont.setEditable(false);
				NReservationTXT.setEditable(false);

				m.setTitle("Supprime");
				ajouteToTableau.setText("SUPPRIMER");
				panelajoute.add(ajouteToTableau);
				ajouteToTableau.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						fonctions.RemoveRow("contrat", "N_de_Contrat", N_de_Contrat);
						fonctions.acctualise(model, "contrat");
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
						m.setTitle("modifier Contrat");
						fonctions.RemoveRow("contrat", "N_de_Contrat", N_de_Contrat);
						fonctions.ajouteContrat(NcontratTXT.getText(), txtpDTCont.getText(), NReservationTXT.getText());
						fonctions.acctualise(model, "contrat");

					}
				});
			}

		}
	}

}
