import java.io.*;
import java.util.*;
import java.text.*;

public class TodosCliente
{
    //Declaracao de variaveis
    private Cliente array[];
    private int cont;

    private DecimalFormat mt;
    private BufferedReader bR;

    ///  Classes (Instanciar)
    private Calculos cl;
    private Pesquisa ps;
    private Validacao vs;
    private Visualizacoes vis;
    private EscreverFicheiro ef;
    private FicheiroObjectos fo;
    private Ordenar o;
    private EscreverNovoRegistroEvento nr;

    ///Inicializacao das variaveis
    public TodosCliente()
    {
        array = new Cliente[100];
        cont = 0;
        mt = new DecimalFormat("###,###.00Mts");
        bR = new BufferedReader(new InputStreamReader(System.in));
        cl = new Calculos();
        ps = new Pesquisa();
        vs = new Validacao();
        vis = new Visualizacoes();
        ef = new EscreverFicheiro();
        fo = new FicheiroObjectos();
        o = new Ordenar();
        nr = new EscreverNovoRegistroEvento();

    }

    /// Metodo para ler ficheiro de texto
    public void lerdoFich(String nf)
    {
        StringTokenizer str;
        String linha, nome, data, evento, decoracao, assessoria, feriado;
        int funcionarios, numeroP;
        long telefone;

        try
        {

            FileReader fr = new FileReader(nf);
            BufferedReader br = new BufferedReader(fr);
            linha = br.readLine();

            while (linha != null)
            {
                str = new StringTokenizer(linha, ";");
                //Telefone;Nome;Evento;Data;Valor;Confirmado;Pago;Avaliação;Feriado
                telefone = Long.parseLong(str.nextToken());
                nome = str.nextToken();
                evento = str.nextToken();
                data = str.nextToken();
                numeroP = Integer.parseInt(str.nextToken());
                decoracao = str.nextToken();
                assessoria = str.nextToken();
                funcionarios = Integer.parseInt(str.nextToken());
                feriado = str.nextToken();

                array[cont] = new Cliente(telefone, nome, evento, data, numeroP, decoracao, assessoria, funcionarios, feriado);
                cont++;
                linha = br.readLine();
            }
            System.out.println("Ficheiro lido com sucesso.");
            br.close();
        } catch (FileNotFoundException f)
        {
            System.out.println("O ficheiro " + nf + " nao foi encontrado");
        } catch (NumberFormatException nb)
        {
            System.out.println(nb.getMessage());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }


    ///  ======== Adaptadores Calculos =======

    ///  Valor total por tipo de Evento e Valor total total
    public void adaptValorTotal()
    {
        float acumA, acumG, acumC, acumT;
        acumA = cl.acumValorTotalTipo("Aniversario", cont, array);
        acumG = cl.acumValorTotalTipo("Graduacao", cont, array);
        acumC = cl.acumValorTotalTipo("Casamento", cont, array);
        acumT = cl.acumTotalEvento(acumA, acumC, acumG);
        vis.VisualizarAcumuladores(acumA, acumG, acumC, acumT);
    }

    ///  Contador total por tipo de evento e contador Total
    public void adaptContTotal()
    {
        int contC, contG, contA, contT;
        contC = cl.contarEventosCadaTipo("Casamento", cont, array);
        contA = cl.contarEventosCadaTipo("Aniversario", cont, array);
        contG = cl.contarEventosCadaTipo("Graduacao", cont, array);
        contT = cl.contarEventosTotal(contA, contG, contC);
        vis.VisualizarContadores(contA, contG, contC, contT);
    }
    /// ========= Fim dos Calculos ======

    ///  =========== Adaptador de Pesquisa e Adaptador de ordenacao por data ============

    /// ============ Pesquisa =========
    public void adaptPesquisaData()
    {
        String data = vs.validarString(10, "Introduza a data (AAAA-MM-DD)");
        int pesquisaData = ps.pesquisarData(array, cont, data);
        vis.visualizarPesquisa(array, pesquisaData);
    }

    public void adapPesquisaTelefone()
    {
        long numTelefone = vs.telefoneCliente();
        int pesquisarTelefone = ps.pesquisarTelefone(array, cont, numTelefone);
        vis.visualizarPesquisa(array, pesquisarTelefone);
    }

    ///  Ordenar por Data
    public void adaptOrdenarData()
    {
        o.ordenarPorData(cont, array);
        vis.mostrarEventos(array, cont);
    }
    ///  ===========  Fim dos Adaptador de Pesquisa e Adaptador de ordenacao por data ============

    /// ====== Adaptador do escrever no ficheiro de texto
    public void adaptFeriado()
    {
        int contF = cl.funcionariosFeriado(array, cont);
        float acumF = cl.valorTotalFeriado(cont, array);
        ef.escreverFich("Escrever.txt", contF, acumF);
    }
    /// ====== Fim do escrever no ficheiro de texto


    ///  ========== Adaptador do ficheiro de objectos =========
    public void adaptGravarFicheiroObj()
    {
        fo.gravarFichObj(array);
    }

    public void adaptLerFicheiroObj()
    {
        fo.lerFichObj(array);
        vis.visualizarTabelaTodos(array,cont);
    }

    ///  ======= Fim do adaptador do ficheiro de objectos =======

    ///  Visualizar Dados
    public void visualizarDadosTabela()
    {
        vis.visualizarTabelaTodos(array,cont);
    }

    public void adapNovoEvento()
    {
        nr.novoRegistro();
    }

    public void adaptlerFicherioNovo()
    {
        nr.lerFicheiroNovo();
    }

}

