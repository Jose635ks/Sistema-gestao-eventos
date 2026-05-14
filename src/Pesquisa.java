public class Pesquisa
{
    public Pesquisa()
    {
    }

    ///  Pesquisar o numero de telefone
    public int pesquisarTelefone(Cliente[] array, int cont, long p)
    {
        for (int i = 0; i < cont; i++)
        {
            if (array[i].getNumeroTelefone() == p)
                return i;
        }
        return -1;
    }

    ///  Pesquisar data
    public int pesquisarData(Cliente[] array, int cont, String data)
    {
        for (int i = 0; i < cont; i++)
        {
            if (array[i].getData().equalsIgnoreCase(data))
            {
                return i;
            }
        }
        return -1;
    }
}
