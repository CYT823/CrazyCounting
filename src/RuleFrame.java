

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RuleFrame extends JFrame {
	JLabel ruleTitle;
	JLabel explain;
	JPanel explainPanel = new JPanel();
	RuleFrame() {
		ruleTitle = new JLabel("規則:");
		ruleTitle.setFont(new Font("Serif", Font.BOLD, 28));
		JLabel text;
		
		text = new JLabel();
		text.setFont(new Font("",Font.PLAIN,16));
		text.setText("找到棋盤中藍色的格子。");
		explainPanel.add(text);
		
		text = new JLabel();
		text.setFont(new Font("",Font.PLAIN,16));
		text.setText("棋盤邊上是提示，告訴玩家從該方向開始連續藍色格子的個數。");
		explainPanel.add(text);
		
		text = new JLabel();
		text.setFont(new Font("",Font.PLAIN,16));
		text.setText("例如：12，表示這一列(行)共有3個藍色格子，先是1個，然後是2個相連。");
		explainPanel.add(text);
		
		text = new JLabel();
		text.setFont(new Font("",Font.PLAIN,16));
		text.setText("以此類推...加油!!!");
		explainPanel.add(text);
		
		add(ruleTitle, BorderLayout.NORTH);
		add(explainPanel, BorderLayout.CENTER);
	}
}
