import java.util.*;

public class Grafo {

    public static String tipoDoGrafo(int[][] m) {

        MatrizDeAdjacencia matriz = new MatrizDeAdjacencia(m);

        StringBuilder caracteristicas = new StringBuilder("O grafo é: \n");

        // 1 - Valida se é um grafo dirigido.
        if (matriz.isDirecionado()) {
            caracteristicas.append("   - Dirigido;\n");
        } else {
            caracteristicas.append("   - Não Dirigido;\n");
        }

        // 2 - Valida se é um grafo simples ou multigrafo.
        if (matriz.isSimples()) {
            caracteristicas.append("   - Simples;\n");
        } else {
            caracteristicas.append("   - Multigrafo;\n");
        }

        // 3 - Valida se é um grafo regular.
        if (matriz.isRegular()) {
            caracteristicas.append("   - Regular;\n");
        } else {
            caracteristicas.append("   - Não Regular;\n");
        }

        // 4 - Valida se é um grafo completo.
        if (matriz.isCompleto()) {
            caracteristicas.append("   - Completo;\n");
        } else {
            caracteristicas.append("   - Não Completo;\n");
        }

        // 5 - Valida se é um grafo nulo.
        if (matriz.isNulo()) {
            caracteristicas.append("   - Nulo;\n");
        } else {
            caracteristicas.append("   - Não Nulo;\n");
        }

        return caracteristicas.toString();
    }

    public static String arestasDoGrafo(int[][] m) {
        MatrizDeAdjacencia matriz = new MatrizDeAdjacencia(m);

        List<String> arestas = matriz.listaArestas();

        int quantidade = arestas.size();

        StringBuilder sb = new StringBuilder();
        sb.append("Quantidade: ").append(quantidade).append("\n");
        sb.append("Arestas: { ");

        for (int i = 0; i < quantidade; i++) {
            sb.append(arestas.get(i));
            if (i < quantidade - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }

    public static String grausDoVertice(int[][] m) {
        MatrizDeAdjacencia matriz = new MatrizDeAdjacencia(m);

        StringBuilder sb = new StringBuilder();

        if (!matriz.isDirecionado()) {
            sb.append("Grau do Grafo = ").append(matriz.grauDoGrafo()).append("\nGrau dos Vértices: \n");
            for (int i = 0; i < m.length; i++) {
                sb.append("v").append(i).append(": grau = ").append(matriz.grauNaoDirecionado(i)).append("\n");
            }
        } else {
            sb.append("G = ").append(matriz.grauDoGrafo()).append("\n");
            for (int i = 0; i < m.length; i++) {
                int sai = matriz.grauSaidaDirecionado(i);
                int entra = matriz.grauEntradaDirecionado(i);
                int total = sai + entra;
                sb.append("v").append(i).append(": Sai= ").append(sai).append(", Entra= ")
                  .append(entra).append(", Total= ").append(total).append("\n");
            }

        }
        return sb.toString();

    }

    public static String buscaEmProfundidade(int[][] m){
        MatrizDeAdjacencia matriz = new MatrizDeAdjacencia(m);
        List<Integer> ordem = matriz.ordemDeBusca();

        StringBuilder sb = new StringBuilder("Ordem da Busca por Profundidade: {");

        for (int i = 0; i < ordem.size(); i++) {
            sb.append(ordem.get(i));
            if (i < ordem.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }
}
