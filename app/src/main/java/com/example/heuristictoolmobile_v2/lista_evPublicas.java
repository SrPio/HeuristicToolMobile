package com.example.heuristictoolmobile_v2;

import java.io.Serializable;

public class lista_evPublicas implements Serializable {
    public String id;
    public String empresa;
    public String tipoImplementacion;
    public String tipoAplicacion;
    public String tipoEvaluacion;
    public String proposito;
    public String usuarioCreador;
    public String año;

    public lista_evPublicas(String id, String empresa, String tipoImplementacion, String tipoAplicacion, String tipoEvaluacion, String proposito, String usuarioCreador, String año) {
        this.id = id;
        this.empresa = empresa;
        this.tipoImplementacion = tipoImplementacion;
        this.tipoAplicacion = tipoAplicacion;
        this.tipoEvaluacion = tipoEvaluacion;
        this.proposito = proposito;
        this.usuarioCreador = usuarioCreador;
        this.año = año;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoImplementacion() {
        return tipoImplementacion;
    }

    public void setTipoImplementacion(String tipoImplementacion) {
        this.tipoImplementacion = tipoImplementacion;
    }

    public String getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(String tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}
