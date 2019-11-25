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
 	<script defer src="js/jquery-3.4.1.min.js" ></script>
    <script defer src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script defer src="js/function.js" ></script>
    <script defer src="js/bootstrap.min.js"></script>


    <title>Cadastro</title>
</head>
<body>

     <div class="pai">

        <div class="corpo">

            <nav class="navbar navbar-expand-lg navbar-light">
                

                <a href="index.html" class="nav-brand h1 mb-0 text-success "><img style="width: 100px;" src="./img/coree.png" alt=""></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
                    <span class="navbar-toggler-icon"></span>
                </button>   

                <div class="collapse navbar-collapse" id="navbarSite">

                    <div class="input-group col-md-10 my-2 ">



                    </div>
					<form action="index">
                    	<button class="btn text-success">Voltar</button>
                    </form>
                    <a href="login.html"><button class="btn btn-outline-success">Entrar</button></a>

                </div>

            </nav>

            <hr>
            <hr>
            <hr>
            <hr>

            <form action="cadastrarCliente" method="post">
              <h1>Cadastro</h1>
                    <div class="form-row">

                      <div class="col-md-4 mb-3">
                        <label for="validationDefault01">Nome</label>
                        <input type="text" class="form-control" name="nome" id="validationDefault01" placeholder="Digite seu nome" required>
                      </div>

                      <div class="col-md-4 mb-3">
                        <label for="validationDefault02">Sobrenome</label>
                        <input type="text" class="form-control" name="sobrenome" id="validationDefault02" placeholder="Digite seu sobrenome" required>
                      </div>

                      <div class="col-md-4 mb-3">
                        <label for="validationDefaultUsername">Email</label>
                        
                        <div class="input-group">
                          <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroupPrepend2">@</span>
                          </div>

                          <input type="text" class="form-control" name="email" id="validationDefaultUsername" placeholder="Email" aria-describedby="inputGroupPrepend2" required>
                        </div>

                      </div>

                    </div>

                    <div class="form-row">

                      <div class="col-md-6 mb-3">
                        <label for="validationDefault03">Bairro</label>
                        <input type="text" class="form-control" name="bairro" id="validationDefault03" placeholder="Bairro.." required>
                      </div>

                      <div class="col-md-3 mb-3">

                        <label for="validationDefault04">Endereco</label>
                        <input type="text" class="form-control" name="endereco" id="validationDefault04" placeholder="Endereco.." required>
                      </div>

                      <div class="col-md-3 mb-3">
                        <label for="validationDefault05">Numero</label>
                        <input type="number" class="form-control" name="numCasa" id="validationDefault05" placeholder="Numero.." required>
                      </div>

                    </div>

                    <div class="form-row">
                      <div class="col-md-6 mb-3">
                        <label for="validationDefault05">Senha</label>
                        <input type="password" class="form-control" name="senha" id="password01" placeholder="Senha.." required>
                        <input type="hidden" name="deletado" value="nao">
                      </div>
                      
                       <div class="col-md-6 mb-3" id="password02-container">
                        <label for="validationDefault05">Confirmar Senha</label>
                        <input type="password" class="form-control" id="password02" placeholder="Senha.." required>
                      </div>
                      
                    </div>
					
					<div class="form-row">
						<div class="col-md-6 mb-3" id="cpf-container">
							<label for="validadetionDefault06">CPF</label>
							<input type="text" class="form-control" name=cpf id="cpf" required>
						</div>
					</div>
                  


                    <button class="btn btn-success" type="submit" id="submit-cadastro" disabled="disabled">Criar Conta</button>
                   

                  </form>
        </div>

    </div>

</body>
</html>