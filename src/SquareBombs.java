import java.awt.Graphics;
import java.awt.Color;

public class SquareBombs extends Bombs {

	public SquareBombs() {
		super();
	}

	@Override
	public void DrawBombs(Graphics g, CountBomb countBombs, Color color) {
		int count;
		if (countBombs == CountBomb.Six)
			count = 6;
		else if (countBombs == CountBomb.Seven)
			count = 7;
		else if (countBombs == CountBomb.Eight)
			count = 8;
		else if (countBombs == CountBomb.Nine)
			count = 9;
		else
			count = 10;
		int i = 0;
		while (i < count && i < 3) {
			g.setColor(color);
			g.fillRect(GetStartPosX() + 10, GetStartPosY() + i * 10, 10, 10);
			g.setColor(Color.black);
			g.drawRect(GetStartPosX() + 10, GetStartPosY() + i * 10, 10, 10);
			i++;
		}
		while (i < count && i < 6) {
			g.setColor(color);
			g.fillRect(GetStartPosX() + 10, GetStartPosY() + i * 10 + 10, 10, 10);
			g.setColor(Color.black);
			g.drawRect(GetStartPosX() + 10, GetStartPosY() + i * 10 + 10, 5, 10);
			i++;
		}
		int j = 0;
		while (i < count && i < 9) {
			g.setColor(color);
			g.fillRect(GetStartPosX() + 20, GetStartPosY() + j, 10, 10);
			g.setColor(Color.black);
			g.drawRect(GetStartPosX() + 20, GetStartPosY() + j, 10, 10);
			i++;
			j += 10;
		}
		while (i < count) {
			g.setColor(color);
			g.fillRect(GetStartPosX() + 20, GetStartPosY() + 40, 10, 10);
			g.setColor(Color.black);
			g.drawRect(GetStartPosX() + 20, GetStartPosY() + 40, 10, 10);
			i++;
		}
	}
}
