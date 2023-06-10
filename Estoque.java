public class Estoque {
    private Produto produto;
    private int quantidadeEmEstoque;
    private int numeracao;


    public Estoque(Produto produto, int quantidadeEmEstoque, int numeracao) {
        this.produto = produto;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.numeracao = numeracao;
    }

    public double getPrecoItem(){
        return produto.getPreco();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }
}
