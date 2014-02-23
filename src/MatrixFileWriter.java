import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class MatrixFileWriter {
	MatrixFileWriter(String outputFile, float[][] data, int rows, int cols) throws IOException {
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFile));
		
		for (int ii = 0; ii < rows; ii++) {
			for (int jj = 0; jj < cols; jj++) {
				outputWriter.write(Float.toString(data[ii][jj]) + " ");
			}
			outputWriter.newLine();
		}
		outputWriter.flush();  
		outputWriter.close();
	}
}
