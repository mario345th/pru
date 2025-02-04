/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author MINEDUCYT
 */
public class Vertice<T> {
    
    private T v;
    private int x;
    private int y;

    public Vertice() {
    }

    public Vertice(T v, int x, int y) {
        this.v = v;
        this.x = x;
        this.y = y;
    }

    public T getV() {
        return v;
    }

    public void setV(T v) {
        this.v = v;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vertice{" + "v=" + v + '}';
    }
    
    
    
}
