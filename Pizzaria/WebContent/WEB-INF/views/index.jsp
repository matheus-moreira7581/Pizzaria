<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
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

    <div  class="pai">
        <div class="corpo">
           <c:import url="menu.jsp" /> 
           
            
            
            <header>
            </header>
            
            <hr>
            <hr><hr>
            
                <div class="indexBanner">
                
                	<div class=bn1>          	
                		<img src=".//img/lanche.png">
                		
                		<div class="textLanche">
                			<h1>Que tal um Hamburguer?</h1>
                			<h5 class="text-success">Experimente algo enorme no menor preço!</h5>
                			<form action="listarProduto" method="get">
                            	<button type="submit" name="tipo" value="Hamburguer" class="btnLanche">Comprar</button>
                            </form>
                			
                		</div>             		
                	</div>
                	
                	<section>
                	</section>
                	
                    <div class="bn2">
                    	<div class="">
                			<h1>Que tal uma Pizza?</h1>
                			<h5 class="text-success">Não perca tempo! as melhores promoções do mercado</h5>
                			
                		</div>
                		
                    </div>
                    
                    <div class="aside1">
                    	<form action="listarProduto" method="get">
                           <button type="submit" name="tipo" value="Pizza" class="btn1">Comprar</button>
                        </form>
                    </div>
                	
                </div>
            <c:import url="rodape.jsp" />
        </div>
    </div>
</body>
</html>