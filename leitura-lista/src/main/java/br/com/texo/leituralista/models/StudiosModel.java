package br.com.texo.leituralista.models;

public class StudiosModel {
	private String name;
	private int winCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public StudiosModel(String name, int wincount) {
		this.setName(name);
		this.setWinCount(wincount);
	}

}
