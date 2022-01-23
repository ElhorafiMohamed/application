package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class fonctions {

	public static void acctualise(DefaultTableModel model, String NameTableau)

	{
		try {

			model.setRowCount(0);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");

			String query = "SELECT * FROM " + NameTableau;

			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery(query);

			if (NameTableau == "clients") {
				while (res.next()) {

					model.addRow(new Object[] { res.getString(1), res.getString(2), res.getString(3), res.getString(4),
							res.getString(5), res.getString(6), res.getString(7) });
				}
			}

			else if (NameTableau == "vehicule") {
				while (res.next()) {

					model.addRow(new Object[] { res.getString(1), res.getString(2), res.getString(3), res.getString(4),
							res.getString(5), res.getString(6) });
				}
			}

			else if (NameTableau == "reservation" || NameTableau == "contrat") {
				while (res.next()) {

					model.addRow(new Object[] { res.getString(1), res.getString(2), res.getString(3), res.getString(4),
							res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9) });
				}
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String acctualiseMonCompte(int n)

	{
		String x = null, x1 = null, x2 = null, x3 = null, x4 = null, x5 = null, x6 = null, x7 = null, x8 = null;
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");

			String query = "SELECT * FROM user";

			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery(query);

			while (res.next()) {
				x1 = res.getString(2);
				x2 = res.getString(3);
				x3 = res.getString(4);
				x4 = res.getString(5);
				x5 = res.getString(6);
				x6 = res.getString(7);
				x7 = res.getString(8);
				x8 = res.getString(9);

			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (n == 1) {
			x = x1;
		}
		if (n == 2) {
			x = x2;
		}
		if (n == 3) {
			x = x3;
		}
		if (n == 4) {
			x = x4;
		}
		if (n == 5) {
			x = x5;
		}
		if (n == 6) {
			x = x6;
		}
		if (n == 7) {
			x = x7;
		}
		if (n == 8) {
			x = x8;
		}
		return x;
	}

	public static void ajouteveh(String NameTableau, String x1, String x2, String x3, String x4, String x5, String x6) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// database is my_tutorial, userid =root, password //
			// Update your usrid, passwoffrd and database name //
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");
			Statement st = con.createStatement();

			String query = "INSERT INTO " + NameTableau + " values('" + x1 + "','" + x2 + "','" + x3 + "','" + x4
					+ "','" + x5 + "','" + x6 + "')";
			st.executeUpdate(query); // record added.

			con.close();

		} catch (Exception exception) {

			JOptionPane.showMessageDialog(Interface.frame, "Ecrire les donnes d'un maniere clair.", "Alert",
					JOptionPane.WARNING_MESSAGE);

		}
	}

	public static void ajouteclient(String x1, String x2, String x3, String x4, String x5, String x6, String x7) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// database is my_tutorial, userid =root, password //
			// Update your usrid, passwoffrd and database name //
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");
			Statement st = con.createStatement();

			String query = "INSERT INTO clients values('" + x1 + "','" + x2 + "','" + x3 + "','" + x4 + "','" + x5
					+ "','" + x6 + "','" + x7 + "')";
			st.executeUpdate(query); // record added.

			con.close();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void ModifierDetailsDeUser(String x1, char[] x8, String x2, String x3, String x4, String x5,
			String x6, String x7) {
		try {
			RemoveRow("user", "ID", "1");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// database is my_tutorial, userid =root, password //
			// Update your usrid, passwoffrd and database name //
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");
			Statement st = con.createStatement();
			String psw = String.valueOf(x8);

			String query = "INSERT INTO user values('" + '1' + "','" + x1 + "','" + psw + "','" + x2 + "','" + x3
					+ "','" + x4 + "','" + x5 + "','" + x6 + "','" + x7 + "')";
			st.executeUpdate(query); // record added.

			con.close();
			new Deconn();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void ajouteContrat(String Ncontrat, String DateContrat, String N_rese) {
		int nbrjour = 0, prixVehicule = 0, Montant = 0, Reste = 0;
		String cin = null, matricule = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// database is my_tutorial, userid =root, password //
			// Update your usrid, passwoffrd and database name //
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");
			Statement st = con.createStatement();

			String query = "SELECT * FROM reservation WHERE N_reservation=" + "'" + N_rese + "'" + ";";
			ResultSet res = st.executeQuery(query);

			// pour select in tableau
			while (res.next()) {
				cin = res.getString(2);
				matricule = res.getString(3);
				nbrjour = res.getInt("NbrDeJour");
				prixVehicule = res.getInt("Avance");
				Montant = res.getInt("Montant");
				Reste = res.getInt("Reste");

			}

			String queryAjoute = "INSERT INTO contrat values('" + Ncontrat + "','" + N_rese + "','" + cin + "','"
					+ matricule + "','" + DateContrat + "','" + nbrjour + "','" + prixVehicule + "','" + Montant + "','"
					+ Reste + "')";
			st.executeUpdate(queryAjoute); // record added.

			// pour update la disponsibilite de voiture
			// UPDATE Users SET weight = 160, desiredWeight = 145 WHERE id = 1;
			String queryDispo = "UPDATE vehicule SET Disponibilite='Non' WHERE Matricule=" + "'" + matricule + "'"
					+ ";";
			st.executeUpdate(queryDispo);

			con.close();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

//methode de reservation
//ajouter reservation
	public static void ajouteReservation(String x1, String x2, String x3, String x4, String x5, String x6, String x7,
			String x8, String x9) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// database is my_tutorial, userid =root, password //
			// Update your usrid, passwoffrd and database name //
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");
			Statement st = con.createStatement();

			String query = "INSERT INTO reservation values('" + x1 + "','" + x2 + "','" + x3 + "','" + x4 + "','" + x5
					+ "','" + x6 + "','" + x7 + "','" + x8 + "','" + x9 + "')";
			st.executeUpdate(query); // record added.

			con.close();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static String Montant(String n, String matricule) {
		int prix = 0;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");
			Statement st = con.createStatement();
			ResultSet rs;
			String query = "SELECT prix_location FROM vehicule WHERE Matricule=" + "'" + matricule + "'" + ";";
			rs = st.executeQuery(query);
			while (rs.next()) {
				prix = rs.getInt("prix_location");
			}

			con.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
		}
		String x = "" + prix * Integer.parseInt(n);
		return x;
	}

	public static String Reste(String total, String avance) {
		int x = Integer.parseInt(total) - Integer.parseInt(avance);
		String Reste = "" + x;
		return Reste;
	}

	public static void RemoveRow(String NameTableau, String KeyColumn, String Matr) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// database is my_tutorial, userid =root, password //
			// Update your usrid, password and database name //
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");
			Statement st = con.createStatement();

			String query = "DELETE FROM " + NameTableau + " WHERE " + KeyColumn + " =" + "'" + Matr + "'" + ";";

			st.executeUpdate(query); // record added.

			con.close();

		} catch (Exception v) {

		}
	}

//reset your password 
	public static void resetpwd() {
		int input = JOptionPane.showConfirmDialog(null, "Change Password?");
		if (input == 0) {
			user.frame.dispose();
			// Confirmation
			JFrame fr = new JFrame("Confirmation de change le PassWrd");
			;
			fr.setBounds(120, 120, 400, 364);

			// nom
			JLabel nomlBl = new JLabel();
			nomlBl.setBounds(50, 50, 210, 20);
			nomlBl.setText("Ecrire ton nom ?");
			fr.add(nomlBl);

			JTextField nomtXt = new JTextField();
			nomtXt.setBounds(50, 70, 210, 20);
			fr.add(nomtXt);

			// prenom
			JLabel prenomlBl = new JLabel();
			prenomlBl.setBounds(50, 100, 210, 20);
			prenomlBl.setText("Ecrire ton prenom ?");
			fr.add(prenomlBl);

			JTextField prenomtXt = new JTextField();
			prenomtXt.setBounds(50, 120, 210, 20);
			fr.add(prenomtXt);

			// prenom
			JLabel numerolBl = new JLabel();
			numerolBl.setBounds(50, 150, 210, 20);
			numerolBl.setText("Ecrire ton numero ?");
			fr.add(numerolBl);

			JTextField numerotXt = new JTextField();
			numerotXt.setBounds(50, 170, 210, 20);
			fr.add(numerotXt);

			// button donne l'acces a les donnee
			Label ButtonClose = new Label("CHANGE MOT DE PASSE");
			ButtonClose.setFont(new Font("Algerian", Font.BOLD, 14));
			ButtonClose.setForeground(UIManager.getColor("Button.highlight"));
			ButtonClose.setBackground(Color.black);
			ButtonClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (acctualiseMonCompte(3).equals(nomtXt.getText())
							&& acctualiseMonCompte(4).equals(prenomtXt.getText())
							&& acctualiseMonCompte(6).equals(numerotXt.getText())) {
						fr.dispose();
						new Interface();
					} else {
						JOptionPane.showMessageDialog(fr, "les Donnes  est inconnu.", "Alert",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			ButtonClose.setBounds(60, 220, 170, 30);
			fr.getContentPane().add(ButtonClose);

			fr.setLayout(null);
			fr.setVisible(true);

		}
	}

}