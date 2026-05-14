import java.io.*;
import java.text.DecimalFormat;

public class Cliente implements Serializable
{
    /// DECLARACAO DOS ATRIBUTOS
    private String nomeCliente, tipo, data, feriado;
    private int numPessoas;
    private String decoracao, assessoria;
    private int numfuncionarios;
    private float valor_Base, valor_decoracao, valComDec, valComAsse, desconto, valLiquido, acrescimoFeriado, valLiquidoComAcrescimo, imposto, valor_final;
    private DecimalFormat mt;
    private long numeroTelefone;

    /// METODO CONSTRUTOR
    public Cliente(long num, String nC, String t, String d, int nP, String dC, String a, int f, String fer)
    {
        numeroTelefone = num;
        nomeCliente = nC;
        tipo = t;
        data = d;
        numPessoas = nP;
        decoracao = dC;
        assessoria = a;
        numfuncionarios = f;
        feriado = fer;
        valor_Base = valorBase();
        valor_decoracao = decoracao();
        valComDec = valorComDecoracao();
        valComAsse = assessoria();
        desconto = desconto();
        valLiquido = valorLiquido();
        acrescimoFeriado = acrescimo();
        valLiquidoComAcrescimo = valLiquidoComAcrecimo();
        imposto = imposto();
        valor_final = valorFinal();

        mt = new DecimalFormat("##,###.00MTS");

    }

    /// METODO PARA CALCULAR O VALOR BASE
    public float valorBase()
    {
        final int CASAMENTO = 1500, GRADUACAO = 1000, ANIVERSARIO = 800;
        switch (tipo)
        {
            case "Casamento": case "casamento":
            valor_Base = CASAMENTO * numPessoas * 3;
            break;
            case "Graduacao": case "graduacao":
            valor_Base = GRADUACAO * numPessoas;
            break;
            case "Aniversario": case "aniversario":
            valor_Base = ANIVERSARIO * numPessoas;
            break;
        }
        return valor_Base;
    }

    /// CALCULO DO VALOR DA DECORACAO DECORACAO
    public float decoracao()
    {
        final int DECORACAO = 520;
        if (decoracao.equalsIgnoreCase("Sim"))
            valor_decoracao = DECORACAO * numPessoas;
        return valor_decoracao;
    }

    /// CALACULO DO VALOR BASE COM DECORACAO
    public float valorComDecoracao()
    {
        return valor_Base + valor_decoracao;
    }

    /// CALCULO DO VALOR COM ASSESSORIA
    public float assessoria()
    {
        final int ASSESSORIA = 50000;
        if (assessoria.equalsIgnoreCase("Sim"))
            valComAsse = ASSESSORIA + valComDec;
        else
            valComAsse = valComDec;
        return valComAsse;
    }

    /// CALCULO DO DESCONTO
    public float desconto()
    {
        final float DESCONTO1 = 20 / 100f, DESCONTO2 = 10 / 100f;
        if (numPessoas > 375) // MAIS DE 75%
            desconto = DESCONTO1 * valComAsse;
        else
        {
            if (numPessoas > 250) // MAIS DE 50%
                desconto = DESCONTO2 * valComAsse;
        }
        return desconto;
    }

    /// CALCULO DO VALOR COM O DESCONTO
    public float valorLiquido()
    {
        return valComAsse - desconto;
    }

    /// CALCULO DO ACRESCIMO
    public float acrescimo()
    {
        final float ACRECIMO = 5 / 100f;
        if (feriado.equalsIgnoreCase("sim"))
            acrescimoFeriado = ACRECIMO * valLiquido;
        return acrescimoFeriado;
    }

    /// CALCULO DO VALOR COM ACRESCIMO
    public float valLiquidoComAcrecimo()
    {
        return valLiquido + acrescimoFeriado;
    }

    /// CALCULO DO IMPOSTO
    public float imposto()
    {
        final float IMPOSTO = 10 / 100f;
        imposto = IMPOSTO * valLiquidoComAcrescimo;
        return imposto;
    }



    /// CALCULO DO VALOR FINAL
    public float valorFinal()
    {
        return valLiquidoComAcrescimo + imposto;
    }

    public String getNomeCliente()
    {
        return nomeCliente;
    }


    /// Metodo Gets
    public long getNumeroTelefone() {return numeroTelefone;}

    public String getNomeDoCliente()
    {
        return nomeCliente;
    }

    public String getTipo()
    {
        return tipo;
    }

    public String getData()
    {
        return data;
    }

    public String getFeriado()
    {
        return feriado;
    }

    public int getNumPessoas()
    {
        return numPessoas;
    }

    public String getDecoracao()
    {
        return decoracao;
    }

    public int getNumfuncionarios()
    {
        return numfuncionarios;
    }

    public float getValor_Base()
    {
        return valor_Base;
    }

    public float getValComAsse()
    {
        return valComAsse;
    }

    public float getDesconto()
    {
        return desconto;
    }

    public float getAcrescimoFeriado()
    {
        return acrescimoFeriado;
    }

    public float getValor_final()
    {
        return valor_final;
    }

    /// Metodo String ToString
    public String toString()
    {
        return "================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================\n" +
                " | Numero de Telefone :'" + numeroTelefone +
                " | Nome do Cliente :'" + nomeCliente +
                " | Tipo de evento :'" + tipo +
                " | Data do evento :'" + data +
                " | Feriado :'" + feriado +
                " | Numero de Pessoas :" + numPessoas +
                " | Decoracao :'" + decoracao +
                " | Assessoria :'" + assessoria +
                " | Numero de funcionarios:" + numfuncionarios +
                " | Valor Base :" + mt.format(valor_Base) +
                " | Valor da decoracao :" + mt.format(valor_decoracao) +
                " | Valor Base Com Decoracao :" + mt.format(valComDec) +
                " | Valor Com Assessoria :" + mt.format(valComAsse) +
                " | Desconto :" + mt.format(desconto) +
                " | Valor Liquido :" + mt.format(valLiquido) +
                " | Acrescimo do Feriado :" + mt.format(acrescimoFeriado) +
                " | Valor Liquido Com Acrescimo :" + mt.format(valLiquidoComAcrescimo) +
                " | Imposto :" + mt.format(imposto) +
                " | Valor final :" + mt.format(valor_final) +" |"+
                "\n" +
                "================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================"+
                "\n";
    }
}