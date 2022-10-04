package modelo;

import java.sql.Date;

public class Hospede {
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private Date data_Nascimento;
	private String nacionalide;
	private String telefone;
	private Integer id_Reserva;
	
	public Hospede(String nome, String sobrenome, Date data_Nascimento, String nacionalide, String telefone,
			Integer id_Reserva) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.data_Nascimento = data_Nascimento;
		this.nacionalide = nacionalide;
		this.telefone = telefone;
		this.id_Reserva = id_Reserva;
	}

	public Hospede(Integer id, String nome, String sobrenome, Date data_Nascimento, String nacionalide, String telefone,
			Integer id_Reserva) {
		
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.data_Nascimento = data_Nascimento;
		this.nacionalide = nacionalide;
		this.telefone = telefone;
		this.id_Reserva = id_Reserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getData_Nascimento() {
		return data_Nascimento;
	}

	public void setData_Nascimento(Date data_Nascimento) {
		this.data_Nascimento = data_Nascimento;
	}

	public String getNacionalide() {
		return nacionalide;
	}

	public void setNacionalide(String nacionalide) {
		this.nacionalide = nacionalide;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getId_Reserva() {
		return id_Reserva;
	}

	public void setId_Reserva(Integer id_Reserva) {
		this.id_Reserva = id_Reserva;
	}
	
	
}
