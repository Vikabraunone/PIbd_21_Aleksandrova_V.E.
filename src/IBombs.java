import java.awt.Color;
import java.awt.Graphics;

public interface IBombs {
	void DrawBombs(Graphics g, CountBombs count, Color color);
	
	void SetPosition(int x, int y);
}