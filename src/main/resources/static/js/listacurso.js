
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