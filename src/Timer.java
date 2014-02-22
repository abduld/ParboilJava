import java.util.ArrayList;


public class Timer {
	ArrayList<TimerElement> elems;
	
	Timer() {
		elems = new ArrayList<TimerElement>();
	}

	public void start(String category, String message) {
		TimerElement elem = new TimerElement(category, message);
		elem.start();
	}
	
	public void stop(String category, String message) {
		elem.stop();
	}
	
	public void stopAll() {
		for (elem in elems) {
			elem.stop();
		}
	}
	
	public String summarize() {
		return "";
	}
}
