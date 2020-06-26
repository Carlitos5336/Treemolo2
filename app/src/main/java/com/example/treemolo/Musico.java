package com.example.treemolo;

import java.util.Date;

public class Musico {
    private String nombre;
    private String desc;
    private int image;
    private boolean sexo;
    private Date fecha_nac;
    private String direccion;

    public Musico(String nombre, String desc, int image, boolean sexo, Date fecha_nac, String direccion) {
        this.nombre = nombre;
        this.desc = desc;
        this.image = image;
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
