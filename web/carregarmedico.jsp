<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Clientes</title>
        <style>
          
            h1 {
            margin: 0px;
            padding: 0px;   
            display: flex;
            justify-content: center;
            align-items: center;
            font-weight: 5px;
            font-size: 50px;
            font-family: Century Gothic;
            height:100px;    
            border-style: solid;
            background-color: brown;
            color: white;
            -webkit-text-stroke-width: 2px;
            -webkit-text-stroke-color: #000;
            border-style: solid;
            border-color: black;
            }
        
            a {
                padding: 5px 10px; 
                margin:0;
                border: 0px solid #f00; 
                background: black;
                text-decoration: none;
                color: white;
                -webkit-border-radius:5px;
                -moz-border-radius:5px;
                border-radius:5px;
            }
            
            a :hover {
                background: black;
                color: #000; 
                border-color: #000;
            }
            
            .cadastrar {
               
                padding: 5px 10px; 
                margin:0;
                border: 0px solid #f00; 
                background: brown;
                text-decoration: none;
                color: white;
                -webkit-border-radius:5px;
                -moz-border-radius:5px;
                border-radius:5px;
            }
            
           
            h2 {
                 
            }
            
        </style>

    </head>
    
    <body>
        <h1 align="center">Controle de Médicos</h1>
        
        <h2 align="center">Alterar Médicos<h2>
                
        <form name="cadastrar" action="AlterarMedico" method="post">
            <p align="center">
            ${mensagem}
            </p>
            <table align="center">
                
                <tr>
                    <td><label for ="id"> ID: </label> </td>
                    <td> <input type="text" name="idMedico" id="id" readonly="true" value="${medico.idMedico}"/> </td>
                </tr>
                
                <tr>  
                    <td><label for="nome">Nome:</label></td>
                    <td><input type="text" name="nomeMedico" id="nome" value="${medico.nomeMedico}"/></td> 
                </tr>
                
                <tr>
                    <td><label for="endereco">Endereço:</label></td>
                    <td><input type="text" name="enderecoMedico" id="endereco" value="${medico.enderecoMedico}"/></td> 
                </tr>
                
                <tr>
                    <td><label for="crm">CRM:</label></td>
                    <td><input type="number" name="crmMedico" id="crm" value="${medico.crmMedico}"/></td> 
                </tr>
                
                <tr>
                    <td><label for="especialidade">Especialidade:</label></td>
                    <td><input type="text" name="especialidadeMedico" id="especialidade" value="${medico.especialidadeMedico}"/></td> 
                </tr>
                
                
                
                <tr>
                    <td colspan="2" align="center">
                        <input class="alterar" type="submit" name="alterar" value="Alterar">
                    </td>
                </tr>
                
            </table>   
            
            <p align="center">
                <a href="index.jsp">Voltar</a>
            </p>
            
        </form>    
            
    </body>
</html>
