package vish;

import java.awt.Color;

public abstract class ColorTable {
	private final int size;
	private final double fMin;
	private final double fMax;
	protected final Color table[];
	private final double step;
		
	public ColorTable(int size, double fMin, double fMax) {
		this.size = size;
		this.fMin = fMin;
		this.fMax = fMax;
		this.table = new Color[size];
		this.step = (fMax - fMin) / size;
	}
	
	public Color getColor(double f) {
		int value = (int) ((f - fMin) / step);
		return table[value];
	}
	
	public String toString() {
		String string = "Color table, size " + size + "\n";
		for (int i = 0; i < size; i++) {
			string += table[i] + "\n";
		}
		return string;
	}
}
