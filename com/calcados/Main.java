package com.calcados;

import com.calcados.enumerations.FaixaEtaria;
import com.calcados.modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static final String nomeLoja = "Mifat";
    public static void main(String[] args) {
//        System.out.println(vendedor1.calculaSalario(5,2022));
//        System.out.println(vendedor1.calculaComissao(5, 2022));
//        System.out.println(vendedor1.calculaComissao(2022));

//        String marca = "Santa Lola";
//        String descricao = "salto alto fino";
//        String cor = "preto";
//        int tamanho = 37;
//        double preco = 169.90;
//        int quantidade = 5;
//
//        double totalEmEstoque = preco*quantidade;
//
//        double menorPreco = 50;
//
//        if(preco == menorPreco) {
//            System.out.println("O produto tem o mesmo preco do produto mais barato da loja");
//        }
//            else{
//                System.out.println("O produto é mais caro que o item mais barato da loja");
//            }
//
//
//        System.out.printf("há %.2f reais em estoque pelo produto %s tamanho %d \n", totalEmEstoque, descricao, tamanho);
//        System.out.printf("Existem %d produtos com a descricao %s no estoque \n", quantidade, descricao );

        int resposta;
        Loja loja = new Loja(nomeLoja);
        Produto p1 = new Produto("P0001", "vizano", 159.90, "vermelho", "Salto alto", FaixaEtaria.Adulto);

        Estoque estoque1 = new Estoque(p1, 10, 36);
        ItemVenda itemVenda1 = new ItemVenda(estoque1, 2);
        Vendedor vendedor1 = new Vendedor("Antonio Jacinto Oliveira", "12345678912", "83993456782",
                "Jardim Oásis", 1250, "vendedor", 0.02  );
        Venda venda1 = new Venda(LocalDate.of(2022,5,30 ), vendedor1 );
        vendedor1.adicionaVenda(venda1);
        venda1.adicionaItem(itemVenda1);

        loja.adicionaProduto(p1);
        loja.adicionaItem(estoque1);
        loja.adicionaVenda(venda1);
        loja.adicionaFuncionario(vendedor1);


        int indiceFuncionario = 0;
        Funcionario[] funcionario = new Funcionario[3];
        Scanner entrada = new Scanner(System.in);

        do{
            System.out.println("\nMENU\n0 -  Informe 0 para encerrar\n1 - Listar vendas \n2 - Listar funcionários da loja\n3 - Listar funcionários do vetor\n4 - Calcular comissão dos funcionário \n5 -" +
                    " Exibir fluxo de caixa \n6 - Cadastrar funcionário no vetor\n");
            System.out.println("\nInforme um número: ");
            resposta = entrada.nextInt();
            entrada.nextLine();

            switch (resposta){
                case 1:
                    ArrayList<Venda> vendas = (ArrayList<Venda>) loja.getVendas();
                    int idx = 1;
                    for (Venda venda: vendas) {
                        System.out.println("Código: " + idx+") " +venda.getCodigo());
                        System.out.println("Data: " + venda.getData());
                        System.out.println("Total: "+ venda.calculaTotal());
                        System.out.println("Vendedor: " + venda.getVendedor().getNomeCompleto());
                        System.out.println();
                        idx++;
                    }
                    System.out.println("Informe o número da venda que deseja ver detalhes: ");
                    Venda vendaEscolhida;
                    try {
                        int vendaDetalhes = entrada.nextInt()-1;
                        vendaEscolhida = vendas.get(vendaDetalhes);
                    } catch (Exception e){
                        System.out.println("Venda informada não pode ser acessada");
                        continue;
                    }


                    for (ItemVenda item: vendaEscolhida.getItens()) {
                        System.out.println("Descrição: " + item.getItem().getProduto().getDescricao());
                        System.out.println("Marca: " +  item.getItem().getProduto().getMarca());
                        System.out.println("Numeração: " + item.getItem().getNumeracao());
                        System.out.println("Quantidade: " + item.getQuantidade() );
                        System.out.println("Numeração: " + item.getPrecoUnitario());
                        System.out.println("Subtotal: " + item.getQuantidade() * item.getPrecoUnitario());
                    }
                    break;
                case 2:
                    List<Funcionario> vendedores = loja.getFuncionarios();
                    for (Funcionario func: vendedores) {
                        System.out.println("Nome: " + func.getNomeCompleto());
                        System.out.println("Função: " + func.getFuncao());
                        System.out.println();
                    }
                    break;
                case 3:
                    for (Funcionario func: funcionario) {
                        if(func !=null){
                            System.out.println("Nome: " + func.getNomeCompleto());
                            System.out.println("Função: " + func.getFuncao());
                            System.out.println();
                        }
                    }
                    break;

                case 4:
                    LocalDate dataAtual = LocalDate.now();
                    List<Funcionario> comissaoVendedores =  loja.getFuncionarios();
                    for (Funcionario func: comissaoVendedores) {
                        Vendedor vendedorComissao = (Vendedor) func;
                        System.out.println("Nome: " + vendedorComissao.getNomeCompleto());
                        System.out.println("Comissão: " + vendedorComissao.calculaComissao(dataAtual.getMonthValue(), dataAtual.getYear()));

                    }
                    break;
                case 5:
                    Scanner entradaCaixa = new Scanner(System.in);
                    System.out.println("Informe o dia de inicio: Ex: dia 1");
                    int diaInicio = entradaCaixa.nextInt();
                    System.out.println("Informe o mês de inicio: Ex: mês 6");
                    int mesInicio = entradaCaixa.nextInt();
                    System.out.println("Informe o ano de inicio: Ex: ano 2023");
                    int anoInicio = entradaCaixa.nextInt();

                    System.out.println("Informe o dia final: Ex: dia 30");
                    int diaFinal = entradaCaixa.nextInt();
                    System.out.println("Informe o mês de final: Ex: mês 6");
                    int mesFinal = entradaCaixa.nextInt();
                    System.out.println("Informe o ano de final: Ex: ano 2023");
                    int anoFinal = entradaCaixa.nextInt();

                    LocalDate dataInicio = LocalDate.of(anoInicio, mesInicio, diaInicio);
                    LocalDate dataFinal = LocalDate.of(anoFinal, mesFinal, diaFinal);

                    System.out.println(loja.calculaFaturamento(dataInicio, dataFinal));
                    break;

                case 6:
                    if(indiceFuncionario != 3) {
                        funcionario[indiceFuncionario] = new Vendedor();
                        System.out.println("Informe o nome completo: ");
                        funcionario[indiceFuncionario].setNomeCompleto(entrada.nextLine());
                        System.out.println("Informe o CPF: ");
                        funcionario[indiceFuncionario].setCPF(entrada.nextLine());
                        System.out.println("Informe o salário: ");
                        funcionario[indiceFuncionario].setSalario(entrada.nextDouble());
                        indiceFuncionario++;
                        entrada.nextLine();
                    }else{
                        System.out.println("Vetor cheio!");

                    }
                case 0:
                    break;

                default:
                    System.out.println("Informe um numero válido");
            }

        }while(resposta!=0);
        System.out.println("Programa encerrado");



}
}
