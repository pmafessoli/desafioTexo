package br.com.texo.leituralista.dto;

import java.util.List;

import br.com.texo.leituralista.entity.AwardsIntervalEntity;
import br.com.texo.leituralista.models.StatusModel;

public class AwardsIntervalDTO {
	private List<AwardsIntervalEntity> min;
	private List<AwardsIntervalEntity> max;
	private StatusModel returnStatus;

	public List<AwardsIntervalEntity> getMin() {
		return min;
	}

	public void setMin(List<AwardsIntervalEntity> min) {
		this.min = min;
	}

	public List<AwardsIntervalEntity> getMax() {
		return max;
	}

	public void setMax(List<AwardsIntervalEntity> max) {
		this.max = max;
	}

	public StatusModel getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(StatusModel returnStatus) {
		this.returnStatus = returnStatus;
	}

	public AwardsIntervalDTO() {
		super();
		this.returnStatus = new StatusModel("00200", "/movies/awardsinterval");
	}

}
