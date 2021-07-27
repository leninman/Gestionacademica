

//Servicio que consulta un curso por su Id
$("#idCurso").change(function () {
  $.ajax({
      data: {
      idcurso: $("select[name=idCurso]").val(),
      },
      url: "http://localhost:8080/app/consultarcursoporid",
      dataType: "json", //tipo de datos retornados
      type: "GET",
    })
    .done(function (data) {
     // console.log(data);

      $("#annio").val(data["annio"]);
      $("#seccion").val(data["seccion"]);
      $("#turno").val(data["turno"]);
      $("#nivel").val(data["nivel"]);
      $("#especialidad").val(data["especialidad"]);
    })
    .fail(function (data) {
      alert("El curso no existe o no esta activo");
    });
});

