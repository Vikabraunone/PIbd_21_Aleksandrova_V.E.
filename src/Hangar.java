import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Hangar <T extends ITransport, V extends IBombs>{
	private T[] _places;
	private int pictureWidth;
	private int pictureHeight;
	private final int _placeSizeWidth = 210;
	private final int _placeSizeHeight = 90;
	private Color _color;
	private IBombs bombs = null;
	Random rnd = new Random();
	
	
	public Hangar(int sizes, int pictureWidth, int pictureHeight)
    {
        _places = (T[]) new ITransport [sizes];;
        this.pictureWidth = pictureHeight;
        this.pictureHeight = pictureHeight;
        for (int i = 0; i < _places.length; i++)
            _places[i] = null;
    }
    
	public int operatorAdd(T warPlane)
    {
        for (int i = 0; i < _places.length; i++)
            if (CheckFreePlace(i))
            {
                _places[i] = warPlane;
                _places[i].SetPosition(5 + i / 5 * _placeSizeWidth + 5,
                i % 5 * _placeSizeHeight + 15, pictureWidth, pictureHeight);
                return i;
            }
        return -1;
    }

	public T operatorSub(int index)
    {
		if (index < 0 || index > _places.length)
            return null;
        if (!CheckFreePlace(index))
        {
            T warPlane = _places[index];
            _places[index] = null;
            return warPlane;
        }
        return null;
    }
	
	public int operatorMul(int index)
    {
        if (index < 0 || index > _places.length)
            return -1;
        if (!CheckFreePlace(index))
        {
            T warPlane = _places[index];
            if (!(warPlane instanceof Bomber))
            {
            	int posX = rnd.nextInt(90) + 10;
				int posY = rnd.nextInt(90) + 10;
				int typeBombs = rnd.nextInt(3);
				if (typeBombs == 0)
					bombs = new CircleBombs();
				else if (typeBombs == 1)
					bombs = new SquareBombs();
				else
					bombs = new RectangleBombs();
				bombs.SetPosition(5 + index / 5 * _placeSizeWidth + 5, index % 5 * _placeSizeHeight + 15);
                _places[index] = (T) new Bomber(((WarPlane)warPlane).GetMaxSpeed(), ((WarPlane)warPlane).GetWeight(), ((WarPlane)warPlane).GetMainColor(), 
                		_color, true, true, true, bombs);
                _places[index].SetPosition(5 + index / 5 * _placeSizeWidth + 5, index % 5 * _placeSizeHeight + 15, pictureWidth, pictureHeight);
                return index;
            }
        }
        return -1;
    }

	public int operatorDiv(int index)
    {
        if (index < 0 || index > _places.length)
            return -1;
        if (!CheckFreePlace(index))
        {
            T warPlane = _places[index];
            if (warPlane instanceof Bomber)
            {
            	WarPlane plane = (WarPlane)warPlane;
                _places[index] = (T) new WarPlane(plane.GetMaxSpeed(), plane.GetWeight(), plane.GetMainColor());
                _places[index].SetPosition(5 + index / 5 * _placeSizeWidth + 5, index % 5 * _placeSizeHeight + 15, pictureWidth, pictureHeight);
                return index;
            }
        }
        return -1;
    }

    private boolean CheckFreePlace(int index)
    {
        return _places[index] == null;
    }

    public void Draw(Graphics g)
    {
        DrawMarking(g);
        for (int i = 0; i < _places.length; i++)
            if (!CheckFreePlace(i))
                _places[i].DrawWarPlane(g);
    }

    private void DrawMarking(Graphics g)
    {
        g.setColor(Color.black);
        g.drawRect(0, 0, (_places.length / 5) * _placeSizeWidth, 450);
        for (int i = 0; i < _places.length / 5; i++)
        {
            for (int j = 0; j < 5; ++j)
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i * _placeSizeWidth + 110, j * _placeSizeHeight);
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, 450);
        }
    }
    
    public void SetColorChangeWarPlane(int index, Color color)
    {
        if (index < 0 || index > _places.length)
            return;
        if (!CheckFreePlace(index))
            if (!(_places[index] instanceof Bomber))
            	_color = color;
    }
}
