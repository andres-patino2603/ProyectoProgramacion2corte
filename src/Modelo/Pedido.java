/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Falabella
 */
public class Pedido {

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    private int id;
    private double valor;
    private int cantidad;

    public Pedido(int id, double valor, int cantidad) {
        this.id = id;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    // Getters y setters (opcional)

    // Ejemplo de método toString para imprimir el objeto Pedido
    @Override
    public String toString() {
        return "Pedido [id=" + id + ", valor=" + valor + ", cantidad=" + cantidad + "]";
    }

    public int getId() {
       return id;
    }
}
