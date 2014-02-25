import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class VectorAddBenchmark implements ParboilBenchmark {
	int nElements;
	float[] intput1Data;
	float[] intput2Data;
	float[] trueOutputData;
	float[] outputData;

	public final static String name = "VectorAdd";
	public final static String input1File = "dataset/vecadd/1/input0.raw";
	public final static String input2File = "dataset/vecadd/1/input1.raw";
	public final static String outputFile = "dataset/vecadd/1/output.raw";
	
	VectorAddBenchmark() throws IOException {

		timer.start("IO", "Reading inputs");
		VectorFileReader input1Reader = new VectorFileReader(input1File);
		VectorFileReader input2Reader = new VectorFileReader(input2File);
		VectorFileReader outputReader = new VectorFileReader(outputFile);
		timer.stop();
		
		intput1Data = input1Reader.getData();
		intput2Data = input2Reader.getData();
		trueOutputData = outputReader.getData();
		
		nElements = input1Reader.getNElements();
		
		timer.start("Allocate", "Allocating output data");
		outputData = new float[nElements];
		timer.stop();
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean run() {
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

		System.out.println(timer);
		
		return check.check(trueOutputData, outputData);
	}

}
