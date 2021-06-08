
function mostrarrepresentante2() {
    element = document.getElementById("datosRepSec");
    if (element.style.display == "none") {
        element.style.display = "block";
    }
    else {
        element.style.display = 'none';
    }
}
function mostrarcursoelegido() {
    x = document.getElementById("cursoelegido");
    y = document.getElementById("tablecursos");
    z = document.getElementById("titulocursoelegido");
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
                z.style.display = "flex";
                document.getElementById("annioelegido").setAttribute("value", annio);
                document.getElementById("secelegida").setAttribute("value", seccion);
                document.getElementById("turnoelegido").setAttribute("value", turno);
                document.getElementById("nivel").setAttribute("value", nivel);
                document.getElementById("especialidad").setAttribute("value", especialidad);
                if (y.style.display == "block") {
                    y.style.display = "none";
                }
            }

        };
    }

}
//Setea los combos a blanco, oculta los texty establece estilos
$(document).ready(function(){
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
    $("#txtSexoRpr1").hide();
    $("#txtParentescoRpr1").hide();
    $("#txtEdoCivRpr1").hide();
    $("#textAreaDirPpalRpr1").hide();
    $("#textAreaDirSecRpr1").hide();
    $("#txtCodoperadorappalrep1").hide();
    $("#txtTextoTlfPpalRpr1").hide();
    $("#lbltxtTlfPpalRpr1").hide();
    $('input').css('border-radius','200px');
    $('input').css('border','solid;');
    $('input').css('color','#92a8d1;');
    $('select').css('border-radius','100px');
 
});


//Para llamar al servicio que consulta si el representante ya esta registrado
//y mostrar los datos del representante en caso de que ya este registrado
$("#botonBuscRep").click(function () {
    $.ajax({
        data: { tdoc: $('select[name=tipoDocRep1]').val(), ndoc: $('input:text[name=numDocRep1]').val() },
        url: "http://localhost:8080/app/consultarepresentante",
        dataType: 'json', //tipo de datos retornados
        type: "GET"
    }).done(function (data) {
        console.log(data);
        $("#primNombRpr1").val(data['primNombRpr']);
        $("#segNombRpr1").val(data['segNombRpr']);
        $("#primApellRpr1").val(data['primApellRpr']);
        $("#segApellRpr1").val(data['segApellRpr']);
        $("#edadRpr1").val(data['edadRpr']);
        $("#sexoRpr1").hide();
        $("#txtSexoRpr1").show();
        if(data['sexoRpr']=="M"){
            $("#txtSexoRpr1").val("Masculino");
        }
        if(data['sexoRpr']=="F"){
            $("#txtSexoRpr1").val("Femenino");
        }
        $("#parentescoRpr1").hide();
        $("#txtParentescoRpr1").show();
        $("#txtParentescoRpr1").val(data['parentescoRpr']);
        $("#edoCivRpr1").hide();
        $("#txtEdoCivRpr1").show();
        if(data['edoCivRpr']=="C"){
            $("#txtEdoCivRpr1").val("Casado(a)");
        }
        if(data['edoCivRpr']=="S"){
            $("#txtEdoCivRpr1").val("Soltero(a)");
        }
        if(data['edoCivRpr']=="V"){
            $("#txtEdoCivRpr1").val("Viudo(a)");
        }
        if(data['edoCivRpr']=="D"){
            $("#txtEdoCivRpr1").val("Divorciado(a)");
        }
        $("#fechNacRpr1").val(data['fechNacRpr']);
        $("#textoDirPpalRpr1").hide();
        $("#textAreaDirPpalRpr1").show();
        $("#textAreaDirPpalRpr1").val(data['dirPpalRpr']);
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
        $("#textAreaDirSecRpr1").val(data['dirSecRpr']);
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
        $("#lbltxtTlfPpalRpr1").show();
        $("#txtTextoTlfPpalRpr1").show();
        $("#txtCodoperadorappalrep1").show();
        var codigoArea=(data['tlfPpalRpr']).substring(0,4);
        var telefono=(data['tlfPpalRpr']).substring(5,14);
        $("#txtTextoTlfPpalRpr1").val(telefono);
        $("#txtCodoperadorappalrep1").val(codigoArea);
        $("#emailRpr1").val(data['emailRpr']);

    }).fail(function(data) {
        alert( "error" );
      });
});








