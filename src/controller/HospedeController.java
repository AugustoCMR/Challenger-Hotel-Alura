package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.HospedeDAO;
import factory.ConnectionFactory;
import modelo.Hospede;

public class HospedeController {
	
	HospedeDAO hospedeDAO;
	
	public HospedeController() {
		Connection connection = new ConnectionFactory().pegaConexao();
		this.hospedeDAO = new HospedeDAO(connection);
	}
	
	public void salvar(Hospede hospede) {
		this.hospedeDAO.salvar(hospede);
	}
	
	public List<Hospede> listarHospedes() {
		return this.hospedeDAO.listarHospede();
	}
	
	public List<Hospede> listarHospedesId(String id) {
		return this.hospedeDAO.buscarId(id);
	}
	
	public void atualizar(String nome, String sobrenome, Date data_nascimento, String nacionalidade, String telefone, Integer idReserva, Integer id) {
		this.hospedeDAO.atualizar(nome, sobrenome, data_nascimento, nacionalidade, telefone, idReserva, id);
	}
	
	public void deletar(Integer id) {
		this.hospedeDAO.deletar(id);
	}
}
