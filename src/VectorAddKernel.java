
public class VectorAddKernel extends ParboilKernel {
	float[] output;
	float[] input1;
	float[] input2;
	int len;
	
	VectorAddKernel(ThreadIdx tidx, BlockIdx bidx, BlockDim bdim, GridDim gdim,
			float[] output, float[] input1, float[] input2, int len) {
		this.threadIdx = tidx;
		this.blockIdx = bidx;
		this.blockDim = bdim;
		this.gridDim = gdim;
		this.output = output;
		this.input1 = input1;
		this.input2 = input2;
		this.len = len;
	}

	@Override
	public void run() {
		int tid = threadIdx.getX() + blockDim.getX() * blockIdx.getX();
		if (tid < len) {
			output[tid] = input1[tid] + input2[tid];
		}
	}

	public float[] getOutput() {
		return output;
	}

	public float[] getInput1() {
		return input1;
	}

	public float[] getInput2() {
		return input2;
	}

	public int getLen() {
		return len;
	}
}
