package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Hospede;

public class HospedeDAO {
	
	private Connection connection;
	
	public HospedeDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Hospede hospede) {
		
		try {
			String sql = "INSERT INTO hospedes (nome, sobrenome, data_Nascimento, nacionalidade, telefone, id_reserva) VALUES(?, ?, ?, ?, ?, ?)"; 
			
			try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, hospede.getNome());
				pstm.setString(2, hospede.getSobrenome());
				pstm.setDate(3, hospede.getData_Nascimento());
				pstm.setString(4, hospede.getNacionalide());
				pstm.setString(5, hospede.getTelefone());
				pstm.setInt(6, hospede.getId_Reserva());
				
				pstm.executeUpdate();
				
				try(ResultSet rst = pstm.getGeneratedKeys()) {
					while(rst.next()) {
						hospede.setId(rst.getInt(1));
					}
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Hospede> listarHospede() {
		List<Hospede> hospedes = new ArrayList<>();
		
		try {
			String sql = "SELECT id, nome, sobrenome, data_Nascimento, nacionalidade, telefone, id_reserva FROM hospedes";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();
				
				transformaResultSetEmHospede(hospedes, pstm);
			}
			return hospedes;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Hospede> buscarId(String id) {
		List<Hospede> hospedes = new ArrayList<>();
		
		try {
			String sql = "SELECT id, nome, sobrenome, data_Nascimento, nacionalidade, telefone, id_reserva FROM hospedes where id = ?";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();
				
				transformaResultSetEmHospede(hospedes, pstm);
			}
			return hospedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(String nome, String sobrenome, Date data_nascimento, String nacionalidade, String telefone, Integer idReserva, Integer id) {
		
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE hospedes SET nome = ?, sobrenome = ?, data_Nascimento = ?, nacionalidade = ?, telefone = ?, id_reserva = ? WHERE id = ?")){
			
			pstm.setString(1, nome);
			pstm.setString(2, sobrenome);
			pstm.setDate(3, data_nascimento);
			pstm.setString(4, nacionalidade);
			pstm.setString(5, telefone);
			pstm.setInt(6, idReserva);
			pstm.setInt(7, id);
			pstm.execute();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Integer id) {
		
		try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM hospedes where id = ?")){
			
			pstm.setInt(1, id);
			pstm.execute();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void transformaResultSetEmHospede(List<Hospede> hospedes, PreparedStatement pstm) throws SQLException {
		try(ResultSet rst = pstm.getResultSet()) {
			while(rst.next()) {
				Hospede hospede = new Hospede(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));
				hospedes.add(hospede);
			}
			
		}
	}
}
