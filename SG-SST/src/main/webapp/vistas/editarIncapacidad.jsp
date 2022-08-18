<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
    
<jsp:include page="cabecera.jsp"/>

<h3>Editar Incapacidad</h3>

      <form:form modelAttribute="ausentismo" method="POST" action="/crearIncapacidad" >
      
      <div class="row align-items-start">
        
        <div class="col">
        
         <div class="mb-3 autocompleteBS">
          <label for="nombreEmpleado" class="form-label">Nombre Empleado</label>
          <form:input type="text" path="nombre" class="form-control" id="nombreEmpleado"/>
        </div>
       
        

        <div class="d-nonx mt-2">
        
          <div class="mb-3">
            <label for="IDEmpleado" class="form-label">ID Empleado</label>
            <form:input type="text" class="form-control" id="IDEmpleado"  path="numID" />
          </div>
          
          
        </div>
        
        
        
        
         <div class="mb-3 autocompleteBS">
          <label for="inputText1" class="form-label">Diagnosticos</label>
          <input type="text" class="form-control" id="inputText1" value="${ausentismo.getDiagnostico().getDiagnostico()}"/>
        </div>
       
        

        <div class="d-nonx mt-2">
        
          <div class="mb-3">
            <label for="inputID1" class="form-label">Codigo CIE10</label>
            <form:input type="text" class="form-control" id="inputID1"  path="codigoDiagnosti"/>
          </div>
          
          
        </div>
        
        
        <div class="mb-3 ">
          <label for="inputText1" class="form-label">Salario</label>
          <form:input path="salario" type="number" class="form-control" id="salario" onblur="calcularSalario()"/>
       <form:errors path="salario"></form:errors>
        </div>
       
        

        <div class="d-nonx mt-2">
         
          <div class="mb-3">
            <label for="inputID1" class="form-label">Salario x Dia</label>
            <form:input type="text" class="form-control" id="salarioDia"  path="salarioDia"/>
          <form:errors path="salarioDia"></form:errors>
          </div>
          
          
        </div>
        
        
          <div class="mb-3 autocompleteBS">
          <label for="inputText1" class="form-label">Fecha Inicio</label>
          <form:input type="date" class="form-control" id="fechaIni" path="fechaInicial" onblur="calcularSalario()"/>
        <form:errors path="fechaInicial"></form:errors>
        </div>
       
        </div>
        
        <div class="col">

        <div class="d-nonx mt-2">
       
          <div class="mb-3">
            <label for="inputID1" class="form-label">Fecha Fin</label>
            <form:input type="date" class="form-control" id="fechaFin" path="fechaFin" onchange="calcularDias()"/>
             <form:errors path="fechaFin"></form:errors>
          </div>
          
          
        </div>
           <div class="d-nonx mt-2">
        
          <div class="mb-3">
            <label for="inputID1" class="form-label">Total Dias</label>
            <form:input type="text" class="form-control" id="totalDias" path="totalDias"/>
             <form:errors path="totalDias"></form:errors>
          </div>
          
          
        </div>
              <div class="mb-3 ">
          <label for="inputText1" class="form-label">Cargo</label>
          <form:input path="cargo" type="text" class="form-control" id="cargo" />
       <form:errors path="cargo"></form:errors>
        </div>
        
              <div class="mb-3 ">
          <label for="inputText1" class="form-label">EPS</label>
          <form:input path="EPS" type="text" class="form-control" id="EPS" />
       <form:errors path="EPS"></form:errors>
        </div>
        
        
              <div class="mb-3 ">
          <label for="inputText1" class="form-label">Clasificacion</label>
          <form:select path="clasificacion" class="form-select" id="clasificacion" >
          <form:option value="">- Seleccionar -</form:option>
          <form:option value="Inicial">Inicial</form:option>
          <form:option value="Prorroga">Prorroga</form:option>
         
          </form:select>
       <form:errors path="salario"></form:errors>
        </div>
        
         <div class="mb-3 ">
          <label for="inputText1" class="form-label">Tipo de Incapacidad</label>
          <form:select path="tipoIncapacidad" class="form-select" id="clasificacion" >
          <form:option value="">- Seleccionar -</form:option>
          <form:option value="Enfermedad Comun">Enfermedad Comun</form:option>
          <form:option value="Lic. Maternidad">Lic. Maternidad</form:option>
           <form:option value="Lic. Paternidad">Lic. Paternidad</form:option>
          <form:option value="Enfermedad Laboral">Enfermedad Laboral</form:option>
          <form:option value="Accidente de trabajo">Accidente de trabajo</form:option>
          <form:option value="Fondo Pensiones">Fondo Pensiones</form:option>
          <form:option value="Accedente de Transito">Accedente de Transito</form:option>
         
          </form:select>
       <form:errors path="tipoIncapacidad"></form:errors>
        </div>
        
        <button type="submit" class="btn btn-primary">Enviar</button>
        
        
        </div>
        </div>
        
        <form:hidden path="id"/>
      </form:form>
<jsp:include page="pie.jsp"/>