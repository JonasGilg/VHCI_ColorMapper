/**
 * Visualization and HCI
 * Exercise 3: Color Mapping
 * Volker Ahlers, HS Hannover (volker.ahlers@hs-hannover.de)
 */

package vish;

import java.awt.Color;

public class DummyTable extends ColorTable {

	public DummyTable(int size, double fMin, double fMax) {
		super(size, fMin, fMax);
		for (int i = 0; i < size; i++) {
			// ToDo: create color table entries
			table[i] = new Color(1f, 1f, 1f);
		}
	}
	
}
