package com.gestaoclinica.apis.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.Equipamento;
import com.gestaoclinica.apis.repositories.EquipamentoRepository;
import com.gestaoclinica.apis.service.exceptions.CamposObrigatoriosException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoRepository repository;

	public List<Equipamento> findAll() {
		return repository.findAll();

	}

	public Equipamento insert(Equipamento obj) {
		try {
			repository.save(obj);
		} catch (DataIntegrityViolationException e) {

			throw new RecursoJaCadastradoException("Essa máquina já foi cadastrada no sistema.", obj.getEquipamento());

		} catch (ConstraintViolationException e) {
			
			throw new CamposObrigatoriosException(null,"Campos obrigatórios devem ser preenchidos.");
			
		} catch (RuntimeException e) {

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}

	public Equipamento delete(Equipamento obj) {

		try {
			repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e) {

			throw new RecursoNaoEncontradoException("a essa máquina", obj.getId());

		} catch (EmptyResultDataAccessException e) {

			throw new RecursoNaoEncontradoException("a essa máquina", obj.getId());

		}  catch (InvalidDataAccessApiUsageException e) {
			
			throw new CamposObrigatoriosException(null,"O id do recurso a ser deletado deve ser informado.");
			
			
		} catch (RuntimeException e) {
		

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}

}
