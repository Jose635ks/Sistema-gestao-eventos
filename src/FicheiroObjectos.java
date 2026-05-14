import java.io.*;

public class FicheiroObjectos
{
    public FicheiroObjectos()
    {
    }

    ///  Gravar no ficheiro de objectos
    public void gravarFichObj(Cliente[] array)
    {
        try
        {
            FileOutputStream f = new FileOutputStream("Ficheiro.dat");
            ObjectOutputStream r = new ObjectOutputStream(f);
            r.writeObject(array);
            System.out.println("Ficheiro Gravado com Sucesso");
            r.close();
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Cliente[] lerFichObj(Cliente[] array)
    {

        try
        {
            FileInputStream fin = new FileInputStream("Ficheiro.dat");
            ObjectInputStream in = new ObjectInputStream(fin);
            array = (Cliente[]) in.readObject();
            in.close();
            System.out.println("Ficheiro lido com sucesso");
        } catch (FileNotFoundException fl)
        {
            System.out.println("Ficheiro não encontrado: " + fl.getMessage());
        } catch (IOException e)
        {
            System.out.println("Erro de leitura: " + e.getMessage());
        } catch (ClassNotFoundException a)
        {
            System.out.println("Classe não encontrada: " + a.getMessage());
        }
        return array;
    }


}
