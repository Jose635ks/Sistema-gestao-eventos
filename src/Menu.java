import java.io.IOException;

public class Menu
{
    private Validacao vs;
    private TodosCliente td;
    private Visualizacoes vis;

    public Menu()
    {
        vs = new Validacao();
        td = new TodosCliente();
        vis = new Visualizacoes();
    }

    public void menu()
    {
        int op;
        int subop = 0;
        boolean passou = false;

        do
        {
            System.out.println();
            System.out.println("**** MENU ***");
            System.out.println("1. Ler os dados do ficheiro e armazenar no array de objectos.");
            System.out.println("2. Visualizar os dados do array de objectos.");
            System.out.println("3. Ver a quantidade de eventos total e de cada tipo.");
            System.out.println("4. Ver o total de eventos no total e por cada tipo.");
            System.out.println("5. Escrever num ficheiro de texto a quantidade e valor total a ser pago aos funcionários que irão trabalhar no feriado.");
            System.out.println("6. Escrever os dados no ficheiro de objecto.");
            System.out.println("7. Ler os dados em um ficheiro de objecto.");
            System.out.println("8. Pesquisar eventos pelo telefone e data.");
            System.out.println("9. Ordenar os eventos de forma crescente da data do evento.");
            System.out.println("10. Visualizar os dados dos programadores. ");
            System.out.println("11. Introducao de um novo evento");
            System.out.println("12. Visualizar os dados do novo evento");
            System.out.println("13. Sair do programa");
            op = vs.validarInt(1, 13, "Introduza as opcoe de 1 a 13.");

            switch (op)
            {
                case 1:
                    td.lerdoFich("Dados.txt");
                    break;

                case 2:
                    if (passou == false)
                    {
                        td.visualizarDadosTabela();
                    } else
                        System.out.println("Por favor, comece da primeira opcao");
                    break;

                case 3:
                    td.adaptContTotal();
                    break;

                case 4:
                    td.adaptValorTotal();
                    break;

                case 5:
                    td.adaptFeriado();
                    break;

                case 6:
                    td.adaptGravarFicheiroObj();
                    break;

                case 7:
                    td.adaptLerFicheiroObj();
                    break;

                case 8:
                    subop = vs.validarInt(1, 2, "Deseja Pesquisar (1- Telefone , 2- Data)");
                    switch (subop)
                    {
                        case 1:
                            td.adapPesquisaTelefone();
                            break;
                        case 2:
                            td.adaptPesquisaData();
                            break;
                    }
                    break;

                case 9:
                    td.adaptOrdenarData();
                    break;

                case 10:
                    vis.visualizarProg();
                    break;

                case 11:
                    td.adapNovoEvento();
                    break;

                case 12:
                    td.adaptlerFicherioNovo();
                    break;
                case 13:
                    vis.visualizarEncerrar();
                    break;

            }
        } while (op != 13);
    }
}



