/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.integrados.data.actividad.ActividadAlumno;
import org.integrados.data.enums.Nivel;

/**
 *
 * @author Yani
 */
public class Alumno extends Persona {

    private List<ActividadAlumno> actividades;
    private Date fechaNacimiento;
    private int edadMadurativa;
    private int grado;
    private String division;
    private Nivel nivel;
    private String observaciones;

    public Alumno(int dni, String nombre, String apellido, int grado, String division) {
        super(dni, nombre, apellido);
        this.grado = grado;
        this.division = division;
        this.actividades = new ArrayList<>();
    }

    public Alumno(int dni, String nombre, String apellido, String usuario, String clave, int grado, String division) {
        super(dni, nombre, apellido, usuario, clave);
        this.grado = grado;
        this.division = division;
        this.actividades = new ArrayList<>();
    }

    public List<ActividadAlumno> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadAlumno> actividades) {
        this.actividades = actividades;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdadMadurativa() {
        return edadMadurativa;
    }

    public void setEdadMadurativa(int edadMadurativa) {
        this.edadMadurativa = edadMadurativa;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Alumno{" + "actividades=" + actividades + ", fechaNacimiento=" + fechaNacimiento + ", edadMadurativa=" + edadMadurativa + ", grado=" + grado + ", division=" + division + ", nivel=" + nivel + ", observaciones=" + observaciones + '}';
    }

}
