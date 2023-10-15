package br.com.projetomedico.dao;


import br.com.projetomedico.model.Convenio;
import br.com.projetomedico.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ConvenioDAOImpl {

    private Connection conn;

    public ConvenioDAOImpl() throws Exception {
        
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }
    
    public List<Object> carregarConvenios() {

        List<Object> convenios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from convenio order by nomeconvenio;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Convenio convenio = new Convenio();
                convenio.setIdConvenio(rs.getInt("idconvenio"));
                convenio.setNomeConvenio(rs.getString("nomeconvenio"));
                convenios.add(convenio);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar os convenios. " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão." + e.getMessage());
                e.printStackTrace();
            }
        }

        return convenios;
}
    
}
