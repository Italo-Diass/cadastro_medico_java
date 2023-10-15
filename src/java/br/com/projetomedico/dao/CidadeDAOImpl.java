package br.com.projetomedico.dao;

import br.com.projetomedico.model.Cidade;
import br.com.projetomedico.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAOImpl {

    private Connection conn;

    public CidadeDAOImpl() throws Exception {
        
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public List<Object> carregarCidades() {

        List<Object> cidades = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from cidade;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("idcidade"));
                cidade.setNomeCidade(rs.getString("nomecidade"));
                cidades.add(cidade);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar os cidades. " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão." + e.getMessage());
                e.printStackTrace();
            }
        }

        return cidades;
}
}
