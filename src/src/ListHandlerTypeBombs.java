import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.TransferHandler;

public class ListHandlerTypeBombs extends TransferHandler {
	public boolean canImport(TransferSupport support) {
		if (!support.isDrop())
			return false;
		return support.isDataFlavorSupported(DataFlavor.stringFlavor);
	}

	public boolean importData(TransferSupport support) {
		if (!canImport(support))
			return false;
		Transferable transferable = support.getTransferable();
		if (WarPlaneConfigApplication.GetWarPlane() == null)
		{
			WarPlaneConfigApplication.ClearIndexJLists();
			return false;
		}
		if (!(WarPlaneConfigApplication.GetWarPlane() instanceof Bomber))
		{
			WarPlaneConfigApplication.ClearIndexJLists();
			return false;
		}
		try {
			String line = (String) transferable.getTransferData(DataFlavor.stringFlavor);
			if (line.equals("Круглые"))
				WarPlaneConfigApplication.SetBombs(new CircleBombs(((Bombs)WarPlaneConfigApplication.GetBombs()).GetIntCount()));
			else if (line.equals("Квадратные"))
				WarPlaneConfigApplication.SetBombs(new SquareBombs(((Bombs)WarPlaneConfigApplication.GetBombs()).GetIntCount()));
			else if (line.equals("Прямоугольные"))
				WarPlaneConfigApplication.SetBombs(new RectangleBombs(((Bombs)WarPlaneConfigApplication.GetBombs()).GetIntCount()));
			WarPlaneConfigApplication.GetPanelWarPlane().repaint();
			WarPlaneConfigApplication.ClearIndexJLists();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}