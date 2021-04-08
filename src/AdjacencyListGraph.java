import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//this class creates an adjacency list graph
public class AdjacencyListGraph {

    private List<Vertex> vertices;
    private List<Edge> edgeList;

    public AdjacencyListGraph() {
        this.vertices = new ArrayList<>();
        this.edgeList = new ArrayList<>();
    }

    public void addVertex(Vertex vertex){
        this.vertices.add(vertex);
    }

    public void addEdge(Edge edge){

        Vertex startVertex = edge.getStartVertex();
        Vertex targetVertex = edge.getTargetVertex();

        this.vertices.get(vertices.indexOf(startVertex)).addEdge(new Edge(startVertex, targetVertex, edge.getWeight()));
        this.vertices.get(vertices.indexOf(targetVertex)).addEdge(new Edge(targetVertex, startVertex, edge.getWeight()));

    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertexList(List<Vertex> vertexList) {
        this.vertices = vertexList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }
}

// this class makes and holds information on edges we use in our graph
class Edge {
    private double weight;
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(Vertex startVertex, Vertex targetVertex, double weight) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}

// this class creates a vertex and adds functions to compare and print out vertexes
class Vertex implements Comparable<Vertex>{

    private String name;
    private Edge minEdge;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private boolean visited;
    private Vertex previousVertex;
    private double minDistance = Double.POSITIVE_INFINITY;   // to detect whether heap is in need of refresh because of better weighted edge
    private List<Edge> adjacencies;

    public Vertex(String name) {
        this.name = name;
        this.adjacencies = new ArrayList<>();
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void addEdge(Edge edge){
        this.adjacencies.add(edge);
    }

    public Edge getMinEdge() {
        return minEdge;
    }

    public void setMinEdge(Edge minEdge) {
        this.minEdge = minEdge;
    }

    public List<Edge> getAdjacencies() {
        return adjacencies;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return ""+this.name;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.minDistance, otherVertex.getMinDistance());
    }

}

//this class is responsible for handling our prims algorithm
//TODO: remove unused functions and values or bring them into use
//TODO: rename algorithm to something more precise

class Algorithm {

    private List<Vertex> vertexList;
    private PriorityQueue<Vertex> Q;
     // private MinHeap<Vertex> Q;

    public Algorithm(AdjacencyListGraph graph){
        this.vertexList = graph.getVertices();
        this.Q = new PriorityQueue<>();
        //this.Q = new MinHeap<>();
    }

    public void spanningTree(){                             //uses the prim function to create minimum spanning tree
        for(Vertex vertex : vertexList){                    //for all vertexes in our vertex list
            if( !vertex.isVisited() ){                      //if the vertex has not been visited, run prim
                Prim(vertex);                               //prim finds the minimum edge out, and adds it to the tree
            }
        }
    }


    private void Prim(Vertex vertex){

        vertex.setMinDistance(0);                           //resets minimum distance to 0
        Q.add(vertex);
        //  Q.Insert(vertex);

        while( !Q.isEmpty() ){
            Vertex v = Q.poll();                            //poll removes and returns the element at the head of the queue
           //    Vertex v = Q.extractMin();
            scanVertex(v);                                  //scan finds the lowest valued edge from the current tree
        }
    }

    private void scanVertex(Vertex vertex) {                //this method goes through the edges and compares their weight,
                                                                    // and saves the minimum distance and edge
        vertex.setVisited(true);

        for( Edge edge : vertex.getAdjacencies() ) {
            Vertex w = edge.getTargetVertex();
            // this.heap.Insert(w);
            if (w.isVisited()) continue;

            if (edge.getWeight() < w.getMinDistance()) {
               w.setMinDistance(edge.getWeight());
                w.setMinEdge(edge);

                if( this.Q.contains(w)){
                this.Q.remove(w);
                }
                this.Q.add(w);
            }
        }
    }


    public void printGraph(){
        double totaldistance=0;
        for(Vertex vertex : vertexList){
            if( vertex.getMinEdge() != null ){
                Edge e = vertex.getMinEdge();
                System.out.println("Edge: "+e.getStartVertex()+"-"+e.getTargetVertex()+" Weight "+e.getWeight());
                totaldistance=totaldistance+e.getWeight();
            }
        }
        System.out.println("Total  distance :"+totaldistance);
    }
}