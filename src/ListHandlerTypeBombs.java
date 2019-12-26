import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class ListHandlerTypeBombs extends TransferHandler {
	private JPanel panelWarPlane;

	public ListHandlerTypeBombs(JPanel panel) {
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
		try {
			String line = (String) transferable.getTransferData(DataFlavor.stringFlavor);
			if (line.equals("Круглые"))
				WarPlaneConfigApplication.bombs = new CircleBombs();
			else if (line.equals("Квадратные"))
				WarPlaneConfigApplication.bombs = new SquareBombs();
			else if (line.equals("Прямоугольные"))
				WarPlaneConfigApplication.bombs = new RectangleBombs();
			else {
				WarPlaneConfigApplication.ClearIndexJLists();
				return false;
			}
			if (!(WarPlaneConfigApplication.warPlane instanceof Bomber)) {
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