/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ConstruyeGrafo;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import javax.swing.JFrame;

/**
 *
 * @author Apa
 */
public class VistaGrafo extends JFrame {

    public VistaGrafo(mxGraphComponent controladorGrafo) {
        
        this.add(controladorGrafo);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    }
}
