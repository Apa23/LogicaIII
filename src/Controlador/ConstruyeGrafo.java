/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Grafo;
import Modelo.ListaLigadaAdya;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.util.HashMap;

/**
 *
 * @author Apa
 */
public class ConstruyeGrafo {

    mxGraph graph = new mxGraph();
    Object parent = graph.getDefaultParent();
    mxGraphComponent graphComponent;

    public ConstruyeGrafo(Grafo grafo) {
        graph.getModel().beginUpdate();
        try {
            
            Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,30);
            Object v2 = graph.insertVertex(parent, null, "World!", 240, 150,80, 30);
            graph.insertEdge(parent, null, "", v1, v2);
        } finally {
            graph.getModel().endUpdate();
        }
        graphComponent = new mxGraphComponent(graph);
        graph.setAllowDanglingEdges(false);
        graph.setCellsResizable(false);
        graph.setCellsEditable(false);
        graph.setEdgeLabelsMovable(false);
    }

    public mxGraphComponent getGraphComponent() {
        return graphComponent;
    }

}
