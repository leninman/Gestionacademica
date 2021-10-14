//let Cursos_prof={};   //objeto curso
//let cursos=[];//arreglo o lista de objetos curso
let idPrf=0;
let idmaterias=[];
let idcursos=[];
let direccionbase;

$(document).ready(function () {
    //$("#idCurso").val("");
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
                  "sLast":"Último",
                  "sNext":"Siguiente",
                  "sPrevious": "Anterior"
         },
         "sProcessing":"Procesando...",
          },
      //para usar los botones   
      responsive: "true",
      dom: 'Bfrtilp',       
      /*buttons:[ 
    {
      extend:    'excelHtml5',
      text:      '<i class="fas fa-file-excel"></i> ',
      titleAttr: 'Exportar a Excel',
      className: 'btn btn-success'
    },
    {
      extend:    'pdfHtml5',
      text:      '<i class="fas fa-file-pdf"></i> ',
      titleAttr: 'Exportar a PDF',
      className: 'btn btn-danger'
    },
    {
      extend:    'print',
      text:      '<i class="fa fa-print"></i> ',
      titleAttr: 'Imprimir',
      className: 'btn btn-info'
    },
  ]*/	        
  }); 






});

/*$("#idCurso").change(function () {
  direccionbase=$("#direccionbase").val();
  url=direccionbase+"/consultarcursoporid";	
    $.ajax({
        data: {
        idcurso: $("select[name=idCurso]").val(),
        },
        url: url,
        dataType: "json", //tipo de datos retornados
        type: "GET",
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
  });*/

  $("#botonBuscPrf").click(function () {
    direccionbase=$("#direccionbase").val();
    url=direccionbase+"/buscarProfesor";	
    $.ajax({
        data: {
          tdoc: $("select[name=tipoDocPrf]").val(),
          ndoc: $("input:text[name=numDocPrf]").val(),
        },
        url: url,
        dataType: "json", //tipo de datos retornados
        type: "GET",
      })
      .done(function (data) {
        $("#nombre").val(data["primNombPrf"]+" "+data["primApellPrf"]);
        $("#idPrf").val(data["idPrf"]);
       
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
      let htmlTags = '<tr>'+
      '<td>' + numCurso + '</td>'+
      '<td>' + annio + '</td>'+
      '<td>' + seccion + '</td>'+
      '<td>' + asignatura + '</td>'+
      '<td><a type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top"title="Eliminar" id="btnEliminar"><i class="bi bi-trash"></i></a></td>'+
    '</tr>';
    $('#tablemateriasasignadas tbody').append(htmlTags);

    idPrf=$("#idPrf").val();

    /*Cursos_prof={
      "idCurso":numCurso,
      "idMat":idmat,
      "idProf":idPrf
    }*/

    idcursos.push(numCurso);
    idmaterias.push(idmat);

   // console.log(cursos);


    //idCursos.push(numCurso); 
   // idMaterias.push(idmat);
    
    $(this).closest('tr').remove();

    }
  }

  $(document).on('click', '#btnEliminar', function (event) {
    event.preventDefault();
    $(this).closest('tr').remove();
});



  /*let numCurso=$("#idAlumno").val()
  let annio=$("#tipoDocAl").val()+$("#numDocAl").val();
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
    $("#nombre").val("");*/
    //cedulas.push(cedula);
   
}

/*$("#botonAsignar").click(function () {
    let numAlumno=$("#idAlumno").val()
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
     
    
      
}); */

/*$(document).on('click', '#btnEliminar', function (event) {
    event.preventDefault();
    $(this).closest('tr').remove();
});*/

$("#guardar").click(function () {
  direccionbase=$("#direccionbase").val();
  url=direccionbase+"/asignarmateriasycursos";
  
    $.ajax({
      
        data: {
          
          idcursos: idcursos,
          idmaterias:idmaterias,
          idprofesor:idPrf


        },
        
       
        
        url: url,
        dataType: "json", //tipo de datos retornados
        type: "POST",
        contentType : "application/x-www-form-urlencoded",
        
      })
      .done(function () {
        
      		alert("EL CURSO HA SIDO CARGADO CORRECTAMENTE");
       
      })
      .fail(function (data) {
        console.log(data);
      });
});





