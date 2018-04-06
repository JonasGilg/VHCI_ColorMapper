package vish;

import java.awt.*;

public class BlueScaleTable extends ColorTable {
	public BlueScaleTable(int size, double fMin, double fMax) {
		super(size, fMin, fMax);

		for (int i = 0; i < size; i++) {
			float color = (float) i / size;
			table[i] = new Color(Color.HSBtoRGB(2.0f / 3.0f, color, 1));
		}
	}
}
