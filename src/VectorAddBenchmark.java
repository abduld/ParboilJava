import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class VectorAddBenchmark implements ParboilBenchmark {
	int nElements;
	float[] intput1Data;
	float[] intput2Data;
	float[] outputData;
	
	public final static String input1File = "";
	public final static String input2File = "";
	public final static String outputFile = "";
	
	VectorAddBenchmark() throws IOException {
		VectorFileReader input1Reader = new VectorFileReader(input1File);
		VectorFileReader input2Reader = new VectorFileReader(input2File);
		
		intput1Data = input1Reader.getData();
		intput2Data = input2Reader.getData();
		nElements = input1Reader.getNElements();
		
		outputData = new float[nElements];
		
		benchmark();
	}
	
	@Override
	public void benchmark() {
		BlockDim blockDim = new BlockDim(16);
		GridDim gridDim = new GridDim((int) Math.ceil(nElements / ((float) blockDim.getX())));
		
		ExecutorService executor = Executors.newFixedThreadPool(blockDim.getX());
		
		for (int ii = 0; ii < nElements; ii++) {
			Runnable thread = new VectorAddKernel(
					new ThreadIdx(ii % 16),
					new BlockIdx(ii / 16),
					blockDim,
					gridDim,
					outputData,
					intput1Data,
					intput2Data,
					nElements);
			executor.execute(thread);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {}
	}

}
