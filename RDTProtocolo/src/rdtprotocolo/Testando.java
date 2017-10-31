package rdtprotocolo;

import java.io.*;

public class Testando
{
    public final static void main(String[] argv)
    {
        RedeSimulador simulator;
        
        int nsim = Integer.parseInt(argv[0]);
        double loss = Double.parseDouble(argv[1]);
        double corrupt = Double.parseDouble(argv[2]);
        double delay = Double.parseDouble(argv[3]);
        int trace = Integer.parseInt(argv[4]);
        long seed = Long.parseLong(argv[5]);
    
                                   
        System.out.println("******************************************************************************");
        System.out.println("******** executando simulador de rede com os parâmetros *********");
        System.out.println("******************************************************************************");
        System.out.println("nsim="+nsim);
        System.out.println("loss="+loss);
        System.out.println("corrupt="+corrupt);
        System.out.println("delay="+delay);
        System.out.println("trace="+trace);
        System.out.println("seed="+seed);
         
        simulator = new RedeSimulador(nsim, loss, corrupt, delay,
                                                trace, seed);
                                                
        simulator.runSimulator();
        System.out.println("******* Fim da simulação com os parâmetros *********");
        System.out.println("nsim="+nsim);
        System.out.println("loss="+loss);
        System.out.println("corrupt="+corrupt);
        System.out.println("delay="+delay);
        System.out.println("trace="+trace);
        System.out.println("seed="+seed);
        System.out.println("*********************************************");
        System.out.println("Dado recebido ******************************");
        System.out.println(simulator.getReceivedData());
        System.out.println("*********************************************");
        System.out.println("Tempo de simulação:"+simulator.getTime());
        System.out.println("******************************************************************************");
        

    }
}
