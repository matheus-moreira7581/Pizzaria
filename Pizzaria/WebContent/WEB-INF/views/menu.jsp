 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<nav id="homeinicio" class="navbar navbar-expand-lg navbar-light">
                

                <a href="index" class="nav-brand h1 mb-0 text-danger "><img style="width: 100px;" src="./img/coree.png" alt=""></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
                    <span class="navbar-toggler-icon"></span>
                </button>   

                <div class="collapse navbar-collapse" id="navbarSite">


                    <div class="input-group col-md-10 my-2 ">

                        <div class="input-group-prepend navbar-item ">
                            
                        <button class="btn btn-success  border-success input-group-text" id="basic-addon1"><img src="https://img.icons8.com/material-rounded/24/000000/search.png"></button>

                        </div>

                        <input type="text" class="form-control col-md-6" placeholder="Search for Products, Brands and More.." aria-label="Username" aria-describedby="basic-addon1">

                    </div>
					<c:if test="${empty clienteLogado}">
					<a href="cadastro" class="btn text-sucess">Cadastrar</a>
					<a href="telaLogin" class="btn btn-success">Entrar</a>					
					</c:if>
					<c:if test="${not empty clienteLogado}">
						<a href="logoff" class="btn btn-success">Logoff</a>
					</c:if>
					
                    

                </div>

            </nav>