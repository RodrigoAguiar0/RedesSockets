package rdtprotocolo;

public class Mensagem
{
    private String data;
    
    public Mensagem(String inputData)
    {
        if (inputData == null)
        {
            data = "";
        }
        else if (inputData.length() > RedeSimulador.MAXDATASIZE)
        {
            data = "";
        }
        else
        {
            data = new String(inputData);
        }
    }
           
    public boolean setData(String inputData)
    {
        if (inputData == null)
        {
            data = "";
            return false;
        }
        else if (inputData.length() > RedeSimulador.MAXDATASIZE)
        {
            data = "";
            return false;
        }
        else
        {
            data = new String(inputData);
            return true;
        }
    }
    
    public String getData()
    {
        return data;
    }

    public String toString()
    {
        return data;
    }

    
}
