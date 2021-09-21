var IdMateriaAsignada = [];
var direccionbase;
var materia;
var id;
var annio;
var nivel;
var especialidad;
var idmateria;
var Profesor=[];




$("#botonAsignar").click(function () {
  materia = $("#materia").val();
  annio = $("#annio").val();
  nivel = $("#nivel").val();
  especialidad = $("#especialidad").val();
  direccionbase = $("#direccionbase").val();
  url = direccionbase + "/validarmateria";
  $.ajax({
      data: {
        materia: $("select[name=materia]").val(),
        annio: $("select[name=annio]").val(),
        nivel: $("select[name=nivel]").val(),
        especialidad: $("select[name=especialidad]").val(),
      },
      url: url,
      type: "GET",
    })
    .done(function (response) {
      if (response != '') {
        let htmlTags = '<tr>' +
          '<td>' + materia + '</td>' +
          '<td>' + annio + '</td>' +
          '<td>' + nivel + '</td>' +
          '<td>' + especialidad + '</td>' +
          '<td><a type="button" class="btn btn-secondary" data-toggle="tooltip" data-placement="top"title="Eliminar" id="btnEliminar"><i class="bi bi-trash"></i></a></td>' +
          '</tr>';
        $('#tablemateriasasignadas tbody').append(htmlTags);
        IdMateriaAsignada.push(id);
      } else {
        alert('NO EXISTE MATERIA CON ESTOS PARÁMETROS');
      }
    });
});

$("#registrarprofesor").click(function () {
  direccionbase = $("#direccionbase").val();
  url = direccionbase + "/agregarprofesor";
// Get form
var form = $('#formProfesor')[0];
console.log(form);
 // FormData object 
 //var data = new FormData(form);
//var profe=data.get(profesor);
//console.log(profe);
 //data.append('idMat',IdMateriaAsignada);

 /*$.ajax({
  type: "POST",
  enctype: 'multipart/form-data',
  url: url,
  data: {
    profesor:profe,
    idMat:IdMateriaAsignada,
  },
  processData: false,
  contentType: false,
  cache: false,
  timeout: 800000,
  success: function (data) {
    
      console.log("SUCCESS : ", data);
     
  },
  error: function (e) {
    
      console.log("ERROR : ", e);
     
  }
});*/




  /*direccionbase = $("#direccionbase").val();
  url = direccionbase + "/agregarprofesor";
  Profesor=new FormData(document.getElementById('formProfesor'));
  console.log(Profesor);
  $.ajax({
    data: {
      profesor:Profesor,
      idMat:IdMateriaAsignada,
    },
  
    url:url,
    dataType: "json", //tipo de datos retornados
    type: "POST",

  })
  .done(function (response) {

  });*/
  

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
});

$(document).on('click', '#btnEliminar', function (event) {
  event.preventDefault();
  $(this).closest('tr').remove();
});

$("#btnLimpiar").click(function () {
  window.location.href = "/app/registroprofesor";
});