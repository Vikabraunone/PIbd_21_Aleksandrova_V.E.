import java.awt.Color;
import java.awt.Graphics;

public class CircleBombs extends Bombs {
	public CircleBombs() {
		super();
	}

	@Override
	public void DrawBombs(Graphics g, CountBombs countBombs, Color color) {
		int count;
		if (countBombs == CountBombs.Six)
			count = 6;
		else if (countBombs == CountBombs.Seven)
			count = 7;
		else if (countBombs == CountBombs.Eight)
			count = 8;
		else if (countBombs == CountBombs.Nine)
			count = 9;
		else
			count = 10;
		int i = 0;
		while (i < count && i < 3) {
			g.setColor(color);
			g.fillOval(_startPosX + 10, _startPosY + i * 10, 10, 10);
			g.setColor(Color.black);
			g.drawOval(_startPosX + 10, _startPosY + i * 10, 10, 10);
			i++;
		}
		while (i < count && i < 6) {
			g.setColor(color);
			g.fillOval(_startPosX + 10, _startPosY + i * 10 + 10, 10, 10);
			g.setColor(Color.black);
			g.drawOval(_startPosX + 10, _startPosY + i * 10 + 10, 10, 10);
			i++;
		}
		int j = 0;
		while (i < count && i < 9) {
			g.setColor(color);
			g.fillOval(_startPosX + 20, _startPosY + j, 10, 10);
			g.setColor(Color.black);
			g.drawOval(_startPosX + 20, _startPosY + j, 10, 10);
			i++;
			j += 10;
		}
		while (i < count) {
			g.setColor(color);
			g.fillOval(_startPosX + 20, _startPosY + 40, 10, 10);
			g.setColor(Color.black);
			g.drawOval(_startPosX + 20,_startPosY + 40, 10, 10);
			i++;
		}
	}
}
