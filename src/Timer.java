import java.util.ArrayList;


public final class Timer {
	ArrayList<TimerElement> elems;
	
	Timer() {
		elems = new ArrayList<TimerElement>();
	}

	public TimerElement start(String category, String message) {
		TimerElement elem = new TimerElement(category, message);
		elem.start();
		return elem;
	}
	
	public void stop(TimerElement elem) {
		elem.stop();
	}
	
	public void stopAll() {
		for (TimerElement elem : elems) {
			elem.stop();
		}
	}
	
	public String summarize() {
		return "";
	}
}
