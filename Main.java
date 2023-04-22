import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    String marca = "Santa Lola";
    String descricão = "salto alto fino";
    String cor = "preto";
    int tamanho = 37;
    double preco = 169.90;
    int quantidade = 5;
    int resposta;

    double totalEmEstoque = preco*quantidade;
    
    double menorPreco = 50;
    //boolean ehIgual = preco == menorPreco;

    if(preco == menorPreco) {
        System.out.println("O produto tem o mesmo preço do produto mais barato da loja");
    }
        else{
            System.out.println("O produto é mais caro que o item mais barato da loja");
        }


    System.out.printf("há %.2f reais em estoque pelo produto %s tamanho %d \n", totalEmEstoque, descricão, tamanho);
    System.out.printf("Existem %d produtos com a descricão %s no estoque \n", quantidade, descricão );


    System.out.println("MENU\n1 - exibir marca do produto \n2 - exibir descrição do produto \n3 -" +
            " exibir preço do produto \n");

    do{
    Scanner entrada = new Scanner(System.in);
    System.out.println("Informe um número: \nInsira 0 para encerrar ");
    resposta = entrada.nextInt();
    switch (resposta){
        case 1:
            System.out.println(marca);
            break;
        case 2:
            System.out.println(descricão);
            break;
        case 3:
            System.out.println(preco);
            break;
        case 0:
            System.out.println("Programa encerrado");
            break;
        default:
            System.out.println("Informe um numero válido");
    }

    }while(resposta!=0);
}
}
