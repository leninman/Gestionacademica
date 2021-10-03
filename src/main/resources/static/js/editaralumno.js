let direccionbase;

$(document).ready(function () {
  $("#botonCambiarRep").show();
  $("#botonBuscRep").hide();
  $("#botonCambiarRep2").show();
  $("#botonBuscRep2").hide();

});


$("#botonCambiarRep").click(function () {
  $("#botonCambiarRep").hide();
  $("#botonBuscRep").show();

  $("#tipoDocRep1").prop('disabled',false);

  $("#numDocRep1").prop('disabled',false);

  


});




$("#botonCambiarRep2").click(function () {
  $("#botonCambiarRep2").hide();
  $("#botonBuscRep2").show();

  $("#tipoDocRep2").prop('disabled',false);

  $("#numDocRep2").prop('disabled',false);

  


});


$("#botonEditarAlumno").click(function () {

  $("#primNombAl").prop('disabled',false);
  






  $("#botonCambiarRep").prop('disabled',false);
  $("#botonCambiarRep2").prop('disabled',false);
  $("#guardar").prop('disabled',false);

  
 /* $("#botonCambiarRep").hide();
  $("#botonBuscRep").show();

  $("#tipoDocRep1").prop('disabled',false);

  $("#numDocRep1").prop('disabled',false);*/

  


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

