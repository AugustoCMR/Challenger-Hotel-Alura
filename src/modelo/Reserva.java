package modelo;

import java.sql.Date;

public class Reserva {
	
	private Integer id;
	private Date data_entrada;
	private Date data_saida;
	private String valor;
	private String forma_pagamento;
	
	public Reserva(Date data_entrada, Date data_saida, String valor, String forma_pagamento) {
		this.data_entrada = data_entrada;
		this.data_saida = data_saida;
		this.valor = valor;
		this.forma_pagamento = forma_pagamento;
	}

	public Reserva(Integer id, Date data_entrada, Date data_saida, String valor, String forma_pagamento) {
		this.id = id;
		this.data_entrada = data_entrada;
		this.data_saida = data_saida;
		this.valor = valor;
		this.forma_pagamento = forma_pagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_entrada() {
		return data_entrada;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public String getValor() {
		return valor;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}
	
	
	
	
	
	
}
