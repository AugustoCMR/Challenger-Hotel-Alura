package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservaController {
	
	private ReservaDAO reservaDAO;
	
	public ReservaController() {
		Connection connection = new ConnectionFactory().pegaConexao();
		this.reservaDAO = new ReservaDAO(connection);
	}
	
	public void salvar(Reserva reserva) {
		this.reservaDAO.salvar(reserva);
	}
	
	public List<Reserva> buscar() {
		return this.reservaDAO.buscar();
	}
	
	public List<Reserva> buscarId(String id) {
		return this.reservaDAO.buscarId(id);
	}
	
	public void atualizar(Date data_entrada, Date data_saida, String valor, String forma_pagamento, Integer id) {
		this.reservaDAO.atualizar(data_entrada, data_saida, valor, forma_pagamento, id);
	}
	
	public void deletar(Integer id) {
		this.reservaDAO.deletar(id);
	}
	
}
