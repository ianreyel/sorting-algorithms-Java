package algoritmosOrdenacao;

//Classe Candidato contendo dados de candidatos 
// a um concurso musical. Os seus dados são: numero_candidato, 
// cpf, nome, idade, sexo e genero_musical.
//Autor: Ivan Carlos Alcântara de Oliveira.

public class Candidato {
	// Atributos privados de um Candidato
    private int numero_candidato;
    private String cpf;
    private String nome;
    private int idade;
    private char sexo;
    private String genero_musical;
    
    // Construtor sem parâmetros 
    public Candidato() {
    	this(0, "000.000.000-00", "-", 0, '-', "-");
    }

    // Construtor com parâmetros envolvendo todos os 
    // atributos da classe
    public Candidato(int numero_candidato, String cpf, String nome, int idade, char sexo, String genero_musical) {
        this.numero_candidato = numero_candidato;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.genero_musical = genero_musical;
    }

    /**
     * @return the numero_candidato
     */
    public int getNumero_candidato() {
        return numero_candidato;
    }
    /**
     * @param numero_candidato the numero_candidato to set
     */
    public void setNumero_candidato(int numero_candidato) {
        this.numero_candidato = numero_candidato;
    }
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }
    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    /**
     * @return the nome
     */ 
    public String getNome() {
        return nome;
    }
    /**
     * @param nome the nome to set
     */   
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }
    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
    /**
     * @return the sexo
     */ 
    public char getSexo() {
        return sexo;
    }
    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    /**
     * @return the genero_musical
     */ 
    public String getGenero_musical() {
        return genero_musical;
    }
    /**
     * @param genero_musical the genero_musical to set
     */
    public void setGenero_musical(String genero_musical) {
        this.genero_musical = genero_musical;
    }
    // Sobrescrita do método toString()
    // utilizado, por exemplo, quando um objeto da classe é 
    // impresso com System.out.println/print
    @Override
    public String toString() {
        return "Número do canditado: "+numero_candidato+", "+"CPF: "+cpf+", "+"Nome: "+nome+
                ", "+"idade: "+idade+", "+"sexo: "+sexo+", "+"Gênero Musical: "+genero_musical+", ";
    }
    
}
