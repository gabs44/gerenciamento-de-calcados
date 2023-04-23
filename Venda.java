
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Venda {
    final private UUID codigo = UUID.randomUUID();
    private LocalDate data;
    private Vendedor vendedor;
    private ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();

    public Venda(LocalDate data, Vendedor vendedor) {
        this.data=data;
        this.vendedor = vendedor;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public double calculaTotal() {
        double total =0;
        for (ItemVenda item: itens){
            total += item.calculaTotal();
        }
        return total;
    }


    void adicionaItem(ItemVenda itemVenda){
        itens.add(itemVenda);
    }

    void removeItem(ItemVenda itemVenda){
        itens.remove(itemVenda);
    }
}
