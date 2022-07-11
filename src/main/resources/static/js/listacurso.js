let mensajerespuesta;
let codigorespuesta;
let direccionbase;
let url;
let idCurso;

$(document).ready(function () {
  

    $('#tablecursos').DataTable({        
        language: {
                "lengthMenu": "",
                "zeroRecords": "No se encontraron resultados",
                "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sSearch": "Buscar:",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast":"Último",
                    "sNext":"Siguiente",
                    "sPrevious": "Anterior"
			     },
			     "sProcessing":"Procesando..."
                             
            },
        //para usar los botones   
        responsive: "true",
        dom: 'Bfrtilp'       
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

class CursoDTO {
  constructor(idCurso, idAnnio, idSec, idAnnioEsc, idTurno, annio, intAnnioEsc, seccion, turno, nivel, especialidad) {
    this.idCurso = idCurso;
    this.idAnnio = idAnnio;
    this.idSec = idSec;
    this.idAnnioEsc = idAnnioEsc;
    this.idTurno = idTurno;
    this.annio = annio;
    this.intAnnioEsc = intAnnioEsc;
    this.seccion = seccion;
    this.turno = turno;
    this.nivel = nivel;
    this.especialidad = especialidad;

  }

 
}


$('#btncerrarregistrarcurso').click(function() {
  $('#Registro').modal('hide');
});



$("#crearCurso").click(function () {
   direccionbase=$("#direccionbase").val();
   url=direccionbase+"/crearCurso";
  let annio = $('#Annio').val();
  let intAnnioEsc = $('#intAnnioEsc').val();
  let seccion = $('#Seccion').val();
  let turno = $('#Turno').val();
  let nivel = $('#Nivel').val();
 

  cursoDTO = new CursoDTO(0,0,0,0,0,annio,intAnnioEsc,seccion,turno,nivel,'');



    $.ajax({
      data: JSON.stringify(cursoDTO),     
      url: url,
		  headers: {"X-CSRF-TOKEN": token,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
      }, 
      dataType: "json", //tipo de datos retornados
      type: "POST",
		  success: function (response) {
      
        mensajerespuesta=response["responseDescription"];
        codigorespuesta=response["responseCode"];
        $('#modalcursoregistrado').modal({ backdrop: 'static', keyboard: false });
        $("#modalcursoregistrado").modal("show");
        $("#parrafomodalcursoregistrado").html(mensajerespuesta);
        if(codigorespuesta===104){
          $("#Registro").modal('hide');
        }
        $("#btnCursoRegistrado").focus();
      
      }
      })
      .done(function (response) {
      })
      .fail(function (response) {
         
      });
});


$("#btnCursoRegistrado").click(function () {
  $("#modalcursoregistrado").modal('hide');
  if(codigorespuesta===104){
   
    window.location.href = direccionbase + "/listarcursos";
  }
});


/*$("#eliminarCurso").click(function() {
  let fila=$(this).closest("tr");
  idCurso=fila.find("#idCurso").html();
  
  $("#nomAlumno").val(nombreAlumno);
  $("#cedAlumno").val(cedulaAlumno);
  $("#notaprimerlapso").val(nota1);
  $("#notasegundolapso").val(nota2);
  $("#notatercerlapso").val(nota3);
  $('#modaldetallenotasalumno').modal({ backdrop: 'static', keyboard: false });
  $("#modaldetallenotasalumno").modal("show");

});*/


$("#eliminarCurso").click(function () {
  let fila=$(this).closest("tr");
  idCurso=fila.find("#idCurso").html();

  $.ajax({
    data: {
      idCurso: idCurso,
    },     
    url: url,
    headers: {"X-CSRF-TOKEN": token,
    }, 
    dataType: "json", //tipo de datos retornados
    type: "DELETE",
    success: function (response) {
    
      mensajerespuesta=response["responseDescription"];
      codigorespuesta=response["responseCode"];
      $('#modalcursoeliminado').modal({ backdrop: 'static', keyboard: false });
      $("#modalcursoeliminado").modal("show");
      $("#parrafomodalcursoeliminado").html(mensajerespuesta);
      $("#btnCursoEliminado").focus();
    
    }
    })
});


$('#registrarCurso').click(function () {
  $('#Registro').modal({backdrop: 'static', keyboard: false});
  $('#Registro').modal('show');
});

$('#mensaje3').fadeIn();
  setTimeout(function() {
       $("#mensaje3").fadeOut();
  },2000);

$('#mensaje6').fadeIn();
   setTimeout(function() {
        $("#mensaje6").fadeOut();
   },2000);

$('#mensaje7').fadeIn();
    setTimeout(function() {
    $("#mensaje7").fadeOut();
    },2000);

$('#mensaje8').fadeIn();
  setTimeout(function() {
       $("#mensaje8").fadeOut();
  },2000);

$('#mensaje9').fadeIn();
  setTimeout(function() {
       $("#mensaje9").fadeOut();
  },2000);

$('#mensaje4').fadeIn();
  setTimeout(function() {
       $("#mensaje4").fadeOut();
  },2000);

$('#mensaje12').fadeIn();
  setTimeout(function() {
       $("#mensaje12").fadeOut();
  },2000);

$('#mensaje29').fadeIn();
  setTimeout(function() {
       $("#mensaje29").fadeOut();
  },2000);

$('#mensaje30').fadeIn();
  setTimeout(function() {
       $("#mensaje30").fadeOut();
  },2000);


































/*var d = '<tr>' +
    '<th>NUMERO DEL ALUMNO</th>' +
    '<th>CEDULA</th>' +
    '<th>NOMBRE Y APELLIDO</th>' +
    '<th>AÑO QUE CURSA</th>' +
    '<th>SECCION</th>' +
    '<th></th>'
'</tr>';*/





/*$("#buscarAlumno").click(function () {
    $.ajax({
            data: {
                tdoc: $("select[name=inputTipoDoc]").val(),
                ndoc: $("input:text[name=inputNumeroDeCedula]").val(),
            },
            url: "http://localhost:8080/app/consultaralumno",
            dataType: 'json',
            type: "GET"
     
            
        })
        .done(function (data) {
            //table = $("#tablaAlumnos");
            //console.log(data["idAl"]);
            //console.log(table);
            //row=$("#dataRow");
            // console.log(row);

            d += '<tr>' +
                '<td>' + data["idAl"] + '</td>' +
                '<td>' + data["tipoDocAl"] + data["numDocAl"] + '</td>' +
                '<td>' + data["primNombAl"] + ' ' + data["primApellAl"] + '</td>' +
                '<td>' + data["annio"] + '</td>' +
                '<td>' + data["seccion"] + '</td>' +
                '</tr>';



            $("#tablaAlumnos").append(d);




        })
        .fail(function (data) {
            alert("El alumno no se encuentra registrado");
        });

});*/


/*$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/app/consultarcursosporperiodo",
        dataType: 'json', //tipo de datos retornados
        type: "GET"
    }).done(function (data) {

        


    });

});*/