package org.integrados.data.bloques;

public class Bloque {

    protected Integer id;

    protected Bloque() {
        this.id= null;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Bloque{" + "id=" + id + '}';
    }
    
    /**
     * el metodo equals recibiria dos objetos. dentro del metodo solo se compara si son dos bloques iguales, sin depender del tipo de bloque
     
     public boolean equals(Bloque solucion, Bloque respuestaAlumno){
     *  
     * return (respuestaAlumno.equals(solucion);
     *      
     }
     */
}
