package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface implements MouseListener {

	public static JFrame frame;
	public static JPanel panelAFF;

	// declaration les buttons
	JPanel panelTableau, panelDeconnextion, panelCompte, panelReserve, panelcontrat, panelVehicuel, panelCLIENT;
	Image IconLOGO = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/logolahihsan.png").getImage()
			.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	Image IconDASHBOARD = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/tableau-de-bord.png").getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	Image IconClient = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/homme.png").getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	Image IconVeh = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/auto.png").getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	Image IconContrat = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/deposer.png").getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	Image IconReservation = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/calendrier.png").getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	Image IconMonCompte = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/ordinateur-de-bureau.png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	Image IconDeconnection = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/deconnexion.png").getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

	// declaration des pane
	static reservation reserve;
	static Contrat cont;
	static DASHBOARD dashboard;
	static lesClient client;
	static MonCompte moncompte;
	static vehicule Veh;

	Interface() {

		// les panle pour chaque button
		reserve = new reservation();
		cont = new Contrat();
		dashboard = new DASHBOARD();
		client = new lesClient();
		moncompte = new MonCompte();
		Veh = new vehicule();

		frame = new JFrame();
		frame.setBounds(200, 20, 1000, 800);
		frame.setUndecorated(true);

		panelAFF = new JPanel();
		panelAFF.setBackground(new Color(0, 128, 128));
		panelAFF.setBounds(250, 0, 750, 800);
		panelAFF.setLayout(null);
		frame.add(panelAFF);

		Label ButtonClose = new Label("X");
		ButtonClose.setFont(new Font("Algerian", Font.BOLD, 14));
		ButtonClose.setForeground(Color.WHITE);
		ButtonClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		ButtonClose.setBounds(730, 0, 62, 22);
		ButtonClose.setBackground(new Color(47, 79, 79));
		panelAFF.add(ButtonClose);

		// menu
		JPanel panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBackground(new Color(47, 79, 79));
		panelMenu.setBounds(0, 0, 250, 800);

		// menu LOGO
		JPanel panelLOGO = new JPanel();
		panelLOGO.setLayout(null);
		panelLOGO.setBackground(new Color(47, 79, 79));
		panelLOGO.setBounds(0, 0, 250, 250);

		JLabel lblLOGO = new JLabel();
		lblLOGO.setIcon(new ImageIcon(IconLOGO));
		lblLOGO.setBounds(-20, 0, 250, 250);
		panelLOGO.add(lblLOGO);
		panelMenu.add(panelLOGO);

		// les Panel pour l Menu Tableau de board

		panelTableau = new JPanel();
		panelTableau.setBounds(0, 250, 250, 40);
		panelTableau.setLayout(null);
		panelTableau.setBackground(new Color(47, 79, 79));
		panelMenu.add(panelTableau);

		JLabel tblLBL = new JLabel();
		tblLBL.setBounds(15, 0, 40, 40);
		tblLBL.setIcon(new ImageIcon(IconDASHBOARD));
		panelTableau.add(tblLBL);

		JLabel txtLBL = new JLabel();
		txtLBL.setBounds(70, 0, 160, 40);
		txtLBL.setText("ACCUEIL");
		txtLBL.setForeground(Color.WHITE);
		txtLBL.setFont(new Font("Dialog", Font.BOLD, 18));
		panelTableau.add(txtLBL);

		// les Panel pour l Menu Client

		panelCLIENT = new JPanel();
		panelCLIENT.setBounds(0, 302, 250, 40);
		panelCLIENT.setLayout(null);
		panelCLIENT.setBackground(new Color(47, 79, 79));
		panelMenu.add(panelCLIENT);

		JLabel clientLBL = new JLabel();
		clientLBL.setBounds(15, 0, 40, 40);
		clientLBL.setIcon(new ImageIcon(IconClient));
		panelCLIENT.add(clientLBL);

		JLabel txtLBLClient = new JLabel();
		txtLBLClient.setBounds(70, 0, 160, 40);
		txtLBLClient.setText("CLIENT");
		txtLBLClient.setForeground(Color.WHITE);
		txtLBLClient.setFont(new Font("Dialog", Font.BOLD, 18));
		panelCLIENT.add(txtLBLClient);

		// les Panel pour l Menu Vehicuel

		panelVehicuel = new JPanel();
		panelVehicuel.setBounds(0, 354, 250, 40);
		panelVehicuel.setLayout(null);
		panelVehicuel.setBackground(new Color(47, 79, 79));
		panelMenu.add(panelVehicuel);

		JLabel VEHLBL = new JLabel();
		VEHLBL.setBounds(15, 0, 40, 40);
		VEHLBL.setIcon(new ImageIcon(IconVeh));
		panelVehicuel.add(VEHLBL);

		JLabel txtLBLVEH = new JLabel();
		txtLBLVEH.setBounds(70, 0, 160, 40);
		txtLBLVEH.setText("VEHICULE");
		txtLBLVEH.setForeground(Color.WHITE);
		txtLBLVEH.setFont(new Font("Dialog", Font.BOLD, 18));
		panelVehicuel.add(txtLBLVEH);

		// les Panel pour l Menu Contrats

		panelcontrat = new JPanel();
		panelcontrat.setBounds(0, 458, 250, 40);
		panelcontrat.setLayout(null);
		panelcontrat.setBackground(new Color(47, 79, 79));
		panelMenu.add(panelcontrat);

		JLabel CONTRATLBL = new JLabel();
		CONTRATLBL.setBounds(15, 0, 40, 40);
		CONTRATLBL.setIcon(new ImageIcon(IconContrat));
		panelcontrat.add(CONTRATLBL);

		JLabel txtLBLContrat = new JLabel();
		txtLBLContrat.setBounds(70, 0, 160, 40);
		txtLBLContrat.setText("CONTRATS");
		txtLBLContrat.setForeground(Color.WHITE);
		txtLBLContrat.setFont(new Font("Dialog", Font.BOLD, 18));
		panelcontrat.add(txtLBLContrat);

		// les Panel pour l Menu reserve

		panelReserve = new JPanel();
		panelReserve.setBounds(0, 406, 250, 40);
		panelReserve.setLayout(null);
		panelReserve.setBackground(new Color(47, 79, 79));
		panelMenu.add(panelReserve);

		JLabel ResLBL = new JLabel();
		ResLBL.setBounds(15, 0, 40, 40);
		ResLBL.setIcon(new ImageIcon(IconReservation));
		panelReserve.add(ResLBL);

		JLabel txtLBLRes = new JLabel();
		txtLBLRes.setBounds(70, 0, 160, 40);
		txtLBLRes.setText("RESERVATION");
		txtLBLRes.setForeground(Color.WHITE);
		txtLBLRes.setFont(new Font("Dialog", Font.BOLD, 18));
		panelReserve.add(txtLBLRes);

		// les Panel pour l Menu MonCompte

		panelCompte = new JPanel();
		panelCompte.setBounds(0, 640, 250, 40);
		panelCompte.setLayout(null);
		panelCompte.setBackground(new Color(47, 79, 79));
		panelMenu.add(panelCompte);

		JLabel ComLBL = new JLabel();
		ComLBL.setBounds(15, 0, 40, 40);
		ComLBL.setIcon(new ImageIcon(IconMonCompte));
		panelCompte.add(ComLBL);

		JLabel txtLBLCom = new JLabel();
		txtLBLCom.setBounds(70, 0, 160, 40);
		txtLBLCom.setText("MON COMPTE");
		txtLBLCom.setForeground(Color.WHITE);
		txtLBLCom.setFont(new Font("Dialog", Font.BOLD, 18));
		panelCompte.add(txtLBLCom);

		// les Panel pour l Menu reserve

		panelDeconnextion = new JPanel();
		panelDeconnextion.setBounds(0, 692, 250, 40);
		panelDeconnextion.setLayout(null);
		panelDeconnextion.setBackground(new Color(47, 79, 79));
		panelMenu.add(panelDeconnextion);

		JLabel DecLBL = new JLabel();
		DecLBL.setBounds(15, 0, 40, 40);
		DecLBL.setIcon(new ImageIcon(IconDeconnection));
		panelDeconnextion.add(DecLBL);

		JLabel txtLBLDec = new JLabel();
		txtLBLDec.setBounds(70, 0, 160, 40);
		txtLBLDec.setText("DECONNEXION");
		txtLBLDec.setForeground(Color.WHITE);
		txtLBLDec.setFont(new Font("Dialog", Font.BOLD, 18));
		panelDeconnextion.add(txtLBLDec);

		panelAFF.setLayout(null);
		frame.add(panelMenu);

		frame.setLayout(null);
		frame.setVisible(true);

		panelTableau.addMouseListener(this);
		panelCLIENT.addMouseListener(this);
		panelVehicuel.addMouseListener(this);
		panelcontrat.addMouseListener(this);
		panelReserve.addMouseListener(this);
		panelCompte.addMouseListener(this);
		panelDeconnextion.addMouseListener(this);

		dashboard.panelTableau.addMouseListener(this);
		dashboard.panelCLIENT.addMouseListener(this);
		dashboard.panelVehicuel.addMouseListener(this);
		dashboard.panelcontrat.addMouseListener(this);
		dashboard.panelReserve.addMouseListener(this);
		dashboard.panelCompte.addMouseListener(this);

	}

	public void AucunCHiked(JPanel p) {
		reserve.setVisible(false);
		cont.setVisible(false);
		dashboard.setVisible(false);
		client.setVisible(false);
		moncompte.setVisible(false);
		Veh.setVisible(false);

		p.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == panelTableau || e.getSource() == dashboard.panelTableau) {
			panelAFF.add(dashboard);
			AucunCHiked(dashboard);
		} else if (e.getSource() == panelDeconnextion) {
			new Deconn();
		}

		else if (e.getSource() == panelCompte || e.getSource() == dashboard.panelCompte) {
			panelAFF.add(moncompte);
			AucunCHiked(moncompte);
		}

		else if (e.getSource() == panelReserve || e.getSource() == dashboard.panelReserve) {
			panelAFF.add(reserve);
			AucunCHiked(reserve);
		} else if (e.getSource() == panelcontrat || e.getSource() == dashboard.panelcontrat) {
			panelAFF.add(cont);
			AucunCHiked(cont);
		} else if (e.getSource() == panelVehicuel || e.getSource() == dashboard.panelVehicuel) {
			panelAFF.add(Veh);
			AucunCHiked(Veh);
		} else if (e.getSource() == panelCLIENT || e.getSource() == dashboard.panelCLIENT) {
			panelAFF.add(client);
			AucunCHiked(client);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == panelTableau) {
			panelTableau.setBackground(Color.ORANGE);
		}

		if (e.getSource() == panelDeconnextion) {
			panelDeconnextion.setBackground(Color.ORANGE);
		}
		if (e.getSource() == panelCompte) {
			panelCompte.setBackground(Color.ORANGE);
		}
		if (e.getSource() == panelReserve) {
			panelReserve.setBackground(Color.ORANGE);
		}
		if (e.getSource() == panelcontrat) {
			panelcontrat.setBackground(Color.ORANGE);
		}
		if (e.getSource() == panelVehicuel) {
			panelVehicuel.setBackground(Color.ORANGE);
		}
		if (e.getSource() == panelCLIENT) {
			panelCLIENT.setBackground(Color.ORANGE);
		}

		if (e.getSource() == dashboard.panelTableau) {
			dashboard.panelTableau.setBackground(new Color(47, 79, 79));
		}
		if (e.getSource() == dashboard.panelCompte) {
			dashboard.panelCompte.setBackground(new Color(47, 79, 79));
		}
		if (e.getSource() == dashboard.panelReserve) {
			dashboard.panelReserve.setBackground(new Color(47, 79, 79));
		}
		if (e.getSource() == dashboard.panelcontrat) {
			dashboard.panelcontrat.setBackground(new Color(47, 79, 79));
		}
		if (e.getSource() == dashboard.panelVehicuel) {
			dashboard.panelVehicuel.setBackground(new Color(47, 79, 79));
		}
		if (e.getSource() == dashboard.panelCLIENT) {
			dashboard.panelCLIENT.setBackground(new Color(47, 79, 79));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		panelTableau.setBackground(new Color(47, 79, 79));
		panelDeconnextion.setBackground(new Color(47, 79, 79));
		panelReserve.setBackground(new Color(47, 79, 79));
		panelcontrat.setBackground(new Color(47, 79, 79));
		panelVehicuel.setBackground(new Color(47, 79, 79));
		panelCLIENT.setBackground(new Color(47, 79, 79));
		panelCompte.setBackground(new Color(47, 79, 79));

		dashboard.panelTableau.setBackground(new Color(0, 128, 128));
		dashboard.panelReserve.setBackground(new Color(0, 128, 128));
		dashboard.panelcontrat.setBackground(new Color(0, 128, 128));
		dashboard.panelVehicuel.setBackground(new Color(0, 128, 128));
		dashboard.panelCLIENT.setBackground(new Color(0, 128, 128));
		dashboard.panelCompte.setBackground(new Color(0, 128, 128));

	}

}
