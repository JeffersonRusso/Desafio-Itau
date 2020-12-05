package com.desafio.itau.model;

//Bean de Estatistica apenas com Gets e Sets
//Bean responsavel por receber as estatisticas calculadas
///////////////////////////////////////////////////////////////
// count -> soma +1 quando entra uma transacao
// sum   -> 
// avg   ->
// min   ->
// max   ->
//////////////////////////////////////////////////////////////

public class Estatistica {
	
	private int count;
	private double sum;
	private double avg;
	private double min;
	private double max;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}

}
