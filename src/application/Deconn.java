package application;

import java.awt.Frame;

import javax.swing.JOptionPane;

public class Deconn {

	Frame x = Interface.frame;

	Deconn() {

		int input = JOptionPane.showConfirmDialog(null, "Ferme ce logiciel?");
		// 0=yes, 1=no, 2=cancel
		if (input == 0) {
			x.dispose();
		}
	}
}