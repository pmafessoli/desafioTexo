package br.com.texo.leituralista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.texo.leituralista.entity.StudioEntity;
import br.com.texo.leituralista.models.StudiosModel;

public interface StudioRepository extends JpaRepository<StudioEntity, Long> {

    @Query(value = "SELECT * FROM (SELECT S.NAME, SUM(CASE WHEN M.WINNER = TRUE THEN 1	ELSE 0 END) AS WINS FROM STUDIOS S, MOVIES M WHERE M.ID = S.FK_ID_MOVIE GROUP BY S.NAME ORDER BY WINS DESC ) WHERE WINS >0", nativeQuery = true)
    List<StudiosModel> studiosOrderWinns();
}
