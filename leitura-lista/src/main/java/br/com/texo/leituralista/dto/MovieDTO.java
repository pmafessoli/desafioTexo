package br.com.texo.leituralista.dto;

import java.util.List;

import br.com.texo.leituralista.entity.MovieEntity;

public class MovieDTO {

	private List<MovieEntity> movies;

	public List<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	}
}
