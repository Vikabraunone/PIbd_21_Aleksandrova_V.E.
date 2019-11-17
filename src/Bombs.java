import java.awt.Color;
import java.awt.Graphics;

public abstract class Bombs implements IBombs {
	private int StartPosX;
	private int StartPosY;
	private Color Color;

	public int GetStartPosX() {
		return StartPosX;
	}

	public void SetStartPosX(int x) {
		StartPosX = x;
	}

	public int GetStartPosY() {
		return StartPosY;
	}

	public void SetStartPosY(int y) {
		StartPosY = y;
	}

	public Color GetColor() {
		return Color;
	}

	public void SetColor(Color color) {
		Color = color;
	}

	public abstract void DrawBombs(Graphics g, CountBomb count, Color color);
}