
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


function mostrar() {

    //var x=document.getElementById("tipoDocumento");
    //var y=document.getElementById("numDocumento");
    console.log(document.getElementById("tipoDocumento").nodeValue);
    console.log(document.getElementById("numDocumento").innerHTML);





}





    $("#botonBuscRep").click(function () {
        tdoc = $("#tipoDocumento").val();
        ndoc = $("#numDocumento").val();
        
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/app/consultarcursosporperiodo",
          
            
            success: function () {
                alert(hola);
            },
            error: function () {
                alert(no);
            }
        });
    });




