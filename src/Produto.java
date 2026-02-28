import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class Produto {
	
	private static final double MARGEM_PADRAO = 0.2;
	protected String descricao;
	protected double precoCusto;
	protected double margemLucro;
	
	private void init(String desc, double precoCusto, double margemLucro) {
		
		if ((desc.length() >= 3) && (precoCusto > 0.0) && (margemLucro > 0.0)) {
			descricao = desc;
			this.precoCusto = precoCusto;
			this.margemLucro = margemLucro;
		} else {
			throw new IllegalArgumentException("Valores inválidos para os dados do produto.");
		}
	}
	
	public Produto(String desc, double precoCusto, double margemLucro) {
		init(desc, precoCusto, margemLucro);
	}
	
	public Produto(String desc, double precoCusto) {
		init(desc, precoCusto, MARGEM_PADRAO);
	}
	
	public double valorVenda() {
		return (precoCusto * (1.0 + margemLucro));
	}
	
    @Override
	public String toString() {
    	
    	NumberFormat moeda = NumberFormat.getCurrencyInstance();
    	
		return String.format("NOME: " + descricao + ": " + moeda.format(valorVenda()));
	}

	@Override
	public boolean equals(Object obj){
		Produto outro = (Produto)obj;
		return this.descricao.toLowerCase().equals(outro.descricao.toLowerCase());
	}

	public static Produto criarDoTexto(String linha) {
		Produto novoProduto = null;
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String[] atributos = linha.split(";");
		int tipo = Integer.parseInt(atributos[0]);
		String descricao = atributos[1];
		Double preco = Double.parseDouble(atributos[2]);
		Double margem = Double.parseDouble(atributos[3]);
		if(tipo == 1) {
			novoProduto = new ProdutoNaoPerecivel(descricao, preco, margem);
		}
		else {
			LocalDate data = LocalDate.parse(atributos[4], formatoData);
			novoProduto = new ProdutoPerecivel(descricao, preco, margem, data);
		}
		return novoProduto;
	}

	public String gerarDadosTexto() {
		return String.format("");
	};
};
