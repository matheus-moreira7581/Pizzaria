 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<nav id="homeinicio" class="navbar navbar-expand-lg text-white">
                

                <a href="index" class="nav-brand h1 mb-0 text-danger "><img style="width: 100px;" src="./img/coree.png" alt=""></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
                    <span class="navbar-toggler-icon"><img src=".//img/menuburguer.jpg"></span>
                </button>   

                <div class="collapse navbar-collapse" id="navbarSite">


                    <div class="input-group col-md-10 my-2 ">
					</div>
					<c:if test="${empty clienteLogado}">
					<a href="cadastro" class="btn text-success">Cadastrar</a>
					<a href="telaLogin" class="btn btn-success">Entrar</a>					
					</c:if>
					<c:if test="${not empty clienteLogado}">
						<a href="logoff" class="btn btn-success">Logoff</a>
					</c:if>
					
                    

                </div>

            </nav>