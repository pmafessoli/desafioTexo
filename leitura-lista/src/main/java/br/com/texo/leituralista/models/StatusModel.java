package br.com.texo.leituralista.models;

import java.util.Date;

public class StatusModel {

	public String codreturn;
	private Date timestamp;
	public String status;
	public String message;
	public String path;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public StatusModel(String codreturn, String path) {
		super();
		Date date = new Date();
		this.setTimestamp(new Date(date.getTime()));
		this.codreturn = codreturn;
		this.path = path;

		switch (codreturn) {

			case "00200":
				this.message = "Executado com sucesso!";
				this.status = "200";
				break;

			case "00201":
				this.message = "Excluído!";
				this.status = "200";
				break;

			case "00204":
				this.message = "Erro no servidor!";
				this.status = "204";
				break;

			case "00400":
				this.message = "Solicitação não executada!";
				this.status = "400";
				break;

			case "00403":
				this.message = "Acesso negado!";
				this.status = "403";
				break;

			case "00404":
				this.message = "Caminho inválido!";
				this.status = "404";
				break;

			case "00405":
				this.message = "Erro ao executar o sevidor!";
				this.status = "405";
				break;
		}

	}

}
