public class Main {
    public static void main(String[] args) {
    String marca = "Santa Lola";
    String descricão = "salto alto fino";
    String cor = "preto";
    int tamanho = 37;
    double preco = 169.90;
    int quantidade = 5;

    double totalEmEstoque = preco*quantidade;
    
    double menorPreco = 50;
    boolean ehIgual = preco == menorPreco;
    System.out.printf("O produto tem o mesmo preço do menor preço da loja? %b \n", ehIgual);
    System.out.printf("há %.2f reais em estoque pelo produto %s tamanho %d \n", totalEmEstoque, descricão, tamanho);
    System.out.printf("Existem %d produtos com a descricão %s no estoque \n", quantidade, descricão );


    }
}
