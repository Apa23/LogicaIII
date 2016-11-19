/**
 * @author Juan Pablo Tobón Flórez y Andrés Felipe Aparicio Mestre
 */
package Vista;

import com.mxgraph.swing.mxGraphComponent;
import javax.swing.JFrame;

/** 
 * ClaseVistaGrafo: Clase que hereda JFrame y contiene la representación visual 
 * del grafo.
 */
public class VistaGrafo extends JFrame {
    
     /**
     * Constructor de la clase que asigna sus parametros de entrada a los 
     * atributos de la clase.
     * @param controladorGrafo
     */
    public VistaGrafo(mxGraphComponent controladorGrafo) {
        
        this.add(controladorGrafo);
        this.pack();
        this.setLocationRelativeTo(null);
        
    }
}
