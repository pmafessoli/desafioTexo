package br.com.texo.leituralista.models;

public class AwardsIntervalModel {
	private String year;
	private int winnerCount;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getWinnerCount() {
		return winnerCount;
	}

	public void setWinnerCount(int winnerCount) {
		this.winnerCount = winnerCount;
	}

	public AwardsIntervalModel(String year, int wincount) {
		super();
		this.year = year;
		this.winnerCount = wincount;
	}

}
