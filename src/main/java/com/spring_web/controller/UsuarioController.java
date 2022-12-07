package com.spring_web.controller;

import java.util.List;

import javax.crypto.interfaces.PBEKey;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_web.model.Usuario;
import com.spring_web.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<Usuario> listAll(){
        return repository.listAll();
    }

    @GetMapping("/{id}")
    public Usuario find(@PathVariable("/id") Integer id){
        return repository.finById(id);
    }

    @PostMapping("/usuarios")
    public String post(@RequestBody Usuario usuario){
        repository.save(usuario);
        return "Post enviando com sucesso";
    }

    @DeleteMapping("/usuarios/{id}")
    public String delete(@PathVariable("id") Integer id){
        repository.remove(id);
        return "Usuarios " + id + "deletado com sucesso";
    }

    @PutMapping("/usuarios")
    public String put(@RequestBody Usuario usuario){
        repository.update(usuario);
        return "Usuario" + usuario + "atualizado com sucesso";
    }
    
}
