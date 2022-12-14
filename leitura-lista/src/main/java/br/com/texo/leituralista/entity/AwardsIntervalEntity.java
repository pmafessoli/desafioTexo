package br.com.texo.leituralista.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "AWARDSINTERVAL")
public class AwardsIntervalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @Transient
	@Column(name = "producer", length = 255)
	private String producer;

	@Column(name = "interval")
	private int interval;

	@Transient
	private int previousWin;

	@Transient
	private int followingWin;

	@Transient
	public String getProducer() {
		return producer;
	}

	public AwardsIntervalEntity(String producer, int interval, int previousWin, int followingWin) {
		super();
		this.producer = producer;
		this.interval = interval;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getPreviousWin() {
		return previousWin;
	}

	public void setPreviousWin(int previousWin) {
		this.previousWin = previousWin;
	}

	public int getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(int followingWin) {
		this.followingWin = followingWin;
	}

}
