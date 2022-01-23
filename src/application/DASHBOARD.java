package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Panel pour le DASHBOARD
public class DASHBOARD extends JPanel {

	JPanel panelTableau, panelDeconnextion, panelCompte, panelReserve, panelcontrat, panelVehicuel, panelCLIENT;

	/**
	 * Create the panel.
	 */
	public DASHBOARD() {
		setSize(750, 800);
		setLayout(null);
		setBackground(new Color(0, 128, 128));

		Label txtLBLRes = new Label("ACCUEIL");
		txtLBLRes.setBounds(0, 0, 750, 40);
		txtLBLRes.setBackground(new Color(47, 79, 79));
		txtLBLRes.setForeground(Color.white);
		txtLBLRes.setAlignment(Label.CENTER);
		txtLBLRes.setFont(new Font("Dialog", Font.BOLD, 30));
		add(txtLBLRes);

		// menu
		Image IconLOGO = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/logolahihsan.png").getImage()
				.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		Image IconDASHBOARD = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/tableau-de-bord.png")
				.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		Image IconClient = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/homme.png").getImage()
				.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		Image IconVeh = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/auto.png").getImage()
				.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		Image IconContrat = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/deposer.png").getImage()
				.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		Image IconReservation = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/calendrier.png").getImage()
				.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		Image IconMonCompte = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/ordinateur-de-bureau.png")
				.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);

		// menu LOGO
		JPanel panelLOGO = new JPanel();
		panelLOGO.setLayout(null);
		panelLOGO.setBackground(new Color(0, 128, 128));
		panelLOGO.setBounds(150, 0, 400, 300);

		JLabel lblLOGO = new JLabel();
		lblLOGO.setIcon(new ImageIcon(IconLOGO));
		lblLOGO.setBounds(-1, 0, 400, 400);
		panelLOGO.add(lblLOGO);
		add(panelLOGO);

		// les Panel pour l Menu Tableau de board

		panelTableau = new JPanel();
		panelTableau.setBounds(0, 300, 250, 250);
		panelTableau.setLayout(null);
		panelTableau.setBackground(new Color(0, 128, 128));
		add(panelTableau);

		JLabel tblLBL = new JLabel();
		tblLBL.setBounds(25, 0, 200, 200);
		tblLBL.setIcon(new ImageIcon(IconDASHBOARD));
		panelTableau.add(tblLBL);

		JLabel txtLBLacc = new JLabel();
		txtLBLacc.setBounds(60, 200, 250, 50);
		txtLBLacc.setText("ACCEUIL");
		txtLBLacc.setForeground(Color.WHITE);
		txtLBLacc.setFont(new Font("Dialog", Font.BOLD, 18));
		panelTableau.add(txtLBLacc);

		// les Panel pour l Menu Client

		panelCLIENT = new JPanel();
		panelCLIENT.setBounds(250, 300, 250, 250);
		panelCLIENT.setLayout(null);
		panelCLIENT.setBackground(new Color(0, 128, 128));
		add(panelCLIENT);

		JLabel clientLBL = new JLabel();
		clientLBL.setBounds(25, 0, 200, 200);
		clientLBL.setIcon(new ImageIcon(IconClient));
		panelCLIENT.add(clientLBL);

		JLabel txtLBLClient = new JLabel();
		txtLBLClient.setBounds(70, 200, 250, 50);
		txtLBLClient.setText("CLIENT");
		txtLBLClient.setForeground(Color.WHITE);
		txtLBLClient.setFont(new Font("Dialog", Font.BOLD, 18));
		panelCLIENT.add(txtLBLClient);

		// les Panel pour l Menu Vehicuel

		panelVehicuel = new JPanel();
		panelVehicuel.setBounds(500, 300, 250, 250);
		panelVehicuel.setLayout(null);
		panelVehicuel.setBackground(new Color(0, 128, 128));
		add(panelVehicuel);

		JLabel VEHLBL = new JLabel();
		VEHLBL.setBounds(25, 0, 200, 200);
		VEHLBL.setIcon(new ImageIcon(IconVeh));
		panelVehicuel.add(VEHLBL);

		JLabel txtLBLVEH = new JLabel();
		txtLBLVEH.setBounds(70, 200, 250, 50);
		txtLBLVEH.setText("VEHICULE");
		txtLBLVEH.setForeground(Color.WHITE);
		txtLBLVEH.setFont(new Font("Dialog", Font.BOLD, 18));
		panelVehicuel.add(txtLBLVEH);

		// les Panel pour l Menu Contrats

		panelcontrat = new JPanel();
		panelcontrat.setBounds(0, 550, 250, 250);
		panelcontrat.setLayout(null);
		panelcontrat.setBackground(new Color(0, 128, 128));
		add(panelcontrat);

		JLabel CONTRATLBL = new JLabel();
		CONTRATLBL.setBounds(25, 0, 200, 200);
		CONTRATLBL.setIcon(new ImageIcon(IconContrat));
		panelcontrat.add(CONTRATLBL);

		JLabel txtLBLContrat = new JLabel();
		txtLBLContrat.setBounds(60, 200, 250, 50);
		txtLBLContrat.setText("CONTRATS");
		txtLBLContrat.setForeground(Color.WHITE);
		txtLBLContrat.setFont(new Font("Dialog", Font.BOLD, 18));
		panelcontrat.add(txtLBLContrat);

		// les Panel pour l Menu reserve

		panelReserve = new JPanel();
		panelReserve.setBounds(250, 550, 250, 250);
		panelReserve.setLayout(null);
		panelReserve.setBackground(new Color(0, 128, 128));
		add(panelReserve);

		JLabel ResLBL = new JLabel();
		ResLBL.setBounds(25, 0, 200, 200);
		ResLBL.setIcon(new ImageIcon(IconReservation));
		panelReserve.add(ResLBL);

		JLabel txtLBLRese = new JLabel();
		txtLBLRese.setBounds(50, 200, 250, 50);
		txtLBLRese.setText("RESERVATION");
		txtLBLRese.setForeground(Color.WHITE);
		txtLBLRese.setFont(new Font("Dialog", Font.BOLD, 18));
		panelReserve.add(txtLBLRese);

		// les Panel pour l Menu MonCompte

		panelCompte = new JPanel();
		panelCompte.setBounds(500, 550, 250, 250);
		panelCompte.setLayout(null);
		panelCompte.setBackground(new Color(0, 128, 128));
		add(panelCompte);

		JLabel ComLBL = new JLabel();
		ComLBL.setBounds(25, 0, 200, 200);
		ComLBL.setIcon(new ImageIcon(IconMonCompte));
		panelCompte.add(ComLBL);

		JLabel txtLBLCom = new JLabel();
		txtLBLCom.setBounds(50, 200, 250, 50);
		txtLBLCom.setText("MON COMPTE");
		txtLBLCom.setForeground(Color.WHITE);
		txtLBLCom.setFont(new Font("Dialog", Font.BOLD, 18));
		panelCompte.add(txtLBLCom);

	}

}
