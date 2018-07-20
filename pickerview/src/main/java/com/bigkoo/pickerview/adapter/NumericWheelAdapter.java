package com.bigkoo.pickerview.adapter;


import com.contrarywind.adapter.WheelAdapter;

/**
 * Numeric Wheel adapter.
 */
public class NumericWheelAdapter implements WheelAdapter {
	
	private int minValue;
	private int maxValue;
	private int interval;//间隔

	/**
	 * Constructor
	 * @param minValue the wheel min value
	 * @param maxValue the wheel max value
	 */
	public NumericWheelAdapter(int minValue, int maxValue, int interval) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.interval = interval == 0 ? 1 : interval;
	}

	@Override
	public Object getItem(int index) {
		if (index >= 0 && index < getItemsCount()) {
			int value = minValue + index * interval;;
			return value;
		}
		return 0;
	}

	@Override
	public int getItemsCount() {
		double x = (maxValue - minValue + 1) / (double)interval;
		return (int) Math.floor(x + 0.5);
	}
	
	@Override
	public int indexOf(Object o){
		try {
			return (int)o - minValue;
		} catch (Exception e) {
			return -1;
		}

	}
}
