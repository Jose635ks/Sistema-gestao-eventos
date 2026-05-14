import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.*;

public class EscreverFicheiro
{
    private DecimalFormat mt;
    public EscreverFicheiro()
    {
        mt = new DecimalFormat("###,###.00Mts");
    }

    public void escreverFich(String nf, int contF, float acumFeriado)
    {

        try
        {
            FileWriter fw = new FileWriter(nf);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Ficheiro lido com sucesso!");
            bw.write("A quantidade total de funcionarios que irão trabalhar no feriado é: " + contF);
            bw.newLine();
            bw.write("O valor total pago aos funcionarios é: " + mt.format(acumFeriado));
            bw.close();

        } catch (NumberFormatException nb)
        {
            System.out.println(nb.getMessage());
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
