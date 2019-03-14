
package org.integrados.controller.estadisticas;

import java.util.List;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseAlumnoDlg;
import org.integrados.view.DocenteInicioDlg;

public class DocenteBrowseAlumnoCtrl {

    private DocenteBrowseAlumnoDlg alumnoBrw;
    public DocenteInicioDlg docenteInicioDlg;
    private PersonaABM alumnoABM = new PersonaABM();
    private List<Alumno> listaAlumnos;
    private int contadorRealizadas = 0;
    private int contadorNoRealizadas = 0;

    public DocenteBrowseAlumnoCtrl() {
    }

    
    public DocenteBrowseAlumnoCtrl(DocenteInicioDlg docenteInicioDlg) {
        this.docenteInicioDlg = docenteInicioDlg;
    }
    

    public void mostrarBrw() {
        Docente docente = this.docenteInicioDlg.getDocenteInicioCtrl().getDocente();
        listaAlumnos = alumnoABM.listaAlumnos(docente.getId());
        this.cantRealizadasYNo(listaAlumnos);

        alumnoBrw = new DocenteBrowseAlumnoDlg(this, listaAlumnos, this.contadorRealizadas, this.contadorNoRealizadas);
        this.alumnoBrw.mostrar();
    }

    public void cantRealizadasYNo(List<Alumno> alumnos) {

        for (Alumno alumno : alumnos) {
            for (RegistroActividad reg : alumno.getRegistroActividades()) {
                try {
                    if (reg.getFinalizoCorrectamente()) {
                        this.contadorRealizadas++;
                    } else { 
                        this.contadorNoRealizadas++;
                    }
                } catch (Exception e) {
                    System.out.println("Error en metodo cantRealizadasYNo");
                }
            }
        }
    }

    public void ocultar() {
        alumnoBrw.setVisible(false);
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.alumnoBrw.ocultar();
            LoginCtrl.app.cerrar();
        }
    }

}
