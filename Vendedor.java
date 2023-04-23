import java.util.ArrayList;
import java.util.Calendar;

public class Vendedor extends Funcionario {
    private ArrayList<Venda> vendas = new ArrayList<Venda>();
    private double comissao;

    public Vendedor(String nomeCompleto, String CPF, String telefone, String endereco,
                    double salario, String funcao, double comissao) {
        super(nomeCompleto, CPF, telefone, endereco, salario, funcao);
        this.comissao = comissao;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    double calculaSalario(int mes, int ano){
        double valorComissao = calculaComissao(mes, ano);
        return valorComissao + getSalario();
    }

    double calculaComissao(int mes, int ano){
        double total =0;
        for (Venda venda: vendas) {
            if (venda.getData().getYear() == ano && venda.getData().getMonth().getValue() == mes) {
                total += venda.calculaTotal();
                System.out.println(venda.calculaTotal());
            }
        }
        return total * comissao;
    }

    void adicionaVenda(Venda venda){
        vendas.add(venda);
    }

    void removeVenda(Venda venda){
        vendas.remove(venda);
    }
}
