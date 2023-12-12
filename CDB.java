public final class CDB extends RendaFixa implements Investimento {
  private float juros = 120;
  private float ir;

  public float getJuros() {
    return juros;
  }

  public void setJuros(float valor) {
    this.juros = valor;
  }

  public float getIr() {
    return ir;
  }

  public void setIr(float valor) {
    this.ir = valor;
  }

  public CDB() {
    super();
  }

  public CDB(String nome, String cpf, String banco, float ir) {
    this();
    this.nome = nome;
    this.cpf = cpf;
    this.banco = banco;
    this.ir = ir;
  }

  @Override
  public void imprimir() {
    System.out.println(String.format("\nNome: %s\nCPF: %s\nBanco: %s\nIr: %f", this.getNome(), this.getCpf(),
        this.getBanco(), this.getIr()));
  }

  @Override
  public float calcularInvestimento(float valor, int meses, float taxaSELIC) {
    // Adding rate, not multiplying (it can subtract value).
    return valor + ((valor * (Selic.taxaSelic / 100) + valor * (getJuros() / 100)) * meses * ir);
  }
}