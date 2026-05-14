public class Calculos
{
    public Calculos()
    {

    }

    ///  Valor Total por tipo de evento
    public float acumValorTotalTipo(String tipo, int cont, Cliente array[])
    {
        float x = 0;
        for (int i = 0; i < cont; i++)
        {
            if (array[i].getTipo().equalsIgnoreCase(tipo))
                x += array[i].getValor_final();
        }
        return x;
    }

    /// Valor total dos eventos
    public float acumTotalEvento(float acumA, float acumC, float acumG)
    {
        return acumA + acumC + acumG;
    }

    ///  Quanitdade de eventos por cada tipo
    public int contarEventosCadaTipo(String tipo, int cont, Cliente array[])
    {
        int x = 0;
        for (int i = 0; i < cont; i++)
        {
            if (array[i].getTipo().equalsIgnoreCase(tipo))
                x++;
        }
        return x;
    }

    ///  Contadores de eventos total
    public int contarEventosTotal(int contA, int contG, int contC)
    {
        return contA + contC + contG;
    }

    public int funcionariosFeriado(Cliente array[], int cont)
    {
        int contF = 0;
        for (int i = 0; i < cont; i++)
        {
            if (array[i].getFeriado().equalsIgnoreCase("sim"))
                contF += array[i].getNumfuncionarios();
        }
        return contF;
    }

    ///  Acumulador de feriado
    public float valorTotalFeriado(int cont, Cliente array[])
    {
        float acumFeriado = 0;
        for (int i = 0; i < cont; i++)
        {
            if (array[i].getFeriado().equalsIgnoreCase("sim"))
                acumFeriado += array[i].getAcrescimoFeriado();
        }
        return acumFeriado;
    }
}
