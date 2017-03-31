
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
	
	//delete this
	public void printPoint() {
		System.out.print("xCoordinate: " + xCoordinate +
				"\n" + "yCoordinate: " + yCoordinate);
	}

}
