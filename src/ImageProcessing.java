
public class ImageProcessing {
	private int numRows;
	private int numCols;
	private int minVal;
	private int maxVal;
	private int[][] imgAry;
	
	public ImageProcessing() {
		
	}
	
	public void loadImage() {
		
	}
	
	public int getNumRows() { return numRows; }
	
	public int getNumCols() { return numCols; }
	
	public int getMinVal() { return minVal; }
	
	public int getMaxVal() { return maxVal; }
	
	public int getImgArrVal(int rowIndex, int colIndex) {
		return imgAry[rowIndex][colIndex];
	}

}
