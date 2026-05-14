import  java.io.*;
public class Validacao
{
    private BufferedReader br;

    public Validacao()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /// Validar Decoracao/Assessoria/Feriado
    public String validarOpcao(String msg)
    {
        String x = "";
        do
        {
            System.out.println(msg);
            try
            {
                x = br.readLine();
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            } catch (NumberFormatException n)
            {
                System.out.println(n.getMessage());
            }
            if (!x.equalsIgnoreCase("Sim") && !x.equalsIgnoreCase("Nao") )
                System.out.println("Erro");
        } while (!x.equalsIgnoreCase("Sim") && !x.equalsIgnoreCase("Nao"));
        return x;
    }

    /// Validar Evento
    public String validarEvento(String msg)
    {
        String x = "";
        do
        {
            System.out.println(msg);
            try
            {
                x = br.readLine();
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            } catch (NumberFormatException n)
            {
                System.out.println(n.getMessage());
            }

            if (!x.equalsIgnoreCase("Casamento") && !x.equalsIgnoreCase("Aniversario") && !x.equalsIgnoreCase("Graduacao"))
                System.out.println("Erro");
        } while (!x.equalsIgnoreCase("Casamento") && !x.equalsIgnoreCase("Aniversario") && !x.equalsIgnoreCase("Graduacao"));
        return x;
    }


    ///  Validar Data / nome
    public String validarString(int a,String msg)
    {
        String x = "";
        do
        {
            System.out.println(msg);
            try
            {
                x = br.readLine();
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }catch (NumberFormatException n)
            {
                System.out.println(n.getMessage());
            }

            if (x.length() < a)
                System.out.println("Erro");
        } while (x.length() < a);
        return x;
    }

    ///  Validar numero de telefone
    public long telefoneCliente()
    {
        long x = 0;
        do
        {
            System.out.println("Introduza o seu nuemero de telefone +258");
            try
            {
                x = Long.parseLong(br.readLine());

            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            if (x < 820000000 || x > 879999999)
                System.out.println("Erro!");
        } while (x < 820000000 || x > 879999999);
        return x;
    }

    ///  Validacao de inteiros
    public int validarInt(int a,int b, String msg)
    {
        int n = 0;
        do
        {
            System.out.println(msg);
            try
            {
                n = Integer.parseInt(br.readLine());
            }
            catch (IOException i)
            {
                System.out.println(i.getMessage());
            }
            catch (NumberFormatException nf)
            {
                System.out.println(nf.getMessage());
            }
            if (n < a || n>b)
                System.out.println("Entrada inválida!");
        }
        while (n < a || n > b);
        return n;
    }
}
