import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.TransferHandler;

public class ListHandlerDopColor extends TransferHandler {
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
			if (line.equals("Black"))
				WarPlaneConfigApplication.SetDopColor(Color.BLACK);
			else if (line.equals("White"))
				WarPlaneConfigApplication.SetDopColor(Color.WHITE);
			else if (line.equals("Green"))
				WarPlaneConfigApplication.SetDopColor(Color.GREEN);
			else if (line.equals("Red"))
				WarPlaneConfigApplication.SetDopColor(Color.RED);
			else if (line.equals("Blue"))
				WarPlaneConfigApplication.SetDopColor(Color.BLUE);
			else if (line.equals("Yellow"))
				WarPlaneConfigApplication.SetDopColor(Color.YELLOW);
			else if (line.equals("Gray"))
				WarPlaneConfigApplication.SetDopColor(Color.LIGHT_GRAY);
			else if (line.equals("Orange"))
				WarPlaneConfigApplication.SetDopColor(Color.ORANGE);
			WarPlaneConfigApplication.GetPanelWarPlane().repaint();
			WarPlaneConfigApplication.ClearIndexJLists();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
