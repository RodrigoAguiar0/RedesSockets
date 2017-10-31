package rdtprotocolo;

public class Evento
{
    private double time;
    private int type;
    private int entity;
    private Pacote packet;
    
    public Evento(double t, int ty, int ent)
    {
        time = t;
        type = ty;
        entity = ent;
        packet = null;
    }
    
    public Evento(double t, int ty, int ent, Pacote p)
    {
        time = t;
        type = ty;
        entity = ent;
        packet = new Pacote(p);
    }
            
    public boolean setTime(double t)
    {
        time = t;
        return true;
    }
    
    public boolean setType(int n)
    {
        if ((n != RedeSimulador.TIMERINTERRUPT) &&
            (n != RedeSimulador.FROMAPP) &&
            (n != RedeSimulador.FROMNETWORK))
        {
            type = -1;
            return false;
        }
        
        type = n;
        return true;
    }
    
    public boolean setEntity(int n)
    {
        if ((n != RedeSimulador.A) &&
            (n != RedeSimulador.B))
        {
            entity = -1;
            return false;
        }
        
        entity = n;
        return true;
    }
    
    public boolean setPacket(Pacote p)
    {
        if (p == null)
        {
            packet = null;
        }        
        else
        {
            packet = new Pacote(p.getSeqnum(), p.getAcknum(),
                                p.getChecksum(), p.getPayload());
        }
        
        return true;
    }
    
    public double getTime()
    {
        return time;
    }
    
    public int getType()
    {
        return type;
    }
    
    public int getEntity()
    {
        return entity;
    }
    
    public Pacote getPacket()
    {
        return packet;
    }
    
    public String toString()
    {
        return("time: " + time + "  type: " + type + "  entity: " + entity +
               "packet: " + packet);
    }
        
}
