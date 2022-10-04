//package controller;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//
//import dao.UsuarioDAO;
//import factory.ConnectionFactory;
//import modelo.Usuario;
//
//public class UsuarioController {
//	
//	private UsuarioDAO usuarioDAO;
//	
//	public UsuarioController() {
//		Connection connection = new ConnectionFactory().pegaConexao();
//		this.usuarioDAO = new UsuarioDAO(connection);
//	}
//	
//	public ResultSet autenticaUsuario(Usuario objetoUsuario) {
//		 return this.usuarioDAO.autenticacaoUsuario(objetoUsuario);
//	}
//}
