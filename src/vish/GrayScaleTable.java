package vish;

import java.awt.*;

public class GrayScaleTable extends ColorTable {
	public GrayScaleTable(int size, double fMin, double fMax) {
		super(size, fMin, fMax);

		for (int i = 0; i < size; i++) {
			float color = (float) i / size;
			table[i] = new Color(Color.HSBtoRGB(0, 0, color));
		}
	}
}