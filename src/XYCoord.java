
public class XYCoord {
	private int xCoordinate;
	private int yCoordinate;
	
	public XYCoord(int coordinate) {
		this.xCoordinate = coordinate;
		this.yCoordinate = 0;
	}
	
	public XYCoord(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public void setXCoordinate(int xCoord) {
		xCoordinate = xCoord;
	}
	
	public void setYCoordinate(int yCoord) {
		yCoordinate = yCoord;
	}
	
	public void setCoord(int xCoord, int yCoord) {
		xCoordinate = xCoord;
		yCoordinate = yCoord;
	}
	
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	public int getYCoordinate() {
		return yCoordinate;
	}
	
	//delete this
	public void printPoint() {
		System.out.print("xCoordinate: " + xCoordinate +
				"\n" + "yCoordinate: " + yCoordinate);
	}

}
