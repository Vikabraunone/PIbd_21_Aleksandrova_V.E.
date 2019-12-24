import java.awt.Color;
import java.awt.Graphics;

public abstract class Bombs implements IBombs {
	protected int _startPosX;
	protected int _startPosY;
	private CountBombs _count;
	
	public CountBombs GetCount()
    {
		return _count;
    }
	
	public Bombs() {
		int count = (int) (Math.random() * 6 + 5);
		if (count == 6)
			_count = CountBombs.Six;
		else if (count == 7)
			_count = CountBombs.Seven;
		else if (count == 8)
			_count = CountBombs.Eight;
		else if (count == 9)
			_count = CountBombs.Nine;
		else
			_count = CountBombs.Ten;
	}
	
	@Override
	public void SetPosition(int x, int y)
    {
		_startPosX = x;
		_startPosY = y;
    }
	
	public abstract void DrawBombs(Graphics g, CountBombs count, Color color);
}