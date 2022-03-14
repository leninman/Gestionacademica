var rep1encontrado;
var rep2encontrado;
var cursoasignado;
var direccionbase;
var porvalidacion;
function mostrarrepresentante2() {
  element = document.getElementById("datosRepSec");
  if (element.style.display === "none") {
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
      if (x.style.display === "none") {
        x.style.display = "flex";
        document.getElementById("annio").setAttribute("value", annio);
        document.getElementById("seccion").setAttribute("value", seccion);
        document.getElementById("turno").setAttribute("value", turno);
        document.getElementById("nivel").setAttribute("value", nivel);
        document.getElementById("especialidad").setAttribute("value", especialidad);
        
      }
      y.style.display = "none";
      cursoasignado = true;
    };
  }
}

//Setea los combos a blanco, oculta los textos establece estilos
$(document).ready(function () {
  $("#txtSexoRpr1").hide();
  $("#txtParentescoRpr1").hide();
  $("#txtOtroParentescoRpr1").hide();
  $("#txtOtroParentescoRpr2").hide();
  $("#txtEdoCivRpr1").hide();
  $("#textAreaDirPpalRpr1").hide();
  $("#textAreaDirSecRpr1").hide();
  $("#txtCodoperadorappalrep1").hide();
  $("#txtTextoTlfPpalRpr1").hide();
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
			     "sProcessing":"Procesando..."
            },
       
        responsive: "true",
        dom: 'Bfrtilp'       
           
    });   
});


$("#submit").click(function () {
   if($("#annio").val()===""&&$("#seccion").val()===""&&$("#turno").val()===""&&$("#nivel").val()===""&&$("#especialidad").val()===""){
	  	alert("DEBE SELECCIONAR UN CURSO");
	}
     
});

$("#parentescoRpr1").change(function () {
  if ($("#parentescoRpr1").val() === "Otro") {
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
        ndoc: $("input:text[name=numDocRep1]").val()
        

      },
      url:url,
      dataType: "json", //tipo de datos retornados
      type: "GET"
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
        ndoc: $("input:text[name=numDocRep2]").val()
      },
      url: url,
      dataType: "json", //tipo de datos retornados
      type: "GET"
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
