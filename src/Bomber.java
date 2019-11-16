import java.awt.Color;
import java.awt.Graphics;

public class Bomber extends WarPlane {
	Bombs bombs;
	Color _dopColor;
	boolean _spire;
	boolean _emblem;
	
	public Bomber(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean spire, boolean emblem, Bombs bomb)
	{
		super(maxSpeed, weight, mainColor);
		_dopColor = dopColor;
		_spire = spire;
		_emblem = emblem;
		bombs = bomb;
	}

	public void SetDopColor(Color dopColor) {
		_dopColor = dopColor;
	}

	public Color GetDopColor() {
		return _dopColor;
	}

	public void SetSpire(boolean spire) {
		_spire = spire;
	}

	public boolean GetSpire() {
		return _spire;
	}

	public void SetEmblem(boolean emblem) {
		_emblem = emblem;
	}

	public boolean GetEmblem() {
		return _emblem;
	}
	
	@Override
	public void DrawWarPlane(Graphics g)
    {
		if (_spire)
        {
            g.setColor(_dopColor);
            g.fillOval(_startPosX, _startPosY + 33, 50, 4);
            g.setColor(Color.BLACK);
            g.fillOval(_startPosX, _startPosY + 33, 50, 4);
        }
        super.DrawWarPlane(g);
        if (_emblem)
        {
        	g.setColor(Color.RED);
            g.fillOval( _startPosX + 45, _startPosY + 50, 10, 10);
            g.setColor(Color.BLACK);
            g.drawOval(_startPosX + 45, _startPosY + 50, 10, 10);
        }
        bombs.SetStartPosX(_startPosX);
        bombs.SetStartPosY(_startPosY);
    }
}
