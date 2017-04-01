
public class HoughTransform {

	private XYCoord point;
	private int angleInDegrees;
	private double angleInRadians;
	private int numOfRows;
	private int numOfCols;
	private int minimumVal;
	private int maximumVal;
	private int[][] houghAry;
	
	public HoughTransform(ImageProcessing imgProObj) {
		numOfRows = imgProObj.getNumRows();
		numOfCols = imgProObj.getNumCols();
		minimumVal = imgProObj.getMinVal();
		maximumVal = imgProObj.getMaxVal();
		int distance = (int)Math.sqrt(Math.pow(numOfRows, 2) + 
									Math.pow(numOfCols, 2));
		houghAry = new int[distance][180];
		
	}
	
	public double computeDistance(int angle, int distance, 
										int row, int col) {
		double t = computeT(angle,row,col);
		return Math.sqrt((Math.pow(row, 2)) + 
				(Math.pow(col, 2))) * (Math.cos(t));
	}
	
	public void determineHeader() {
		
	}
	
	public double computeT(int angle, int row, int col) {
		return (angle - Math.atan(col/row) - (Math.PI/2));
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
