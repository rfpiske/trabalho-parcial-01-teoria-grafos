public class Main {

    public static void main(String[] args) {
        int[][] K3 = {
                { 0, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 0 }
        };

        System.out.println(Grafo.tipoDoGrafo(K3));
        System.out.println("ARESTAS:\n" + Grafo.arestasDoGrafo(K3));
        System.out.println("\n" + Grafo.grausDoVertice(K3));
        System.out.println(Grafo.buscaEmProfundidade(K3));

        int[][] DIGRAFO_CICLO3 = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 0, 0 }
        };

        System.out.println("\nDIGRAFO_CICLO3");
        System.out.println(Grafo.tipoDoGrafo(DIGRAFO_CICLO3));
        System.out.println("ARESTAS:\n" + Grafo.arestasDoGrafo(DIGRAFO_CICLO3));
        System.out.println("\n" + Grafo.grausDoVertice(DIGRAFO_CICLO3));
        System.out.println(Grafo.buscaEmProfundidade(DIGRAFO_CICLO3));

        int[][] MULTIGRAFO = {
                { 0, 2, 0 },
                { 2, 0, 1 },
                { 0, 1, 0 }
        };

        System.out.println("\nMULTIGRAFO");
        System.out.println(Grafo.tipoDoGrafo(MULTIGRAFO));
        System.out.println("ARESTAS:\n" + Grafo.arestasDoGrafo(MULTIGRAFO));
        System.out.println("\n" + Grafo.grausDoVertice(MULTIGRAFO));
        System.out.println(Grafo.buscaEmProfundidade(MULTIGRAFO));

        int[][] COM_LACO = {
                { 1, 0 },
                { 0, 0 }
        };

        System.out.println("\nCOM_LACO");
        System.out.println(Grafo.tipoDoGrafo(COM_LACO));
        System.out.println("ARESTAS:\n" + Grafo.arestasDoGrafo(COM_LACO));
        System.out.println("\n" + Grafo.grausDoVertice(COM_LACO));
        System.out.println(Grafo.buscaEmProfundidade(COM_LACO));

        int[][] NULO_4 = {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        };

        System.out.println("\nNULO_4");
        System.out.println(Grafo.tipoDoGrafo(NULO_4));
        System.out.println("ARESTAS:\n" + Grafo.arestasDoGrafo(NULO_4));
        System.out.println("\n" + Grafo.grausDoVertice(NULO_4));
        System.out.println(Grafo.buscaEmProfundidade(NULO_4));

    }
}
