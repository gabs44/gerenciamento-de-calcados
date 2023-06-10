public class ItemVenda {
    private Estoque estoque;
    private double precoUnitario;
    private int quantidade;

    public ItemVenda(Estoque estoque, int quantidade) {
        this.estoque = estoque;
        this.precoUnitario = estoque.getPrecoItem();
        this.quantidade = quantidade;
    }

    public Estoque getItem() {
        return estoque;
    }

    public void setItem(Estoque estoque) {
        this.estoque = estoque;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    double calculaTotal(){
        return quantidade * precoUnitario;
    }

    void aumentaQuantidade(){
        quantidade++;
    }

    void diminuiQuantidade(){
        quantidade--;

    }
}
