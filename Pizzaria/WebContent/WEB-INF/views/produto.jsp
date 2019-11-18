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


    <title>${produtos.tipo} - ${produtos.nome}</title>
</head>
<body>

     <div class="pai">

        <div class="corpo">
        
            <c:import url="menu.jsp" />

            <hr>
            <hr>
            <hr>
            <hr>

            <div class="container">

                 <div class="d-inline row">
                    <img src="./img/pizza.jpg" style="width: 80px" alt="">
                    <img src="./img/pizza.jpg" style="width: 80PX" alt="">
                    <img src="./img/pizza.jpg" style="width: 80PX" alt="">
                    <img src="./img/pizza.jpg" style="width: 80PX" alt="">
                    <img src="./img/pizza.jpg" style="width: 80PX" alt="">
                    
                </div>
                

                <div class="row my-4">
                    <img src=".\img\<c:url value="${produtos.imgSource}" />"  style="width: 500px" alt="">

                    <div class="col-md-6">
                        <h3>${produtos.nome}</h3>
                        <h5>${produtos.descricao}</h5>
                        <c:if test="${produtos.desconto > 0}">
                        	<small class="row col-md-4 my-2" style="color: grey">De: R${produtos.preco}</small>
                         </c:if>
                        
                        <h1 class="col-md-4 text-danger" style="letter-spacing: 2px"> 
                        	<span style="font-size: 20px; color: grey">Por:</span> 
                        	R$<fmt:formatNumber type="number" maxFractionDigits="2" value="${produtos.preco - produtos.desconto}"/>
                        </h1>
                        <hr>
                        <form action="addCarrinho" method="get">
                                <div class="col-md-4 mb-5">
                                        <label for="validationDefaultUsername" style="color: grey">Quant.</label>
                                        
                                        <div class="input-group">

                                            <div class="input-group-prepend">
                                                <span class="input-group-text btn" id="inputGroupPrepend2">-</span>
                                            </div>
                                             
                                            <input type="number" class="form-control" name="qtdProduto" id="validationDefaultUsername" value="1" aria-describedby="inputGroupPrepend2" required>

                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="inputGroupPrepend2">+</span>
                                            </div>
                                        </div>
                                </div>

                                
                        
                        	<button type="submit" name="codigoProduto" class="btn btn-danger col-md-4" style="padding: 15px" value="${produtos.codigo}">ADD AO CARRINHO</button>
                        </form>
                       
                
                    </div>
                </div>

            </div>

            <!-- footer  -->

            <c:import url="rodape.jsp" />

            

        </div>

    </div>

</body>
</html>