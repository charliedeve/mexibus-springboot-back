package com.example.com.example.crudReact.dto;



public class EspacioDTO implements java.io.Serializable{

    private Long idEspacio;

    private String nombre;

    private String dimensiones;

    private int precio;

    private String estado;

    public EspacioDTO(){}

    public EspacioDTO(Long idEspacio, String nombre, String dimensiones, int precio, String estado) {
        this.idEspacio = idEspacio;
        this.nombre = nombre;
        this.dimensiones = dimensiones;
        this.precio = precio;
        this.estado = estado;
    }

    public Long getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(Long idEspacio) {
        this.idEspacio = idEspacio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
