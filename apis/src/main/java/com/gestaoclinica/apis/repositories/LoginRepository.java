package com.gestaoclinica.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoclinica.apis.entities.Usuario;
import com.gestaoclinica.apis.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
