let cedulas=[];
let idCurso=0;
let direccionbase;

var token;

$(document).ready(function () {
	token = $("meta[name='_csrf']").attr("content");
    $("#idCurso").val("");
    $("#tipoDocAl").val("");
});

$("#idCurso").change(function () {
  direccionbase=$("#direccionbase").val();
  url=direccionbase+"/consultarcursoporid";	
    $.ajax({
        data: {
        idcurso: $("select[name=idCurso]").val()
        },
        url: url,
        dataType: "json", //tipo de datos retornados
        type: "GET"
      })
      .done(function (data) {
          
        $("#annio").val(data["annio"]);
        $("#annioescolar").val(data["intAnnioEsc"]);
        $("#seccion").val(data["seccion"]);
        $("#turno").val(data["turno"]);
        $("#nivel").val(data["nivel"]);
        $("#especialidad").val(data["especialidad"]);
      })
      .fail(function (data) {
        alert("El curso no existe o no esta activo");
      });
      idCurso=$("select[name=idCurso]").val();
  });

  $("#botonBuscAl").click(function () {
    direccionbase=$("#direccionbase").val();
    url=direccionbase+"/consultaAlumno";	
    $.ajax({
        data: {
          tdoc: $("select[name=tipoDocAl]").val(),
          ndoc: $("input:text[name=numDocAl]").val()
        },
        url: url,
        dataType: "json", //tipo de datos retornados
        type: "GET"
      })
      .done(function (data) {
        $("#nombre").val(data["primNombAl"]+" "+data["primApellAl"]);
        $("#idAlumno").val(data["idAl"]);
       
      })
      .fail(function (data) {
        alert("El alumno no se encuentra registrado");
        $("#tipoDocAl").val("");
        $("#numDocAl").val("");
      });

});

$("#botonAsignar").click(function () {
    let numAlumno=$("#idAlumno").val();
    let cedula=$("#tipoDocAl").val()+$("#numDocAl").val();
    let nombre=$("#nombre").val();
    let htmlTags = '<tr>'+
        '<td>' + numAlumno + '</td>'+
        '<td>' + cedula + '</td>'+
        '<td>' + nombre + '</td>'+
        '<td><a type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top"title="Eliminar" id="btnEliminar"><i class="bi bi-trash"></i></a></td>'+
      '</tr>';
      $('#tablealumnosinscritos tbody').append(htmlTags);  
      $("#tipoDocAl").val("");
      $("#numDocAl").val("");
      $("#nombre").val("");
      cedulas.push(cedula);
     
    
      
}); 

$(document).on('click', '#btnEliminar', function (event) {
    event.preventDefault();
    $(this).closest('tr').remove();
});

$("#guardar").click(function () {
  direccionbase=$("#direccionbase").val();
  url=direccionbase+"/actualizaridalumnos";
    $.ajax({
        data: {
            idcurso: idCurso,  
            cedulasAlumnos: cedulas
        },
        url: url,
		headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
        dataType: "json", //tipo de datos retornados
        type: "POST",
		success: function (json) {
        alert("EL CURSO HA SIDO CARGADO CORRECTAMENTE");
        window.location.href = direccionbase + "/listarcursos";
      }
      })
      .done(function () {
      })
      .fail(function (data) {
         
      });
});





