public abstract class RendaFixa {
  protected String nome;
  protected String cpf;
  protected String banco;

  public String getNome() {
    return this.nome;
  }

  public void setNome(String valor) {
    this.nome = valor;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String valor) {
    this.cpf = valor;
  }

  public String getBanco() {
    return this.banco;
  }

  public void setBanco(String valor) {
    this.banco = valor;
  }

  public RendaFixa() {

  }

  public RendaFixa(String nome, String cpf, String banco) {
    this();
    this.nome = nome;
    this.cpf = cpf;
    this.banco = banco;
  }

  public abstract void imprimir();

}