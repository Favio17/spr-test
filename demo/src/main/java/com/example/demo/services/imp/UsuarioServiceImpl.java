package com.example.demo.services.imp;

import com.example.demo.exception.UsuarioNotFoundException;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public Usuario saveUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUser(Long id, Usuario usuario) {
        Usuario usuarioExistente = getById(id);
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setCorreo(usuario.getCorreo());
        usuarioExistente.setContrasenia(usuario.getContrasenia());
        usuarioExistente.setActivo(usuario.getActivo());
        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void deleteUser(Long id) {
        Usuario usuario = getById(id);
        usuarioRepository.delete(usuario);
    }
}
