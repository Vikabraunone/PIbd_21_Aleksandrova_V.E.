import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.TransferHandler;

public class ListHandlerWarPlane extends TransferHandler {
	public boolean canImport(TransferSupport support) {
		if (!support.isDrop())
			return false;
		return support.isDataFlavorSupported(DataFlavor.stringFlavor);
	}

	public boolean importData(TransferSupport support) {
		if (!canImport(support))
			return false;
		Transferable transferable = support.getTransferable();
		try {
			String line = (String) transferable.getTransferData(DataFlavor.stringFlavor);
			if (line.equals("Военный самолёт"))
				WarPlaneConfigApplication.SetWarPlane(new WarPlane(0, 0, Color.WHITE));
			else if (line.equals("Бомбардировщик"))
				WarPlaneConfigApplication.SetWarPlane(new Bomber(0, 0, Color.WHITE, Color.BLACK, true, true, true, new CircleBombs()));
			WarPlaneConfigApplication.GetPanelWarPlane().repaint();
			WarPlaneConfigApplication.ClearIndexJLists();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}