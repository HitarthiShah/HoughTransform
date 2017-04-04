import java.awt.Point;
import java.io.File;
import java.io.PrintWriter;

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
		numOfRows = 180;
		numOfCols = (int)Math.sqrt(Math.pow(imgProObj.getNumRows(), 2) + 
				    Math.pow(imgProObj.getNumCols(), 2));
		minimumVal = imgProObj.getMinVal();
		maximumVal = imgProObj.getMaxVal();
		System.out.println("This is numOfCols " + numOfCols);
		houghAry = new int[180][numOfCols];
		angleInDegrees = 0;
		angleInRadians = 0.0;
		point = new XYCoord(0,0);
		
	}
	
	public double computeDistance(double angle, XYCoord pt) {
		double t = computeT(angle,pt);
		return Math.sqrt((Math.pow(pt.getXCoordinate(), 2)) + 
				(Math.pow(pt.getYCoordinate(), 2))) * (Math.cos(t));
	}
	
	public double computeT(double radians, XYCoord pt) {
		return (radians - Math.atan(pt.getYCoordinate()/pt.getXCoordinate())
				- (Math.PI/2));
	}
	
	public void determineHeader() {
		 minimumVal = 9999;
		 maximumVal = -9999;
		for(int i = 0; i < numOfRows; ++i) {
			for(int j = 0; j < numOfCols; ++j) {
				if(houghAry[i][j] < minimumVal) 
					minimumVal = houghAry[i][j];
				if(houghAry[i][j] > maximumVal)
					maximumVal = houghAry[i][j];
			}//for columns
		}//for rows
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
	
	public void executeHoughTransform(ImageProcessing image) {
		int distance = 0;
		
		for(int row = 0; row < image.getNumRows(); ++row) {
			for(int col = 0; col < image.getNumCols(); ++col) {
				if(image.getImgArrVal(row,col) > 0) {
					angleInDegrees = 0;
					point.setCoord(row, col);
					point.printPoint();
					while(angleInDegrees < 179) {
						angleInRadians = (angleInDegrees) * (Math.PI/180);
						distance = Math.abs((int)computeDistance(angleInRadians,point));
						System.out.println("This is the distance " + distance);
						houghAry[angleInDegrees][distance]++;
						angleInDegrees++;
					}
					angleInDegrees = 0;
				}//if
			}//for columns
		}//for rows	
	}
	
	public void prettyPrint(String outputFile) {
		try {
			PrintWriter printToFile = new PrintWriter(new File(outputFile));
			for(int row = 0; row < numOfRows; ++row) {
				for(int col = 0; col < numOfCols; ++col) {
					if(houghAry[row][col] > 0) {
						printToFile.print(houghAry[row][col] + " ");
					} else 
						printToFile.print(" ");
				}
				printToFile.println();
			}
			printToFile.flush();
			printToFile.close();
		} catch(Exception ioe) {
			System.out.println(ioe);
		}
	}
	
}
