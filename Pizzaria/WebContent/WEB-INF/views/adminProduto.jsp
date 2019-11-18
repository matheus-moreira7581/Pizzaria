<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Darker+Grotesque:300,400,500,600,700,800,900$display=swap">


    <!-- css -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    <!-- js -->

    <script defer src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

    <script defer src="js/bootstrap.min.js"></script>


    <title>Admin - Lista Produtos</title>
</head>
<body>

     <div class="pai">

        <div class="corpo">
        
			<c:import url="menuAdmin.jsp" />

            <hr>
            <hr>
           
            <div class="row col-md-10">

                <h2 class="col-md-8">GERENCIAMENTO DE PRODUTOS</h2>

                <a href="novoProduto" class="btn btn-warning">Novo Produto</a>
            </div>

            <div class="container">

                

                <p>Todos os alimentos cadastrados no sistema:</p>  

                <table class="table table-bordered">

                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Tipo</th>
                      <th>Nome</th>
                      <th>Preço</th>
                      <th>Desconto</th>
                      <th>Ação</th>
                    </tr>
                  </thead>

                  <tbody>
                  	<c:forEach var="produto" items="${listProdutos}">
	                  	<form action="atualizarProduto" method="get">
		                    <tr>
		                      <td>${produto.codigo}</td>
		                      <td>${produto.tipo}</td>
		                      <td>${produto.nome}</td>
		                      <td>${produto.preco}</td>
		                      <td>${produto.desconto}</td>
		                      <td>
		                          <button name="id" formaction="excluirProduto" value="${produto.codigo}" class="btn btn-danger">Excluir</button>
	
								  <button name="id" value="${produto.codigo}" class="btn btn-success">Atualizar</button>
		                         
		                      </td>
		                    </tr>
		                 </form>
                    </c:forEach>
                  </tbody>

                </table>

              </div>

            <!-- footer  -->

            <c:import url="rodape.jsp" />

            

        </div>

    </div>

</body>
</html>