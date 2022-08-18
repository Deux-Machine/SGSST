<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="cabecera.jsp"/>
<link href="/css/autocompleteBS.css" rel="stylesheet" />
<center><h3>Reporte por Empleado</h3></center>

<br/>
<hr/>
<form action="/reporteEmpleado" method="POST">
<div class="container">
<div class="input-group mb-3 autocompleteBS">
  <span class="input-group-text" id="basic-addon1">Buscar Empleado</span>

         
          <input type="text" class="form-control" id="nombreEmpleado" name="nombre" />
        
       
       
    
         
          
            <input type="hidden" class="form-control" id="dataEmpleado"  name="numDoc" />
          


</div>
</div>
<br/>
<center><button onclick="return verificarIdEm();" type="submit" class="btn btn-primary">Enviar</button></center>
</form>



<jsp:include page="pie.jsp"/>
<script src="/js/autocompleteBS.js"></script> 
<script>
function verificarIdEm(){
	var idEm=document.getElementById("dataEmpleado").value;
	if(idEm==''){
		alert("Por favor seleccionar un empleado del listado de busqueda");
		return false;
	}else{
		return true;
	}
	
}
const autoCompleteConfig = [{
    name: 'Empleados',
    debounceMS: 250,
    minLength: 3,
    maxResults: 20,
    inputSource: document.getElementById('nombreEmpleado'),
    targetID: document.getElementById('dataEmpleado'),
    fetchURL: 'http://localhost:8087/api/empleados?text={term}',
    fetchMap: {id: "id_user",
               name: "nombre"}
  }
];
//console.log(autoCompleteConfig);
// Initiate Autocomplete to Create Listeners
autocompleteBS(autoCompleteConfig);
function resultHandlerBS(inputName, selectedData) {
  console.log(inputName);
  console.log(selectedData);
}
</script>