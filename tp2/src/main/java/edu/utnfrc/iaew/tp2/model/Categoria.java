package edu.utnfrc.iaew.tp2.model;

/**
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.001
 * Ultimo cambio: 17/05/2016
 */
public enum Categoria {
    Periferico, Disco, CPU, RAM, Motherboard;
    
    /*@Override
    public String toString() {
        switch(this) {
            case Periferico: return "Periferico";
            case Disco: return "Disco Duro";
            case CPU: return "CPU";
            case RAM: return "Memoria RAM";
            case Motherboard: return "Motherboard";                         
            default: throw new IllegalArgumentException();
        }
    }*/
}
