import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("--- Investimentos ---");
    int userInput = 0;

    do {

      try {

        System.out.println("\n- Informações para a Renda Fixa -\n");

        System.out.println("Digite o título do investimento: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite o seu banco: ");
        String banco = scanner.nextLine();

        System.out.println("\n- Dados do Investimento -\n");
        System.out.println("Digite o valor a ser investido em R$:");
        float valorInvestido = scanner.nextFloat();
        System.out.println("Digite o tempo em meses:");
        int meses = scanner.nextInt();
        System.out.println("Digite a taxa SELIC do ano:");
        Selic.taxaSelic = scanner.nextFloat();

        System.out.println("\nSelecione seu tipo de investimento\n\n1 - CDB\n2 - LCI\n3 - LCA\n4 - Poupança\n5 - Sair");

        userInput = scanner.nextInt();
        float resultado;

        switch (userInput) {

          case 1:
            System.out.println("Digite o IR: ");
            float ir = scanner.nextFloat();
            CDB cdb = new CDB(nome, cpf, banco, ir);

            cdb.imprimir();
            resultado = cdb.calcularInvestimento(valorInvestido, meses, Selic.taxaSelic);
            escrever(cdb, resultado);

            break;
          case 2:
            LCI lci = new LCI(nome, cpf, banco);

            lci.imprimir();
            resultado = lci.calcularInvestimento(valorInvestido, meses, Selic.taxaSelic);
            escrever(lci, resultado);
            break;
          case 3:
            LCA lca = new LCA(nome, cpf, banco);

            lca.imprimir();
            resultado = lca.calcularInvestimento(valorInvestido, meses, Selic.taxaSelic);
            escrever(lca, resultado);
            break;
          case 4:
            Poupanca poupanca = new Poupanca(nome, cpf, banco);

            poupanca.imprimir();
            resultado = poupanca.calcularInvestimento(valorInvestido, meses, Selic.taxaSelic);
            Main.escrever(poupanca, resultado);

            break;
          case 5:
            System.out.println("\nSaindo...");
            break;
          default:
            System.out.println("\nComando não reconhecido.");
        }

        scanner.nextLine(); // Consuming "\n".

      } catch (IOException e) {
        System.out.println("\nErro de entrada ou saída do arquivo, reinicie o programa.\n" + e.getMessage());
        break;
      } catch (InputMismatchException e) {
        System.out.println("\nValor de entrada inválido, recomece.\n");
        e.printStackTrace();
        scanner.nextLine(); // Consuming "\n" for reentering the loop.
        continue;
      } // Good practice to catch specific errors and handle them, not catch them all.
    } while (userInput != 5);

    scanner.close();
    System.out.println("\nSistema finalizado.");
  }

  public static void escrever(RendaFixa objeto, float resultado) throws IOException {

    try {
      FileWriter fw = new FileWriter("investimentos.txt", true); // true for appending, and not overwriting file.
      // BufferedReader bf = new BufferedReader(fw);

      fw.write(String.format("%s - %s - %s - %f\n", objeto.getNome(), objeto.getCpf(), objeto.getBanco(), resultado));

      fw.close();
      // bf.close();
    } catch (IOException e) {
      System.out.println("Erro: " + e.getMessage());
    }

  }
}