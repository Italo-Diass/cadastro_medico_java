

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de médicos</title>
        <script src="js/jquery-1.10.1.js" type="text/javascript"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript"></script>
        <style>
            .body{
                font-family: sans-serif;
            }
            .container{
                width: 100vh;
                margin: auto;
                align-items: center;
                text-align: center;
            }
            .table{
                align-items: center;
                margin: auto;
            }
            h1{
                text-align: center;
                color: blueviolet;
            }
        </style>
    </head>
    <body class="body">
        <div class="container">

            <h1>Controle de médicos</h1>
            <hr>
            <h2>Cadastrar médico</h2>
            <br>
            <br>
            <form name="cadastrar" action="CadastrarMedico" method="post">
                ${mensagem}
                <table class="table">
                    <tr>
                        <td>
                            <label for="nome">Nome:</label>
                        </td>
                        <td>
                            <input type="text" name="nomePessoa" id="nome">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="endereco">Endereço:</label>
                        </td>
                        <td>
                            <input type="text" name="enderecoPessoa" id="endereco">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="crm">CRM:</label>
                        </td>
                        <td>
                            <input type="number" name="crmMedico" id="crm">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="especialidade">Especialidade:</label>
                        </td>
                        <td>
                            <input type="text" name="especialidadeMedico" id="especialidade">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label for="cidade">Cidade:</label>
                        </td>
                        <td>
                            <select name="idCidade">
                                <c:forEach var="cidade" items="${cidades}">
                                    <option value="${cidade.idCidade}"> 
                                        ${cidade.nomeCidade}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr class="wrapper">
                        <td>Convenios: </td>
                        <td class="toclone">
                            <select name="idConvenio">
                                <c:forEach var="convenio" items="${convenios}">
                                    <option value="${convenio.idConvenio}">${convenio.nomeConvenio}</option>
                                </c:forEach>
                            </select>
                            <button type="button" class="add">+</button>
                            <button type="button" class="remove">-</button>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2" > <input type="submit" name="cadastrar" value="Cadastrar"></td>
                    </tr>
                </table>
            </form>
            <hr>
            <a href="index.jsp">Voltar</a>
        </div>


        <script type="text/javascript">
            function adicionar() {
                var ElementoClonado = $(this.parentNode).clone(); //clona o elemento                                                                     
                $('.wrapper').append(ElementoClonado);
                $('.add').on("click", adicionar);
                $('.remove').on("click", remover);
                $(this).unbind("click");
                
            }
            function remover() {
                $(this.parentNode).remove();
            }
            $('.add').on("click", adicionar);
            $('.remove').on("click", remover);
        </script>
    </body>
</html>


