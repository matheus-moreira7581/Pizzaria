package proj.pizza.controller;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String errorPage(Exception e, Model model) {
		String ex = new String();
//		if (e.getMessage() == "No entity found for query") {
//			ex = "Os dados digitados nao foram encontrados";
//		}
		switch (e.getMessage()) {
			case "No entity found for query":
				ex = "Os dados digitado nao foram encontrado";
				break;
			case "could not execute statement; SQL [n/a]; constraint [null]; nested exception is "
					+ "org.hibernate.exception.ConstraintViolationException: could not execute statement":
				ex = "Não foi possivel deletar";
				break;
		}
		model.addAttribute("erro", ex);
		e.printStackTrace();
		System.out.println("A mensagem de erro é: " + e.getMessage());
		return "Erro";
	}
	
//	@RequestMapping("ErroCheck")
//	public String errorCheck(@ModelAttribute("e") Exception e, Model model) {
//		String ex = new String();
//		if (e.getMessage() == "No entity found for query") {
//			ex = "Os dados digitados nao foram encontrados";
//		}
//		model.addAttribute("erro", ex);
//		e.printStackTrace();
//		return "Erro";
//	}
}
