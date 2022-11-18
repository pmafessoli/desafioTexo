package br.com.texo.leituralista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.texo.leituralista.entity.AwardsIntervalEntity;
import br.com.texo.leituralista.entity.MovieEntity;

public interface AwardsIntervalRepository extends JpaRepository<MovieEntity, Long> {

    @Query(value = "SELECT * FROM AWARDSINTERVAL_VIEW ", nativeQuery = true)
    List<AwardsIntervalEntity> awardsInterval();
}