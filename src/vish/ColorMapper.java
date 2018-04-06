package vish;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class ColorMapper extends JFrame {

	private static final long serialVersionUID = 1L;

	private enum ColorTableType {
		DUMMY,
		GREYSCALE,
		RAINBOW,
		BLUE
	}

	private final Dataset dataset;
	private final ColorTable colorTable;

	public static void main(String[] args) {
		ColorMapper window;
		window = new ColorMapper("Hawaii", 800, 800, ColorTableType.BLUE, 50);
		window.setVisible(true);
	}

	public ColorMapper(String title, int width, int height, ColorTableType ctType, int ctSize) {
		super(title);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - width) / 2);
		int y = (int) ((dimension.getHeight() - height) / 2);

		setBounds(x, y, width, height);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		dataset = new HawaiiDataset();

		switch (ctType) {
			case DUMMY:
				colorTable = new DummyTable(ctSize, dataset.getFMin(), dataset.getFMax());
				break;
			case GREYSCALE:
				colorTable = new GrayScaleTable(ctSize, dataset.getFMin(), dataset.getFMax());
				break;
			case RAINBOW:
				colorTable = new RainbowScaleTable(ctSize, dataset.getFMin(), dataset.getFMax());
				break;
			case BLUE:
				colorTable = new BlueScaleTable(ctSize, dataset.getFMin(), dataset.getFMax());
				break;
			default:
				throw new IllegalStateException();
		}
	}

	/**
	 * Create visualization image and show it in frame
	 */
	@Override
	public void paint(Graphics graphics) {
		int width = getWidth();
		int height = getHeight();

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		int xSize = dataset.getXSize();
		int ySize = dataset.getYSize();

		double xMin = dataset.getXMin();
		double yMin = dataset.getYMin();

		double dx = dataset.getDx();
		double dy = dataset.getDy();

		double dxImage = dx * (xSize - 1) / (double) width;
		double dyImage = dy * (ySize - 1) / (double) height;

		for (int i = 0; i < width; i++) {
			double x = xMin + i * dxImage;
			for (int j = 0; j < height; j++) {
				double y = yMin + (height - 1 - j) * dyImage;
				Color color = colorTable.getColor(dataset.getInterpolatedData(x, y));
				image.setRGB(i, j, color.getRGB());
			}
		}
		graphics.drawImage(image, 0, 0, null);
	}
}
