import java.util.ArrayList;

public class Loja {
    final private ArrayList<Venda> vendas = new ArrayList<>();
    final private ArrayList<Item> estoque = new ArrayList<>();
    final private ArrayList<Produto> produtoLoja = new ArrayList<>();
    final private ArrayList<Funcionario> funcionarios = new ArrayList<>();



    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public ArrayList<Item> getEstoque() {
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

    void adicionaItem(Item item){
        estoque.add(item);
    }

    void removeItem(Item item){
        estoque.remove(item);
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

}
