<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Darker+Grotesque:300,400,500,600,700,800,900$display=swap">


<!-- css -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">

<!-- js -->

<script defer src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script defer
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>

<script defer src="js/bootstrap.min.js"></script>


<title>Atualizar Produto</title>
</head>
<body>

	<div class="pai">

		<div class="corpo">

			<nav class="navbar navbar-expand-lg navbar-light">


				<a href="index.html" class="nav-brand h1 mb-0 text-success "><img
					style="width: 100px;" src="./img/coree.png" alt=""></a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSite">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSite">


					<div class="input-group col-md-10 my-2 "></div>

					<form action="adminProduto">
						<button class="btn text-success">Voltar</button>
						<button class="btn btn-outline-success" formaction="admin_logoff">Logoff</button>
					</form>

				</div>

			</nav>

			<hr>

			<form action="atualizarUmProduto" method="post" id="atualizar" enctype="multipart/form-data">

				<h1>Atulizar Produto</h1>
				<hr>
				<div class="form-row">
					<div class="col-md-4 mb-3">
						<label for="validationDefault01">Codigo</label> 
						<input type="text"
							class="form-control" name="codigo" id="validationDefault01"
							value="${produtos.codigo}" readonly>
					</div>
				</div>
				<div class="form-row">

					<div class="col-md-4 mb-6">
						<label for="validationDefault01">Nome</label> 
						<input type="text"
							class="form-control" name="nome" id="validationDefault01"
							value="${produtos.nome}" required>
					</div>
					<div class="col-md-2 mb-5">
						<label for="validationDefaultUsername">Preço</label>
						<div class="input-group">
							<input type="text" class="form-control"
								id="validationDefaultUsername" name="preco"
								value="${produtos.preco}" aria-describedby="inputGroupPrepend2"
								required>
						</div>
					</div>
					<div class="col-md-2 mb-6">
						<label for="validationDefault01">Tipo:</label> <select
							class="form-control" name="tipo" form="atualizar">
							<option value="${produtos.tipo}" selected>${produtos.tipo}</option>
							<c:if test="${produtos.tipo == 'Pizza'}">
								<option value="Hamburguer">Hamburguer</option>
							</c:if>

							<c:if test="${produtos.tipo != 'Pizza'}">
								<option value="Pizza">Pizza</option>
							</c:if>
						</select>
					</div>
					<div class="col-md-2 mb-3">
						<label>Desconto</label> <input type="text" class="form-control"
							id="validationDefaultUsername" name="desconto"
							aria-describedby="inputGroupPrepend2" value="${produtos.desconto}" required>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-12 mb-3">
						<label for="validationDefault02">descricao</label>
						<textarea class="form-control" name="descricao"
							id="validationDefault02" required>${produtos.descricao}</textarea>
					</div>
				</div>

				<div class="form-row">
					<div class="col-md-12 mb-3">
						<label for="validationDefaultUsername">Foto do Produto</label>
						<div class="input-group">
							<input type="file" class="form-control"
								id="validationDefaultUsername" name="foto"
								aria-describedby="inputGroupPrepend2"">
						</div>
					</div>
				</div>
				
				<button class="btn btn-success" type="submit">Atualizar</button>
			</form>



		</div>

	</div>

</body>
</html>