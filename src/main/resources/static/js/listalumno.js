
$(document).ready(function () {
  

    $('#tablaAlumnos').DataTable({        
        language: {
                "lengthMenu": "Mostrar _MENU_ registros",
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