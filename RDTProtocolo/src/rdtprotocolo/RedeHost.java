package rdtprotocolo;

import java.util.Random;

public class RedeHost
{
    // This constant controls the maximum size of the buffer in a Mensagem
    // and in a Pacote
    public static final int TAMANHOMAXIMODADO = 20;

    
    private int entidade;
    private int traceLevel;
    private EventoLista eventoLista;
    private Random rand;
    private double tempo;
    private double perdaProb;
    private double corrupProb;
    private String dadoRecebido;   
   
    /**
     *  Versão padrão do método de saída para implementar.
     */
    protected void Output(Mensagem message)
    {
         System.out.println("Output method called for entity" + entidade 
                             + "but not implemented.");
    }
    /**
     *  Versão padrão do método de entrada para implementar.
     */
    protected void Input(Pacote packet)
    {
         System.out.println("Input method called for entity" + entidade 
                             + "but not implemented.");
    }
    /**
     *  Versão padrão do método de interrupção do temporizador para implementar.
     */
    protected void TimerInterrupt()
    {
         System.out.println("TimerInterupt method called for entity" + entidade 
                             + "but not implemented.");
    }
    /**
     *  Versão padrão do método de inicialização para implementar.
     */
    protected void Init()
    {
         System.out.println("Init method called for entity" + entidade
                             + "but not implemented.");
    }


    

    public RedeHost(int entityName,
                       EventoLista events,
                       double pLoss,
                       double pCorrupt,
                       int trace,
                       Random random)
    {
        entidade = entityName;
        eventoLista = events;
        perdaProb = pLoss;
        corrupProb = pCorrupt;
        traceLevel = trace;
        rand = random;
        tempo = 0.0;
        dadoRecebido = "";
    }
    
    
    protected final void stopTimer()
    {
        if (traceLevel > 0)
        {
            System.out.println("stopTimer: parando temporizador em " + tempo);
        }

        Evento timer = eventoLista.removeTimer(entidade);

        // Let the student know they are attempting to cancel a non-existant 
        // timer
        if (timer == null)
        {
            System.out.println("paraTemporizador: Aviso: Impossível cancelar seu " +
                               "temporizador");
        }        
    }
    
    protected final void startTimer(double increment)
    {
        if (traceLevel > 0)
        {
            System.out.println("startTimer: Iniciando temporizador em " + tempo);
        }

        Evento t = eventoLista.removeTimer(entidade);        

        if (t != null)
        {
            System.out.println("startTimer: Aviso: Tentanto iniciar um " +
                               "temporizador que já está executando");
            eventoLista.add(t);
            return;
        }
        else
        {
            Evento timer = new Evento(tempo + increment,
                                    RedeSimulador.TIMERINTERRUPT, entidade);
            eventoLista.add(timer);
        }
    }    
    
    protected final void udtSend(Pacote p)
    {
        int destination;
        double arrivalTime;
        Pacote packet = new Pacote(p);
    
        if (traceLevel > 0)
        {
            System.out.println("udtSend: " + packet);
        }

        // Set our destination
        if (entidade == RedeSimulador.A)
        {
            destination = RedeSimulador.B;
        }
        else if (entidade == RedeSimulador.B)
        {
            destination = RedeSimulador.A;
        }
        else
        {
            System.out.println("udtSend: Aviso: Remetente de pacote inválido");
            return;
        }

        // Simulate losses
        if (rand.nextDouble() < perdaProb)
        {
            if (traceLevel > 0)
            {
                System.out.println("udtSend: Pacote sendo perdido");
            }
            
            return;
        }
        
        // Simular corrompimento
        if (rand.nextDouble() < corrupProb)
        {
            if (traceLevel > 0)
            {
                System.out.println("udtSend: Pacote sendo corrompido");
            }
            
            double x = rand.nextDouble();
            if (x < 0.75)
            {
                String payload = packet.getPayload();
                
                if (payload.length()<2){
                	payload = "=";
                }
                else{
                    //payload = "?" + payload.substring(payload.length() - 1);
                    payload = "=" + payload.substring(1);
              	
                }
                 
                packet.setPayload(payload);
            }
            else if (x < 0.875)
            {
                packet.setSeqnum(Math.abs(rand.nextInt()));
            }
            else
            {
                packet.setAcknum(Math.abs(rand.nextInt()));
            }
        }
        
        
        // Decida quando o pacote chegará. Como o meio não pode
        // reordenar, o pacote chegará 1 a 10 unidades de tempo após o
        // último pacote enviado por este remetente
        arrivalTime = eventoLista.getLastPacketTime(destination);
        
        if (arrivalTime <= 0.0)
        {
            arrivalTime = tempo;
        }
        
        //arrivalTime = arrivalTime + 1.0 + (rand.nextDouble() * 19.0);
        arrivalTime = arrivalTime + 1.0 + Math.abs(5.0*rand.nextGaussian()+9.0);

        // criar e agendar o evento
        if (traceLevel > 2)
        {
            System.out.println("udtSend: Agendando a chegada do outro lado");
        }
        Evento arrival = new Evento(arrivalTime, RedeSimulador.FROMNETWORK, destination, packet);
        eventoLista.add(arrival);
    }
    
    protected final void deliverData(String dataSent)
    {
        if (entidade == RedeSimulador.B){
            dadoRecebido = dadoRecebido + "DATA:" + dataSent+"\n" ; 
        }
        if (traceLevel > 0)
        {
            System.out.print("deliverData: Dado recebido em "+entidade + ":");
            System.out.println(dataSent);

        }
    }
    
    protected void setTime(double newtime)
    {
        tempo=newtime;
    }

    protected double getTime()
    {
        return tempo;
    }

    protected String getReceivedData()
    {
        return dadoRecebido;
    }
    
    
    protected void printEventList()
    {
        System.out.println(eventoLista.toString());
    }
    
}
