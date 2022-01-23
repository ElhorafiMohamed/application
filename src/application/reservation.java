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

public class reservation extends JPanel implements ActionListener, ListSelectionListener {

	JButton ajoute, remove, modifier;

	String column[] = { "N_Reserv", "CIN", "Matricule", "DateReser", "DateDepart","NbrJour","Montant","Avance","Reste" };
	DefaultTableModel model = new DefaultTableModel(column, 0);
	// Créer la table
	JTable jt = new JTable(model);
	ListSelectionModel listModel = jt.getSelectionModel();

	String N_reserva, cin, matri, dateRes, dateDep,nbrjour,avance;

	/**
	 * Create the panel.
	 */
	public reservation() {
		setSize(750, 800);
		setLayout(null);
		setBackground(new Color(0, 128, 128));

		Label txtLBLRes = new Label("LES RESERVATION");
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

		remove = new JButton("Supprime");
		remove.setBounds(310, 600, 140, 50);
		remove.setBackground(new Color(47, 79, 79));
		remove.setForeground(Color.white);
		remove.setFont(new Font("Dialog", Font.BOLD, 18));
		add(remove);

		modifier = new JButton("Modifier");
		modifier.setBounds(460, 600, 140, 50);
		modifier.setBackground(new Color(47, 79, 79));
		modifier.setForeground(Color.white);
		modifier.setFont(new Font("Dialog", Font.BOLD, 18));
		add(modifier);

		ajoute = new JButton("Ajouter");
		ajoute.setBounds(160, 600, 140, 50);
		ajoute.setBackground(new Color(47, 79, 79));
		ajoute.setForeground(Color.white);
		ajoute.setFont(new Font("Dialog", Font.BOLD, 18));
		add(ajoute);

		panel.add(pane);
		add(panel);

		fonctions.acctualise(model, "reservation");

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
				// id,cin, matri, dateRes, dateDep, Monta, Rest;
				N_reserva = (String) tm.getValueAt(sel[0], 0);
				cin = (String) tm.getValueAt(sel[0], 1);
				matri = (String) tm.getValueAt(sel[0], 2);
				dateRes = (String) tm.getValueAt(sel[0], 3);
				dateDep = (String) tm.getValueAt(sel[0], 4);
				nbrjour=(String) tm.getValueAt(sel[0], 5);
				avance=(String) tm.getValueAt(sel[0], 7);
				
			}
		}
	}

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

		// Numero de reservation
		Label N_ReservationLBL = new Label("Num de Res :");
		N_ReservationLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		N_ReservationLBL.setForeground(Color.WHITE);
		N_ReservationLBL.setBounds(10, 20, 120, 22);
		N_ReservationLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(N_ReservationLBL);

		JTextField N_ReservationTxt = new JTextField("");
		N_ReservationTxt.setBounds(150, 20, 150, 25);
		N_ReservationTxt.setBackground(UIManager.getColor("Button.highlight"));
		N_ReservationTxt.setToolTipText("");
		N_ReservationTxt.setColumns(10);
		panelajoute.add(N_ReservationTxt);

		// CIN de client
		Label cinLBL = new Label("CIN de client :");
		cinLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		cinLBL.setForeground(Color.WHITE);
		cinLBL.setBounds(10, 60, 120, 22);
		cinLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(cinLBL);

		JTextField cinTxt = new JTextField("");
		cinTxt.setBounds(150, 60, 150, 25);
		cinTxt.setBackground(UIManager.getColor("Button.highlight"));
		cinTxt.setToolTipText("");
		cinTxt.setColumns(10);
		panelajoute.add(cinTxt);

		// Marticule de vehicule
		Label MarticuleLBL = new Label("Matricule veh :");
		MarticuleLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		MarticuleLBL.setForeground(Color.WHITE);
		MarticuleLBL.setBounds(10, 100, 120, 22);
		MarticuleLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(MarticuleLBL);

		JTextField MarticuleTxt = new JTextField("");
		MarticuleTxt.setBounds(150, 100, 150, 25);
		MarticuleTxt.setBackground(UIManager.getColor("Button.highlight"));
		MarticuleTxt.setToolTipText("");
		MarticuleTxt.setColumns(10);
		panelajoute.add(MarticuleTxt);

		// Date de reservation
		Label DateReservationLBL = new Label("Date Reservation:");
		DateReservationLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		DateReservationLBL.setForeground(Color.WHITE);
		DateReservationLBL.setBounds(10, 140, 120, 22);
		DateReservationLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(DateReservationLBL);

		JTextField DateReservationTXT = new JTextField("jour/mois/annee");
		DateReservationTXT.setBounds(150, 140, 150, 25);
		DateReservationTXT.setBackground(UIManager.getColor("Button.highlight"));
		DateReservationTXT.setToolTipText("");
		DateReservationTXT.setColumns(10);
		panelajoute.add(DateReservationTXT);

		// Date de Depart
		Label DateDepartLBL = new Label("Date Depart:");
		DateDepartLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		DateDepartLBL.setForeground(Color.WHITE);
		DateDepartLBL.setBounds(10, 180, 120, 22);
		DateDepartLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(DateDepartLBL);

		JTextField DateDepartTXT = new JTextField("jour/mois/annee");
		DateDepartTXT.setBounds(150, 180, 150, 25);
		DateDepartTXT.setBackground(UIManager.getColor("Button.highlight"));
		DateDepartTXT.setToolTipText("");
		DateDepartTXT.setColumns(10);
		panelajoute.add(DateDepartTXT);

		// Nombre des JOUR
		Label NbrJourLBL = new Label("Nbr Jours :");
		NbrJourLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		NbrJourLBL.setForeground(Color.WHITE);
		NbrJourLBL.setBounds(10, 220, 120, 22);
		NbrJourLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(NbrJourLBL);

		JTextField NbrJourTXT = new JTextField("");
		NbrJourTXT.setBounds(150, 220, 150, 25);
		NbrJourTXT.setBackground(UIManager.getColor("Button.highlight"));
		NbrJourTXT.setToolTipText("");
		NbrJourTXT.setColumns(10);
		panelajoute.add(NbrJourTXT);

		// Nombre des JOUR
		Label AvanceLBL = new Label("l'avance :");
		AvanceLBL.setFont(new Font("Algerian", Font.BOLD, 14));
		AvanceLBL.setForeground(Color.WHITE);
		AvanceLBL.setBounds(10, 260, 120, 22);
		AvanceLBL.setBackground(new Color(0, 128, 128));
		panelajoute.add(AvanceLBL);

		JTextField AvanceTXT = new JTextField("");
		AvanceTXT.setBounds(150, 260, 150, 25);
		AvanceTXT.setBackground(UIManager.getColor("Button.highlight"));
		AvanceTXT.setToolTipText("");
		AvanceTXT.setColumns(10);
		panelajoute.add(AvanceTXT);

		// button pour ajoute/supprime/update les donnes saisir au DATA
		JButton ajouteToTableau = new JButton();
		ajouteToTableau.setBounds(80, 300, 200, 50);
		ajouteToTableau.setBackground(new Color(47, 79, 79));
		ajouteToTableau.setForeground(Color.white);
		ajouteToTableau.setFont(new Font("Dialog", Font.BOLD, 18));

		if (e.getSource() == ajoute) {

			m.setTitle("Ajouter Reservation");
			ajouteToTableau.setText("Ajouter");
			panelajoute.add(ajouteToTableau);
			ajouteToTableau.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Ajouter les données du formulaire

					fonctions.ajouteReservation(N_ReservationTxt.getText(), cinTxt.getText(),
							MarticuleTxt.getText(), DateReservationTXT.getText(), DateDepartTXT.getText(),
							NbrJourTXT.getText(), fonctions.Montant(NbrJourTXT.getText(),MarticuleTxt.getText()), AvanceTXT.getText(),
							fonctions.Reste(fonctions.Montant(NbrJourTXT.getText(),MarticuleTxt.getText()),AvanceTXT.getText()));
						fonctions.acctualise(model, "reservation");

				}
			});
		}
		if (e.getSource() == remove || e.getSource() == modifier) {
			// id,cin, matri, dateRes, dateDep, Monta, Rest;
			N_ReservationTxt.setText(N_reserva);
			cinTxt.setText(cin);
			MarticuleTxt.setText(matri);
			DateReservationTXT.setText(dateRes);
			DateDepartTXT.setText(dateDep);
			NbrJourTXT.setText(nbrjour);
			AvanceTXT.setText(avance);
			m.setTitle("detalis Client");

			

			if (e.getSource() == remove) {
				
				N_ReservationTxt.setEditable(false);
				cinTxt.setEditable(false);
				MarticuleTxt.setEditable(false);
				DateReservationTXT.setEditable(false);
				DateDepartTXT.setEditable(false);
				NbrJourTXT.setEditable(false);
				AvanceTXT.setEditable(false);
				
				m.setTitle("Supprime Reservation");
				ajouteToTableau.setText("Supprime");
				panelajoute.add(ajouteToTableau);
				ajouteToTableau.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						fonctions.RemoveRow("reservation", "N_reservation", N_reserva);
						fonctions.acctualise(model, "reservation");
					}
				});

			}
		}
		if (e.getSource() == modifier) {

			m.setTitle("modifier Reservation");
			ajouteToTableau.setText("modifier");
			panelajoute.add(ajouteToTableau);
			ajouteToTableau.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					fonctions.RemoveRow("reservation", "N_reservation", N_reserva);
					fonctions.ajouteReservation(N_ReservationTxt.getText(), cinTxt.getText(),
							MarticuleTxt.getText(), DateReservationTXT.getText(), DateDepartTXT.getText(),
							NbrJourTXT.getText(), fonctions.Montant(NbrJourTXT.getText(),MarticuleTxt.getText()), AvanceTXT.getText(),
							fonctions.Reste(fonctions.Montant(NbrJourTXT.getText(),MarticuleTxt.getText()),AvanceTXT.getText()));
					fonctions.acctualise(model, "reservation");
				}
			});

		}
	}

}
