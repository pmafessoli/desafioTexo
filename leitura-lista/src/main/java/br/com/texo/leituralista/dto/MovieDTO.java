package br.com.texo.leituralista.dto;

import java.util.List;

import br.com.texo.leituralista.entity.MovieEntity;
import br.com.texo.leituralista.models.StatusModel;

public class MovieDTO {

	private List<MovieEntity> movies;
	private StatusModel returnStatus;

	public List<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	}

	public StatusModel getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(StatusModel returnStatus) {
		this.returnStatus = returnStatus;
	}

	public MovieDTO(String year) {
		returnStatus = new StatusModel("00200", "/movies/" + year);
	}

}
