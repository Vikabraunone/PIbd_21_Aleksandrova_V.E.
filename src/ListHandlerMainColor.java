import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.TransferHandler;

public class ListHandlerMainColor extends TransferHandler {
	private MyPanelWarPlane panelWarPlane;

	public ListHandlerMainColor(MyPanelWarPlane panel) {
		panelWarPlane = panel;
	}

	public boolean canImport(TransferSupport support) {
		if (!support.isDrop())
			return false;
		return support.isDataFlavorSupported(DataFlavor.stringFlavor);
	}

	public boolean importData(TransferSupport support) {
		if (!canImport(support))
			return false;
		Transferable transferable = support.getTransferable();
		if (WarPlaneConfigApplication.warPlane == null) {
			WarPlaneConfigApplication.ClearIndexJLists();
			return false;
		}
		try {
			String line = (String) transferable.getTransferData(DataFlavor.stringFlavor);
			if (line.equals("Black"))
				WarPlaneConfigApplication.MainColor = Color.BLACK;
			else if (line.equals("White"))
				WarPlaneConfigApplication.MainColor = Color.WHITE;
			else if (line.equals("Green"))
				WarPlaneConfigApplication.MainColor = Color.GREEN;
			else if (line.equals("Red"))
				WarPlaneConfigApplication.MainColor = Color.RED;
			else if (line.equals("Blue"))
				WarPlaneConfigApplication.MainColor = Color.BLUE;
			else if (line.equals("Yellow"))
				WarPlaneConfigApplication.MainColor = Color.YELLOW;
			else if (line.equals("Gray"))
				WarPlaneConfigApplication.MainColor = Color.LIGHT_GRAY;
			else if (line.equals("Orange"))
				WarPlaneConfigApplication.MainColor = Color.ORANGE;
			else {
				WarPlaneConfigApplication.ClearIndexJLists();
				return false;
			}
			if (WarPlaneConfigApplication.warPlane instanceof Bomber)
				WarPlaneConfigApplication.warPlane = new Bomber(0, 0, WarPlaneConfigApplication.MainColor,
						WarPlaneConfigApplication.DopColor, true, true, true, WarPlaneConfigApplication.bombs);
			else
				WarPlaneConfigApplication.warPlane = new WarPlane(0, 0, WarPlaneConfigApplication.MainColor);
			MyPanelWarPlane.warPlane = (WarPlane) WarPlaneConfigApplication.warPlane;
			panelWarPlane.repaint();
			WarPlaneConfigApplication.ClearIndexJLists();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}