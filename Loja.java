import java.time.LocalDate;
import java.util.ArrayList;

public class Loja {
    String nome;
    final private ArrayList<Venda> vendas = new ArrayList<>();
    final private ArrayList<Estoque> estoque = new ArrayList<>();
    final private ArrayList<Produto> produtoLoja = new ArrayList<>();
    final private ArrayList<Funcionario> funcionarios = new ArrayList<>();


    public Loja(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public ArrayList<Estoque> getEstoque() {
        return estoque;
    }


    public ArrayList<Produto> getProduto() {
        return produtoLoja;
    }


    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }


    void adicionaVenda(Venda venda){
        vendas.add(venda);
    }

    void removeVenda(Venda venda){
        vendas.remove(venda);
    }

    void adicionaItem(Estoque estoque){
        this.estoque.add(estoque);
    }

    void removeItem(Estoque estoque){
        this.estoque.remove(estoque);
    }

    void adicionaProduto(Produto produto){
        produtoLoja.add(produto);
    }

    void removeProduto(Produto produto){
        produtoLoja.remove(produto);
    }

    void adicionaFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    void removeFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
    }

    double calculaFaturamento(LocalDate dataInicio, LocalDate dataLimite) {
        double saldoVendas = 0;
        for (Venda venda : vendas) {
            if (venda.getData().isAfter(dataInicio) && venda.getData().isBefore(dataLimite)) {
                saldoVendas += venda.calculaTotal();
            }
        }
        return saldoVendas;
    }

}
