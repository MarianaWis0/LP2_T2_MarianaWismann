package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, String>{

	EmpleadoEntity findByDni(String dni);
	
	@Query(value ="select * from tb_empleado where dni_empleado = :dni " , nativeQuery = true )
	EmpleadoEntity findByDniE(@Param("dni") String dni);
}
