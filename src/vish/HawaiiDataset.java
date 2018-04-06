/**
 * Visualization and HCI
 * Exercise 3: Color Mapping
 * Volker Ahlers, HS Hannover (volker.ahlers@hs-hannover.de)
 */

package vish;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class HawaiiDataset extends Dataset {

	public HawaiiDataset() {
		xSize = 465;
		ySize = 436;
		xMin = 0.0;
		yMin = 0.0;
		dx = 30.0;
		dy = 30.0;
		data = new double[xSize][ySize];
		readElevationData("hawaii.dat", xSize, ySize);
		findFMinMax();
	}

	/**
	 * Read elevation data column by column into array.
	 * Elevation data is stored as ASCII file with one or more
	 * space-separated (x,y,z) vectors per line.
	 * x and y components are ignored.
	 */
	private void readElevationData(String filename, int xSize, int ySize) {
		BufferedReader stream = null;
		try {
			try {
				stream = new BufferedReader(new FileReader(filename));
				String line;
				int i = 0;
				int j = 0;
				while ((line = stream.readLine()) != null) {
					StringTokenizer tokenizer = new StringTokenizer(line);
					while (tokenizer.hasMoreTokens()) {
						tokenizer.nextToken();
						tokenizer.nextToken();
						data[i][j] = Double.parseDouble(tokenizer.nextToken());
						j++;
						if (j == ySize) {
							// next column
							i++;
							j = 0;
						}
					}
				}
			} finally {
				if (stream != null) {
					stream.close();
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
