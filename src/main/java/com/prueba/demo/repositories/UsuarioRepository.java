package com.prueba.demo.repositories;

import com.prueba.demo.models.UsuarioModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    @Query(value = "select * from users where numero_documento = :cedula", nativeQuery = true)
    UsuarioModel getUsuario(@Param("cedula") String Cedula);

}
