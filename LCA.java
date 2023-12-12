public final class LCA extends RendaFixa implements Investimento {
  private float juros = 105;

  public float getJuros() {
    return juros;
  }

  public void setJuros(float valor) {
    this.juros = valor;
  }

  public LCA() {
    super();
  }

  public LCA(String nome, String cpf, String banco) {
    this();
    this.nome = nome;
    this.cpf = cpf;
    this.banco = banco;
  }

  @Override
  public void imprimir() {
    System.out.println(String.format("\nNome: %s\nCPF: %s\nBanco: %s", this.getNome(), this.getCpf(), this.getBanco()));
  }

  @Override
  public float calcularInvestimento(float valor, int meses, float taxaSELIC) {
    // Adding rate, not multiplying (it can subtract value).
    return valor + ((valor * (Selic.taxaSelic / 100) + valor * (getJuros() / 100)) * meses);
  }
}