import java.util.ArrayList;


public final class Timer {
	ArrayList<TimerElement> elems;
	
	Timer() {
		elems = new ArrayList<TimerElement>();
	}

	public TimerElement start(String category, String message) {
		TimerElement elem = new TimerElement(category, message);
		elems.add(elem);
		elem.start();
		return elem;
	}
	
	public void stop(TimerElement elem) {
		elem.stop();
	}

	public void stop() {
		if (elems.size() > 0) {
			stop(elems.get(elems.size() - 1));
		}
	}
	
	public void stopAll() {
		for (TimerElement elem : elems) {
			elem.stop();
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (TimerElement elem : elems) {
			s += elem + "\n";
		}
		return s;
	}
}
