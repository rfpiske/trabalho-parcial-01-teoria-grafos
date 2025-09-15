import java.util.ArrayList;
import java.util.List;

public class MatrizDeAdjacencia {

    private int[][] matriz; // Matriz de adjacência
    private int n; // Ordem do grafo, ou, quatidade de vértices.

    public MatrizDeAdjacencia(int[][] matrizAd) {

        // Valida se a matriz não é nula ou vazia.
        if (matrizAd == null || matrizAd.length == 0) {
            throw new IllegalArgumentException("A matriz não pode ser nula ou vazia!");
        }

        int linhas = matrizAd.length;

        // Valida se a matriz é quadrada e se não há valores negativos.
        for (int i = 0; i < matrizAd.length; i++) {
            if (matrizAd[i] == null || matrizAd[i].length != linhas) {
                throw new IllegalArgumentException("A matriz deve ser quadrada (n x n).");
            }

            for (int j = 0; j < linhas; j++) {
                if (matrizAd[i][j] < 0) {
                    throw new IllegalArgumentException("Os valores da matriz devem ser maiores ou iguais a 0.");
                }
            }
        }

        this.n = linhas;
        this.matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrizAd[i], 0, this.matriz[i], 0, n);
        }
    }

    // Retorna a quantidade de vértices da matriz.
    public int ordem() {
        return this.n;
    }

    // ================== CLASSIFICAÇÃO DA MATRIZ ==================

    // Valida se o grafo é dirigido ou não
    public boolean isDirecionado() {
        for (int i = 0; i < this.n; i++) {
            for (int j = i + 1; j < this.n; j++) {
                if (this.matriz[i][j] != this.matriz[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Valida se há loop no grafo
    public boolean temLoop() {
        for (int i = 0; i < this.n; i++) {
            if (this.matriz[i][i] > 0) {
                return true;
            }
        }
        return false;
    }

    // Valida se há aresta paralela no grafo
    public boolean temArestaParalela() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (i != j && this.matriz[i][j] > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // Valida se o grafo é simples
    public boolean isSimples() {
        if (!temLoop() && !temArestaParalela()) {
            return true;
        }
        return false;
    }

    // Valida se o grafo é nulo
    public boolean isNulo() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.matriz[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCompleto() {
        if (isDirecionado()) {
            for (int i = 0; i < this.n; i++) {
                if (this.matriz[i][i] != 0) {
                    return false;
                }
                for (int j = 0; j < this.n; j++) {
                    if (i != j && this.matriz[i][j] != 1) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 0; i < this.n; i++) {
                if (this.matriz[i][i] != 0) {
                    return false;
                }
                for (int j = i + 1; j < this.n; j++) {
                    if (this.matriz[i][j] != 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // ================== GRAUS ==================

    // Retorna o grau do vértice em um grafo não direcionado
    public int grauNaoDirecionado(int vertice) {
        int soma = 0;
        for (int i = 0; i < this.n; i++) {
            if (vertice != i) {
                soma += this.matriz[vertice][i];
            } else {
                soma += (this.matriz[vertice][vertice]) * 2;
            }
        }
        return soma;
    }

    // Contabiliza o grau das saídas do vértice
    public int grauSaidaDirecionado(int vertice) {
        int soma = 0;
        for (int i = 0; i < this.n; i++) {
            soma += this.matriz[vertice][i];
        }
        return soma;
    }

    // Contabiliza o grau das entradas do vértice
    public int grauEntradaDirecionado(int vertice) {
        int soma = 0;
        for (int i = 0; i < this.n; i++) {
            soma += this.matriz[i][vertice];
        }
        return soma;
    }

    // Soma os graus de entrada e saída, retornando o valor total do vértice
    public int grauDirecionado(int vertice) {
        return grauEntradaDirecionado(vertice) + grauSaidaDirecionado(vertice);
    }

    // Retorna qual o maior grau em um vértice
    public int grauMaximo() {
        int max = 0;
        for (int vertice = 0; vertice < this.n; vertice++) {
            int grau = 0;
            if (isDirecionado()) {
                grau = grauDirecionado(vertice);
            } else {
                grau = grauNaoDirecionado(vertice);
            }
            max = grau;
        }
        return max;
    }

    public int grauDoGrafo() {
        int soma = 0;

        if (isDirecionado()) {
            for (int v = 0; v < this.n; v++) {
                soma += grauDirecionado(v); // total = in + out
            }
        } else {
            for (int v = 0; v < this.n; v++) {
                soma += grauNaoDirecionado(v);
            }
        }

        return soma;
    }

    public boolean isRegular() {
        int ref;

        if (isDirecionado()) {
            ref = grauDirecionado(0);
            for (int i = 1; i < this.n; i++) {
                if (grauDirecionado(i) != ref) {
                    return false;
                }
            }
            return true;
        } else {
            ref = grauNaoDirecionado(0);
            for (int i = 1; i < this.n; i++) {
                if (grauNaoDirecionado(i) != ref) {
                    return false;
                }
            }
        }
        return true;
    }

    // ================== ARESTAS ==================

    public List<String> listaArestas() {
        List<String> arestas = new ArrayList<>();

        if (isDirecionado()) {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.n; j++) {
                    int temp = this.matriz[i][j];
                    for (int k = 0; k < temp; k++) {
                        arestas.add("(" + i + "->" + j + ")");
                    }
                }
            }
        } else {
            for (int i = 0; i < this.n; i++) {
                int temp = this.matriz[i][i]; // Contabiliza quando há um loop no grafo.
                for (int j = 0; j < temp; j++) {
                    arestas.add("{" + i + "," + i + "}");
                }
            }

            for (int i = 0; i < this.n; i++) {
                for (int j = i + 1; j < this.n; j++) {
                    int temp = this.matriz[i][j];
                    for (int k = 0; k < temp; k++) {
                        arestas.add("(" + i + "->" + j + ")");
                    }
                }
            }
        }

        return arestas;
    }

    // ================== BUSCA EM PROFUNDIDADE ou DFS ==================

    public List<Integer> ordemDeBusca() {
        boolean[] visitado = new boolean[this.n];
        List<Integer> ordem = new ArrayList<>();

        for (int i = 0; i < this.n; i++) {
            if (!visitado[i]) {
                buscaProfundidade(i, visitado, ordem);
            }
        }

        return ordem;
    }

    private void buscaProfundidade(int vertice, boolean[] visitado, List<Integer> ordem) {
        visitado[vertice] = true;
        ordem.add(vertice);

        for (int i = 0; i < this.n; i++) {
            if (this.matriz[vertice][i] > 0 && !visitado[i]) {
                buscaProfundidade(i, visitado, ordem);
            }
        }
    }
}
