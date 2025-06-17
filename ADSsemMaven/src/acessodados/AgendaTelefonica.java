package acessodados;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entidades.Contato;

public class AgendaTelefonica {
    public void cadastrarContato (Contato contato){
        String sql = "INSERT INTO contatos (NOME, TELEFONE, EMAIL) VALUES (?, ? ,?)";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.setString(3, contato. getEmail());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removerContato(String nome) {
        String sql = "DELETE FROM contatos WHERE nome = ?";
        PreparedStatement ps = null;
        try { 
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1,nome);
            int rows = ps.executeUpdate();
            if (rows>0) {
                System.out.println("Contato removido com sucesso!");

            } else {
                System.out.println("Contato não encontrado!");

            }
        }catch (SQLException e) {
                e.printStackTrace();
            }
    }public Contato buscarContato(String nome) {
        String sql = "SELECT * FROM contatos WHERE nome = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try  {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1,nome);
            rs = ps.executeQuery();

            if (rs.next()) {
                Contato contato = new Contato(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("telefone"),
                rs.getString("email")
                );
                
            
                return contato;
            } else {
                System.out.println("Contato não encontrado.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }public List<Contato> listarContatos() {
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contatos";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Contato contato = new Contato(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                    
                
                lista.add(contato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}   


