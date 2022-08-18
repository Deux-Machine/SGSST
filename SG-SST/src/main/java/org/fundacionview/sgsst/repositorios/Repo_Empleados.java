package org.fundacionview.sgsst.repositorios;

import java.util.ArrayList;

import org.fundacionview.sgsst.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Empleados extends JpaRepository<Empleado, Long>{

	@Query("FROM Empleado WHERE nombre LIKE %:texto% OR numID LIKE %:texto%")
	public ArrayList<Empleado> consultaPorNombreo_ID(@Param("texto")String texto);
	
	@Query(value="SELECT *FROM tbl_empleado WHERE numID=:cc ORDER BY id LIMIT 1",nativeQuery = true)
	public Empleado consultarCC(@Param("cc")String cc);
	
}