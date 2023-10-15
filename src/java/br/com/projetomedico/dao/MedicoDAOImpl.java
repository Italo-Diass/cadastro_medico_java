package br.com.projetomedico.dao;

import br.com.projetomedico.model.Cidade;
import br.com.projetomedico.model.Medico;
import br.com.projetomedico.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class MedicoDAOImpl implements GenericDAO {
    
    private Connection conn;
    public MedicoDAOImpl() throws Exception{
    try{
        this.conn = ConnectionFactory.getConnection();
        System.out.println("Conectado com sucesso!");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
                
       }
    }

    @Override
    public Boolean cadastrar(Object object) {
    Medico medico = (Medico) object;
    PreparedStatement stmt = null;
    
    String sql = "insert into medico(crmmedico, especialidademedico, idcidade, idpessoa) values( ?, ?, ?, ?);";

    try{
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, medico.getCrmMedico());
        stmt.setString(2, medico.getEspecialidadeMedico());
        stmt.setInt(3, medico.getCidadeMedico().getIdCidade());
        stmt.setInt(4, new PessoaDAOImpl().cadastrar(medico));
        stmt.execute();
        return true;
    }catch(Exception e) {
        System.out.println("Problemas ao cadastrar medico. Erro" + e.getMessage());
        e.printStackTrace();
        return false;
    }finally{
        try{
            ConnectionFactory.closeConnection(conn, stmt);
        }catch(Exception ex) {
            System.out.println("Problemas ao fechar conexão! Erro" + ex.getMessage());
        }
    }
    }

    @Override
    public List<Object> listar() {
    
        List<Object> medicos =  new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "select m.*, c.*, pe.* from medico m, cidade c, pessoa pe where m.idcidade = c.idcidade and m.idpessoa = pe.idpessoa;";
        //"select c.*, p.*, pe.* from cliente c, profissao p, pessoa pe where c.idprofissao = p.idprofissao and c.idpessoa = pe.idpessoa; "
        
        
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Medico medico = new Medico();
                medico.setIdMedico(rs.getInt("idmedico"));
                medico.setIdPessoa(rs.getInt("idpessoa"));
                medico.setNomePessoa(rs.getString("nomepessoa"));
                medico.setEnderecoPessoa(rs.getString("enderecopessoa"));
                medico.setCrmMedico(rs.getInt("crmmedico"));
                medico.setEspecialidadeMedico(rs.getString("especialidademedico"));
                medico.setCidadeMedico(new Cidade(rs.getInt("idcidade")));
                medico.setCidadeMedico(new Cidade(rs.getString("nomecidade")));
                medicos.add(medico);
            }
            
        }catch(SQLException ex){
            
            System.out.println(ex.getMessage() + "Erro ao listar os medicos. ");
            ex.printStackTrace();
    }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
        }catch(Exception e){
                System.out.println("Erro ao fechar conexão." + e.getMessage());
                e.printStackTrace();
        }
     }    
        
        return medicos;
    }

    @Override
    public Boolean excluir(int idObject) {
       
        PreparedStatement stmt = null;
        
        
        
        String sql = "delete from medico where idpessoa = ?; commit; delete from pessoa where idpessoa = ?";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.setInt(2, idObject);
            stmt.executeUpdate();
            return true;
        }catch (Exception e) {
            System.out.println("Problemas ao excluir medico. Erro" + e.getMessage()); e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medico medico = null;
        
        
        
        String sql = "select * from medico where idmedico = ?;";
        
        try{
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                medico = new Medico();
                medico.setIdMedico(rs.getInt("idMedico"));
                medico.setNomePessoa(rs.getString("nomePessoa"));
                medico.setEnderecoPessoa(rs.getString("enderecoPessoa"));
                medico.setCrmMedico(rs.getInt("crmMedico"));
                medico.setEspecialidadeMedico(rs.getString("especialidadeMedico"));
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao carregar medico. Erro: " + e.getMessage());
            e.printStackTrace();
            
        }finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception e){
                System.out.println("Erro ao fechar conexão. Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
       return medico;
    }

    @Override
    public Boolean alterar(Object object) {
        Medico medico = (Medico) object;
        PreparedStatement stmt = null;
        
        String sql ="update medico set nomemedico = ?, enderecomedico = ?, crmmedico = ?, especialidademedico = ? where idmedico = ?";
        
        try {
           stmt = conn.prepareStatement(sql);
          stmt.setString(1, medico.getNomePessoa());
          stmt.setString(2, medico.getEnderecoPessoa());
          stmt.setInt(3, medico.getCrmMedico());
          stmt.setString(4, medico.getEspecialidadeMedico());
          stmt.setInt(5, medico.getIdMedico());
          stmt.executeUpdate();
          return true;
          
        }catch(Exception e) {
            System.out.println("Problemas ao alterar medico. Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
           finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
                
            }catch(Exception ex){
                System.out.println("Problemas ao fechar a conexão. Erro:  " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
 }
