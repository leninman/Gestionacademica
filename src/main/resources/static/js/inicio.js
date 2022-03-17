


$(document).ready(function () {
  token = $("meta[name='_csrf']").attr("content");

});

function Abrirmodalalumno(){
    $('#buscarNotasAlumno').modal({backdrop: 'static', keyboard: false});
    $("#buscarNotasAlumno").modal('show');
}

$("#btnPersona").click(function () {
  direccionbase=$("#direccionbase").val();
  url=direccionbase+"app/consultarNotas";	
  $.ajax({
      data: {
        tipoDoc: $("select[name=tipodoc]").val(),
        numDoc: $("input:text[name=nrodoc]").val()
      },
      url:url,
       headers: {
      "X-CSRF-TOKEN": token,
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
      dataType: "json", //tipo de datos retornados
      type: "GET"
    })
    .done(function (data) {
    
     
    })
    .fail(function (data) {
    
    });
});