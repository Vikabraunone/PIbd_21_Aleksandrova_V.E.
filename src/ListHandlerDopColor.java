import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class ListHandlerDopColor extends TransferHandler {
	private JPanel panelWarPlane;

	public ListHandlerDopColor(JPanel panel) {
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
		if (WarPlaneConfigApplication.warPlane == null)
		{
			WarPlaneConfigApplication.ClearIndexJLists();
			return false;
		}
		if (!(WarPlaneConfigApplication.warPlane instanceof Bomber))
		{
			WarPlaneConfigApplication.ClearIndexJLists();
			return false;
		}
		try {
			String line = (String) transferable.getTransferData(DataFlavor.stringFlavor);
			if (line.equals("Black"))
				WarPlaneConfigApplication.DopColor = Color.BLACK;
			else if (line.equals("White"))
				WarPlaneConfigApplication.DopColor = Color.WHITE;
			else if (line.equals("Green"))
				WarPlaneConfigApplication.DopColor = Color.GREEN;
			else if (line.equals("Red"))
				WarPlaneConfigApplication.DopColor = Color.RED;
			else if (line.equals("Blue"))
				WarPlaneConfigApplication.DopColor = Color.BLUE;
			else if (line.equals("Yellow"))
				WarPlaneConfigApplication.DopColor = Color.YELLOW;
			else if (line.equals("Gray"))
				WarPlaneConfigApplication.DopColor = Color.LIGHT_GRAY;
			else if (line.equals("Orange"))
				WarPlaneConfigApplication.DopColor = Color.ORANGE;
			else {
				WarPlaneConfigApplication.ClearIndexJLists();
				return false;
			}
			WarPlaneConfigApplication.warPlane = new Bomber(0, 0, WarPlaneConfigApplication.MainColor,
					WarPlaneConfigApplication.DopColor, true, true, true, WarPlaneConfigApplication.bombs);
			MyPanelWarPlane.warPlane = (WarPlane) WarPlaneConfigApplication.warPlane;
			panelWarPlane.repaint();
			WarPlaneConfigApplication.ClearIndexJLists();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
