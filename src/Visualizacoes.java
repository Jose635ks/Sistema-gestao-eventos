import java.text.*;

public class Visualizacoes
{
    private DecimalFormat mt;

    public Visualizacoes()
    {
        mt = new DecimalFormat("###,###.00Mts");
    }

    ///  Metodo visualizar Pesquisa
    public void visualizarPesquisa(Cliente[] array, int pos)
    {
        if (pos != -1)
            System.out.println(array[pos]);
        else
            System.out.println("Não foi encontrado.");
    }

    ///  Visualizacao do valor total do evento e por cada tipo
    public void VisualizarAcumuladores(float acumA, float acumG, float acumC, float acumT)
    {
        System.out.println("Os valores recebidos por cada tipo de evento são:");
        System.out.println("Aniversario : " + mt.format(acumA));
        System.out.println("Graduacao: " + mt.format(acumG));
        System.out.println("Casamento: " + mt.format(acumC));
        System.out.println("O valor total é: " + mt.format(acumT));
    }

    ///  Quantidade total do evento e por cada tipo
    public void VisualizarContadores(int cA, int cG, int cC, int cT)
    {
        System.out.println("O número de clientes por cada tipo de evento é:");
        System.out.println("Aniversario: " + cA);
        System.out.println("Graduacao: " + cG);
        System.out.println("Casamento: " + cC);
        System.out.println("O número total é: " + cT);
    }

    ///  Visualizar a data ja ordenada
    public void mostrarEventos(Cliente[] array, int cont)
    {
        System.out.println("Lista de eventos ordenada por data:");
        for (int i = 0; i < cont; i++)
        {
            System.out.println((i + 1) + ". " + array[i]);
        }
    }

    /// Visualizar todos os dados
    public String toString(Cliente array[])
    {
        String x = "";
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
                x += array[i] + "\n";
        }
        return x;
    }

    ///  Dados dos Programadores
    public void visualizarProg()
    {
        System.out.println("Dados dos programadores: ");

        System.out.println("José Manuel Xavier Vaz -> 20250247");
        System.out.println("Allen Derick Cossa -> 20230561");
        System.out.println("Kelvin Issá Infante -> 20250164");

    }


    public void visualizarEncerrar()
    {
        System.out.println("Programa encerrado com sucesso!");
    }

    public void visualizarTabelaTodos(Cliente[] array, int cont)
    {
        DecimalFormat df = new DecimalFormat("#,##0.00 MT");

        // Cabeçalho da tabela
        System.out.println("================================================================================================================================================================================");
        System.out.printf("| %-18s | %-18s | %-12s | %-12s | %-9s | %-18s | %-12s | %-18s | %-13s | %-16s |\n",
                "Telefone", "Nome", "Tipo", "Dia", "Pessoas", "Valor Base",
                "Decoração", "Valor Assessoria", "Desconto", "Valor Final");

        // Linha de separação
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Dados
        for (int i = 0; i < cont; i++)
        {
            Cliente c = array[i];

            System.out.printf("| %-18s | %-18s | %-12s | %-12s | %-9d | %-18s | %-12s | %-18s | %-13s | %-16s |\n",
                    c.getNumeroTelefone(),
                    c.getNomeDoCliente(),
                    c.getTipo(),
                    c.getData(),
                    c.getNumPessoas(),
                    df.format(c.getValor_Base()),
                    c.getDecoracao(),
                    df.format(c.getValComAsse()),
                    df.format(c.getDesconto()),
                    df.format(c.getValor_final()));
        }

        // Linha final de fechamento
        System.out.println("================================================================================================================================================================================");
    }

    public void visualizarNovoEvento(Cliente [] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != null)
                System.out.println(array[i]);
        }
    }

}


