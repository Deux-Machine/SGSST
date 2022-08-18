package org.fundacionview.sgsst.repositorios;

import java.util.ArrayList;
import java.util.Optional;

import org.fundacionview.sgsst.modelos.CIE10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo_Cie10  extends JpaRepository<CIE10, Integer> {

	
	// HQL   -.--  SQL
	
	@Query(value = "FROM CIE10 WHERE diagnostico like :diagnostico",nativeQuery = true)
	public ArrayList<CIE10> getDiagnostico(@Param("diagnostico")String diagnostico);
	
	
	@Query("FROM CIE10 WHERE origen='E.G'  OR seg_osteomuscular='CRANEO'")
	public ArrayList<CIE10> consultaAND();
	
	
	@Query("FROM CIE10 WHERE codigo BETWEEN 'Z400' AND 'Z499'")
	public ArrayList<CIE10> consultaBETWEEN();
	
	
	@Query("FROM CIE10 WHERE diagnostico LIKE %:texto% OR codigo LIKE %:texto%")
	public ArrayList<CIE10> consultaPorDiagnostico_Codigo(@Param("texto")String texto);
	
	
	@Query("FROM CIE10 where id IN (12052,12056,12067)")
	public ArrayList<CIE10> consultarIN();
	
	
	
	public Optional<CIE10> findByCodigo(String codigo);
	
	
}