import java.io.PipedOutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Loja loja = new Loja();
        Produto p1 = new Produto("P0001", "vizano", 159.90, "vermelho", "Salto alto", "adulto");
        Item item1 = new Item(p1, 10, 36);
        ItemVenda itemVenda1 = new ItemVenda(item1, 2);
        Vendedor vendedor1 = new Vendedor("Antonio Jacinto Oliveira", "12345678912", "83993456782",
                "Jardim Oásis", 1250, "vendedor", 0.02  );
        Venda venda1 = new Venda(LocalDate.of(2022,5,30 ), vendedor1 );
        venda1.adicionaItem(itemVenda1);
        vendedor1.adicionaVenda(venda1);
        System.out.println(vendedor1.calculaSalario(5,2022));





        String marca = "Santa Lola";
        String descricao = "salto alto fino";
        String cor = "preto";
        int tamanho = 37;
        double preco = 169.90;
        int quantidade = 5;
        int resposta;

        double totalEmEstoque = preco*quantidade;

        double menorPreco = 50;
        //boolean ehIgual = preco == menorPreco;

        if(preco == menorPreco) {
            System.out.println("O produto tem o mesmo preco do produto mais barato da loja");
        }
            else{
                System.out.println("O produto é mais caro que o item mais barato da loja");
            }


        System.out.printf("há %.2f reais em estoque pelo produto %s tamanho %d \n", totalEmEstoque, descricao, tamanho);
        System.out.printf("Existem %d produtos com a descricao %s no estoque \n", quantidade, descricao );


        System.out.println("MENU\n1 - exibir marca do produto \n2 - exibir descricao do produto \n3 -" +
                " exibir preco do produto \n");

        do{
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe um número: \nInsira 0 para encerrar ");
        resposta = entrada.nextInt();
        switch (resposta){
            case 1:
                System.out.println(marca);
                break;
            case 2:
                System.out.println(descricao);
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
