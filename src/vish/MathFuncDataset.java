/**
 * Visualization and HCI
 * Exercise 3: Color Mapping
 * Volker Ahlers, HS Hannover (volker.ahlers@hs-hannover.de)
 */

package vish;

public class MathFuncDataset extends Dataset {
	
	public MathFuncDataset(int xSize, int ySize, 
			double xMin, double xMax, double yMin, double yMax) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.xMin = xMin;
		this.yMin = yMin;
		dx = (xMax - xMin) / (double)(xSize - 1);
		dy = (yMax - yMin) / (double)(ySize - 1);
		data = new double[xSize][ySize];
		createSinCosData();
		findFMinMax();
	}

	/**
	 * Compute mathematical function values
	 * f(x,y) = sin(2 pi x) * cos(2 pi y) 
	 */
	public void createSinCosData() {
		for (int i = 0; i < xSize; i++) {
			double x = xMin + i * dx;
			for (int j = 0; j < ySize; j++) {
				double y = yMin + j * dy;				
				data[i][j] = Math.sin(2 * Math.PI * x) * Math.cos(2 * Math.PI * y);
			}
		}
	}

	// To do: add further mathematical functions
	
}
