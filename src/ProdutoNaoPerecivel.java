public class ProdutoNaoPerecivel extends Produto{

    public ProdutoNaoPerecivel(String descricao, double precoCusto, double margemLucro) {
        super(descricao, precoCusto, margemLucro);
    }

    public ProdutoNaoPerecivel(String descricao, double precoCusto) {
        super(descricao, precoCusto);
    }

    public double valorVenda(){
        return precoCusto * (1 + margemLucro);
    }

    /**
    * Gera uma linha de texto a partir dos dados do produto. Preço e margem de lucro vão formatados com 2 casas
    decimais.
    * @return Uma string no formato "1; descrição;preçoDeCusto;margemDeLucro"
    */
    @Override
    public String gerarDadosTexto() {
        
    }
}
