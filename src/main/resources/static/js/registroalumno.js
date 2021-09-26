var rep1encontrado;
var rep2encontrado;
var cursoasignado;
var direccionbase;
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
        document.getElementById("annio").setAttribute("value", annio);
        document.getElementById("seccion").setAttribute("value", seccion);
        document.getElementById("turno").setAttribute("value", turno);
        document.getElementById("nivel").setAttribute("value", nivel);
        document
          .getElementById("especialidad")
          .setAttribute("value", especialidad);
      }
      y.style.display = "none";
      cursoasignado = true;
    };
  }
}

//Setea los combos a blanco, oculta los textos establece estilos
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

  
  //console.log(flag);

 // $("#txtTipoDocAl").hide();
 // $("#txtSexoAl").hide();
 // $("#txtStatus").hide();
 // $("#txtEstadodirppalest").hide();
 // $("#txtMunicipiodirppalest").hide();
 // $("#txtCiudaddirppalest").hide();
 // $("#txtParroquiadirppalest").hide();
 // $("#txtCodpostaldirppalest").hide();
 // $("#txtEstadodirsecest").hide();
//  $("#txtMunicipiodirsecest").hide();
//  $("#txtCiudaddirsecest").hide();
 // $("#txtParroquiadirsecest").hide();
 // $("#txtCodpostaldirsecest").hide();
 // $("#txtCodoperadorappalest").hide();
  //$("#txtCodoperadorasecest").hide();
  
  
  
  

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
  direccionbase=$("#direccionbase").val();
  url=direccionbase+"/consultarepresentante";	
  $.ajax({
      data: {
        tdoc: $("select[name=tipoDocRep1]").val(),
        ndoc: $("input:text[name=numDocRep1]").val(),
        

      },
      url:url,
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

$("#btnLimpiar").click(function () {
  window.location.href = "/app/registroalumno";
});

/*$("#guardarAlumno").click(function () {
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
});*/

