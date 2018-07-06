import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

	public static void main(String[] args) {
		new GUI();
	}
	GUI(){
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		 
		GridBagConstraints bag1 = new GridBagConstraints();
		bag1.gridx = 0;
		bag1.gridy = 0;
		bag1.gridwidth = 5;
		bag1.gridheight = 5;
		bag1.weightx = 0;
		bag1.weighty = 0;
		bag1.fill = GridBagConstraints.NONE;
		bag1.anchor = GridBagConstraints.WEST;
		 
		GridBagConstraints bag2 = new GridBagConstraints();
		bag2.gridx = 0;
		bag2.gridy = 5;
		bag2.gridwidth = 5;
		bag2.gridheight = 1;
		bag2.weightx = 0;
		bag2.weighty = 0;
		bag2.fill = GridBagConstraints.NONE;
		bag2.anchor = GridBagConstraints.WEST;
		 
		GridBagConstraints bag3 = new GridBagConstraints();
		bag3.gridx = 0;
		bag3.gridy = 6;
		bag3.gridwidth = 5;
		bag3.gridheight = 1;
		bag3.weightx = 0;
		bag3.weighty = 0;
		bag3.fill = GridBagConstraints.BOTH;
		bag3.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints bag4 = new GridBagConstraints();
		bag4.gridx = 0;
		bag4.gridy = 7;
		bag4.gridwidth = 5;
		bag4.gridheight = 1;
		bag4.weightx = 0;
		bag4.weighty = 0;
		bag4.fill = GridBagConstraints.NONE;
		bag4.anchor = GridBagConstraints.WEST;
		 
		GridBagConstraints bag5 = new GridBagConstraints();
		bag5.gridx = 5;
		bag5.gridy = 0;
		bag5.gridwidth = 1;
		bag5.gridheight = 5;
		bag5.weightx = 0;
		bag5.weighty = 0;
		bag5.fill = GridBagConstraints.NONE;
		bag5.anchor = GridBagConstraints.WEST;
		 
		GridBagConstraints bag6 = new GridBagConstraints();
		bag6.gridx = 6;
		bag6.gridy = 0;
		bag6.gridwidth = 1;
		bag6.gridheight = 5;
		bag6.weightx = 0;
		bag6.weighty = 0;
		bag6.fill = GridBagConstraints.BOTH;
		bag6.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints bag7 = new GridBagConstraints();
		bag7.gridx = 7;
		bag7.gridy = 0;
		bag7.gridwidth = 1;
		bag7.gridheight = 5;
		bag7.weightx = 0;
		bag7.weighty = 0;
		bag7.fill = GridBagConstraints.NONE;
		bag7.anchor = GridBagConstraints.WEST;
		 
		GridBagConstraints bag8 = new GridBagConstraints();
		bag8.gridx = 5;
		bag8.gridy = 5;
		bag8.gridwidth = 3;
		bag8.gridheight = 3;
		bag8.weightx = 0;
		bag8.weighty = 0;
		bag8.fill = GridBagConstraints.NONE;
		bag8.anchor = GridBagConstraints.WEST;
		 
		GridBagConstraints bag9 = new GridBagConstraints();
		bag9.gridx = 0;
		bag9.gridy = 8;
		bag9.gridwidth = 6;
		bag9.gridheight = 2;
		bag9.weightx = 0;
		bag9.weighty = 0;
		bag9.fill = GridBagConstraints.BOTH;
		bag9.anchor = GridBagConstraints.WEST;
		
		JPanel whitePanel = new JPanel();
//		whitePanel.setBackground(Color.WHITE);
		
		frame.add(whitePanel, bag1);
		frame.add(new Button("Bag2"), bag2);
		frame.add(new Button("Bag3"), bag3);
		frame.add(new Button("Bag4"), bag4);
		frame.add(new Button("Bag5"), bag5);
		frame.add(new Button("Bag6"), bag6);
		frame.add(new Button("Bag7"), bag7);
		frame.add(new Button("Bag8"), bag8);
		frame.add(new Button("Bag9"), bag9);
		
		

		frame.setVisible(true);
	}
}
