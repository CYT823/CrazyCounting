

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class Util {

	final static void drawLine(Graphics g, int size, int panelWidth) { // 畫格子
		int width = panelWidth / size;
		int lineLength = size * width; // 每條線長
		g.setColor(Color.BLACK);

		for (int i = 0; i <= lineLength + width; i += width) { // 畫行
			g.drawLine(i, 0, i, lineLength);
			g.drawLine(i + 1, 0, i + 1, lineLength);
			g.drawLine(i + 2, 0, i + 2, lineLength);
		}
		for (int i = 0; i <= lineLength; i += width) { // 畫列
			g.drawLine(0, i, lineLength + 22, i);
			g.drawLine(0, i + 1, lineLength + 22, i + 1);
			g.drawLine(0, i + 2, lineLength + 22, i + 2);
		}
	}
	
	final static String[][] bombSetting(int size) { // 排炸彈
		String[][] map = new String[size][size];
		for (int row = 0; row < size; row++) {
			for (int i = 0; i < 2; i++) {
				int bomb = (int) (Math.random() * 100) % (size + 1);
				if (bomb < size)
					map[row][bomb] = "*";
			}
		}
		return map;
	}

	final static String[] search(String[][] bombMap, int size) { // 找安全位置間隔
		String[] result = new String[size*2]; 
		for (int i = 0; i < size; i++) { // 左邊顯示
			int count = 0;
			String num = "";
			boolean flag = true;
			for (int j = 0; j < size; j++) {
				if (bombMap[i][j] != "*") {
					count++;
					flag = true;
				} else {
					if (count != 0) { // 如果count=0 那就不用加上去了
						num += (count + " ");
						count = 0;
						flag = false;
					}
				}
			}
			if(flag == true)
				num += (count + " ");
			result[i] = num;
		}
		for (int i = 0; i <size; i++) { // 上排顯示
			int count = 0;
			String num = "";
			boolean flag = true;
			for (int j = 0; j < size; j++) {
				if (bombMap[j][i] != "*") {
					count++;
					flag = true;
				} else {
					if (count != 0) { // 如果count=0 那就不用加上去了
						num += count + " ";
						count = 0;
						flag = false;
					}
				}
			}
			if(flag == true)
				num += (count + " ");
			result[i + size] = num;
		}

		return result;
	}

	final static boolean checkPixelBound(int x, int y, int size) { // 檢查滑鼠點選位置
		if (x < 0 || x > size - 1 || y < 0 || y > size - 1) {
			return false;
		}
		return true;
	}

	final static void drawAnswer(Graphics g, int x, int y, int size, int width, String[][] bombMap) { // draw answer
		if (checkPixelBound(x, y, size) && bombMap[y][x] == null) {
			g.setColor(new Color(0,0,255,100)); //畫RGBA
			g.fillRect(x * width + 3, y * width + 3, width-3, width-3);
		} else if (checkPixelBound(x, y, size) && bombMap[y][x].equals("*")) {
			drawAllAns(g, size, width, bombMap);
			JOptionPane.showMessageDialog(null, "Nice try", "QQ", JOptionPane.ERROR_MESSAGE);
		} else {

		}
	}

	final static void drawAllAns(Graphics g, int size, int width, String[][] map) { //錯了顯示所有答案
		for (int x = 0; x < size ; x++) {
			for (int y = 0; y < size ; y++) {
				if (map[y][x] == null) {
					g.setColor(new Color(0,255,0,100)); //安全地畫綠色
					g.fillRect(x * width + 3, y * width + 3, width-3, width-3);
				} else { //炸彈畫紅色
					g.setColor(new Color(255,0,0,100));
					g.fillRect(x * width + 3, y * width + 3, width-3, width-3);
				}
			}
		}
	}
	
	final static void checkGame(String[][] map, String[][] clickMap, int size) { //看遊戲結束了沒
		boolean flag = true;
		for (int i = 0; i < size; i++) { 
			for (int j = 0; j < size; j++) {
				if(map[i][j] != clickMap[i][j]) {
					flag = false;
					break;
				}
			}
		}
		if(flag == true) {
			JOptionPane.showMessageDialog(null, "Congratulation!!!", "~YA~", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
