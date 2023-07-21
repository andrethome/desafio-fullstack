package br.com.accenture.desafiofullstack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import br.com.accenture.desafiofullstack.model.Fornecedor;
import br.com.accenture.desafiofullstack.repositories.FornecedorRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/v1/fornecedor")
public class FornecedorController {

	@Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Fornecedor create(@RequestBody Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @GetMapping
    public List<Fornecedor> listar() {
        return fornecedorRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Fornecedor buscarPorId(@PathVariable Long id) {
        var fornecedorOptional = fornecedorRepository.findById(id);
        if (fornecedorOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return fornecedorOptional.get();
    }
    
    @PutMapping("/{id}")
    public Fornecedor updatePorId(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        var fornecedorOptional = fornecedorRepository.findById(id);
        if (fornecedorOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        fornecedor.setId(id);
        return fornecedorRepository.save(fornecedor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
        var fornecedorOptional = fornecedorRepository.findById(id);
        if (fornecedorOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        fornecedorRepository.delete(fornecedorOptional.get());
    }

}
