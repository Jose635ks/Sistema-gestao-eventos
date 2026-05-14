import java.io.*;
import java.util.StringTokenizer;


public class EscreverNovoRegistroEvento
{
    private Validacao val;
    private Cliente array[];
    private int cont;
    private Visualizacoes vis;

    public EscreverNovoRegistroEvento()
    {
        val = new Validacao();
        array = new Cliente[100];
        cont = 0;
        vis = new Visualizacoes();
    }

    public void novoRegistro()
    {
        long telefone;
        String nome, tipoEvento, data, decoracao, assessoria, feriado;
        int numPessoas, numFuncionarios;

        telefone = val.telefoneCliente();
        nome = val.validarString(2, "Introduza o seu nome");
        tipoEvento = val.validarEvento("Introduza o tipo de evento (Casamento,Aniversario,Graduacao)");
        data = val.validarString(10, "Introduza a data (AAAA-MM-DD)");
        numPessoas = val.validarInt(1, 500, "Introduza o numero de pessoas(<=500)");
        numFuncionarios = val.validarInt(1, 10, "Introduza o numero de funcionarios (<10)");
        decoracao = val.validarOpcao("Deseja Decoracao (Sim ou Nao)");
        assessoria = val.validarOpcao("Deseja Assessoria (Sim ou Nao)");
        feriado = val.validarOpcao("E feriado (Sim ou Nao)");

        array[cont] = new Cliente(telefone, nome, tipoEvento, data, numPessoas, decoracao, assessoria, numFuncionarios, feriado);
        cont++;


        try
        {
            FileWriter fw = new FileWriter("Registro.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            String linha = telefone + ";" + nome + ";" + tipoEvento + ";" + data + ";" + numPessoas + ";" + decoracao + ";" + assessoria + ";" + numFuncionarios + ";" + feriado;
            bw.write(linha);
            bw.newLine();
            bw.close();
            System.out.println("Ficheiro gravado com sucesso");
        } catch (NumberFormatException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException b)
        {
            System.out.println(b.getMessage());
        }

    }

    public void lerFicheiroNovo()
    {
        try
        {
            FileReader fr = new FileReader("Registro.txt");
            BufferedReader br = new BufferedReader(fr);
            StringTokenizer st;
            String linha;
            linha = br.readLine();
            while (linha != null)
            {
                st = new StringTokenizer(linha, ";");

                long telefone = Long.parseLong(st.nextToken());
                String nome = st.nextToken();
                String tipoEvento = st.nextToken();
                String data = st.nextToken();
                int numPessoas = Integer.parseInt(st.nextToken());
                String decoracao = st.nextToken();
                String assessoria = st.nextToken();
                int numFuncionarios = Integer.parseInt(st.nextToken());
                String feriado = st.nextToken();

                array[cont] = new Cliente(telefone, nome, tipoEvento, data, numPessoas, decoracao, assessoria, numFuncionarios, feriado);
                cont++;

                linha = br.readLine();
            }
            vis.visualizarNovoEvento(array);

            br.close();
            System.out.println(" Ficheiro lido com sucesso!");

        } catch (IOException e)
        {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
    }



}
