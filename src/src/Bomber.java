import java.awt.Color;
import java.awt.Graphics;

public class Bomber extends WarPlane {
	private Color _dopColor;
	private boolean _isSpire;
	private boolean _isBombs;
	private boolean _isEmblem;
	private IBombs _bombs;

	public Bomber(String info)
    {
		super(info);
        String[] strs = info.split(";");
        if (strs.length == 9)
        {
        	SetMaxSpeed(Integer.parseInt (strs[0]));
    		SetWeight(Float.parseFloat(strs[1]));
    		SetMainColor(new Color(Integer.parseInt(strs[2])));
    		SetDopColor(new Color(Integer.parseInt(strs[3])));
    		SetSpire(Boolean.parseBoolean(strs[4]));
    		SetEmblem(Boolean.parseBoolean(strs[5]));
    		SetTrueBombs(Boolean.parseBoolean(strs[6]));
    		if (strs[7].equals("CircleBombs"))
    			_bombs = new CircleBombs(Integer.parseInt(strs[8]));
    		else if (strs[7].equals("SquareBombs"))
    			_bombs = new SquareBombs(Integer.parseInt(strs[8]));
    		else
    			_bombs = new RectangleBombs(Integer.parseInt(strs[8]));
        }
    }
	
	public Bomber(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean isSpire, boolean isBombs,
			boolean isEmblem, IBombs bombs) {
		super(maxSpeed, weight, mainColor);
		_dopColor = dopColor;
		_isSpire = isSpire;
		_isBombs = isBombs;
		_isEmblem = isEmblem;
		_bombs = bombs;
	}

	public void SetDopColor(Color dopColor) {
		_dopColor = dopColor;
	}

	public Color GetDopColor() {
		return _dopColor;
	}
	
	public void SetBombs(IBombs bombs) {
		_bombs = bombs;
	}
	
	public IBombs GetBombs() {
		return _bombs;
	}

	public void SetSpire(boolean spire) {
		_isSpire = spire;
	}

	public boolean GetSpire() {
		return _isSpire;
	}

	public void SetTrueBombs(boolean bombs) {
		_isBombs = bombs;
	}

	public boolean GetTrueBombs() {
		return _isBombs;
	}

	public void SetEmblem(boolean emblem) {
		_isEmblem = emblem;
	}

	public boolean GetEmblem() {
		return _isEmblem;
	}

	@Override
	public void DrawWarPlane(Graphics g) {
		if (_isSpire) {
			g.setColor(_dopColor);
			g.fillOval(_startPosX, _startPosY + 33, 50, 4);
			g.setColor(Color.BLACK);
			g.drawOval(_startPosX, _startPosY + 33, 50, 4);
		}
		super.DrawWarPlane(g);
		if (_isEmblem) {
			g.setColor(_dopColor);
			g.fillOval(_startPosX + 45, _startPosY + 50, 10, 10);
			g.setColor(Color.BLACK);
			g.drawOval(_startPosX + 45, _startPosY + 50, 10, 10);
		}
		if (_isBombs) {
			_bombs.SetPosition(_startPosX, _startPosY);
			_bombs.DrawBombs(g, ((Bombs) _bombs).GetCount(), GetDopColor());
		}
	}
	
	@Override
    public String toString() {
        return super.toString()  + ";" + GetDopColor().getRGB() + ";" + GetSpire() + ";" + GetTrueBombs() + ";" + GetEmblem() + ";" + _bombs.toString();
    }
}