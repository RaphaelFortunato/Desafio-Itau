package com.example.demo.dto;

import java.util.DoubleSummaryStatistics;

public class EstatisticasResponse {
	
	private long count;
	private double sum;
	private double avg;
	private double min;
	private double max;
	
	public EstatisticasResponse(DoubleSummaryStatistics statis) {
		this.count = statis.getCount();
		this.sum = statis.getSum();
		this.avg = statis.getAverage();
		this.min = statis.getMin();
		this.max = statis.getMax();
	}

	public long getCount() {
		return count;
	}

	public double getSum() {
		return sum;
	}

	public double getAvg() {
		return avg;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}
	
	
	

}
