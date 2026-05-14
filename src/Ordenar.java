public class Ordenar
{
    public Ordenar()
    {

    }

    public void ordenarPorData(int cont,Cliente array[])
    {
        for (int i = 0; i < cont - 1; i++)
        {
            for (int j = 0; j < cont - i - 1; j++)
            {

                // Extrai ano, mes e dia diretamente da String "AAAA-MM-DD"
                int ano1 = Integer.parseInt(array[j].getData().substring(0, 4));
                int mes1 = Integer.parseInt(array[j].getData().substring(5, 7));
                int dia1 = Integer.parseInt(array[j].getData().substring(8, 10));

                int ano2 = Integer.parseInt(array[j + 1].getData().substring(0, 4));
                int mes2 = Integer.parseInt(array[j + 1].getData().substring(5, 7));
                int dia2 = Integer.parseInt(array[j + 1].getData().substring(8, 10));

                // Verifica se precisa trocar
                if (ano1 > ano2 ||
                        (ano1 == ano2 && mes1 > mes2) ||
                        (ano1 == ano2 && mes1 == mes2 && dia1 > dia2))
                {

                    Cliente temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
