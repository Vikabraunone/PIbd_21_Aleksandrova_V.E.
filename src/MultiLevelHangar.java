import java.util.ArrayList;

public class MultiLevelHangar {
    ArrayList<Hangar<ITransport, IBombs>> hangarStages;
    private final int countPlaces = 20;
    
    public MultiLevelHangar(int countStages, int pictureWidth, int pictureHeight)
    {
		hangarStages = new ArrayList<Hangar<ITransport, IBombs>>();
		for (int i = 0; i < countStages; ++i)
			hangarStages.add(new Hangar<ITransport, IBombs>(countPlaces, pictureWidth, pictureHeight));
    }
    
    // Индексатор
    public Hangar<ITransport, IBombs> GetHangar(int ind)
    {
		if (ind > -1 && ind < hangarStages.size())
			return hangarStages.get(ind);
		return null;
    }

	// Индексатор
	public ITransport GetTransport(int level, int indexTransport) {
		if (level > -1 && level < hangarStages.size())
			if (indexTransport > -1 && indexTransport < countPlaces)
				return hangarStages.get(level)._places.get(indexTransport);
		return null;
	}
}
