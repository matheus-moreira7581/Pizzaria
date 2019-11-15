 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	           <nav id="homeinicio" class="navbar navbar-expand-lg navbar-light">
                <a href="index" class="nav-brand h1 mb-0 text-danger "><img style="width: 100px;" src="./img/coree.png" alt=""></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
                    <span class="navbar-toggler-icon"></span>
                </button>   
                <div class="collapse navbar-collapse" id="navbarSite">
                    <div class="input-group col-md-9 my-2 ">
                    </div>
					<form action="adminProduto" method="get">
						<button type="submit" class="btn btn-success">Produtos</button>
						<button type="submit" class="btn btn-success" formaction="adminCliente">Cliente</button>
						<button type="submit" class="btn btn-success" formaction="admin_logoff" >Logoff</button>
					</form>
                </div>
            </nav>