public class ItemVenda {
    private Item item;
    private double precoUnitario;
    private int quantidade;

    public ItemVenda(Item item, int quantidade) {
        this.item = item;
        this.precoUnitario = item.getPrecoItem();
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
