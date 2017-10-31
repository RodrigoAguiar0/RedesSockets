package rdtprotocolo;

import java.util.Vector;

public class EventoLista
{
    private Vector<Evento> data;
    
    public EventoLista()
    {
        data = new Vector<Evento>();
    }
    
    public boolean add(Evento e)
    {
        data.addElement(e);
        return true;
    }
    
    public Evento removeNext()
    {
        if (data.isEmpty())
        {
            return null;
        }
    
        int firstIndex = 0;
        double first = ((Evento)data.elementAt(firstIndex)).getTime();
        for (int i = 0; i < data.size(); i++)
        {
            if (((Evento)data.elementAt(i)).getTime() < first)
            {
                first = ((Evento)data.elementAt(i)).getTime();
                firstIndex = i;
            }
        }
        
        Evento next = (Evento)data.elementAt(firstIndex);
        data.removeElement(next);
    
        return next;
    }
    
    public String toString()
    {
        return data.toString();
    }

    public Evento removeTimer(int entity)
    {
        int timerIndex = -1;
        Evento timer = null;
        
        for (int i = 0; i < data.size(); i++)
        {
            if ((((Evento)(data.elementAt(i))).getType() == 
                                           RedeSimulador.TIMERINTERRUPT) &&
                (((Evento)(data.elementAt(i))).getEntity() == entity))
            {
                timerIndex = i;
                break;
            }
        }
        
        if (timerIndex != -1)
        {
            timer = (Evento)(data.elementAt(timerIndex));
            data.removeElement(timer);
        }
        
        return timer;
            
    }
    
    public double getLastPacketTime(int entityTo)
    {
        double time = 0.0;
        for (int i = 0; i < data.size(); i++)
        {
            if ((((Evento)(data.elementAt(i))).getType() == 
                                           RedeSimulador.FROMNETWORK) &&
                (((Evento)(data.elementAt(i))).getEntity() == entityTo))
            {
                time = ((Evento)(data.elementAt(i))).getTime();
            }
        }
    
        return time;
    }
}
