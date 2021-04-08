public class Main {

    public static void main(String[] args) {

        AdjacencyListGraph graph = new AdjacencyListGraph();

Vertex Eskildstrup = new Vertex("Eskildstrup");
        graph.addVertex(Eskildstrup);

        Vertex Haslev = new Vertex("Haslev");
        graph.addVertex(Haslev);

        Vertex Holbæk = new Vertex("Holbæk");
        graph.addVertex(Holbæk);

        Vertex Jærgerspris = new Vertex("Jærgerspris");
        graph.addVertex(Jærgerspris);

        Vertex Kalundborg = new Vertex("Kalundborg");
        graph.addVertex(Kalundborg);

        Vertex Korsør = new Vertex("Korsør");
        graph.addVertex(Korsør);


        Vertex Køge = new Vertex("Køge");
        graph.addVertex(Køge);


        Vertex Maribo = new Vertex("Maribo");
        graph.addVertex(Maribo);


        Vertex Næstved = new Vertex("Næstved");
        graph.addVertex(Næstved);


        Vertex Ringsted = new Vertex("Ringsted");
        graph.addVertex(Ringsted);


        Vertex Slagelse = new Vertex("Slagelse");
        graph.addVertex(Slagelse);


        Vertex NykøbingF = new Vertex("NykøbingF");
        graph.addVertex(NykøbingF);


        Vertex Vordingborg = new Vertex("Vordingborg");
        graph.addVertex(Vordingborg);


        Vertex Roskilde = new Vertex("Roskilde");
        graph.addVertex(Roskilde);


        Vertex Sorø = new Vertex("Sorø");
        graph.addVertex(Sorø);


        Vertex Nakskov = new Vertex("Nakskov");
        graph.addVertex(Nakskov);


        graph.addEdge(new Edge(Eskildstrup,Maribo,28));

        graph.addEdge(new Edge(Eskildstrup,NykøbingF,13));

        graph.addEdge(new Edge(Eskildstrup,Vordingborg,24));


        graph.addEdge(new Edge(Haslev,Korsør,60));

        graph.addEdge(new Edge(Haslev,Køge,24));


        graph.addEdge(new Edge(Haslev,Næstved,25));

        graph.addEdge(new Edge(Haslev,Ringsted,19));


        graph.addEdge(new Edge(Haslev,Roskilde,47));


        graph.addEdge(new Edge(Haslev,Slagelse,48));


        graph.addEdge(new Edge(Haslev,Sorø,34));


        graph.addEdge(new Edge(Haslev,Vordingborg,40));


        graph.addEdge(new Edge(Holbæk,Jærgerspris,34));


        graph.addEdge(new Edge(Holbæk,Kalundborg,44));


        graph.addEdge(new Edge(Holbæk,Korsør,66));


        graph.addEdge(new Edge(Holbæk,Ringsted,36));


        graph.addEdge(new Edge(Holbæk,Roskilde,32));


        graph.addEdge(new Edge(Holbæk,Slagelse,46));


        graph.addEdge(new Edge(Holbæk,Sorø,63));


        graph.addEdge(new Edge(Jærgerspris,Korsør,95));

        graph.addEdge(new Edge(Jærgerspris,Køge,58));



        graph.addEdge(new Edge(Jærgerspris,Ringsted,56));


        graph.addEdge(new Edge(Jærgerspris,Roskilde,33));


        graph.addEdge(new Edge(Jærgerspris,Slagelse,74));


        graph.addEdge(new Edge(Jærgerspris,Sorø,63));




        graph.addEdge(new Edge(Kalundborg,Ringsted,62));


        graph.addEdge(new Edge(Kalundborg,Roskilde,77));



        graph.addEdge(new Edge(Kalundborg,Slagelse,39));


        graph.addEdge(new Edge(Kalundborg,Sorø,51));





        graph.addEdge(new Edge(Korsør,Næstved,45));

        graph.addEdge(new Edge(Korsør,Slagelse,20));



        graph.addEdge(new Edge(Køge,Næstved,45));


        graph.addEdge(new Edge(Køge,Ringsted,28));


        graph.addEdge(new Edge(Køge,Roskilde,25));



        graph.addEdge(new Edge(Køge,Vordingborg,60));




        graph.addEdge(new Edge(Maribo,Nakskov,27));


        graph.addEdge(new Edge(Maribo,NykøbingF,27));



        graph.addEdge(new Edge(Næstved,Roskilde,57));


        graph.addEdge(new Edge(Næstved,Ringsted,26));


        graph.addEdge(new Edge(Næstved,Slagelse,37));


        graph.addEdge(new Edge(Næstved,Sorø,32));


        graph.addEdge(new Edge(Næstved,Vordingborg,28));



        graph.addEdge(new Edge(Ringsted,Roskilde,31));


        graph.addEdge(new Edge(Ringsted,Sorø,15));


        graph.addEdge(new Edge(Ringsted,Vordingborg,58));


        graph.addEdge(new Edge(Slagelse,Sorø,14));


        Algorithm algorithm = new Algorithm(graph);
        algorithm.spanningTree();
        algorithm.printGraph();
    }
}
