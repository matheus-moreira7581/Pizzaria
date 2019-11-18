$(document).ready(function () {
	$("#password01").keyup(validate);
	$("#password02").keyup(validate);
	$("#cpf").keyup(validate);
});

function validate() {
	var cpfv = validateCPF();
	var passv = checkPasswordMatch();
	if(cpfv == true && passv == true ) {
		$('#submit-cadastro').prop('disabled', false);
	}
}

function validateCPF() {
	var cpf = $("#cpf").val();
	var re = /^([0-9]{3}[\.]?[-]?[0-9]{3}[\.]?[-]?[0-9]{3}[-]?[0-9]{2})*$/;
	var is_valid = re.test(cpf);
	if (!is_valid || cpf.length == 0) {
		if(!$("#ValidateCPF").lenght) {
    		$("#ValidateCPF").remove();
    	}
    	$("<div class='col-md-6 mb-3' id='ValidateCPF'>CPF Invalido</div>").insertAfter("#cpf-container");
    	$('#submit-cadastro').prop('disabled', true);
    	return false
	}
	else {
		$("#ValidateCPF").remove();
		//$('#submit-cadastro').prop('disabled', false);
		return true
	}
	
}

function checkPasswordMatch() {
    var password = $("#password01").val();
    var confirmPassword = $("#password02").val();

    if (password != confirmPassword || password == 0 || confirmPassword == 0) {
    	if(!$("#divCheckPasswordMatch").lenght) {
    		$("#divCheckPasswordMatch").remove();
    	}
    	$("<div class='col-md-6 mb-3' id='divCheckPasswordMatch'>Senha sao diferentes</div>").insertAfter("#password02-container");
    	$('#submit-cadastro').prop('disabled', true);
    	return false;
    }
    else {
    	$("#divCheckPasswordMatch").remove();
    	//$('#submit-cadastro').prop('disabled', false);
    	return true
    }
    
}