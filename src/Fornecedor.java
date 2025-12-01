import java.util.LinkedList;
import java.util.List;

public class Fornecedor {
    private static int ultimoID = 10000;
    private String nome;
    private int documento;
    private List<Produto> produtos; 

    public Fornecedor(String nome) {
        if (nome == null || nome.trim().split("\\s+").length < 2) {
            throw new IllegalArgumentException("O nome do fornecedor deve conter pelo menos duas palavras.");
        }
        this.nome = nome;
        this.documento = ultimoID++;
        this.produtos = new LinkedList<>(); 
    }

    public void adicionarProduto(Produto novo) {
        if (novo == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        this.produtos.add(novo);
    }

    public int getDocumento() {
        return this.documento;
    }

    public String getNome() {
        return this.nome;
    }
    
    public List<Produto> getProdutos() {
        return this.produtos;
    }

    @Override
    public int hashCode() {
        return this.documento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fornecedor: ").append(nome)
          .append(" | Documento: ").append(documento)
          .append("\nHistórico de Produtos: ");
        
        if (produtos.isEmpty()) {
            sb.append("Nenhum produto vendido.");
        } else {
            for (Produto p : produtos) {
                sb.append("\n  - ").append(p.toString());
            }
        }
        return sb.toString();
    }
}