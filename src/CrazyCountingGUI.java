import javax.swing.JFrame;

public class CrazyCountingGUI {
	public static void main(String[] args) {
		CrazyCountingFrame frame = new CrazyCountingFrame();
		frame.setTitle("Crazy Counting");
		frame.setSize(513, 650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
