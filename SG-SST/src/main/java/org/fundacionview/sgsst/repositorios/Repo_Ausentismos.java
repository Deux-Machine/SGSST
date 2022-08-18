package org.fundacionview.sgsst.repositorios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.fundacionview.sgsst.modelos.Ausentismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Ausentismos extends JpaRepository<Ausentismo, Integer>{

	
	public ArrayList<Ausentismo> findByAreaTrabajo(String areaTrabajo);
	
	
	@Query("FROM Ausentismo  WHERE  areaTrabajo=:area AND DATE(fechaRegistro) BETWEEN DATE(:FechaIn) AND DATE(:fechaFin)")
	public ArrayList<Ausentismo> consultaConfechas(@Param("area")String area,@Param("FechaIn")Date FechaIn,@Param("fechaFin")Date fechaFin);
	
	
	
	public ArrayList<Ausentismo> findByTipoIncapacidad(String tipoIncapacidad);
	
	@Query(value = "SELECT sum(asumido_empresa) as totaEmpresa,sum(totaleps) as totalEps,sum(total_pensiones) as totalPensiones,sum(totalarl) as totalArl FROM tbl_ausentismos WHERE fecha_reg BETWEEN :fechaIn AND :fechaFin", nativeQuery = true)
	public ArrayList<Map<String,Double>> consultaCuentas(@Param("fechaIn")Date fechaIn,@Param("fechaFin")Date fechaFin);
	
	
	public ArrayList<Ausentismo> findByNumID(String numID);
	
}