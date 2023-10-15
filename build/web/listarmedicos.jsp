<%@page import="java.util.List"%>
<%@page import="br.com.projetomedico.model.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Médicos</title>
    </head>
    <body>
        <h1 align="center">Listagem</h1>
        <hr /> 
        <table align="center" border="1">
        

            <tr>
                <th colspan="9">Lista de Médicos</th>
            </tr>

            <tr>
                <th align="center">IdMedico</th>
                <th align="center">IdPessoa</th>
                <th align="center">Nome</th>
                <th align="center">Endereço</th>
                <th align="center">CRM</th>
                <th align="center">Especialidade</th>
                <th align="center">Cidade</th>
                <th align="center" colspan="2">Editar</th>
            </tr>

            <%
                List<Medico> medicos = (List<Medico>) request.getAttribute("medicos");
                for (Medico medico : medicos) {
            %>

        
            <tr>
                <td align="center"><%=medico.getIdMedico()%></td>
                <td aling="center"><%=medico.getIdPessoa()%> </td>
                <td align="center"><%=medico.getNomePessoa()%></td>    
                <td align="center"><%=medico.getEnderecoPessoa()%></td>
                <td align="center"><%=medico.getCrmMedico()%></td>
                <td align="center"><%=medico.getEspecialidadeMedico()%></td>
                <td align="center"><%=medico.getCidadeMedico().getNomeCidade()%></td>
                <td align="center"><a href="ExcluirMedico?idMedico=<%=medico.getIdPessoa()%>">Exluir</a></td>
                <td align="center"><a href="CarregarMedico?idMedico=<%=medico.getIdPessoa()%>">Alterar</a></td>
                
            </tr>
            
           
                        
            <% 
                }
            %>
        </table>
        
         <hr>
         <p align="center">
         <a href="index.jsp">Voltar</a>
         </p>
    </body>
</html>
