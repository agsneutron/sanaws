<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin-Sana</title>
        <!-- bootstrap -->
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/roboto.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/material.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/ripples.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/custom.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-datepicker.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
        
        <script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.11.3.min.js">
	</script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js">
	</script>
        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/ajax/utilerias.js"></script>
        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/ajax/ajax-cobradores.js"></script>
        
        <!-- font Awesome -->
        <!-- Google font -->
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <%@ include file="/WEB-INF/jsp/menu.jsp"%>
    
<script>
$dr=jQuery.noConflict();
$dr(document).ready(function() {
    $dr('#tableRuta').DataTable({
        "language": {
            "lengthMenu": "Despliega _MENU_  registros por página",
            "zeroRecords": "No se encontraron registros",
            "info": "Mostrando página _PAGE_ de _PAGES_",
            "infoEmpty": "No hay registros disponibles",
            "search": "Buscar",
            "oPaginate":{sFirst:"First",sLast:"Last",sNext:"Siguiente",sPrevious:"Anterior"},
            "infoFiltered": "(filtrado de _MAX_ registros totales)"
            
        }
    } );
} );

function envia(page) {
	window.location.replace("<%=request.getContextPath()%>"+page);
}
</script>
 
    
	<div class="">
        <div class="container">
        <div class="cobrador-ruta">
        <h1 class="text-center color-amber">Consola ${usuario}</h1>
        	<div class="row">
            	<div class="col-sm-6 col-md-6 col-lg-6 ">
                    <div class="panel panel-primary">
                        <div class="panel-heading double-line">
                        	<div class="col-xs-6 col-sm-6 col-md-9">
                            	<h3 class="panel-title">Ruta 20 abril 2015</h3>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-3 input-group date">
                                <form class="" style="display:none">
                                  <input type="text" class="form-control floating-label white" placeholder="Busqueda...">
                                </form>
                                <button id="button-float" class="btn btn-fab btn-fab-mini btn-raised btn-sm btn-material-amber"><i class="mdi-editor-insert-invitation"></i></button>
                            </div>
                        </div>
                    <div class="panel-body">
                            <div class="table-responsive text-center">
                                  <table class="table table-bordered" id="tableRuta">
                                    <thead>
                                      <tr>
                                        <th>No.</th>
                                        <th>Cliente</th>
                                        <th>Hr. Visita</th>
                                        <th>Cuota</th>    
                                        <th>¿Cobro?</th>
                                        <th>Cobrado</th> 
                                        <th>Razon</th>         
                                      </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="cliente" items="${listaClientes}">
                                      <tr>
                                        <td>1</td>
                                        <td>${cliente.cliente}</td>
                                        <td>${cliente.horario}</td>
                                        <td>${cliente.cuota}</td>
                                        <td><span class="glyphicon ${cliente.circulo}" aria-hidden="true"></span>
                                        </td>
                                        <td>${cliente.cobrado}</td>
                                        <td>${cliente.razon}</td>
                                      </tr>
                                     </c:forEach>
                                      
                                    </tbody>
                                  </table>
                            </div>
                        </div>
                    </div>
            	</div>
                <div class="col-sm-6 col-md-6 col-lg-6 text-center">
                	<div id="map-ruta">&nbsp;</div>
                </div>
            </div>
            <div class="row">    
                <div class="col-sm-3 col-md-3 col-lg-3">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Clientes Asignados</h3>
                    </div>
                    <div class="panel-body">
                       <div class="list-group">
						<c:forEach var="asignado" items="${clientesAsignados}">

	                        <!-- item-->
	                        <a href="#" class="btn btn-flat btn-primary list-custom">
	                            <div class="list-group-item">
	                                <div class="icon-clients">
	                                    <i class="mdi-action-account-circle"></i>
	                                </div>
	                                <div class="row-content">
	                                    <p class="list-group-item-text">${asignado.cliente}</p>
	                                </div>
	                            </div>
	                         </a>
	                         <!-- item-->   
                            <div class="list-group-separator"></div>
                         	<!-- item-->
                         
                         </c:forEach> 
                         
                                                   
                        </div>
                    </div>
                </div>
   				</div>
                <div class="col-sm-6 col-md-6 col-lg-6">
                	<div id="map-client-asig">&nbsp;</div>
                </div>
                <div class="col-sm-3 col-md-3 col-lg-3">
                    <div class="well">
                    	<h1 class="sub-header">Meta del dia <br> <strong>$3,600</strong></h1> 
                        <h1 class="sub-header">Cobrado <br> <strong>$350</strong></h1>
                        <button class="btn btn-fab btn-raised btn-material-amber"><i class="mdi-action-print"></i></button> 
                     </div>
   				</div>
            </div> 
            </div>           
		</div>            
	</div><!-- /.center -->

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ripples.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/material.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-datepicker.js"></script>
        
         	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
			<script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.gmap.js"></script>
	   <script src="${pageContext.request.contextPath}/resources/js/distanciasMap.js"></script>
	 		
   <script type="text/javascript">
    var locations = [
      	['Morelos No. 105  Col. Centro, Tula de Allende Hidalgo ', 20.0539368, -99.3430843, 1], 
		['Lic Benito Juarez No. 212, Col. Centro C.P. 93990 Panuco Veracruz', 22.0595745, -98.1796215, 2],
		['Maximino Avila Camacho #107 Col. Centro CP 93600 Martinez de la Torre,  Ver.', 20.062972, -97.0529809, 3], 
		['Plaza Principal # 27 Col. Centro C.P. 37980 San Jose Iturbide Gto.', 21.0000002, -100.3853965, 4],
		['Hidalgo #185-B Col. Centro C.P. 99100, Sombrerete Zacatecas', 23.6339499, -103.6372117, 5],
    ];
//Mapa Clientes Asigandos
    var map = new google.maps.Map(document.getElementById('map-client-asig'), {
      zoom: 10,
      center: new google.maps.LatLng(19.2799481,-99.669227),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });
    var infowindow = new google.maps.InfoWindow();
    var marker, i;
    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });
      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
//Mapa ruta del cobrador	
initialize();
  </script>
  
  
  
        <script>
            $(document).ready(function() {
                // This command is used to initialize some elements and make them work properly
                $.material.init();
            });
        </script>
        <script type="text/javascript">
		
            $(function() {               
                $(".center").center();
                $(window).resize(function() {
                    $(".center").center();
                });
            });
            /* Centrar elementos */
            jQuery.fn.center = function() {
                this.css("position", "absolute");
                this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) +
                        $(window).scrollTop()) - 1 + "px");
                this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) +
                        $(window).scrollLeft()) + "px");
                return this;
            }
			$('.input-daterange').datepicker({
				language: "es"
			});
			$('#consola-date').datepicker({
			});
			$('.input-group.date').datepicker({
			});
        </script>
        
    </body>
</html>