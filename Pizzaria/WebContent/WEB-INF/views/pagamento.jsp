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

    <title>Home</title>
</head>
<body>
     <div class="pai">
        <div class="corpo">
            <c:import url="menu.jsp" />
            <hr>
            <hr>
            <hr>
            <hr>
            <h1>Escolha uma forma de pagamento</h1>
            <hr>
            <form class="pagamento bg-success text-white" action="confirmacao" method="post">
                <div class="pag">
                    <label for="credito">Crédito/Débito</label>
                    <input type="radio" name="formaPagamento" value="Cartao" id="credito">
                </div>
                <div class="pag">
                    <label for="dinheiro">Dinheiro</label>
                    <input type="radio" name="formaPagamento" value="Dinheiro" id="dinheiro">
                </div>
				<div class="tema row bg-dark w-50"><h1 class="text-white">Endereço de entrega</h1></div>
				<div class="form-row my-3">
                    <div class="col-md-3 mb-3">
                      <label for="validationDefault03">Bairro</label>
                      <input type="text" class="form-control" name="bairro" id="validationDefault03" value="${clienteLogado.bairro }" required>
                    </div>
                    <div class="col-md-7 mb-3">
                      <label for="validationDefault04">Endereco</label>
                      <input type="text" class="form-control" name="endereco" id="validationDefault04" value="${clienteLogado.endereco }" required>
                    </div>
                    <div class="col-md-2 mb-3">
                      <label for="validationDefault05">Numero</label>
                      <input type="number" class="form-control" name="numCasa" id="validationDefault05" value="${clienteLogado.numCasa}" required>
                    </div>
                       <button class="btn btn-primary" type="submit">Confirmar</button>
                 </div>
            </form>
            <hr>
            <hr>
            <hr>
            <hr>
        </div>
    </div>
</body>
</html>