package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento en MySQL
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50) // Columna 'nombre'
    private String nombre;

    @Column(name = "correo", nullable = false, unique = true) // Columna 'correo'
    private String correo;

    @Column(name = "password", nullable = false) // Columna 'contraseña'
    private String contrasenia;

    @Column(name = "activo", nullable = false) // Indica si el usuario está activo
    private Boolean activo;

    // Constructor sin argumentos (requerido por JPA)
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombre, String correo, String contrasenia, Boolean activo) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.activo = activo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

