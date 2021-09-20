var IdMateriaAsignada=[];
var direccionbase;
var materia;
var id;
var annio;
var nivel;
var especialidad;




$("#botonAsignar").click(function () {
  materia= $("#materia").val();
  annio= $("#annio").val();
  nivel= $("#nivel").val();
  especialidad= $("#especialidad").val();
 /* table = document.getElementById("tablematerias");
  rows = table.getElementsByTagName("tr");
  for (i = 1; i < rows.length; i++) {
    row = table.rows[i];
    row.onclick = function () {
      var cell = this.getElementsByTagName("td")[0];
      id=cell.innerHTML;
      var cell = this.getElementsByTagName("td")[2];
      materia=cell.innerHTML;
      var cell = this.getElementsByTagName("td")[3];
      annio=cell.innerHTML;
      var cell = this.getElementsByTagName("td")[4];
      nivel=cell.innerHTML;
      var cell = this.getElementsByTagName("td")[5];
      especialidad=cell.innerHTML;
    }
  }*/

  let htmlTags = '<tr>'+
      '<td>' + materia + '</td>'+
      '<td>' + annio + '</td>'+
      '<td>' + nivel + '</td>'+
      '<td>' + especialidad + '</td>'+
      '<td><a type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top"title="Eliminar" id="btnEliminar"><i class="bi bi-trash"></i></a></td>'+
    '</tr>';
    $('#tablemateriasasignadas tbody').append(htmlTags);  
    
  
    //IdMateriaAsignada.push(id);
  
}); 

//Setea los combos a blanco, oculta los textos establece estilos
$(document).ready(function () {
  $("#tipoDocPrf").val("");
  $("#sexoPrf").val("");
  $("#status").val("");
  $("#estadodirppalprf").val("");
  $("#edadPrf").val("");
  $("#edoCivilPrf").val("");
  $("#municipiodirppalprf").val("");
  $("#ciudaddirppalprf").val("");
  $("#parroquiadirppalprf").val("");
  $("#codpostaldirppalprf").val("");
  $("#estadodirsecprf").val("");
  $("#municipiodirsecprf").val("");
  $("#ciudaddirsecprf").val("");
  $("#parroquiadirsecprf").val("");
  $("#codpostaldirsecprf").val("");
  $("#codoperadorappalprf").val("");
  $("#codoperadorasecprf").val("");
  $("#pregrado1").val("");
   $("#pregrado2").val("");
   $("#materia").val("");
   $("#annio").val("");
   $("#nivel").val("");
   $("#especialidad").val("");
   
   
      /* $('#tablematerias').DataTable({        
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
        para usar los botones   
        responsive: "true",
        dom: 'Bfrtilp',       
        buttons:[ 
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
		]	        
    }); */

});

$(document).on('click', '#btnEliminar', function (event) {
  event.preventDefault();
  $(this).closest('tr').remove();
});

$("#btnLimpiar").click(function () {
  window.location.href = "/app/registroprofesor";
});