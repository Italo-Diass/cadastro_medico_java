package br.com.projetomedico.dao;

import br.com.projetomedico.model.Pessoa;
import br.com.projetomedico.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAOImpl {
    
    private Connection conn;
    
    public PessoaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }
    
    public Integer cadastrar (Pessoa pessoa) {
            
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idPessoa = null;
        
        String sql = "insert into pessoa(nomepessoa, enderecopessoa) values(?, ?) returning idpessoa;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getEnderecoPessoa());
            rs = stmt.executeQuery();
            
            if (rs.next()){
                idPessoa = rs.getInt("idpessoa");
            }
            
        }catch(SQLException e){
            System.out.println("Problemas ao cadastrar cliente. Erro" + e.getMessage());
            e.printStackTrace();
        }finally{
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro" + ex.getMessage());
            }
        
        }
        
        
        
        
        return idPessoa;
    }
            
    
}
