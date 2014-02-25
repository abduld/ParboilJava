
public interface ParboilBenchmark {
	final CheckSolution check = new CheckSolution();
	final Timer timer = new Timer();
	public boolean run();
	public String getName();
}
