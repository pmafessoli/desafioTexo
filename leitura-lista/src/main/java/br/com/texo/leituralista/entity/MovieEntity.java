package br.com.texo.leituralista.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "MOVIES")
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 4, nullable = false)
	private String year;

	@Column(length = 255, nullable = false)
	private String title;

	@OneToMany
	@JoinTable(name = "STUDIOS", joinColumns = @JoinColumn(name = "FK_ID_MOVIE"), inverseJoinColumns = @JoinColumn(name = "ID"))
	private List<StudioEntity> studios;

	@OneToMany
	@JoinTable(name = "PRODUCERS", joinColumns = @JoinColumn(name = "FK_ID_MOVIE"), inverseJoinColumns = @JoinColumn(name = "ID"))
	private List<ProducerEntity> producers;

	@Column(name = "winner")
	private Boolean winner;

	public MovieEntity() {
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getWinner() {
		return winner;
	}

	public void setWinner(Boolean winner) {
		this.winner = winner;
	}

	public List<ProducerEntity> getProducers() {
		return producers;
	}

	public void setProducers(List<ProducerEntity> producers) {
		this.producers = producers;
	}

	public List<StudioEntity> getStudios() {
		return studios;
	}

	public void setStudios(List<StudioEntity> studios) {
		this.studios = studios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
