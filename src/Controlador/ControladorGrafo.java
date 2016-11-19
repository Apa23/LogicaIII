/**
 * @author Juan Pablo Tobón Flórez y Andrés Felipe Aparicio Mestre
 */
package Controlador;

import Modelo.Grafo;
import Modelo.NodoSimple;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.Random;

/**
 * ClaseControladorGafo: Clase que se encarga de las operaciones de recorrido y
 * construccion visiual del grafo.
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

    /**
     * Constructor de la clase que asigna sus parametros de entrada a los
     * atributos de la clase.
     *
     * @param grafo
     */
    public ControladorGrafo(Grafo grafo) {
        g = grafo;
        camino = new int[g.getNumVertices()];
        visitado = new int[grafo.getNumVertices()];
        vertices = new Object[grafo.getNumVertices()];
        for (int i = 0; i < grafo.getNumVertices(); i++) {

            Object vertice = graph.insertVertex(parent, null, grafo.getVertices().get(i), 20 + (int) (rnd.nextDouble() * 500), 20 + (int) (rnd.nextDouble() * 500), 80, 30);
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

    /**
     * getGraphComponent: metodo que retorna el componenete grafico que se
     * encarga de generar visualmente el grafo.
     *
     * @return mxGraphComponent
     */
    public mxGraphComponent getGraphComponent() {
        return graphComponent;
    }

    /**
     * rutasPosibles: Metodo que determina todas las rutas posibles entre dos 2
     * vertices del grafo.
     *
     * @param inicio
     * @param ultimo
     * @param pos
     */
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
        visitado[inicio] = 1;
        p = g.getLista().getVec(inicio);
        int n;
        while (p != null) {
            n = p.getDato();
            if (visitado[n] == 0) {
                rutasPosibles(n, ultimo, pos + 1);
                visitado[n] = 0;
            }
            p = p.getLiga();
        }
    }

    /**
     * rutasMasRapida: metodo que retorna un arreglo con los indices de posicion
     * del arreglo de caminos que recorren menos vertices para legar de un
     * vertice a otro(Los elegidos en el metodo rutas posibles).
     *
     * @return ArrayList
     */
    public ArrayList rutasMasRapida() {
        int menor, aux, rutaM;
        ArrayList rutasCortas = new ArrayList();
        menor = caminos.get(0).length;
        rutaM = 0;
        for (int i = 1; i < caminos.size(); i++) {
            aux = caminos.get(i).length;
            if (menor > aux) {
                menor = aux;
                rutaM = i;
            }
        }
        for (int i = 0; i < caminos.size(); i++) {
            aux = caminos.get(i).length;
            if (caminos.get(rutaM).length == aux) {
                rutasCortas.add(i);
            }
        }
        return rutasCortas;
    }

    /**
     * getCaminos: metodo que retorna el arreglo donde se encuentran los caminos
     * posibles entre los dos vertices elegios en el metodo rutas posbiles.
     *
     * @return ArrayList
     */
    public ArrayList<String[]> getCaminos() {
        return caminos;
    }

}
