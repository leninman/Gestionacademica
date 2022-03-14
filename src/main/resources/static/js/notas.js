
let token;



$(document).ready(function () {
  token = $("meta[name='_csrf']").attr("content");

  $('.editar').prop('disabled', true);
  $('.editar').css('background-color', '#E5D9D7');
  $('.confirmar').prop('disabled', false);
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
      alert("LAS NOTAS HAN SIDO GUARDADAS CORRECTAMENTE");
      window.location.href = direccionbase + "/listarcursos";
    }
  })
    .done(function () {
    })
    .fail(function (data) {
      alert('DEBE LLENAR Y CONFIRMAR TODAS LAS NOTAS');
    });
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