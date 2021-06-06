
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









    $("#sexoRpr1").val("");
    $("#tdocrep1").val("");
    
});

$("#botonBuscRep").click(function () {
    $.ajax({
        data: { tdoc: $('select[name=tdoc]').val(), ndoc: $('input:text[name=ndoc]').val() },
        url: "http://localhost:8080/app/consultarepresentante",
        dataType: 'json', //tipo de datos retornados
        type: "GET"
    }).done(function (data) {
        console.log(data);
        document.getElementById("primNombRpr1").setAttribute("value", data['primNombRpr']);
        document.getElementById("segNombRpr1").setAttribute("value", data['segNombRpr']);
        document.getElementById("primApellRpr1").setAttribute("value", data['primApellRpr']);
        document.getElementById("segApellRpr1").setAttribute("value", data['segApellRpr']);
        document.getElementById("edadRpr1").setAttribute("value", data['edadRpr']);
        document.getElementById("sexoRpr1").setAttribute("value", data['sexoRpr']);

    });
});








