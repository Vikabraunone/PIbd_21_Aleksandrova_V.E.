import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MultiLevelHangar {
    ArrayList<Hangar<ITransport, IBombs>> hangarStages;
    private final int countPlaces = 20;
    private int pictureWidth;
    private int pictureHeight;
    private int level = -1;
    
    public MultiLevelHangar(int countStages, int pictureWidth, int pictureHeight)
    {
		hangarStages = new ArrayList<Hangar<ITransport, IBombs>>();
		this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
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
				return GetHangar(level).GetTransport(indexTransport);
		return null;
	}
	
	public boolean SaveFile(File file) throws Exception
    {
		try {
			if (file.exists())
				file.delete();
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			fw.write("CountLeveles:" + hangarStages.size() + System.lineSeparator());
			for (Hangar<ITransport, IBombs> hangar : hangarStages) {
				fw.append("Level" + System.lineSeparator());
				SaveLevel(hangar, fw);
			}
			fw.close();
			return true;
		} catch (Exception ex) {
			throw new Exception();
		}
    }
	
	public boolean SaveLevelFile(File file, int level) throws Exception
    {
		try {
			if (file.exists())
				file.delete();
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			fw.write("Level:" + level + System.lineSeparator());
			SaveLevel(hangarStages.get(level - 1), fw);
			fw.close();
			return true;
		} catch (Exception ex) {
			throw new Exception();
		}
    }
	
	public void SaveLevel(Hangar<ITransport, IBombs> hangar, FileWriter fw) throws Exception
    {
		try {
			if (hangar == null)
				return;
			for (int i = 0; i < countPlaces; i++) {
				ITransport plane = hangar.GetTransport(i);
				if (plane != null) {
					if (plane instanceof Bomber)
						fw.append(i + ":Bomber:");
					else if (plane instanceof WarPlane)
						fw.append(i + ":WarPlane:");
					fw.append(plane + System.lineSeparator());
				}
			}
		} catch (Exception e) {
			throw new Exception();
		}
    }

	public boolean LoadData(File file) throws Exception
    {
		if (!file.exists())
			return false;
		level = -1;
		int countLevels = 0;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			if (line.contains("CountLeveles")) {
				countLevels = Integer.parseInt(line.split(":")[1]);
				hangarStages = new ArrayList<Hangar<ITransport, IBombs>>(countLevels);
			} else
				throw new Exception();
			while ((line = reader.readLine()) != null) {
				line.replace("\r", "");
				if (line.equals("Level")) {
					level++;
					hangarStages.add(new Hangar<ITransport, IBombs>(countPlaces, pictureWidth, pictureHeight));
					continue;
				}
				if (level >= countLevels)
					return false;
				LoadLine(hangarStages.get(level), line);
			}
			fr.close();
			return true;
		} catch (Exception ex) {
			throw new Exception();
		}
    }

	public boolean LoadLevelData(File file) throws Exception {
		if (!file.exists())
			return false;
		level = -1;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			if (line.contains("Level")) {
				level = Integer.parseInt(line.split(":")[1]) - 1;
				if (level < 0 || level > hangarStages.size())
					return false;
				hangarStages.set(level, new Hangar<ITransport, IBombs>(countPlaces, pictureWidth, pictureHeight));
			}
			while ((line = reader.readLine()) != null)
				LoadLine(hangarStages.get(level), line);
			return true;
		} catch (Exception ex) {
			throw new Exception();
		}
	}

	public void LoadLine(Hangar<ITransport, IBombs> hangar, String line)
    {
		if (hangar == null)
			return;
		ITransport warPlane = null;
		if (line == null || line == "")
			return;
		line.replace("\r", "");
		if (line.split(":")[1].equals("WarPlane"))
			warPlane = new WarPlane(line.split(":")[2]);
		else if (line.split(":")[1].equals("Bomber"))
			warPlane = new Bomber(line.split(":")[2]);
		if (warPlane != null)
			hangar.AddWarPlane(Integer.parseInt(line.split(":")[0]), warPlane);
    }
	
	public int GetLevel() {
		return level;
	}
}