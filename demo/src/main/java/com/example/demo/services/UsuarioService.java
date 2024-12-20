package com.example.demo.services;

import com.example.demo.models.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAll();
    Usuario getById(Long id);
    Usuario saveUser(Usuario usuario);
    Usuario updateUser(Long id, Usuario usuario);
    void deleteUser(Long id);
}