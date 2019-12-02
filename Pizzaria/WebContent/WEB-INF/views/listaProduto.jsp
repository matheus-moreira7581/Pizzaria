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


    <title>Produtos - ${listProdutos[0].tipo}</title>
</head>
<body>

     <div class="pai">

        <div class="corpo">
        
            <c:import url="menu.jsp" />

            <hr>
            <hr>
            <hr>
            <hr>

            <div class="row"><h2><strong>Produtos</strong></h2></div>

            <hr>

            <h1><c:out value="${listProdutos[0].tipo}"></c:out></h1>
            
            <div class="container-fluid content-row">
    			<div class="row">
    				<c:if test="${empty listProdutos}"> 
    					<h1>Sem Produtos</h1>
    				</c:if>
	    			<c:forEach var="produto" items="${listProdutos}">
                         <div class="col-sm-12 col-lg-4" style="margin-bottom: 25px">
	            			<div class="card h-100">
	           					<img class="card-img-top img-responsive" src="img/${produto.imgSource}" alt="pizza">
	                  				<div class="card-body">
	                    				<h4 class="card-title">${produto.nome}<h4>
	                    				<h6>${produto.descricao}</h6>
	                    				<h1 class="card-text text-dark">R$<fmt:formatNumber type="number" maxFractionDigits="2" value="${produto.preco - produto.desconto}"/></h1>
	                    				<form action="produto" method="get">
	                    					<button class="btn btn-dark w-30" name="id" value="${produto.codigo}">Comprar</button>
	                    				</form>
	            					</div>
	            			</div>
	    				</div>
               		</c:forEach>
               	</div>
			</div>
            <hr>
			 -->
            <hr>

            <!-- footer  -->

            <c:import url="rodape.jsp" />

            

        </div>

    </div>

</body>
</html>