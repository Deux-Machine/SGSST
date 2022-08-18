<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
</div>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
  
  <script src="https://oportuna.red/apks/autocompleteBS.js"></script>
  
  <!--  Librerias Jquery Datatables -->

  <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
   <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
  
     
 <script type="text/javascript">
 
 function calcularDias(){
	 var fechaIni= document.getElementById("fechaIni").value;
	 var fechaFin= document.getElementById("fechaFin").value;
	 
	 var tiempo1=Date.parse(fechaIni);
	 var tiempo2=Date.parse(fechaFin);
	 
	 var total=tiempo2-tiempo1;
	 
	 var dias= total/(1000*60*60*24);
	 
	 document.getElementById("totalDias").value=dias;
 }
 
 
 function calcularSalario(){
	 
	var salario= document.getElementById("salario").value;
	
	var totalDia=salario/30;
	
	document.getElementById("salarioDia").value=totalDia;
	 
 }
 
 
 function alertaClick(){
	 window.alert("Evento Click de campo de texto");
 }
 
 
 const autoCompleteConfig = [{
	    name: 'Diagnosticos CIE10',
	    debounceMS: 250,
	    minLength: 3,
	    maxResults: 20,
	    inputSource: document.getElementById('inputText1'),
	    targetID: document.getElementById('inputID1'),
	    fetchURL: 'http://localhost:8087/apis/diagnosticos?texto={term}',
	    fetchMap: {id: "codigo",
	               name: "diagnostico"}
	  },
	  {
		    name: 'Empleados',
		    debounceMS: 250,
		    minLength: 3,
		    maxResults: 20,
		    inputSource: document.getElementById('nombreEmpleado'),
		    targetID: document.getElementById('IDEmpleado'),
		    fetchURL: 'http://localhost:8087/apis/empleados?texto={term}',
		    fetchMap: {id: "numID",
		               name: "nombre"}
		  }
	  
	];
	console.log(autoCompleteConfig);
	// Initiate Autocomplete to Create Listeners
	autocompleteBS(autoCompleteConfig);
	function resultHandlerBS(inputName, selectedData) {
	  console.log(inputName);
	  console.log(selectedData);
	}
 
 </script>   
</body>
</html>