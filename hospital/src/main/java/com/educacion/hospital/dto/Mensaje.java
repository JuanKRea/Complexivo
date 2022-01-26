
package com.educacion.hospital.dto;

import java.io.Serializable;


public class Mensaje implements Serializable {

    private String header;
    private String descripcion;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
