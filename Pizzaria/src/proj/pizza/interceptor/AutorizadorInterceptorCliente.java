package proj.pizza.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptorCliente extends HandlerInterceptorAdapter{
	private String uri;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		uri = request.getRequestURI();

		

		if(uri.endsWith("login") || uri.endsWith("validar_login") || uri.endsWith("loginAdmin") || uri.endsWith("adminProduto") 
				|| uri.endsWith("novoProduto") || uri.endsWith("listarProduto") || uri.endsWith("atualizarProduto") 
				|| uri.endsWith("atualizarUmProduto") || uri.endsWith("cadastrarProduto") || uri.endsWith("excluirProduto") 
				|| uri.endsWith("adminCliente") || uri.endsWith("validar_login_admin") || uri.endsWith("atualizarCliente") 
				|| uri.endsWith("atualizarUmCliente") || uri.endsWith("excluirCliente") || uri.endsWith("admin_logoff") 
				|| uri.endsWith("cadastro") || uri.endsWith("cadastrarCliente") || uri.endsWith("index") 
				|| uri.contains("css") || uri.contains("js") || uri.contains("img") || uri.contains("rest")) {
			return true;
		}

		if(request.getSession().getAttribute("clienteLogado") !=null) {
			return true;
		}
		response.sendRedirect("login");
		return false;
	}
}
