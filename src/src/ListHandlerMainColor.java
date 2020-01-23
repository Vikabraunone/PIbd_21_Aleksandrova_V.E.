import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.TransferHandler;

public class ListHandlerMainColor extends TransferHandler {
	public boolean canImport(TransferSupport support) {
		if (!support.isDrop())
			return false;
		return support.isDataFlavorSupported(DataFlavor.stringFlavor);
	}

	public boolean importData(TransferSupport support) {
		if (!canImport(support))
			return false;
		Transferable transferable = support.getTransferable();
		if (WarPlaneConfigApplication.GetWarPlane() == null) {
			WarPlaneConfigApplication.ClearIndexJLists();
			return false;
		}
		try {
			String line = (String) transferable.getTransferData(DataFlavor.stringFlavor);
			if (line.equals("Black"))
				WarPlaneConfigApplication.SetMainColor(Color.BLACK);
			else if (line.equals("White"))
				WarPlaneConfigApplication.SetMainColor(Color.WHITE);
			else if (line.equals("Green"))
				WarPlaneConfigApplication.SetMainColor(Color.GREEN);
			else if (line.equals("Red"))
				WarPlaneConfigApplication.SetMainColor(Color.RED);
			else if (line.equals("Blue"))
				WarPlaneConfigApplication.SetMainColor(Color.BLUE);
			else if (line.equals("Yellow"))
				WarPlaneConfigApplication.SetMainColor(Color.YELLOW);
			else if (line.equals("Gray"))
				WarPlaneConfigApplication.SetMainColor(Color.LIGHT_GRAY);
			else if (line.equals("Orange"))
				WarPlaneConfigApplication.SetMainColor(Color.ORANGE);
			WarPlaneConfigApplication.GetPanelWarPlane().repaint();
			WarPlaneConfigApplication.ClearIndexJLists();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}