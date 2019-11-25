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
            <hr>
            <hr>
                <!-- Carousel -->
            <div id="corouselSite" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#corouselSite" data-slide-to="0" class="active bg-success"></li>
                        <li data-target="#corouselSite" data-slide-to="1" class="bg-danger"></li>
                        <li data-target="#corouselSite" data-slide-to="2" class="bg-danger"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="./img/pizzaaaa.jpg" class="img-fluid d-block " style="filter: blur(1px)" alt="...">
                            <div class="carousel-caption">
                                <h1 style="font-size: 50px;">Tem Pizza!!</h1>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#corouselSite" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon " aria-hidden="true"></span>
                        <span class="sr-only">Anterior</span>
                    </a>
                    <a class="carousel-control-next" href="#corouselSite" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Próximo</span>
                    </a>
            </div>
            <hr>
            <hr><hr>
                <div class="card-group col-md-8">
                    <div class="row my-5">
                        <h1> <strong>Ta com fome? Porque a hora é agora!</strong> </h1>
                    </div>
                    <div class="row mll" style="margin-left: 20px;">
                        <div class="jumbotron fundo-bcg">
                            <h1 class="display-4">Que tal uma Pizza?</h1>
                            <p class="lead">Nossa pizzas são uma ótima escolha para você afinal são exageradamente recheadas e com um gosto único e um toque especial para você querer voltar sempre!!</p>
                            <hr class="my-4">
                            <p>Nosso ingredientes são nosso carro chefe! Por isso é confidencial!</p>
                           <!-- <form action="listarProduto" method="get">
                            	<button type="submit" name="tipo" value="Pizza" class="btn btn-success btn-lg">Comprar</button>
                            </form>
                             --> 
                              <a class="btn btn-success btn-lg" href="listarProduto?tipo=Pizza">Comprar</a>
                        </div>
                    </div>
                    <div class="row my-3" style="margin-left: 20px;">
                        <div class="jumbotron fundo-bcg0">
                            <h1 class="display-4">Talvez um Hamburguer?</h1>
                            <p class="lead">Nossa pizzas são uma ótima escolha para você afinal são exageradamente recheadas e com um gosto único e um toque especial para você querer voltar sempre!!</p>
                            <hr class="my-4">
                            <p>Nosso ingredientes são nosso carro chefe! Por isso é confidencial!</p>
                           <!-- <form action="listarProduto" method="get">
                            	<button type="submit" name="tipo" class="btn btn-success btn-lg" value="Hamburguer">Comprar</button>
                            </form> --> 
                            <a class="btn btn-success btn-lg" href="listarProduto?tipo=Hamburguer">Comprar</a>
                        </div>
                    </div>
            </div>
            <c:import url="rodape.jsp" />
        </div>
    </div>
</body>
</html>