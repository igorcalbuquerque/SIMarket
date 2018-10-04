package entidades;

public class Produto {

    private static int codigoAutomatico = 0;
    private int codigoProduto;
    private String descricao;
    private double valorCompra;
    private double valorVenda;
    private Secao secao;

    public Produto(int codigo,String descricao, double valorCompra, double valorVenda, Secao secao)
    {
        setCodigoProduto(codigo);
        setDescricao(descricao);
        setValorCompra(valorCompra);
        setValorVenda(valorVenda);
        setSecao(secao);
    }

    public Produto(String descricao,double valorCompra ,double valorVenda, Secao secao)
    {
        codigoAutomatico++;
        setCodigoProduto(codigoAutomatico);
        setDescricao(descricao);
        setValorCompra(valorCompra);
        setValorVenda(valorVenda);
        setSecao(secao);
    }
    public int getCodigoProduto(){return codigoProduto;}
    public void setCodigoProduto(int novoCodigo){
        codigoProduto = novoCodigo;
    }
    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    public double getValorCompra()
    {
        return valorCompra;
    }
    public void setValorCompra(double valorCompra)
    {
        this.valorCompra = valorCompra;
    }
    public double getValorVenda()
    {
        return valorVenda;
    }
    public void setValorVenda(double valorVenda)
    {
        this.valorVenda = valorVenda;
    }
    public Secao getSecao()
    {
        return secao;
    }
    public void setSecao(Secao secao)
    {
        this.secao = secao;
    }

    @Override
    public String toString(){
        return "Código : "+getCodigoProduto()+" Descrição: "+getDescricao()+" Valor Compra: "+getValorCompra()+" Valor Venda: " +
                getValorVenda()+" Seção: "+getSecao().getDescricao()+ "\n";
    }
}
