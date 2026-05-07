package algoritmosOrdenacao;

import java.util.Scanner;
import java.util.Arrays;

//Classe __Aula3_ED_completo.__Aula3_ED: encarregada de executar algumas funcionalidades
//com objetos do tipo Candidato a um concurso musical armazenados em um vetor
//Autores: Jean Marcos Laine e Ivan Carlos Alcântara de Oliveira.


public class organizarCandidato {
    // Objeto de leitura
    private Scanner ler = new Scanner(System.in); 
    // constante com o total de candidatos
    public static final int MAX_CANDIDATOS = 15;

    // main: ponto de entrada do programa
    public static void main(String[] args) {
        // Cria objeto da Classe com a 
        // execução das funcionalidades solicitadas
        new organizarCandidato();
    }

    // Construtor da classe encarregada de realizar a execução
    // das funcionalidades solicitadas
    public organizarCandidato() {
        // Vetor de Candidatos
        Candidato candidatos[];
        // Cria vetor de objetos do tipo Candidato para 
        // uso nos métodos de ordenação e pesquisa
        candidatos = new Candidato[MAX_CANDIDATOS];
        
        // Cria lista de candidatos
        criarCadastroCandidatos(candidatos);
        // Mostra todos os candidatos cadastrados na ordem do cadastro
        mostrarTodosOsCandidatos(candidatos);
        
        // Criar aqui as cópias do vetor original para ordenação nos métodos InsertionSort e SelectionSort
		// Verificar o exemplo no texto
        Candidato[] candidatosInsertionSort = Arrays.copyOf(candidatos, candidatos.length);
        Candidato[] candidatosSelectionSort = Arrays.copyOf(candidatos, candidatos.length);
        
        // Procura um candidato pelo nome em um vetor não ordenado
        System.out.println("Forneça o nome do candidato: ");
        String nomeCandidato = ler.nextLine();
        Candidato cand = pesquisaSequencial(nomeCandidato, candidatos);
        if (cand != null) {
            System.out.println("Dados Candidato: " + cand.toString());
        } else {
            System.out.println("Candidato Inexistente!");
        }
        
        
        // Ordena o vetor de candidatos pelo nome do candidato
        bubbleSort(candidatos);
        // Mostra os candidatos ordenados por nome
		
        System.out.println("\nApos ordenação");
        mostrarTodosOsCandidatos(candidatos);
        
        
        // Procura um candidato no vetor ordenado pelo número do candidato 
        cand = pesquisaBinaria(nomeCandidato, candidatos);
        if (cand != null) {
            System.out.println("Dados Candidato: " + cand.toString());
        } else {
            System.out.println("Candidato Inexistente!");
        }



        insertionSort(candidatosInsertionSort);
        mostrarTodosOsCandidatos(candidatosInsertionSort);

        selectionSort(candidatosSelectionSort);
        mostrarTodosOsCandidatos(candidatosSelectionSort);
    }
    
    // Método encarregado de criar objetos da classe Candidato
    // e armazenar em um vetor.
    // Este método foi criado para evitar a necessidade de 
    // fazer a leitura de dados de Candidato na fase de testes dos outros 
    // métodos a serem modificados.    
    public void criarCadastroCandidatos(Candidato[] candidatos) {    
        candidatos[0] = new Candidato(1111, "111.111.111-11", "Leonardo", 18, 'M', "rock");
        candidatos[1] = new Candidato(8888, "888.888.888-88", "Luiza", 21, 'F', "romantica");
        candidatos[2] = new Candidato(7777, "777.777.777-77", "Pedro", 22, 'M', "rock");
        candidatos[3] = new Candidato(6666, "666.666.666-66", "Ana Lopes", 54, 'F', "sertanejo");
        candidatos[4] = new Candidato(3333, "333.333.333-33", "Mariana", 25, 'F', "sertanejo");
        candidatos[5] = new Candidato(4444, "444.444.444-44", "Amilton", 35, 'M', "rock");
        candidatos[6] = new Candidato(2222, "222.222.222-22", "Juliano", 19, 'M', "forró");    
        candidatos[7] = new Candidato(5555, "555.555.555-55", "Luciano", 52, 'M', "forró");
        candidatos[8] = new Candidato(1010, "101.101.101-10", "Christiane", 35, 'F', "rock");    
        candidatos[9] = new Candidato(9999, "999.999.999-99", "Luis Alberto C.", 18, 'M', "rap");
        candidatos[10] = new Candidato(1010, "110.110.110-10", "Ronaldo", 28, 'M', "gospel");
        candidatos[11] = new Candidato(1101, "111.000.111-11", "Abreu da Silva", 25, 'M', "rap");
        candidatos[12] = new Candidato(1212, "121.121.121-12", "Ian Reyel", 20, 'M', "rap");
        candidatos[13] = new Candidato(1313, "131.131.131-13", "Sarah de Almeida", 21, 'F', "rock");
        candidatos[14] = new Candidato(1414, "141.141.141-14", "Icaro Reyel", 19, 'M', "rap");
    }
  
        
    // Método que apresenta todos os dados dos candidatos cadastrados.
    // Se houver candidatos exibe a mensagem:
    //    "Candidatos cadastrados:", seguido dos seus dados um por linha.
    // Caso não haja Candidatos cadastrados mostra a mensagem: "Não há candidatos cadastrados!"
    public void mostrarTodosOsCandidatos(Candidato[] cand) {
        String cad = "";
        for(int i=0; i<cand.length; i++) {
            cad += cand[i].toString() + "\n";
        }
        if (cand.length >= 1)
           System.out.println("\nCandidatos cadastrados:\n" + cad);  
        else 
           System.out.println("Não há Candidatos cadastrados!");
    }
    
    
    // Método encarregado de pesquisar um candidato 
    // armazenado em um vetor (ordenado ou não)
    // tendo como chave o nome do candidato.    
    public Candidato pesquisaSequencial(String nomeCandidato, Candidato[] cand) {
        int comparacoes = 0;
        for (int i = 0; i < cand.length; i++) {
            if (cand[i] != null) {
                comparacoes++;
                if (cand[i].getNome().equalsIgnoreCase(nomeCandidato)) {
                    System.out.println("Comparações realizadas na pesquisa sequencial: " + comparacoes);
                    return cand[i];
                }
            }
        }
        System.out.println("Comparações realizadas na pesquisa sequencial: " + comparacoes);
        return null;
    }
    
    // Método encarregado de pesquisar um candidato 
    // armazenado em um vetor ordenado
    // Método de pesquisa binária por nome do candidato
    public Candidato pesquisaBinaria(String nomeCandidato, Candidato[] cand) {
        int comparacoes = 0;
        int inicio = 0;
        int fim = cand.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (cand[meio] == null) {
                break;
            }
            comparacoes++;
            int comparacaoStr = cand[meio].getNome().compareToIgnoreCase(nomeCandidato);
            if (comparacaoStr == 0) {
                System.out.println("Comparações realizadas na pesquisa binária por nome: " + comparacoes);
                return cand[meio];
            } else if (comparacaoStr < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        System.out.println("Comparações realizadas na pesquisa binária por nome: " + comparacoes);
        return null;
    }
    

    // Método encarregado de ordenar os Candidatos 
    // armazenados em um vetor pelo número do candidato.
    public void selectionSort(Candidato cand[]) {
        int trocas = 0;
        int n = cand.length;

        for (int i = 0; i < n - 1; i++) {
            if (cand[i] == null) continue;
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                if (cand[j] != null) {
                    if (cand[j].getNumero_candidato() < cand[indiceMenor].getNumero_candidato()) {
                        indiceMenor = j;
                    }
                }
            }

            if (indiceMenor != i) {
                Candidato temp = cand[i];
                cand[i] = cand[indiceMenor];
                cand[indiceMenor] = temp;
                trocas++;
            }
        }
        System.out.println("Trocas realizadas no Selection Sort: " + trocas);
    }
 
    // Método encarregado de ordenar os Candidatos 
    // armazenados em um vetor pela idade do candidato.
    public void insertionSort(Candidato[] cand) {
        int trocas = 0;
        int n = cand.length;

        for (int i = 1; i < n; i++) {
            if (cand[i] == null) continue;
            Candidato chave = cand[i];
            int j = i - 1;
            while (j >= 0 && cand[j] != null && cand[j].getIdade() > chave.getIdade()) {
                cand[j + 1] = cand[j];
                j--;
                trocas++;
            }
            cand[j + 1] = chave;
        }
        System.out.println("Trocas realizadas no Insertion Sort: " + trocas);
    }
    
    // Método encarregado de ordenar os Candidatos 
    // armazenados em um vetor pelo nome do candidato.
    public void bubbleSort(Candidato[] cand) {
        int trocas = 0;
        int n = cand.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (cand[j] != null && cand[j + 1] != null) {
                    if (cand[j].getNome().compareToIgnoreCase(cand[j + 1].getNome()) > 0) {
                        Candidato temp = cand[j];
                        cand[j] = cand[j + 1];
                        cand[j + 1] = temp;
                        trocas++;
                    }
                }
            }
        }
        System.out.println("Trocas realizadas no Bubble Sort: " + trocas);
    }       
}