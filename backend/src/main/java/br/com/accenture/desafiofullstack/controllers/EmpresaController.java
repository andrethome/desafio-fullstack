package br.com.accenture.desafiofullstack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.accenture.desafiofullstack.model.Empresa;
import br.com.accenture.desafiofullstack.repositories.EmpresaRepository;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

	@Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Empresa create(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @GetMapping
    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Empresa buscarPorId(@PathVariable Long id) {
        var empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return empresaOptional.get();
    }
    
    @PutMapping("/{id}")
    public Empresa updatePorId(@PathVariable Long id, @RequestBody Empresa empresa) {
        var empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        empresa.setId(id);
        return empresaRepository.save(empresa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
        var empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        empresaRepository.delete(empresaOptional.get());
    }
}
