let direccionbase;


$(document).ready(function () {
	
	$('form input[type="text"]').prop("disabled", true);

  $('form select').prop("disabled", true);

  $('form input[type="email"]').prop("disabled", true);

  $('form input[type="date"]').prop("disabled", true);

  $("#guardar").prop('disabled',true);
	
	
});



$("#botonEditarProfesor").click(function () {

  $('form input[type="text"]').prop("disabled", false);

  $('form select').prop("disabled", false);

  $('form input[type="email"]').prop("disabled", false);

  $('form input[type="date"]').prop("disabled", false);

  $("#guardar").prop('disabled',false);

});
 
 





