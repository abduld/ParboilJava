
import org.apache.commons.lang3.time.StopWatch;

public class TimerElement {
	int startLine;
	int endLine;
	String category;
	String message;
	StopWatch stopWatch;

	public final static boolean DEBUG = true;
	
	TimerElement(String category, String message) {
		startLine = -1;
		endLine = -1;
		this.category = category;
		this.message = message;
		stopWatch = new StopWatch();
	}

	public void start() {
		// TODO: double check the stack depth...
		if (DEBUG) {
			startLine = Thread.currentThread().getStackTrace()[3].getLineNumber();
		}
		stopWatch.start();
	}
	
	public void stop() {
		if (DEBUG) {
			endLine = Thread.currentThread().getStackTrace()[2].getLineNumber();
		}
		stopWatch.stop();
	}
	
	public long elapsed() {
		return stopWatch.getNanoTime();
	}
	
	public String toString() {
		return category + "," + message + "," + stopWatch.getStartTime() + "," + stopWatch.getNanoTime();
	}
}
