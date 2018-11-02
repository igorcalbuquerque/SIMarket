/**
 * Validator used to check whether given string is
 * no longer than the specified amount of characters.
 *
 * @author Saú Cesar
 */

package dados;

import entidades.*;
import java.util.ArrayList;

public class EstoqueProduto {

    private ArrayList<ProdutoEstoque> estoque;

    public EstoqueProduto(){
        estoque = new ArrayList<ProdutoEstoque>();
    }
    public void adicionarProduto(Produto produto, double quantidade){
        if(produto!=null){
            ProdutoEstoque jaExiste = buscarProduto(produto.getCodigoBarra());
            if(jaExiste == null){
                ProdutoEstoque produtoEstoque = new ProdutoEstoque(produto,quantidade);
                estoque.add(produtoEstoque);
            }else{
                jaExiste.incrementar(quantidade);
            }
        }
    }
    public void adicionarProduto(Produto produto){
        if(produto != null){
            ProdutoEstoque jaExiste = buscarProduto(produto.getCodigoBarra());
            if(jaExiste == null){
                ProdutoEstoque produtoEstoque = new ProdutoEstoque(produto,0);
                estoque.add(produtoEstoque);
            }
        }
        else{
            System.out.println("O Produto solicitado nao existe!!!");
        }
    }
    public void decrementar(Carrinho carrinho){
        for(ProdutoVenda produtoVenda:carrinho.getCarrinho()){

            for(ProdutoEstoque produtoEstoque:estoque){
                if(produtoVenda.getProduto().getCodigoBarra() == produtoEstoque.getProduto().getCodigoBarra()){
                    produtoEstoque.decrementar(produtoVenda.getQuantidade());
                }
            }
        }
    }
    public void incrementar(int codigo, double quantidade){
        ProdutoEstoque produtoEstoque= buscarProduto(codigo);
        if(produtoEstoque != null){
            produtoEstoque.incrementar(quantidade);
        }
        else {
            System.out.println("O produto informado nao exite!!!");
        }
    }
    public ProdutoEstoque buscarProduto(int codigo){
        for(ProdutoEstoque produtoEstoque: estoque){
            if (produtoEstoque.getProduto().getCodigoProduto() == codigo){
                return produtoEstoque;
            }
        }
        return null;
    }
    public ProdutoEstoque buscarProduto(String codigo){
        for(ProdutoEstoque produtoEstoque: estoque){
            if (produtoEstoque.getProduto().getCodigoBarra().equals(codigo)){
                return produtoEstoque;
            }
        }
        return null;
    }
    public String listarEstoque(){
        String lista = "";
        for(ProdutoEstoque produtoEstoque:estoque){
            lista+=produtoEstoque.toString();
        }
        return lista;
    }
    public void incrementar(NotaFiscal nota){
        for(ProdutoNotaFiscal produtoNota:nota.getNota()){
            for(ProdutoEstoque produtoEstoque:this.estoque){
                if(produtoNota.getProduto().getCodigoProduto() == produtoEstoque.getProduto().getCodigoProduto()){
                    produtoEstoque.incrementar(produtoNota.getQuantidade());
                }
            }
        }
    }
    public void removerProduto(int codigo){

        for(ProdutoEstoque produtoEstoque:this.estoque){
            if(produtoEstoque.getProduto().getCodigoProduto() == codigo){
                estoque.remove(produtoEstoque);
                break;
            }
        }
    }

}
