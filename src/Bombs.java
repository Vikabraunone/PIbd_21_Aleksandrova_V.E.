import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class Bombs implements IBombs {
	protected int _startPosX;
	protected int _startPosY;
	private CountBombs _count;
	
	public Bombs() {
		SetCount(6 + new Random().nextInt(5));
	}
	
	public Bombs(int count) {
		SetCount(count);
	}
	
	public CountBombs GetCount()
    {
		return _count;
    }
	
	public int GetIntCount()
    {
		if (_count == CountBombs.Six)
			return 6;
		else if (_count == CountBombs.Seven)
			return 7;
		else if (_count == CountBombs.Eight)
			return 8;
		else if (_count == CountBombs.Nine)
			return 9;
		else
			return 10;
    }
	
	public void SetCount(int count)
    {
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