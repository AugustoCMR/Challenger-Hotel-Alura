package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import modelo.Usuario;

public class UsuarioDAO {
	
	Connection conn;
	
	public ResultSet autenticacaoUsuario(Usuario objetoUsuario) {
		
		conn = new ConnectionFactory().pegaConexao();
		
		try {
			String sql = "SELECT * FROM USUARIO WHERE USUARIO = ? and SENHA = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objetoUsuario.getNome_usuario());
			pstm.setString(2, objetoUsuario.getSenha_usuario());
			
			ResultSet rst = pstm.executeQuery();
			return rst;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
			
		}
	}
}
