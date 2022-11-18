package br.com.texo.leituralista.dto;

import java.util.List;

import br.com.texo.leituralista.models.AwardsIntervalModel;

public class MovieWinDTO {

	private List<AwardsIntervalModel> years;

	public List<AwardsIntervalModel> getYears() {
		return years;
	}

	public void setYears(List<AwardsIntervalModel> years) {
		this.years = years;
	}

}
