let direccionbase;
var token;
var tipodocumento;
var numerocedula;
var tipousuario;


$(document).ready(function () {
	 token = $("meta[name='_csrf']").attr("content");
	 //direccionbase=$("#direccionbase").val();
	 direccionbase="http://localhost:8090/app";
     tipodocumento=$("#tipodocumento").val();
     numerocedula=$("#numerocedula").val();
     tipousuario=$("#tipousuario").val();
	
	
});



$("#btnBuscarPersona").click(function () {
  	
  url=direccionbase+"/consultarpersona";
  tipodocumento=$("#tipodocumento").val();
  numerocedula=$("#numerocedula").val();
  tipousuario=$("#tipousuario").val();	

  $.ajax({
      data: {
        tipodoc: tipodocumento,
        numdoc: numerocedula,
        tipousuario: tipousuario

      },
      url:url,
 	  headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
      dataType: "json", //tipo de datos retornados
      type: "GET"
    })
    .done(function (data) {
    
      console.log(data);

      //$("#primNombRpr1").val(data["primNombRpr"]);
    
    })
    .fail(function (data) {
      alert("La persona no se encuentra registrada");
    });
});

$('#alert1').fadeIn();     
  setTimeout(function() {
       $("#alert1").fadeOut();           
  },2000);
  
  $('#alert2').fadeIn();     
  setTimeout(function() {
       $("#alert2").fadeOut();           
  },2000);

 $('#alertsesionconexito').fadeIn();     
  setTimeout(function() {
       $("#alertsesionconexito").fadeOut();           
  },2000);












/*let idPrf = 0;
let idmaterias = [];
let idcursos = [];
let direccionbase;
var token;




$(document).ready(function () {
  token = $("meta[name='_csrf']").attr("content");
  $("#tipoDocPrf").val("");
  $('#tablemateriasdisponibles').DataTable({
    language: {
      "lengthMenu": "",
      "zeroRecords": "No se encontraron resultados",
      "info": "",
      "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
      "infoFiltered": "",
      "sSearch": "Buscar:",
      "oPaginate": {
        "sFirst": "Primero",
        "sLast": "Último",
        "sNext": "Siguiente",
        "sPrevious": "Anterior"
      },
      "sProcessing": "Procesando...",
    },
    responsive: "true",
    dom: 'Bfrtilp',
  });
});


$("#botonBuscPrf").click(function () {
  direccionbase = $("#direccionbase").val();
  url = direccionbase + "/buscarProfesor";
 
  
  $.ajax({
      data: {
        tdoc: $("select[name=tipoDocPrf]").val(),
        ndoc: $("input:text[name=numDocPrf]").val(),
      },
      url: url,
 	  headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
      dataType: "json", //tipo de datos retornados
      type: "GET",
    })
    .done(function (data) {
      $("#nombre").val(data["primNombPrf"] + " " + data["primApellPrf"]);
      $("#idPrf").val(data["idPrf"]);
      idPrf = $("#idPrf").val();

    })
    .fail(function (data) {
      alert("El profesor no se encuentra registrado");
      $("#tipoDocPrf").val("");
      $("#numDocPrf").val("");
      $("#nombre").val("");
    });

});


function asignarmateria() {

  table = document.getElementById("tablemateriasdisponibles");
  rows = table.getElementsByTagName("tr");


  for (i = 1; i < rows.length; i++) {
    row = table.rows[i];
    row.onclick = function () {
      var cell = this.getElementsByTagName("td")[0];
      var idmat = cell.innerHTML;
      var cell = this.getElementsByTagName("td")[1];
      var numCurso = cell.innerHTML;
      var cell = this.getElementsByTagName("td")[2];
      var annio = cell.innerHTML;
      var cell = this.getElementsByTagName("td")[3];
      var seccion = cell.innerHTML;
      var cell = this.getElementsByTagName("td")[6];
      var asignatura = cell.innerHTML;
      let htmlTags = '<tr>' +
        '<td>' + numCurso + '</td>' +
        '<td>' + annio + '</td>' +
        '<td>' + seccion + '</td>' +
        '<td>' + asignatura + '</td>' +
        '<td><a type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top"title="Eliminar" id="btnEliminar"><i class="bi bi-trash"></i></a></td>' +
        '</tr>';
      $('#tablemateriasasignadas tbody').append(htmlTags);
      idcursos.push(numCurso);
      idmaterias.push(idmat);
      $(this).closest('tr').remove();
    }
  }

  $(document).on('click', '#btnEliminar', function (event) {
    event.preventDefault();
    $(this).closest('tr').remove();
  });

}

$("#guardar").click(function () {
  direccionbase = $("#direccionbase").val();
  url = direccionbase + "/asignarmateriasycursos";
  
  $.ajax({
      data: {
        idcursos: idcursos,
        idmaterias: idmaterias,
        idprofesor: idPrf
      },
      url: url,
      headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
      dataType: "json", //tipo de datos retornados
      type: "POST",
      contentType: "application/x-www-form-urlencoded",
      success: function (json) {
        alert("EL CURSO HA SIDO ASIGNADO CORRECTAMENTE");
        window.location.href = direccionbase + "/cursosmateriasasignadas";
      }
    })
    .done(function () {
    })
    .fail(function (data) {
      console.log(data);
    });
});*/