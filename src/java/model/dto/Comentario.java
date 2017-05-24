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
public class Comentario {
    private int id;
    private int usuarioId;
    private int postId;
    private String comentario;
    private int comentarioEstadoId;
    private String fechaCreacion;

    public Comentario(int usuarioId, int postId, String comentario, int comentarioEstadoId) {
        this.usuarioId = usuarioId;
        this.postId = postId;
        this.comentario = comentario;
        this.comentarioEstadoId = comentarioEstadoId;
    }

    public Comentario(int id, int usuarioId, int postId, String comentario, int comentarioEstadoId, String fechaCreacion) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.postId = postId;
        this.comentario = comentario;
        this.comentarioEstadoId = comentarioEstadoId;
        this.fechaCreacion = fechaCreacion;
    }

    public Comentario() {
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getComentarioEstadoId() {
        return comentarioEstadoId;
    }

    public void setComentarioEstadoId(int comentarioEstadoId) {
        this.comentarioEstadoId = comentarioEstadoId;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
