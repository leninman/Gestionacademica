
let token;
let idAl;




$(document).ready(function () {
  token = $("meta[name='_csrf']").attr("content");

  $('.editar').prop('disabled', true);
  $('.editar').css('background-color', '#E5D9D7');
  $('.confirmar').prop('disabled', false);
  $('#lapsoconsulta').hide();
  $('#tablenotascontainer').hide();




  /* $('#tablenotas').DataTable({
    
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
 });  */
});

class Alumno {
  constructor(idAlumno, cedulaAlumno, nombreAlumno, nota) {
    this.idAlumno = idAlumno;
    this.cedulaAlumno = cedulaAlumno;
    this.nombreAlumno = nombreAlumno;
    this.nota = nota;
  }
}
class NotasParDTO {
  constructor(idAlumno, idCurso, idLapso, idMat, idPrf, tipoDeCarga, nota) {
    this.idAlumno = idAlumno;
    this.idCurso = idCurso;
    this.idLapso = idLapso;
    this.idMat = idMat;
    this.idPrf = idPrf;
    this.tipoDeCarga = tipoDeCarga;
    this.nota = nota;

  }
}

$('#tipoConsulta').click(function () {

  if ($("#tipoConsulta").val() === "Parciales") {
    $('#lapsoconsulta').show();
  } else {
    $('#lapsoconsulta').hide();
  }


});

$('#btncerrareditarnota').click(function() {
  $('#modaldetallenotasalumno').modal('hide');
});

$('#botonEditarNota1').click(function name() {
  $('#notaprimerlapso').prop('readonly',false);
  $('#notaprimerlapso').focus();
});

$('#botonEditarNota2').click(function name() {
  $('#notasegundolapso').prop('readonly',false);
  $('#notasegundolapso').focus();
});

$('#botonEditarNota3').click(function name() {
  $('#notatercerlapso').prop('readonly',false);
  $('#notatercerlapso').focus();

});

$(".btn").click(function() {
  let fila=$(this).closest("tr");
  idAl=fila.find("#idAlumno").html();
  let nombreAlumno=fila.find("#nombreAlumno").html();
  let cedulaAlumno=fila.find("#cedulaAlumno").html();
  let nota1=fila.find("#notalapso1").html();
  let nota2=fila.find("#notalapso2").html();
  let nota3=fila.find("#notalapso3").html();
  $("#nomAlumno").val(nombreAlumno);
  $("#cedAlumno").val(cedulaAlumno);
  $("#notaprimerlapso").val(nota1);
  $("#notasegundolapso").val(nota2);
  $("#notatercerlapso").val(nota3);
  $('#modaldetallenotasalumno').modal({ backdrop: 'static', keyboard: false });
  $("#modaldetallenotasalumno").modal("show");

});




$('.confirmar').click(function () {

  let fila = $(this).closest("tr");

  if (fila.find(".txtnota").val() === '' || fila.find(".txtnota").val() === null) {
    alert("NOTA NO PUEDE ESTAR VACÍA");
    return;
  }

  let nota = parseFloat(fila.find(".txtnota").val()).toFixed(2);

  fila.find('.cellnota').text(nota);

  fila.find('.cellbtnconfirmar>.confirmar').prop('disabled', true);

  fila.find('.cellbtnconfirmar>.confirmar').css('background-color', '#E5D9D7');

  fila.find('.cellbtneditar>.editar').css('background-color', '#2441e6');

  fila.find('.cellbtneditar>.editar').prop('disabled', false);



});


$('.editar').click(function () {

  let fila = $(this).closest("tr");


  fila.find('.cellbtneditar>.editar').prop('disabled', true);

  fila.find('.cellbtneditar>.editar').css('background-color', '#E5D9D7');

  fila.find('.cellbtnconfirmar>.confirmar').prop('disabled', false);

  fila.find('.cellbtnconfirmar>.confirmar').css('background-color', '#2441e6');

  let nota = fila.find('.cellnota').html();

  let nombre = fila.find('.nombreAlumno').html();

  let cedula = fila.find('.cedulaAlumno').html();

  let id = fila.find('.idAlumno').html();

  let nuevafila = '<tr>' +
    '<td id="idAlumno" class="idAlumno">' + id + '</td>' +
    '<td id="cedulaAlumno" class="cedulaAlumno">' + cedula + '</td>' +
    '<td id="nombreAlumno" class="nombreAlumno">' + nombre + '</td>' +
    '<td id="cellnota" class="cellnota"><input type="text" class="txtnota" onkeypress="return NumCheck(event, this) maxlength="5" /></td>' +
    '<td id="cellbtnconfirmar" class="cellbtnconfirmar"><button type="button" data-toggle="tooltip" data-placement="top" title="Confirmar" class="confirmar" id="confirmar"><i class="bi bi-check"></i></button></td>' +
    '<td id="cellbtneditar" class="cellbtneditar"><button type="button" data-toggle="tooltip" data-placement="top" title="Editar" class="editar" id="editar"><i class="bi bi-pencil-fill"></i></button></td>'
  '</tr>';

  $('#tablenotas tbody').append(nuevafila);
  //alert(nuevafila);
  //fila.append(nuevafila);

  fila.remove();

  //fila.find(".cellnota>.txtnota").val(nota);




});

$("#GuardarCambiarNotas").click(function () {
  direccionbase = $("#direccionbase").val();
  url = direccionbase + "/actualizarNota";
  let idAlumno=idAl;
  let idMateria=$("#idMat").val();
  let idCurso=$("#idCurso").val();
  let notaLapso1=$("#notaprimerlapso").val();
  let notaLapso2=$("#notasegundolapso").val();
  let notaLapso3=$("#notatercerlapso").val();
  $("#modaldetallenotasalumno").modal("hide");
  $.ajax({
    data: {
      idAlumno:idAlumno,
      idMateria:idMateria,
      idCurso:idCurso,
      notaLapso1:notaLapso1,
      notaLapso2:notaLapso2,
      notaLapso3:notaLapso3,
    },
    url: url,
    headers: {
      "X-CSRF-TOKEN": token,
    },
   
    type: "POST",
    dataType:"json",
   
    success: function () {
      
   
      $('#modalnotasmodificadas').modal({backdrop: 'static', keyboard: false});
      $("#modalnotasmodificadas").modal('show');
      $("#parrafomodalnotasmodificadas").html("NOTAS MODIFICADAS");
    }
  })
    .done(function () {
    })
    .fail(function (data) {
      alert('PETICION FALLIDA');
    });


});


$("#Guardar").click(function () {

  let notasParDTO = [];


  if ($('#lapso').val() === '') {
    $("#lbllapso").css('display', 'block');
    setTimeout(() => {
      $("#lbllapso").css('display', 'none');
    }, 2000);
    return;
  }

  if ($('#tipoCarga').val() === '') {
    $("#lbltipodecarga").css('display', 'block');
    setTimeout(() => {
      $("#lbltipodecarga").css('display', 'none');
    }, 2000);
    return;
  }

  for (i = 1; i < $('#tablenotas tr').length; i++) {


    let idAlumno = parseInt($('#tablenotas').find('tr').eq(i).find('td').eq(0).html());

    let idCurso = parseInt($('#idCurso').val());

    let idLapso = parseInt($('#lapso').val());

    let idMat = parseInt($('#idMat').val());

    let idPrf = parseInt($('#idPrf').val());

    let nota = $('#tablenotas').find('tr').eq(i).find('td').eq(3).html();

    let tipoDeCarga = $('#tipoCarga').val();

    notaParDTO = new NotasParDTO(idAlumno, idCurso, idLapso, idMat, idPrf, tipoDeCarga, nota);

    notasParDTO.push(notaParDTO);


  }

  console.log(notasParDTO);
  direccionbase = $("#direccionbase").val();
  url = direccionbase + "/guardarnotas";

  $.ajax({
    data: JSON.stringify(notasParDTO),
    url: url,
    headers: {
      "X-CSRF-TOKEN": token,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    dataType: "json", //tipo de datos retornados
    type: "POST",
    contentType: "application/x-www-form-urlencoded",
    success: function (json) {
      
      $('#modalnotascargadas').modal({backdrop: 'static', keyboard: false});
      $("#modalnotascargadas").modal('show');
      $("#parrafomodalnotascargadas").html("NOTAS REGISTRADAS EN EL SISTEMA");
     
      
    }
  })
    .done(function () {
    })
    .fail(function (data) {
      alert('DEBE LLENAR Y CONFIRMAR TODAS LAS NOTAS');
    });
});

$("#btnNotasCargadas").click(function () {
  window.location.href = direccionbase + "/verCursos";
});

$("#btnNotasModificadas").click(function () {
  //window.location.href = direccionbase + "/verCursos";
  $("#modaldetallenotasalumno").modal('hide');
  let an=$('#inputAnnio').val();
  let sec=$('#inputSeccion').val();
  let mat=$('#inputMateria').val();
  let idProfe=$('#idPrf').val();
  let idMat=$('#idMat').val();
  let idCur=$('#idCurso').val();
  window.location.href=direccionbase + "/consultarNotasDocente" + "/?annio=" + an + "&seccion=" + sec + "&materia=" + mat + "&idPrf=" + idProfe + "&idMat=" + idMat + "&idCurso=" + idCur;
});


$("#consultarnotas").click(function () {
  direccionbase = $("#direccionbase").val();
  url = direccionbase + "/obtenerNotas";
  let cedulaidentidad = $("input:text[name=ciAlumno]").val();
  let lapsoconsultar = $("select[name=lapso]").val();
  let tipoconsulta = $("select[name=tipoConsulta]").val();
  let periodoconsultar = $("select[name=periodoEscolar]").val();


  if (periodoconsultar === '') {
    $("#lblperiodo").css('display', 'block');
    setTimeout(() => {
      $("#lblperiodo").css('display', 'none');
    }, 2000);
    return;
  }

  if (tipoconsulta === '') {
    $("#lbltipo").css('display', 'block');
    setTimeout(() => {
      $("#lbltipo").css('display', 'none');
    }, 2000);
    return;
  }

  if (tipoconsulta === "Parciales") {
    if (lapsoconsultar === '') {
      $("#lblapso").css('display', 'block');
      setTimeout(() => {
        $("#lblapso").css('display', 'none');
      }, 2000);
      return;
    }
  }



  $.ajax({
    data: {
      cedula: cedulaidentidad,
      periodo: periodoconsultar,
      lapso: lapsoconsultar,
      tipodeconsulta: tipoconsulta,
    },
    url: url,
    dataType: "json", //tipo de datos retornados
    type: "GET",
  })
    .done(function (data) {
      /* Inicializamos tabla */
      $("#contenido").html('');
      /* Vemos que la respuesta no este vacía y sea una arreglo */
      if (data != null) {
        /* Recorremos tu respuesta con each */
        console.log(data);
        $.each(data, function (index, value) {
          /* Vamos agregando a nuestra tabla las filas necesarias */
          $("#contenido").append("<tr><td>" + value.annio + "</td><td>" + value.nombreMat + "</td><td>" + value.nota + "</td><td>" + value.porcentaje + "</td></tr>");
        });
        $('#tablenotascontainer').show();
      }
    })
    .fail(function (data) {
      $('#modalconsultadenotasvacia').modal({ backdrop: 'static', keyboard: false });
      $("#modalconsultadenotasvacia").modal('show');
      $("#parrafomodalconsultadenotasvacia").html("No existen registros para esta consulta");
    });
});

$("#btnConsultaDeNotasVacia").click(function () {
  //window.location.href = `${direccionbase}` + "/consultarNotas";
  $('#modalconsultadenotasvacia').modal('hide');
});

function NumCheck(e, field) {
  key = e.keyCode ? e.keyCode : e.which
  // backspace
  if (key == 8) return true
  // 0-9
  if (key > 47 && key < 58) {
    if (field.value == "") return true
    regexp = /.[0-9]{2}$/
    return !(regexp.test(field.value))
  }
  // .
  if (key == 46) {
    if (field.value == "") return false
    regexp = /^[0-9]+$/
    return regexp.test(field.value)
  }
  // other key
  return false

}