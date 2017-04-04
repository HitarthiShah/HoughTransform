
public class Main {
	
	public static void main(String [] args) {
		if(args.length != 2) {
			System.out.println("Program needs 2 files: \n"
					+" one for input data and \n" + 
			" one for printing the results. Terminating!!!");
			System.exit(-1);
		}
		String inputFile  = args[0], 
			   outputFile = args[1];
		ImageProcessing imageProcessing = new ImageProcessing(inputFile);
		imageProcessing.loadImage(inputFile);
		HoughTransform houghTransform = new HoughTransform(imageProcessing);
		houghTransform.executeHoughTransform(imageProcessing);
		houghTransform.prettyPrint(outputFile);
	}

}
