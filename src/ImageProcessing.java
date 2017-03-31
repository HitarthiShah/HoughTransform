import java.io.*;
import java.util.Scanner;

public class ImageProcessing {
	private int numRows;
	private int numCols;
	private int minVal;
	private int maxVal;
	private int[][] imgAry;
	
	public ImageProcessing(String inputFile) {
		try {
			Scanner readInput = new Scanner(new File(inputFile));
			numRows = readInput.nextInt();
			numCols = readInput.nextInt();
			minVal  = readInput.nextInt();
			maxVal  = readInput.nextInt();
			imgAry = new int[numRows][numCols];
			readInput.close();
		} catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
	
	public void loadImage(String inputFile) {
		int pixel = -1;
		try{
			Scanner readInput = new Scanner(new File(inputFile));
			
			//To skip the header
			for(int i = 0; i < 4; ++i)
				pixel = readInput.nextInt();
			
			for(int i = 0; i < numRows; ++i) {
				for(int j = 0; j < numCols; ++j) {
					pixel = readInput.nextInt();
					imgAry[i][j] = pixel;
				}
			}
			
		}catch(IOException ioe) {
			System.out.println(ioe);
		}
	}
	
	public int getNumRows() { return numRows; }
	
	public int getNumCols() { return numCols; }
	
	public int getMinVal() { return minVal; }
	
	public int getMaxVal() { return maxVal; }
	
	public int getImgArrVal(int rowIndex, int colIndex) {
		return imgAry[rowIndex][colIndex];
	}
	
	//delete this
	public void printImg() {
		for(int i = 0; i < numRows; ++i) {
			for(int j = 0; j < numCols; ++j) {
				System.out.print(imgAry[i][j] + " ");
			}
			System.out.println();
		}
	}

}
