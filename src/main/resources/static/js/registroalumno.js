var rep1encontrado;
var rep2encontrado;
var cursoasignado;

function mostrarrepresentante2() {
  element = document.getElementById("datosRepSec");
  if (element.style.display == "none") {
    element.style.display = "block";
  } else {
    element.style.display = "none";
  }
}
function mostrarcursoelegido() {
  x = document.getElementById("cursoelegido");
  y = document.getElementById("rowtablecursos");
  table = document.getElementById("tablecursos");
  rows = table.getElementsByTagName("tr");
  for (i = 1; i < rows.length; i++) {
    row = table.rows[i];
    row.onclick = function () {
      var cell = this.getElementsByTagName("td")[0];
      var id = cell.innerHTML;
      var cell = this.getElementsByTagName("td")[1];
      var annio = cell.innerHTML;
      var cell = this.getElementsByTagName("td")[2];
      var seccion = cell.innerHTML;
      var cell = this.getElementsByTagName("td")[3];
      var turno = cell.innerHTML;
      var cell = this.getElementsByTagName("td")[4];
      var nivel = cell.innerHTML;
      var cell = this.getElementsByTagName("td")[5];
      var especialidad = cell.innerHTML;
      if (x.style.display == "none") {
        x.style.display = "flex";
        document.getElementById("annioelegido").setAttribute("value", annio);
        document.getElementById("secelegida").setAttribute("value", seccion);
        document.getElementById("turnoelegido").setAttribute("value", turno);
        document.getElementById("nivel").setAttribute("value", nivel);
        document
          .getElementById("especialidad")
          .setAttribute("value", especialidad);
      }
      y.style.display = "none";
      cursoasignado=true;
    };
  }
}

//Setea los combos a blanco, oculta los texty establece estilos
$(document).ready(function () {
  $("#tipoDocAl").val("");
  $("#sexoAl").val("");
  $("#status").val("");
  $("#estadodirppalest").val("");
  $("#municipiodirppalest").val("");
  $("#ciudaddirppalest").val("");
  $("#parroquiadirppalest").val("");
  $("#codpostaldirppalest").val("");
  $("#estadodirsecest").val("");
  $("#municipiodirsecest").val("");
  $("#ciudaddirsecest").val("");
  $("#parroquiadirsecest").val("");
  $("#codpostaldirsecest").val("");
  $("#codoperadorappalest").val("");
  $("#codoperadorasecest").val("");
  $("#tipoDocRep1").val("");
  $("#sexoRpr1").val("");
  $("#parentescoRpr1").val("");
  $("#edoCivRpr1").val("");
  $("#estadodirppalrep1").val("");
  $("#municipiodirppalrep1").val("");
  $("#ciudaddirppalrep1").val("");
  $("#parroquiadirppalrep1").val("");
  $("#codpostaldirppalrep1").val("");
  $("#estadodirsecrep1").val("");
  $("#municipiodirsecrep1").val("");
  $("#ciudaddirsecrep1").val("");
  $("#parroquiadirsecrep1").val("");
  $("#codpostaldirsecrep1").val("");
  $("#codoperadorappalrep1").val("");
  $("#codoperadorasecrep1").val("");
  $("#txtCodoperadorappalrep1").val("");
  $("#estadodirppalrep1").val("");
  $("#tipoDocRep2").val("");
  $("#sexoRpr2").val("");
  $("#parentescoRpr2").val("");
  $("#edoCivRpr2").val("");
  $("#estadodirppalrep2").val("");
  $("#municipiodirppalrep2").val("");
  $("#ciudaddirppalrep2").val("");
  $("#parroquiadirppalrep2").val("");
  $("#codpostaldirppalrep2").val("");
  $("#estadodirsecrep2").val("");
  $("#municipiodirsecrep2").val("");
  $("#ciudaddirsecrep2").val("");
  $("#parroquiadirsecrep2").val("");
  $("#codpostaldirsecrep2").val("");
  $("#codoperadorappalrep2").val("");
  $("#codoperadorasecrep2").val("");
  $("#txtCodoperadorappalrep2").val("");
  $("#estadodirppalrep2").val("");
  $("#txtSexoRpr1").hide();
  $("#txtParentescoRpr1").hide();
  $("#txtOtroParentescoRpr1").hide();
  $("#txtOtroParentescoRpr2").hide();
  $("#txtEdoCivRpr1").hide();
  $("#textAreaDirPpalRpr1").hide();
  $("#textAreaDirSecRpr1").hide();
  $("#txtCodoperadorappalrep1").hide();
  $("#txtTextoTlfPpalRpr1").hide();
  // $("#lbltxtTlfPpalRpr1").hide();
  $("#txtCodoperadorasecrep1").hide();
  $("#txtTextoTlfSecRpr1").hide();
  $("#txtSexoRpr2").hide();
  $("#txtParentescoRpr2").hide();
  $("#txtEdoCivRpr2").hide();
  $("#textAreaDirPpalRpr2").hide();
  $("#textAreaDirSecRpr2").hide();
  $("#txtCodoperadorappalrep2").hide();
  $("#txtTextoTlfPpalRpr2").hide();
  $("#txtCodoperadorasecrep2").hide();
  $("#txtTextoTlfSecRpr2").hide();
  rep1encontrado = 0;
  rep2encontrado = 0;
  cursoasignado = false;
});

$("#parentescoRpr1").change(function () {
  if ($("#parentescoRpr1").val() == "Otro") {
    $("#parentescoRpr1").hide();
    $("#txtOtroParentescoRpr1").show();
  }
});

//Para llamar al servicio que consulta si el representante 1 ya esta registrado
//y mostrar los datos del representante en caso de que ya este registrado
$("#botonBuscRep").click(function () {
  $.ajax({
    data: {
      tdoc: $("select[name=tipoDocRep1]").val(),
      ndoc: $("input:text[name=numDocRep1]").val(),
    },
    url: "http://localhost:8080/app/consultarepresentante",
    dataType: "json", //tipo de datos retornados
    type: "GET",
  })
    .done(function (data) {
      rep1encontrado = 1;
      $("#primNombRpr1").val(data["primNombRpr"]);
      $("#segNombRpr1").val(data["segNombRpr"]);
      $("#primApellRpr1").val(data["primApellRpr"]);
      $("#segApellRpr1").val(data["segApellRpr"]);
      $("#edadRpr1").val(data["edadRpr"]);
      $("#sexoRpr1").hide();
      $("#txtSexoRpr1").show();
      $("#txtSexoRpr1").val(data["sexoRpr"]);
      $("#parentescoRpr1").hide();
      $("#txtParentescoRpr1").show();
      $("#txtParentescoRpr1").val(data["parentescoRpr"]);
      $("#edoCivRpr1").hide();
      $("#txtEdoCivRpr1").show();
      $("#txtEdoCivRpr1").val(data["edoCivRpr"]);
      $("#fechNacRpr1").val(data["fechNacRpr"]);
      $("#textoDirPpalRpr1").hide();
      $("#textAreaDirPpalRpr1").show();
      $("#textAreaDirPpalRpr1").val(data["dirPpalRpr"]);
      $("#estadodirppalrep1").hide();
      $("#municipiodirppalrep1").hide();
      $("#ciudaddirppalrep1").hide();
      $("#parroquiadirppalrep1").hide();
      $("#codpostaldirppalrep1").hide();
      $("#lblEstadodirppalrep1").hide();
      $("#lblMunicipiodirppalrep1").hide();
      $("#lblCiudaddirppalrep1").hide();
      $("#lblParroquiadirppalrep1").hide();
      $("#lblCodpostaldirppalrep1").hide();
      $("#textoDirSecRpr1").hide();
      $("#textAreaDirSecRpr1").show();
      $("#textAreaDirSecRpr1").val(data["dirSecRpr"]);
      $("#estadodirsecrep1").hide();
      $("#municipiodirsecrep1").hide();
      $("#ciudaddirsecrep1").hide();
      $("#parroquiadirsecrep1").hide();
      $("#codpostaldirsecrep1").hide();
      $("#lblEstadodirsecrep1").hide();
      $("#lblMunicipiodirsecrep1").hide();
      $("#lblCiudaddirsecrep1").hide();
      $("#lblParroquiadirsecrep1").hide();
      $("#lblCodpostaldirsecrep1").hide();
      $("#codoperadorappalrep1").hide();
      $("#textoTlfPpalRpr1").hide();
      $("#codoperadorasecrep1").hide();
      $("#textoTlfSecRpr1").hide();
      $("#txtTextoTlfPpalRpr1").show();
      $("#txtCodoperadorappalrep1").show();
      var codigoArea = data["tlfPpalRpr"].substring(0, 4);
      var telefono = data["tlfPpalRpr"].substring(5, 14);
      $("#txtTextoTlfPpalRpr1").val(telefono);
      $("#txtCodoperadorappalrep1").val(codigoArea);
      $("#emailRpr1").val(data["emailRpr"]);
      $("#txtTextoTlfSecRpr1").show();
      $("#txtCodoperadorasecrep1").show();
      var codigoArea = data["tlfSecRpr"].substring(0, 4);
      var telefono = data["tlfSecRpr"].substring(5, 14);
      $("#txtTextoTlfSecRpr1").val(telefono);
      $("#txtCodoperadorasecrep1").val(codigoArea);
    })
    .fail(function (data) {
      alert("El representante no se encuentra registrado");
    });
});

//Para llamar al servicio que consulta si el representante 2 ya esta registrado
//y mostrar los datos del representante en caso de que ya este registrado
$("#botonBuscRep2").click(function () {
  $.ajax({
    data: {
      tdoc: $("select[name=tipoDocRep2]").val(),
      ndoc: $("input:text[name=numDocRep2]").val(),
    },
    url: "http://localhost:8080/app/consultarepresentante",
    dataType: "json", //tipo de datos retornados
    type: "GET",
  })
    .done(function (data) {
      rep2encontrado = 1;
      $("#primNombRpr2").val(data["primNombRpr"]);
      $("#segNombRpr2").val(data["segNombRpr"]);
      $("#primApellRpr2").val(data["primApellRpr"]);
      $("#segApellRpr2").val(data["segApellRpr"]);
      $("#edadRpr2").val(data["edadRpr"]);
      $("#sexoRpr2").hide();
      $("#txtSexoRpr2").show();
      $("#txtSexoRpr2").val(data["sexoRpr"]);
      $("#parentescoRpr2").hide();
      $("#txtParentescoRpr2").show();
      $("#txtParentescoRpr2").val(data["parentescoRpr"]);
      $("#edoCivRpr2").hide();
      $("#txtEdoCivRpr2").show();
      $("#txtEdoCivRpr2").val(data["edoCivRpr"]);
      $("#fechNacRpr2").val(data["fechNacRpr"]);
      $("#textoDirPpalRpr2").hide();
      $("#textAreaDirPpalRpr2").show();
      $("#textAreaDirPpalRpr2").val(data["dirPpalRpr"]);
      $("#estadodirppalrep2").hide();
      $("#municipiodirppalrep2").hide();
      $("#ciudaddirppalrep2").hide();
      $("#parroquiadirppalrep2").hide();
      $("#codpostaldirppalrep2").hide();
      $("#lblEstadodirppalrep2").hide();
      $("#lblMunicipiodirppalrep2").hide();
      $("#lblCiudaddirppalrep2").hide();
      $("#lblParroquiadirppalrep2").hide();
      $("#lblCodpostaldirppalrep2").hide();
      $("#textoDirSecRpr2").hide();
      $("#textAreaDirSecRpr2").show();
      $("#textAreaDirSecRpr2").val(data["dirSecRpr"]);
      $("#estadodirsecrep2").hide();
      $("#municipiodirsecrep2").hide();
      $("#ciudaddirsecrep2").hide();
      $("#parroquiadirsecrep2").hide();
      $("#codpostaldirsecrep2").hide();
      $("#lblEstadodirsecrep2").hide();
      $("#lblMunicipiodirsecrep2").hide();
      $("#lblCiudaddirsecrep2").hide();
      $("#lblParroquiadirsecrep2").hide();
      $("#lblCodpostaldirsecrep2").hide();
      $("#codoperadorappalrep2").hide();
      $("#textoTlfPpalRpr2").hide();
      // $("#lbltxtTlfPpalRpr1").show();
      $("#codoperadorasecrep2").hide();
      $("#textoTlfSecRpr2").hide();
      $("#txtTextoTlfPpalRpr2").show();
      $("#txtCodoperadorappalrep2").show();
      var codigoArea = data["tlfPpalRpr"].substring(0, 4);
      var telefono = data["tlfPpalRpr"].substring(5, 14);
      $("#txtTextoTlfPpalRpr2").val(telefono);
      $("#txtCodoperadorappalrep2").val(codigoArea);
      $("#emailRpr2").val(data["emailRpr"]);
      $("#txtTextoTlfSecRpr2").show();
      $("#txtCodoperadorasecrep2").show();
      var codigoArea = data["tlfSecRpr"].substring(0, 4);
      var telefono = data["tlfSecRpr"].substring(5, 14);
      $("#txtTextoTlfSecRpr2").val(telefono);
      $("#txtCodoperadorasecrep2").val(codigoArea);
    })
    .fail(function (data) {
      alert("error");
    });
});

$("#guardarAlumno").click(function () {
  var dirPppalAl;
  var dirSecAl;
  var tlfPpalAl;
  var tlfSecAl;
  var emailAl;
  var dirPpalRpr1;
  var dirSecRpr1;
  var tlfPpalRpr1;
  var tlfSecRpr1;
  var emailRpr1;
  var sexoRpr1;
  var parentescoRpr1;
  var edoCivRpr1;
  var primNombRpr2;
  var segNombRpr2;
  var primApellRpr2;
  var segApellRpr2;
  var tipoDocRep2;
  var numDocRep2;
  var fechNacRpr2;
  var edadRpr2;
  var parentescoRpr2;
  var dirPpalRpr2;
  var dirSecRpr2;
  var tlfPpalRpr2;
  var tlfSecRpr2;
  var emailRpr2;
  var sexoRpr2;
  var edoCivRpr2;

 /*if (!valida()) {
    alert("DEBE COMPLETAR LOS CAMPOS REQUERIDOS");
    return false;
  }

  if(!cursoasignado){
    alert("DEBE REALIZAR LA ASIGNACION DE UN CURSO AL ALUMNO");
    return false;
  }*/

  dirPppalAl =
    $("#textoDirPpalAl").val() +
    " " +
    "ESTADO: " +
    $("#estadodirppalest").val() +
    " " +
    "MUNICIPIO: " +
    $("#municipiodirppalest").val() +
    " " +
    "CIUDAD: " +
    $("#ciudaddirppalest").val() +
    " " +
    "PARROQUIA: " +
    $("#parroquiadirppalest").val() +
    " " +
    "COD POSTAL: " +
    $("#codpostaldirppalest").val();

  if ($("#textoDirSecAl").val() == "") {
    dirSecAl = dirPppalAl;
  } else {
    dirSecAl =
      $("#textoDirSecAl").val() +
      " " +
      "ESTADO: " +
      $("#estadodirsecest").val() +
      " " +
      "MUNICIPIO: " +
      $("#municipiodirsecest").val() +
      " " +
      "CIUDAD: " +
      $("#ciudaddirsecest").val() +
      " " +
      "PARROQUIA: " +
      $("#parroquiadirsecest").val() +
      " " +
      "COD POSTAL: " +
      $("#codpostaldirsecest").val();
  }

  tlfPpalAl =
    $("#codoperadorappalest").val() + "-" + $("#textoTlfPpalAl").val();

  if (
    $("#codoperadorasecest").val() == null &&
    $("#textoTlfSecAl").val() == ""
  ) {
    tlfSecAl = tlfPpalAl;
  } else {
    tlfSecAl = $("#codoperadorasecest").val() + "-" + $("#textoTlfSecAl").val();
  }

  emailAl = $("#emailAl").val();

  emailRpr1 = $("#emailRpr1").val();

  if (rep1encontrado == 1) {
    sexoRpr1 = $("#txtSexoRpr1").val();
    edoCivRpr1 = $("#txtEdoCivRpr1").val();
    parentescoRpr1 = $("#txtParentescoRpr1").val();
    dirPpalRpr1 = $("#textAreaDirPpalRpr1").val();
    dirSecRpr1 = $("#textAreaDirSecRpr1").val();
    tlfPpalRpr1 =
      $("#txtCodoperadorappalrep1").val() +
      "-" +
      $("#txtTextoTlfPpalRpr1").val();
    tlfSecRpr1 =
      $("#txtCodoperadorasecrep1").val() + "-" + $("#txtTextoTlfSecRpr1").val();
  } else {
    sexoRpr1 = $("#sexoRpr1").val();
    edoCivRpr1 = $("#edoCivRpr1").val();
    parentescoRpr1 = $("#parentescoRpr1").val();
    dirPpalRpr1 =
      $("#textoDirPpalRpr1").val() +
      " " +
      "ESTADO: " +
      $("#estadodirppalrep1").val() +
      " " +
      "MUNICIPIO: " +
      $("#municipiodirppalrep1").val() +
      " " +
      "CIUDAD: " +
      $("#ciudaddirppalrep1").val() +
      " " +
      "PARROQUIA: " +
      $("#parroquiadirppalrep1").val() +
      " " +
      "COD POSTAL: " +
      $("#codpostaldirppalrep1").val();
    tlfPpalRpr1 =
      $("#codoperadorappalrep1").val() + "-" + $("#textoTlfPpalRpr1").val();

    if ($("#textoDirSecRpr1").val() == "") {
      dirSecRpr1 = dirPpalRpr1;
    } else {
      dirSecRpr1 =
        $("#textoDirSecRpr1").val() +
        " " +
        "ESTADO: " +
        $("#estadodirsecrep1").val() +
        " " +
        "MUNICIPIO: " +
        $("#municipiodirsecrep1").val() +
        " " +
        "CIUDAD: " +
        $("#ciudaddirsecrep1").val() +
        " " +
        "PARROQUIA: " +
        $("#parroquiadirsecrep1").val() +
        " " +
        "COD POSTAL: " +
        $("#codpostaldirsecrep1").val();
    }

    if (
      $("#codoperadorasecrep1").val() == null &&
      $("#textoTlfSecRpr1").val() == ""
    ) {
      tlfSecRpr1 = tlfPpalRpr1;
    } else {
      tlfSecRpr1 =
        $("#codoperadorasecrep1").val() + "-" + $("#textoTlfSecRpr1").val();
    }
  }

  if ($("#chkRepresentante2").prop("checked")) {
    primNombRpr2 = $("#primNombRpr2").val();
    segNombRpr2 = $("#segNombRpr2").val();
    primApellRpr2 = $("#primApellRpr2").val();
    segApellRpr2 = $("#segApellRpr2").val();
    tipoDocRep2 = $("#tipoDocRep2").val();
    numDocRep2 = $("#numDocRep2").val();
    fechNacRpr2 = $("#fechNacRpr2").val();
    edadRpr2 = $("#edadRpr2").val();
    emailRpr2 = $("#emailRpr2").val();
    if (rep2encontrado == 1) {
      sexoRpr2 = $("#txtSexoRpr2").val();
      edoCivRpr2 = $("#txtEdoCivRpr2").val();
      parentescoRpr2 = $("#txtParentescoRpr2").val();
      dirPpalRpr2 = $("#textAreaDirPpalRpr2").val();
      dirSecRpr2 = $("#textAreaDirSecRpr2").val();
      tlfPpalRpr2 =
        $("#txtCodoperadorappalrep2").val() +
        "-" +
        $("#txtTextoTlfPpalRpr2").val();
      tlfSecRpr2 =
        $("#txtCodoperadorasecrep2").val() +
        "-" +
        $("#txtTextoTlfSecRpr2").val();
    } else {
      sexoRpr2 = $("#sexoRpr2").val();
      edoCivRpr2 = $("#edoCivRpr2").val();
      parentescoRpr2 = $("#parentescoRpr2").val();
      dirPpalRpr2 =
        $("#textoDirPpalRpr2").val() +
        " " +
        "ESTADO: " +
        $("#estadodirppalrep2").val() +
        " " +
        "MUNICIPIO: " +
        $("#municipiodirppalrep2").val() +
        " " +
        "CIUDAD: " +
        $("#ciudaddirppalrep2").val() +
        " " +
        "PARROQUIA: " +
        $("#parroquiadirppalrep2").val() +
        " " +
        "COD POSTAL: " +
        $("#codpostaldirppalrep2").val();
      tlfPpalRpr2 =
        $("#codoperadorappalrep2").val() + "-" + $("#textoTlfPpalRpr2").val();

      if ($("#textoDirSecRpr2").val() == "") {
        dirSecRpr2 = dirPpalRpr2;
      } else {
        dirSecRpr2 =
          $("#textoDirSecRpr2").val() +
          " " +
          "ESTADO: " +
          $("#estadodirsecrep2").val() +
          " " +
          "MUNICIPIO: " +
          $("#municipiodirsecrep2").val() +
          " " +
          "CIUDAD: " +
          $("#ciudaddirsecrep2").val() +
          " " +
          "PARROQUIA: " +
          $("#parroquiadirsecrep2").val() +
          " " +
          "COD POSTAL: " +
          $("#codpostaldirsecrep2").val();
      }

      if (
        $("#codoperadorasecrep2").val() == null &&
        $("#textoTlfSecRpr2").val() == ""
      ) {
        tlfSecRpr2 = tlfPpalRpr2;
      } else {
        tlfSecRpr2 =
          $("#codoperadorasecrep2").val() + "-" + $("#textoTlfSecRpr2").val();
      }
    }
  }

  //CONSTRUYE EL JSON QUE SERA ENTRADA AL SERVICIO
  var dataAl = {
    primNombAl: $("#primNombAl").val(),
    segNombAl: $("#segNombAl").val(),
    primApellAl: $("#primApellAl").val(),
    segApellAl: $("#segApellAl").val(),
    tipoDocAl: $("#tipoDocAl").val(),
    numDocAl: $("#numDocAl").val(),
    fechNacAl: $("#fechNacAl").val(),
    edadAl: $("#edadAl").val(),
    sexoAl: $("#sexoAl").val(),
    status: $("#status").val(),
    fechIngAl: $("#fechIngAl").val(),
    dirPpalAl: dirPppalAl,
    dirSecAl: dirSecAl,
    tlfPpalAl: tlfPpalAl,
    tlfSecAl: tlfSecAl,
    emailAl: emailAl,
    primNombRpr1: $("#primNombRpr1").val(),
    segNombRpr1: $("#segNombRpr1").val(),
    primApellRpr1: $("#primApellRpr1").val(),
    segApellRpr1: $("#segApellRpr1").val(),
    tipoDocRep1: $("#tipoDocRep1").val(),
    numDocRep1: $("#numDocRep1").val(),
    fechNacRpr1: $("#fechNacRpr1").val(),
    edadRpr1: $("#edadRpr1").val(),
    parentescoRpr1: parentescoRpr1,
    dirPpalRpr1: dirPpalRpr1,
    dirSecRpr1: dirSecRpr1,
    tlfPpalRpr1: tlfPpalRpr1,
    tlfSecRpr1: tlfSecRpr1,
    emailRpr1: emailRpr1,
    sexoRpr1: sexoRpr1,
    edoCivRpr1: edoCivRpr1,
    primNombRpr2: primNombRpr2,
    segNombRpr2: segNombRpr2,
    primApellRpr2: primApellRpr2,
    segApellRpr2: segApellRpr2,
    tipoDocRep2: tipoDocRep2,
    numDocRep2: numDocRep2,
    fechNacRpr2: fechNacRpr2,
    edadRpr2: edadRpr2,
    parentescoRpr2: parentescoRpr2,
    dirPpalRpr2: dirPpalRpr2,
    dirSecRpr2: dirSecRpr2,
    tlfPpalRpr2: tlfPpalRpr2,
    tlfSecRpr2: tlfSecRpr2,
    emailRpr2: emailRpr2,
    sexoRpr2: sexoRpr2,
    edoCivRpr2: edoCivRpr2,
    annio: $("#annioelegido").val(),
    seccion: $("#secelegida").val(),
  };

  console.log(dataAl);

  $.ajax({
    url: "http://localhost:8080/app/registraralumno",
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(dataAl),
    dataType: "json",
    async: false,
    cache: false,
    success: function (response) {
      alert("ALUMNO Y REPRESENTANTE(S) REGISTRADO(S) CORRECTAMENTE");
      window.location.href = "/app/listaralumnos";
    },
  });
});

$("#btnLimpiar").click(function () {
  window.location.href = "/app/registroalumno";
});
