import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class VectorFileReader {

	int nElements;
	float[] data;

	VectorFileReader(String fileName) throws IOException {
		int ii;
		
		Scanner in = new Scanner(new FileReader(fileName));

		if (!in.hasNextInt()) {
			in.close();
			throw new IOException("Cannot read vector file.");
		}
		nElements = in.nextInt();


		data = new float[nElements];

		ii = 0;
		while (in.hasNextFloat()) {
			float val;
			
			val = in.nextFloat();
			data[ii] = val;
			
			ii++;
			if (ii == nElements) {
				break ;
			}
		}
		
		in.close();
	}
	
	public int getNElements() {
		return nElements;
	}

	public float[] getData() {
		return data;
	}
}
