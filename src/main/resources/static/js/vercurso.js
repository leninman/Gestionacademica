

$(document).ready(function () {


/* $("#intAnnioEsc").val("");
    $("#Annio").val("");
     $("#Turno").val("");
      $("#Seccion").val("");
        $("#Nivel").val("");*/

});





























/*var d = '<tr>' +
    '<th>NUMERO DEL ALUMNO</th>' +
    '<th>CEDULA</th>' +
    '<th>NOMBRE Y APELLIDO</th>' +
    '<th>AÑO QUE CURSA</th>' +
    '<th>SECCION</th>' +
    '<th></th>'
'</tr>';*/





/*$("#buscarAlumno").click(function () {
    $.ajax({
            data: {
                tdoc: $("select[name=inputTipoDoc]").val(),
                ndoc: $("input:text[name=inputNumeroDeCedula]").val(),
            },
            url: "http://localhost:8080/app/consultaralumno",
            dataType: 'json',
            type: "GET"
     
            
        })
        .done(function (data) {
            //table = $("#tablaAlumnos");
            //console.log(data["idAl"]);
            //console.log(table);
            //row=$("#dataRow");
            // console.log(row);

            d += '<tr>' +
                '<td>' + data["idAl"] + '</td>' +
                '<td>' + data["tipoDocAl"] + data["numDocAl"] + '</td>' +
                '<td>' + data["primNombAl"] + ' ' + data["primApellAl"] + '</td>' +
                '<td>' + data["annio"] + '</td>' +
                '<td>' + data["seccion"] + '</td>' +
                '</tr>';



            $("#tablaAlumnos").append(d);




        })
        .fail(function (data) {
            alert("El alumno no se encuentra registrado");
        });

});*/


/*$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/app/consultarcursosporperiodo",
        dataType: 'json', //tipo de datos retornados
        type: "GET"
    }).done(function (data) {

        


    });

});*/