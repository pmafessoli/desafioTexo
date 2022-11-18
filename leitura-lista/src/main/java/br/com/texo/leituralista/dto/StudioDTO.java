package br.com.texo.leituralista.dto;

import java.util.List;

import br.com.texo.leituralista.models.StudiosModel;

public class StudioDTO {
	private List<StudiosModel> studios;

	public List<StudiosModel> getStudios() {
		return studios;
	}

	public void setStudios(List<StudiosModel> studios) {
		this.studios = studios;
	}

}
