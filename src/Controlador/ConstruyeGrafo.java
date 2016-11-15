/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Grafo;
import Modelo.ListaLigadaAdya;
import Modelo.NodoSimple;
import Vista.VistaGrafo;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Apa
 */
public class ConstruyeGrafo {

    mxGraph graph = new mxGraph();
    Object parent = graph.getDefaultParent();
    mxGraphComponent graphComponent;
    Object vertices[];
    Random rnd = new Random();

    public ConstruyeGrafo(Grafo grafo) {
        vertices = new Object[grafo.getNumVertices()];
        for (int i = 0; i < grafo.getNumVertices(); i++) {

            Object vertice = graph.insertVertex(parent, null, grafo.getVertices().get(i),
                    20 + (int) (rnd.nextDouble() * 500), 20 + (int) (rnd.nextDouble() * 500), 80, 30);
            vertices[i] = vertice;
        }
        graph.getModel().beginUpdate();
        try {
            for (int i = 0; i < grafo.getNumVertices(); i++) {
                NodoSimple q = grafo.getLista().getVec(i);
                while (q != null) {
                    graph.insertEdge(parent, null, "", vertices[i], vertices[q.getDato()]);
                    q = q.getLiga();
                }
            }

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
