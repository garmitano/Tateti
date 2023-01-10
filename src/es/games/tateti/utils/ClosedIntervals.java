package es.games.tateti.utils;

public class ClosedIntervals {
	private int min;
	private int max;
	
	
	public ClosedIntervals(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	
	public boolean isIncluded(int value) {
		return this.min < value && this.max >= value;
	}
}
