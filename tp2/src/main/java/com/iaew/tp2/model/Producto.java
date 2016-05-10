/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iaew.tp2.model;

import org.joda.time.LocalDate;

/**
 *
 * @author ang_2
 */
public class Producto {

    private int idProducto, stockDisponible;
    private String nombre, descripcion;
    private float precioLista;
    private Categoria categoria;
    private LocalDate fechaAlta;

    public Producto() {
    }

    public Producto(int stockDisponible, String nombre, String descripcion, float precioLista, Categoria categoria, LocalDate fechaAlta) {
        this.stockDisponible = stockDisponible;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioLista = precioLista;
        this.categoria = categoria;
        this.fechaAlta = fechaAlta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(float precioLista) {
        this.precioLista = precioLista;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", stockDisponible=" + stockDisponible + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioLista=" + precioLista + ", categoria=" + categoria + ", fechaAlta=" + fechaAlta + '}';
    }

}
