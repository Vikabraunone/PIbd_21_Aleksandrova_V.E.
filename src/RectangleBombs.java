import java.awt.Color;
import java.awt.Graphics;

public class RectangleBombs extends Bombs {
	public RectangleBombs() {
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
			g.fillRect(_startPosX + 10, _startPosY + i * 10, 5, 10);
			g.setColor(Color.black);
			g.drawRect(_startPosX + 10, _startPosY + i * 10, 5, 10);
			i++;
		}
		while (i < count && i < 6) {
			g.setColor(color);
			g.fillRect(_startPosX + 10, _startPosY + i * 10 + 10, 5, 10);
			g.setColor(Color.black);
			g.drawRect(_startPosX + 10, _startPosY + i * 10 + 10, 5, 10);
			i++;
		}
		int j = 0;
		while (i < count && i < 9) {
			g.setColor(color);
			g.fillRect(_startPosX + 20, _startPosY + j, 5, 10);
			g.setColor(Color.black);
			g.drawRect(_startPosX + 20, _startPosY + j, 5, 10);
			i++;
			j += 10;
		}
		while (i < count) {
			g.setColor(color);
			g.fillRect(_startPosX + 20, _startPosY + 40, 5, 10);
			g.setColor(Color.black);
			g.drawRect(_startPosX + 20, _startPosY + 40, 5, 10);
			i++;
		}
	}
}