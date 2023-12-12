public final class Poupanca extends RendaFixa implements Investimento {
  private float juros = 0.5f;

  public float getJuros() {
    // Condition in case the hardcoded value of SELIC is changed (altering it
    // without using setJuros(), or privately changing "juros" inside the class).
    if (Selic.taxaSelic >= 8.5f) {
      return juros; // 0.5f.
    } else {
      return Selic.taxaSelic * 0.7f;
    }
  }

  public void setJuros(float valor) {
    if (Selic.taxaSelic >= 8.5f) {
      this.juros = 0.5f;
    } else {
      this.juros = valor * 0.7f;
    }
  }

  public Poupanca() {
    super();
  }

  public Poupanca(String nome, String cpf, String banco) {
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