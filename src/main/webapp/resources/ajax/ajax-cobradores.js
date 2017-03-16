/**
 * Created by usuario on 30/04/2015.
 */
/**
 * Created by alejandro on 7/04/15.
 */
var $j = jQuery.noConflict();
$j(document).on('ready', main_consulta);

var datosJson;

function main_consulta() {
    $j.ajaxSetup({
		beforeSend: function(xhr, settings) {
			if(settings.type == "POST"){
				xhr.setRequestHeader("X-CSRFToken", $j('[name="csrfmiddlewaretoken"]').val());
			}
            if(settings.type == "GET"){
				xhr.setRequestHeader("X-CSRFToken", $j('[name="csrfmiddlewaretoken"]').val());
			}
		}
	});
    
    $j('#buscar').on('click', verDatos);
    verDatos();

}




function verDatos() {
	
	var fechaInicio = $j("#fechaInicio").val();
    var fechaFin = $j("#fechaFinal").val();
    var ajax_data = {};

    
    if (fechaInicio!=""){fechaInicio = myDateFormatter($('#fechaInicio').datepicker("getDate"));}
    if (fechaFin!=""){fechaFin = myDateFormatter($('#fechaFinal').datepicker("getDate"));}
    
    if(fechaInicio!=""){ajax_data.fechaInicio=fechaInicio;}
    if(fechaFin!=""){ajax_data.fechaFinal=fechaFin;}
    
	$j.ajax({
        url: 'consultaCobradores',
        type: 'get',
        data: ajax_data,
        success: function (data) {
            datosJson = data;
            despliegaTabla(data,fechaInicio,fechaFin);
           
        },
        error: function (data) {
            alert('error!!! ' + data.status);
        }
    });
    
}



function despliegaTabla(Datos,fechaInicio,fechaFin){
	var objJson = JSON.parse(Datos);
	var stabla = '<table id="tablaCobradores" class="table table-bordered order-column">'
    +'<thead>'
    +'  <tr>'
    +'    <th>Cobrador</th>'
    +'    <th>Meta del d&iacute;a</th>'
    +'    <th>Cobro por d&iacute;a</th>'
    +'    <th>Clientes a visitar</th>'
    +'    <th>Visitados</th>' 
    +'    <th></th>'
    +'  </tr>'
    +'</thead>'
    +'<tbody>'
	
	+ '<tr>'
			+'<th scope="row">' + objJson.Nombre + '</th>'
			+'<td>' + objJson.Meta + '</td>'
			+'<td>' + objJson.cobrado + '</td>'
			+'<td>' + objJson.porVisitar + '</td>'
			+'<td>' + objJson.Visitados + '</td>';
	        if (objJson.User_id==0){
	        	stabla +='<td>Consola</td>';
	        }else{
	        	stabla +='<td> <a href="cobradores_consola?user=' + objJson.User_id + '&fechaInicio='+ fechaInicio + '&fechaFinal=' + fechaFin + '">Consola</a></td>';
	        }    
	stabla +='</tr>'    
	+ '</tbody>'
	+'</table>'
	
	+'<script type="text/javascript">'
	+'$dr("#tablaCobradores").DataTable({'
	+'"language": {'
	+'    "lengthMenu": "Despliega _MENU_  registros por p&aacute;gina",'
	+'    "zeroRecords": "No se encontraron registros",'
	+'    "info": "Mostrando p&aacute;gina _PAGE_ de _PAGES_",'
	+'    "infoEmpty": "No hay registros disponibles",'
	+'    "search": "Buscar",'
	+'    "oPaginate":{sFirst:"First",sLast:"Last",sNext:"Siguiente",sPrevious:"Anterior"},'
	+'    "infoFiltered": "(filtrado de _MAX_ registros totales)"'
	+'   }'
	+'  } );'
	+'</script>';
	
	
	$j('#divTable').html(stabla);
	//$j('#labelFecha').html(objJson.rangoFechas);
	
		
}