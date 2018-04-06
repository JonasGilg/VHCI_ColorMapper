package vish;

import java.awt.*;

public class RainbowScaleTable extends ColorTable {
	public RainbowScaleTable(int size, double fMin, double fMax) {
		super(size, fMin, fMax);

		for (int i = 0; i < size; i++) {
			float color = (float) i / size;
			table[i] = new Color(Color.HSBtoRGB(color, 1, 1));
		}
	}
}
