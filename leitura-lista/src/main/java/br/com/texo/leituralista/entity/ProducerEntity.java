package br.com.texo.leituralista.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCERS")
public class ProducerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "NAME", length = 255, nullable = false)
	private String NAME;

	@Column(name = "FK_ID_MOVIE", nullable = false)
	private String FK_ID_MOVIE;

	public ProducerEntity() {
		super();
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

}
