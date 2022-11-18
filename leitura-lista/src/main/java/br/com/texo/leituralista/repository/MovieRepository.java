package br.com.texo.leituralista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.texo.leituralista.entity.MovieEntity;
import br.com.texo.leituralista.models.AwardsIntervalModel;

public interface MovieRepository extends CrudRepository<MovieEntity, Long> {
	@Query("select u from MOVIES u where u.year = ?1")
	List<MovieEntity> findMoviesByYear(String year);

	List<MovieEntity> findMoviesByWinner(Boolean winner);

	@Query(value = "SELECT  year,  SUM(CASE WHEN winner=true THEN 1 ELSE 0 END) AS Wins FROM movies GROUP BY year HAVING WINS>1", nativeQuery = true)
	List<AwardsIntervalModel> moviesWinnersMoreOneYear();

	MovieEntity findOne(Long idPar);
}
