import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CrazyCountingFrame extends JFrame {
	int size;
	String[][] bombMap;
	String[][] clickMap;
	String[] result;
	boolean gameState = false; // 判斷遊戲開始
	int drawPanelWidth;
	
	JPanel leftPanel;
	JPanel topPanel;
	JPanel drawPanel;
	JPanel resultPanel;
	JButton startBtn;
	JButton restartBtn;
	JButton QABtn;
	
	public CrazyCountingFrame() {
		setLayout(new GridBagLayout());
/*
		GridBagConstraints bag1 = new GridBagConstraints();
		bag1.gridx = 0;
		bag1.gridy = 0;
		bag1.gridwidth = 20;
		bag1.gridheight = 20;
		bag1.weightx = 1;
		bag1.weighty = 1;
		bag1.fill = GridBagConstraints.BOTH;
		bag1.anchor = GridBagConstraints.WEST;
*/
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

		size = Integer.parseInt(JOptionPane.showInputDialog("Size: [Suggest 2 ≤ x ≤ 7]"));
		bombMap = new String[size][size];
		clickMap = new String[size][size];
		
		bombMap = Util.bombSetting(size);
		
		result = new String[size*2]; //炸彈提示(左側 上面)
		result = Util.search(bombMap, size);
		
		leftPanel = new JPanel(new GridLayout(size, 1)); //左邊顯示欄位先分隔
		for (int i = 0; i < size; i++) {
			JPanel tempPan = new JPanel(new GridLayout(1, result[i].split(" ").length)); //每一格在平均分放數字
			for (int j = 0; j < result[i].split(" ").length; j++) {
				JLabel tempLb = new JLabel(result[i].split(" ")[j]);
				tempLb.setFont(new Font("", Font.BOLD, 20));
				tempLb.setHorizontalAlignment(JLabel.CENTER);
				tempPan.add(tempLb);
			}
			leftPanel.add(tempPan);
		}
		
		topPanel = new JPanel(new GridLayout(1, size)); //上排顯示欄位
		for (int i = size; i < size*2; i++) {
			JPanel tempPan = new JPanel(new GridLayout(result[i].split(" ").length, 1)); //每一格在平均分放數字
			for (int j = 0; j < result[i].split(" ").length; j++) {
				JLabel tempLb = new JLabel(result[i].split(" ")[j]);
				tempLb.setFont(new Font("", Font.BOLD, 20));
				tempLb.setHorizontalAlignment(JLabel.CENTER);
				tempPan.add(tempLb);
			}
			topPanel.add(tempPan);
		}
		
		drawPanel = new JPanel(); //點選區塊
		drawPanel.setBackground(new Color(211, 211, 211));
		
		resultPanel = new JPanel(); //最下面
		resultPanel.setBackground(new Color(240,248, 255));
		
		
		startBtn = new JButton("SET");
		restartBtn = new JButton("RESET");
		restartBtn.setEnabled(false);
		QABtn = new JButton("不會玩QQ");
		resultPanel.add(startBtn);
		resultPanel.add(restartBtn);
		resultPanel.add(QABtn);

//		add(new JPanel(), bag1);
		add(leftPanel, bag2);
		add(topPanel, bag3);
		add(drawPanel, bag4);
		add(resultPanel, bag5);

		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				restartBtn.setEnabled(true);
				startBtn.setEnabled(false);
				gameState = true;
				drawPanelWidth = drawPanel.getWidth();
				
				for (int i = 0; i < size; i++) { // initial the click map with "*"
					for (int j = 0; j < size; j++) {
						clickMap[i][j] = "*";
					}
				}
				
				Graphics g = drawPanel.getGraphics(); // draw the board
				Util.drawLine(g, size, drawPanel.getWidth());
			}
		});
		
		drawPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent mouseEvent) {
				if (gameState) {
					int width = drawPanelWidth / size;
					int mouseX = (mouseEvent.getX()) / width;
					int mouseY = (mouseEvent.getY()) / width;

					Graphics g = drawPanel.getGraphics();
					Util.drawAnswer(g, mouseX, mouseY, size, width, bombMap);

					if (mouseX < size && mouseY < size) { // 當滑鼠點選超過框框 則不放進陣列
						clickMap[mouseY][mouseX] = null;
					}

					Util.checkGame(bombMap, clickMap, size);
				}
			}
		});
		
		restartBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startBtn.setEnabled(true);
				restartBtn.setEnabled(false);
				gameState = false;

				drawPanel.repaint();
				leftPanel.removeAll();
				topPanel.removeAll();

				size = Integer.parseInt(JOptionPane.showInputDialog("Size: [Suggest 2 ≤ x ≤ 7]"));
				bombMap = new String[size][size];
				clickMap = new String[size][size];
				bombMap = Util.bombSetting(size);
				result = new String[10]; //炸彈提示(左側 上面)
				result = Util.search(bombMap, size);
				
				leftPanel.setLayout(new GridLayout(size, 1)); //= new JPanel(new GridLayout(size, 1)); //左邊顯示欄位
				for (int i = 0; i < size; i++) {
					JPanel tempPan = new JPanel(new GridLayout(1, result[i].split(" ").length));
					for (int j = 0; j < result[i].split(" ").length; j++) {
						JLabel tempLb = new JLabel(result[i].split(" ")[j]);
						tempLb.setFont(new Font("", Font.BOLD, 20));
						tempLb.setHorizontalAlignment(JLabel.CENTER);
						tempPan.add(tempLb);
					}
					leftPanel.add(tempPan);
				}
				leftPanel.revalidate();
				
				topPanel.setLayout(new GridLayout(1, size));// = new JPanel(new GridLayout(1, size)); //上面顯示欄位
				for (int i = size; i < size*2; i++) {
					JPanel tempPan = new JPanel(new GridLayout(result[i].split(" ").length, 1));
					for (int j = 0; j < result[i].split(" ").length; j++) {
						JLabel tempLb = new JLabel(result[i].split(" ")[j]);
						tempLb.setFont(new Font("", Font.BOLD, 20));
						tempLb.setHorizontalAlignment(JLabel.CENTER);
						tempPan.add(tempLb);
					}
					topPanel.add(tempPan);
				}
				topPanel.revalidate();
			}
		});
		
		QABtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				RuleFrame rf = new RuleFrame();
				rf.setTitle("Rules");
				rf.setSize(600, 200);
				rf.setLocationRelativeTo(null);
				rf.setResizable(false);
				rf.setVisible(true);
			}
		});
		
	}
}
