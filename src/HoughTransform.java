
public class HoughTransform {

	private XYCoord point;
	private int angleInDegrees;
	private double angleInRadians;
	private int numOfRows;
	private int numOfCols;
	private int minimumVal;
	private int maximumVal;
	private int[][] houghAry;
	
	public HoughTransform() {
		
	}
	
	public void computeDistance() {
		
	}
	
	public void determineHeader() {
		
	}
	
	public int getAngleInDeg() { return angleInDegrees; }
	
	public double getAngleInRad() { return angleInRadians; }
	
	public int getNumOfRows() { return numOfRows; }
	
	public int getNumOfCols() { return numOfCols; }
	
	public int getMinimumVal() { return minimumVal; }
	
	public int getMaximumVal() { return maximumVal; }
	
	public int getHoughAryVal(int rowIndex, int colIndex) {
		return houghAry[rowIndex][colIndex];
	}
	
}
