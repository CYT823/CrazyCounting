import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {

	public static void main(String[] args) {
		new GUI();
	}
	GUI(){
		JFrame frame = new JFrame();
		frame.setSize(550, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		 
		GridBagConstraints bag1 = new GridBagConstraints();
		bag1.gridx = 0;
		bag1.gridy = 0;
		bag1.gridwidth = 20;
		bag1.gridheight = 20;
		bag1.weightx = 1;
		bag1.weighty = 1;
		bag1.fill = GridBagConstraints.BOTH;
		bag1.anchor = GridBagConstraints.WEST;
		 
		GridBagConstraints bag2 = new GridBagConstraints();
		bag2.gridx = 0;
		bag2.gridy = 20;
		bag2.gridwidth = 20;
		bag2.gridheight = 40;
		bag2.weightx = 1;
		bag2.weighty = 4;
		bag2.fill = GridBagConstraints.BOTH;
		bag2.anchor = GridBagConstraints.WEST;
		 
		GridBagConstraints bag3 = new GridBagConstraints();
		bag3.gridx = 20;
		bag3.gridy = 0;
		bag3.gridwidth = 40;
		bag3.gridheight = 20;
		bag3.weightx = 4;
		bag3.weighty = 1;
		bag3.fill = GridBagConstraints.BOTH;
		bag3.anchor = GridBagConstraints.EAST;
		
		GridBagConstraints bag4 = new GridBagConstraints();
		bag4.gridx = 20;
		bag4.gridy = 20;
		bag4.gridwidth = 40;
		bag4.gridheight = 40;
		bag4.weightx = 5;
		bag4.weighty = 5;
		bag4.fill = GridBagConstraints.BOTH;
		bag4.anchor = GridBagConstraints.EAST;
		
		GridBagConstraints bag5 = new GridBagConstraints();
		bag5.gridx = 0;
		bag5.gridy = 60;
		bag5.gridwidth = 60;
		bag5.gridheight = 20;
		bag5.weightx = 6;
		bag5.weighty = 1;
		bag5.fill = GridBagConstraints.BOTH;
		bag5.anchor = GridBagConstraints.WEST;
		
		
		frame.add(new Button("1"), bag1);
		frame.add(new Button("2"), bag2);
		frame.add(new Button("3"), bag3);
		frame.add(new Button("4"), bag4);
		frame.add(new Button("5"), bag5);

		frame.setVisible(true);
	}
}
