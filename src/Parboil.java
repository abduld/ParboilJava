
public class Parboil {

	public static void main(String[] args) {
		try {
			ParboilBenchmark[] benchmarks = {
					new VectorAddBenchmark()
			};
			for (ParboilBenchmark benchmark : benchmarks) {
				benchmark.benchmark();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ;
		}
	}
}
