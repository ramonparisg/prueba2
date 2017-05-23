/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author raparisg
 */
public class Post {
    private int id;
    private int usuarioId;
    private String titulo;
    private String cuerpo;
    private int postEstadoId;
    private String fechaCreacion;

    public Post() {
    }

    public Post(int id, int usuarioId, String titulo, String cuerpo, int postEstadoId, String fechaCreacion) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.postEstadoId = postEstadoId;
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getPostEstadoId() {
        return postEstadoId;
    }

    public void setPostEstadoId(int postEstadoId) {
        this.postEstadoId = postEstadoId;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
    
}
