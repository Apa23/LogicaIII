/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Grafo;
import Modelo.NodoSimple;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Apa
 */
public class ControladorGrafo {

    mxGraph graph = new mxGraph();
    Object parent = graph.getDefaultParent();
    mxGraphComponent graphComponent;
    Object vertices[];
    Random rnd = new Random();
    ArrayList<String[]> caminos = new ArrayList();
    Grafo g;
    int[] visitado;
    int camino[];

    public ControladorGrafo(Grafo grafo) {
        g = grafo;        
        camino = new int[g.getNumVertices()];
        visitado = new int[grafo.getNumVertices()];
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
    
      public void rutasPosibles(int inicio, int ultimo, int pos) {

        NodoSimple p;
        camino[pos] = inicio;

        if (inicio == ultimo) {
            

            String[] l = new String[pos + 1];

            for (int i = 0; i <= pos; i++) {

                l[i] = g.getVertices().get(camino[i]);

                

            }

            caminos.add(l);

            

        }

        visitado[inicio]=1;

        p = g.getLista().getVec(inicio);

        int n;

        while (p != null) {

            n = p.getDato();

            if (visitado[n] == 0) {

                rutasPosibles(n, ultimo, pos + 1);

                visitado[n]=0;

            }

            p = p.getLiga();

        }



    }
      
      public int rutaMasRapida(){
          int mayor, aux, rutaM;
          mayor = caminos.get(0).length;
          rutaM=0;
          for(int i=1;i<=caminos.size();i++){
              aux= caminos.get(i).length;
              if(mayor < aux){
                  rutaM=i;
              }
            }
          return rutaM;
      }      

    public ArrayList<String[]> getCaminos() {
        return caminos;
    }
      
      

}


