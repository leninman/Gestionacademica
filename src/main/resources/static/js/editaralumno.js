let direccionbase;

$(document).ready(function () {
  $('form input[type="text"]').prop("disabled", true);
  $('form select').prop("disabled", true);
  $('form input[type="email"]').prop("disabled", true);
  $('form input[type="date"]').prop("disabled", true);
  $('form input[type="submit"]').prop("disabled", true);
  $("#botonCambiarRep").show();
  $("#botonBuscRep").hide();
  $("#botonCambiarRep2").show();
  $("#botonBuscRep2").hide();

});


$("#botonCambiarRep").click(function () {
  $("#tipoDocRep1").val("");
  $("#numDocRep1").val("");
  $("#primNombRpr1").val("");
  $("#segNombRpr1").val("");
  $("#primApellRpr1").val("");
  $("#segApellRpr1").val("");
  $("#fechNacRpr1").val("");
  $("#edadRpr1").val("");
  $("#sexoRpr1").val("");
  $("#parentescoRpr1").val("");
  $("#edoCivRpr1").val("");
  $("#textoDirPpalRpr1").val("");
  $("#estadodirppalrep1").val("");
  $("#municipiodirppalrep1").val("");
  $("#ciudaddirppalrep1").val("");
  $("#parroquiadirppalrep1").val("");
  $("#codpostaldirppalrep1").val("");
  $("#textoDirSecRpr1").val("");
  $("#estadodirsecrep1").val("");
  $("#municipiodirsecrep1").val("");
  $("#ciudaddirsecrep1").val("");
  $("#parroquiadirsecrep1").val("");
  $("#codpostaldirsecrep1").val("");
  $("#textoTlfPpalRpr1").val("");
  $("#codoperadorappalrep1").val("");
  $("#emailRpr1").val("");
  $("#codoperadorasecrep1").val("");
  $("#textoTlfSecRpr1").val("");
  $("#botonCambiarRep").hide();
  $("#botonBuscRep").show();
  $("#tipoDocRep1").prop('disabled',false);
  $("#numDocRep1").prop('disabled',false);
});




$("#botonCambiarRep2").click(function () {
  $("#tipoDocRep2").val("");
  $("#numDocRep2").val("");
  $("#primNombRpr2").val("");
  $("#segNombRpr2").val("");
  $("#primApellRpr2").val("");
  $("#segApellRpr2").val("");
  $("#fechNacRpr2").val("");
  $("#edadRpr2").val("");
  $("#sexoRpr2").val("");
  $("#parentescoRpr2").val("");
  $("#edoCivRpr2").val("");
  $("#textoDirPpalRpr2").val("");
  $("#estadodirppalrep2").val("");
  $("#municipiodirppalrep2").val("");
  $("#ciudaddirppalrep2").val("");
  $("#parroquiadirppalrep2").val("");
  $("#codpostaldirppalrep2").val("");
  $("#textoDirSecRpr2").val("");
  $("#estadodirsecrep2").val("");
  $("#municipiodirsecrep2").val("");
  $("#ciudaddirsecrep2").val("");
  $("#parroquiadirsecrep2").val("");
  $("#codpostaldirsecrep2").val("");
  $("#textoTlfPpalRpr2").val("");
  $("#codoperadorappalrep2").val("");
  $("#emailRpr2").val("");
  $("#codoperadorasecrep2").val("");
  $("#textoTlfSecRpr2").val("");
  $("#botonCambiarRep2").hide();
  $("#botonBuscRep2").show();
  $("#tipoDocRep2").prop('disabled',false);
  $("#numDocRep2").prop('disabled',false);
});


$("#botonEditarAlumno").click(function () {
  $('form input[type="text"]').prop("disabled", false);
  $('form select').prop("disabled", false);
  $('form input[type="email"]').prop("disabled", false);
  $('form input[type="date"]').prop("disabled", false);

/* $("#primNombAl").prop('disabled',false);
 $("#segNombAl").prop('disabled',false);
 $("#primApellAl").prop('disabled',false);
 $("#segApellAl").prop('disabled',false);
 $("#tipoDocAl").prop('disabled',false);
 $("#numDocAl").prop('disabled',false);
 $("#fechNacAl").prop('disabled',false);
 $("#edadAl").prop('disabled',false);
 $("#sexoAl").prop('disabled',false);
 $("#status").prop('disabled',false);
 $("#fechIngAl").prop('disabled',false);
 $("#textoDirPpalAl").prop('disabled',false);
 $("#estadodirppalest").prop('disabled',false);
 $("#municipiodirppalest").prop('disabled',false);
 $("#ciudaddirppalest").prop('disabled',false);
 $("#parroquiadirppalest").prop('disabled',false);
 $("#codpostaldirppalest").prop('disabled',false);
 $("#textoDirSecAl").prop('disabled',false);
 $("#estadodirsecest").prop('disabled',false);
 $("#municipiodirsecest").prop('disabled',false);
 $("#ciudaddirsecest").prop('disabled',false);
 $("#parroquiadirsecest").prop('disabled',false);
 $("#codpostaldirsecest").prop('disabled',false);
 $("#codoperadorappalest").prop('disabled',false);
 $("#textoTlfPpalAl").prop('disabled',false);
 $("#emailAl").prop('disabled',false);
 $("#codoperadorasecest").prop('disabled',false);
 $("#textoTlfSecAl").prop('disabled',false);
 $("#tipoDocRep1").prop('disabled',false);
 $("#numDocRep1").prop('disabled',false);
 $("#tipoDocRep2").prop('disabled',false);
 $("#numDocRep2").prop('disabled',false);
 $("#idCurso").prop('disabled',false);*/
  $("#botonCambiarRep").prop('disabled',false);
  $("#botonCambiarRep2").prop('disabled',false);
  $("#guardar").prop('disabled',false);
  $('#botonCambiarRep').css('background-color', '#2441e6');
  $('#botonCambiarRep2').css('background-color', '#2441e6');
  $('#guardar').css('background-color', '#2441e6');
  $('#botonCambiarRep').css('pointer-events','fill');
  $('#botonCambiarRep2').css('pointer-events','fill');
});
 
 
 $("#botonBuscRep").click(function () {
  direccionbase=$("#direccionbase").val();
  url=direccionbase+"/consultarepresentante";
  $.ajax({
      data: {
        tdoc: $("select[name=tipoDocRep1]").val(),
        ndoc: $("input:text[name=numDocRep1]").val(),
      },
      url: url,
      dataType: "json", //tipo de datos retornados
      type: "GET",
    })
    .done(function (data) {
      rep1encontrado = 1;
      console.log(data);
      $("#primNombRpr1").val(data["primNombRpr"]);
      $("#segNombRpr1").val(data["segNombRpr"]);
      $("#primApellRpr1").val(data["primApellRpr"]);
      $("#segApellRpr1").val(data["segApellRpr"]);
      $("#edadRpr1").val(data["edadRpr"]);
      $("#sexoRpr1").val(data["sexoRpr"]);
      $("#parentescoRpr1").val(data["parentescoRpr"]);
      $("#edoCivRpr1").val(data["edoCivRpr"]);
      $("#fechNacRpr1").val(data["fechNacRpr"]);
      $("#textoDirPpalRpr1").val(data["textoDirPpalRpr"]);
      $("#estadodirppalrep1").val(data["estadodirppalrep"]);
      $("#municipiodirppalrep1").val(data["municipiodirppalrep"]);
      $("#ciudaddirppalrep1").val(data["ciudaddirppalrep"]);
      $("#parroquiadirppalrep1").val(data["parroquiadirppalrep"]);
      $("#codpostaldirppalrep1").val(data["codpostaldirppalrep"]);
      $("#textoDirSecRpr1").val(data["textoDirSecRpr"]);
      $("#estadodirsecrep1").val(data["estadodirsecrep"]);
      $("#municipiodirsecrep1").val(data["municipiodirsecrep"]);
      $("#ciudaddirsecrep1").val(data["ciudaddirsecrep"]);
      $("#parroquiadirsecrep1").val(data["parroquiadirsecrep"]);
      $("#codpostaldirsecrep1").val(data["codpostaldirsecrep"]);
      $("#codoperadorappalrep1").val(data["codoperadorappalrep"]);
      $("#textoTlfPpalRpr1").val(data["textoTlfPpalRpr"]);
      $("#codoperadorasecrep1").val(data["codoperadorasecrep"]);
      $("#textoTlfSecRpr1").val(data["textoTlfSecRpr"]);
      $("#emailRpr1").val(data["emailRpr"]);
    })
    .fail(function (data) {
      alert("El representante no se encuentra registrado");
    });
});

//Para llamar al servicio que consulta si el representante 2 ya esta registrado
//y mostrar los datos del representante en caso de que ya este registrado
$("#botonBuscRep2").click(function () {
  direccionbase=$("#direccionbase").val();
  url=direccionbase+"/consultarepresentante";
  $.ajax({
      data: {
        tdoc: $("select[name=tipoDocRep2]").val(),
        ndoc: $("input:text[name=numDocRep2]").val(),
      },
      url: url,
      dataType: "json", //tipo de datos retornados
      type: "GET",
    })
    .done(function (data) {
      rep1encontrado = 1;
      console.log(data);
      $("#primNombRpr2").val(data["primNombRpr"]);
      $("#segNombRpr2").val(data["segNombRpr"]);
      $("#primApellRpr2").val(data["primApellRpr"]);
      $("#segApellRpr2").val(data["segApellRpr"]);
      $("#edadRpr2").val(data["edadRpr"]);
      $("#sexoRpr2").val(data["sexoRpr"]);
      $("#parentescoRpr2").val(data["parentescoRpr"]);
      $("#edoCivRpr2").val(data["edoCivRpr"]);
      $("#fechNacRpr2").val(data["fechNacRpr"]);
      $("#textoDirPpalRpr2").val(data["textoDirPpalRpr"]);
      $("#estadodirppalrep2").val(data["estadodirppalrep"]);
      $("#municipiodirppalrep2").val(data["municipiodirppalrep"]);
      $("#ciudaddirppalrep2").val(data["ciudaddirppalrep"]);
      $("#parroquiadirppalrep2").val(data["parroquiadirppalrep"]);
      $("#codpostaldirppalrep2").val(data["codpostaldirppalrep"]);
      $("#textoDirSecRpr2").val(data["textoDirSecRpr"]);
      $("#estadodirsecrep2").val(data["estadodirsecrep"]);
      $("#municipiodirsecrep2").val(data["municipiodirsecrep"]);
      $("#ciudaddirsecrep2").val(data["ciudaddirsecrep"]);
      $("#parroquiadirsecrep2").val(data["parroquiadirsecrep"]);
      $("#codpostaldirsecrep2").val(data["codpostaldirsecrep"]);
      $("#codoperadorappalrep2").val(data["codoperadorappalrep"]);
      $("#textoTlfPpalRpr2").val(data["textoTlfPpalRpr"]);
      $("#codoperadorasecrep2").val(data["codoperadorasecrep"]);
      $("#textoTlfSecRpr2").val(data["textoTlfSecRpr"]);
      $("#emailRpr2").val(data["emailRpr"]);
    })
    .fail(function (data) {
      alert("El representante no se encuentra registrado");
    });
});

//Servicio que consulta un curso por su Id
$("#idCurso").change(function () {
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
     // console.log(data);

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
});

