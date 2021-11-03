var direccionbase;
var materia;
var id;
var annio;
var nivel;
var especialidad;
var Ids=[];




$("#btnLimpiar").click(function () {
  window.location.href = "/app/registroprofesor";
});

/*$(document).on('click', '#btnEliminar', function (event) {
  event.preventDefault();
  $(this).closest('tr').remove();
});*/


/*$("#botonAsignar").click(function () {
  materia = $("#materia").val();
  annio = $("#annio").val();
  nivel = $("#nivel").val();
  especialidad = $("#especialidad").val();
  direccionbase = $("#direccionbase").val();
  url = direccionbase + "/validarmateria";
  
  $.ajax({
      data: {
        materia: $("select[name=materia]").val(),
        annio: $("select[name=annio]").val(),
        nivel: $("select[name=nivel]").val(),
        especialidad: $("select[name=especialidad]").val(),
      },
      url: url,
      type: "GET",
    })
    .done(function (response) {
      if (response != '') {
        let htmlTags = '<tr>' +
          '<td>' + materia + '</td>' +
          '<td>' + annio + '</td>' +
          '<td>' + nivel + '</td>' +
          '<td>' + especialidad + '</td>' +
          '<td><a type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top"title="Eliminar" id="btnEliminar"><i class="bi bi-trash"></i></a></td>' +
          '</tr>';
        $('#tablemateriasasignadas tbody').append(htmlTags);
        Ids.push(response);
      } else {
        alert('NO EXISTE MATERIA CON ESTOS PARÁMETROS');
      }
    });
 
});*/

/*function mostrardatosacademicospostgrados() {
  element = document.getElementById("datosAcademicosPostgrados");
  if (element.style.display == "none") {
    element.style.display = "block";
  } else {
    element.style.display = "none";
  }
}*/


//Setea los combos a blanco, oculta los textos establece estilos
$(document).ready(function () {
	
 //$('form select').val("");

});

