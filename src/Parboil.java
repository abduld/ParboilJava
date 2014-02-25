
public class Parboil {

	public static void main(String[] args) {
		try {
			ParboilBenchmark[] benchmarks = {
					new VectorAddBenchmark()/*,
					new SgemmBenchmark(),
					new StencilBenchmark(),
					new MRIQBenchmark(),
					new TPACFBenchmark()*/
			};
			for (ParboilBenchmark benchmark : benchmarks) {
				if (benchmark.run() == false) {
					System.out.println("Failed to run benchmark " + benchmark.getName());
				} else {
					System.out.println("Succesfully ran benchmark " + benchmark.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ;
		}
	}
}
