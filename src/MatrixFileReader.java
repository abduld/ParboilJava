import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class MatrixFileReader {
	int rows, cols;
	float[][] data;

	MatrixFileReader(String fileName) throws IOException {
		int ii, jj;
		
		Scanner in = new Scanner(new FileReader(fileName));

		if (!in.hasNextInt()) {
			in.close();
			throw new IOException("Cannot read matrix file.");
		}
		rows = in.nextInt();

		if (!in.hasNextInt()) {
			in.close();
			throw new IOException("Cannot read matrix file.");
		}
		cols = in.nextInt();
		
		data = new float[rows][cols];
		
		jj = ii = 0;
		while (in.hasNextFloat()) {
			float val;
			
			val = in.nextFloat();
			data[ii][jj] = val;
			
			jj++;
			if (jj == cols) {
				jj = 0;
				ii++;
			}
			
			if (ii == rows && jj == cols) {
				break ;
			}
		}
		
		in.close();
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public float[][] getData() {
		return data;
	}
}
