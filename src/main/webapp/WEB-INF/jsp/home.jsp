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
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/resources/bootstrap/fonts/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
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
function envia(page) {
	window.location.replace("<%=request.getContextPath()%>"+page);
}
</script>
    
	<div class="center">
        <div class="container">
        	<div class="row">
            	<div class="col-md-3">
                	&nbsp;
   				</div>
            	<div class="col-md-6 text-center">
                <h1 class="header">Reporte General</h1>
                <div class="panel panel-primary">
                	<div class="panel-heading">
                        <h3 class="panel-title">20 Abril 2015 a 22 de Abril 2015</h3>
                        <button id="button-float-table" class="btn btn-fab btn-fab-mini btn-raised btn-sm btn-material-amber"><i class="mdi-action-print"></i></button>
                    </div>
                
                            
                    <div class="panel-body">
                    	<div class="table-responsive">
                          <table class="table table-bordered">
                            <thead>
                              <tr>
                                <th>Visitados</th>
                                <th>Por Visitar</th>
                                <th>Cobranza Total</th>
                                <th>Por Cobrar</th>
                                <th>Cobrado</th>            
                              </tr>
                            </thead>
                            <tbody>
                              <tr>
                                <th scope="row">1</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                              </tr>
                              <tr>
                                <th scope="row">2</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                              </tr>
                              
                            </tbody>
                          </table>
    				</div>
                    </div>
                </div>
                
             <h1 class="header">Selecciona un rango de fechas</h1>
   		 	 <div class="panel panel-primary">
                    <div class="panel-body">
                    	<div class="input-daterange input-group" id="datepicker">
                            <input type="text" class="input-sm form-control floating-label" name="start" placeholder="Desde" />
                            <span class="input-group-addon">a</span>
                            <input type="text" class="input-sm form-control floating-label" name="end" placeholder="Hasta"/>
                		</div>
                        <div class="text-center">
                <button id="" class="btn btn-fab btn-fab-micro btn-raised btn-sm btn-primary"><i class="mdi-content-forward"></i></button>
						</div>
                    </div>
             </div>
            	</div>
                <div class="col-md-3">
                	&nbsp;
   				</div>
            </div>            
		</div>            
	</div><!-- /.center -->

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ripples.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/material.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-datepicker.js"></script>
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
        </script>
        
    </body>
</html>