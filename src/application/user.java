package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class user implements ActionListener {

	public static JFrame frame;
	private JTextField txtUsername;
	private JTextField passwordField;
	private JLabel lblNewLabel;
	private JButton ButtonOK;
	int nBrdeErreur = 0;

	Image IconUser = new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java/pngegg.png").getImage()
			.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

	user() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(120, 120, 300, 364);
		frame.setUndecorated(true);

		Label ButtonClose = new Label("X");
		ButtonClose.setFont(new Font("Algerian", Font.BOLD, 14));
		ButtonClose.setForeground(UIManager.getColor("Button.highlight"));
		ButtonClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		ButtonClose.setBounds(275, 0, 62, 22);
		frame.getContentPane().add(ButtonClose);

		//TextField pour ecrire username
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.highlight"));
		panel.setBounds(20, 210, 250, 30);
		frame.add(panel);

		txtUsername = new JTextField();
		txtUsername.setBounds(30, 215, 200, 20);
		txtUsername.setBackground(UIManager.getColor("Button.highlight"));
		txtUsername.setToolTipText("");
		txtUsername.setColumns(10);
		frame.add(txtUsername);

		
		//TextField pour ecrire password
		JPanel panel2 = new JPanel();
		panel2.setBackground(UIManager.getColor("Button.highlight"));
		panel2.setBounds(20, 250, 250, 30);
		frame.add(panel2);

		passwordField = new JPasswordField(20);
		passwordField.setBounds(30, 255, 200, 20);
		frame.add(passwordField);

		//button pour login 
		ButtonOK = new JButton("OK");
		ButtonOK.setForeground(new Color(255, 255, 255));
		ButtonOK.setBackground(new Color(47, 79, 79));
		ButtonOK.setBounds(20, 290, 250, 30);
		frame.getContentPane().add(ButtonOK);

		// LOGO
		lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\just waiting\\Desktop\\projet java\\logolahihsan3wan.png"));
		lblNewLabel.setBounds(41, 37, 220, 145);
		frame.getContentPane().add(lblNewLabel);

		frame.setLayout(null);
		frame.setVisible(true);

		ButtonOK.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		String userName = txtUsername.getText();
		String password = passwordField.getText();
		
		//compare username et password qui on a saisir avec DATA 
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "");
			PreparedStatement st = (PreparedStatement) con
					.prepareStatement("Select NomUser, password from user where nomuser=? and password=?");

			st.setString(1, userName);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				frame.dispose();
				new Interface();
			} else {
				//password ou username est incorrecte 
				nBrdeErreur++;
				JOptionPane.showMessageDialog(frame, "Username ou Password est inconnu.", "Alert",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		if (nBrdeErreur == 3) {
			//3 fois qui on a saisir le password ou username
			//modifier le password et username apres le test  
			fonctions.resetpwd();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new user();
	}

}
