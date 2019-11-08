<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


    <title>Home</title>
</head>
<body>

     <div class="pai">

        <div class="corpo">
        
            <nav class="navbar navbar-expand-lg navbar-light">
                

                <a href="index" class="nav-brand h1 mb-0 text-danger "><img style="width: 100px;" src="./img/core.png" alt=""></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
                    <span class="navbar-toggler-icon"></span>
                </button>   

                <div class="collapse navbar-collapse" id="navbarSite">

                    <div class="input-group col-md-10 my-2 ">



                    </div>


                    <a href="cadastro.html"><button class="btn text-success">Cadastrar</button></a>
                    <a href="login.html"><button class="btn btn-outline-success">Entrar</button></a>

                </div>

            </nav>

            <hr>
            <hr>
            <hr>
            <hr>

            <div class=""><h1>Carrinho de pedidos</h1></div>

           <div class="row col-md-12 my-5 ">

               <div class=" card col-md-8">
                <h3 class="row"><strong>Itens</strong></h3>
                	<hr>
                	<c:forEach var="produto" items="${Carrinho}">
                    <img src="./img/pizzaaaa.jpg" style="width: 150px" alt="">
                    <h3>${produto.nome}</h3>
                    <c:if test="${produto.desconto > 0}">
                    <small class="row col-md-6 my-2" style="color: grey">De: R${produto.preco}</small>
                    </c:if>
                    <h2 class="text-danger">R$<fmt:formatNumber type="number" maxFractionDigits="2" value="${produto.preco - produto.desconto}"/></h2>
                	<h3>Qtd: ${produto.qtdProduto} </h3>
                    <a href="" class="btn btn-outline-danger" style="font-size: 18px">Excluir</a>
                    <hr>
                    </c:forEach>

               </div>

               <div class="card col-md-4">
                    <h3 class="row"><strong>Resumo do pedido</strong></h3>
                        <hr>

                    <div class=" d-inline">
                        <h5 class="">SubTotal: R$<fmt:formatNumber type="number" maxFractionDigits="2" value="${param.SubTotal}"/></h5>
                        <h5 class="my-4">Descontos: R$<fmt:formatNumber type="number" maxFractionDigits="2" value="${param.Desconto}"/></h5>
                        <hr>
                    </div>

                    <div class=" d-inline">
                        <h5 class="">Valor Total: <span class="text-danger" style="font-size: 30px;">R$<fmt:formatNumber type="number" maxFractionDigits="2" value="${param.Total}"/></span> </h5>
                        <hr>
                    </div>

                    <div class=" d-inline">
                    	<a href="pagamento" class="btn btn-danger" style="width: 200px; padding:5px; font-size: 25px" >Finalizar</a>
                    </div>
                   

               </div>

           </div>

           <c:import url="rodape.jsp" />
            

        </div>

    </div>

</body>
</html>