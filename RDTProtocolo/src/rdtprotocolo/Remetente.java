package rdtprotocolo;

/*************************************
 * Filename:  Sender.java
 * Names:
 * Student-IDs:
 * Date:
 *************************************/
import java.util.Random;

public class Remetente extends RedeHost

{
    /*
     * Predefined Constant (static member variables):
     *
     *   int MAXDATASIZE : the maximum size of the Mensagem data and
     *                     Pacote payload
     *
     *
     * Predefined Member Methods:
     *
     *  void startTimer(double increment):
     *       Starts a timer, which will expire in
     *       "increment" time units, causing the interrupt handler to be
     *       called.  You should only call this in the Remetente class.
     *  void stopTimer():
     *       Stops the timer. You should only call this in the Remetente class.
     *  void udtSend(Pacote p)
     *       Sends the packet "p" into the network to arrive at other host
     *  void deliverData(String dataSent)
     *       Passes "dataSent" up to application layer. You should only call this in the 
     *       Receiver class.
     *  double getTime()
     *       Returns the current time in the simulator.  Might be useful for
     *       debugging.
     *  String getReceivedData()
     *       Returns a String with all data delivered to receiving process.
     *       Might be useful for debugging. You should only call this in the
     *       Remetente class.
     *  void printEventList()
     *       Prints the current event list to stdout.  Might be useful for
     *       debugging, but probably not.
     *
     *
     *  Predefined Classes:
     *
     *  Mensagem: Used to encapsulate the message coming from application layer
     *    Constructor:
     *      Mensagem(String inputData): 
     *          creates a new Mensagem containing "inputData"
     *    Methods:
     *      boolean setData(String inputData):
     *          sets an existing Mensagem's data to "inputData"
     *          returns true on success, false otherwise
     *      String getData():
     *          returns the data contained in the message
     *  Pacote: Used to encapsulate a packet
     *    Constructors:
     *      Pacote (Pacote p):
     *          creates a new Pacote, which is a copy of "p"
     *      Pacote (int seq, int ack, int check, String newPayload)
     *          creates a new Pacote with a sequence field of "seq", an
     *          ack field of "ack", a checksum field of "check", and a
     *          payload of "newPayload"
     *      Pacote (int seq, int ack, int check)
     *          chreate a new Pacote with a sequence field of "seq", an
     *          ack field of "ack", a checksum field of "check", and
     *          an empty payload
     *    Methods:
     *      boolean setSeqnum(int n)
     *          sets the Pacote's sequence field to "n"
     *          returns true on success, false otherwise
     *      boolean setAcknum(int n)
     *          sets the Pacote's ack field to "n"
     *          returns true on success, false otherwise
     *      boolean setChecksum(int n)
     *          sets the Pacote's checksum to "n"
     *          returns true on success, false otherwise
     *      boolean setPayload(String newPayload)
     *          sets the Pacote's payload to "newPayload"
     *          returns true on success, false otherwise
     *      int getSeqnum()
     *          returns the contents of the Pacote's sequence field
     *      int getAcknum()
     *          returns the contents of the Pacote's ack field
     *      int getChecksum()
     *          returns the checksum of the Pacote
     *      String getPayload()
     *          returns the Pacote's payload
     *
     */

    
    /**
     * Adicione as variáveis ​​de classe necessárias aqui. Eles podem segurar
     * informações de estado para o remetente.
     * Também adicione todos os métodos necessários (por exemplo, checksum of a String)
     * Este é o construtor. Não toque!.
     */
    public Remetente(int entityName,
                       EventoLista events,
                       double pLoss,
                       double pCorrupt,
                       int trace,
                       Random random)
    {
        super(entityName, events, pLoss, pCorrupt, trace, random);
    }

    // Esta rotina será chamada sempre que a camada de aplicação no remetente
    // tem uma mensagem para enviar. O trabalho do seu protocolo é assegurar que
    // os dados em tal mensagem são entregues em ordem, e corretamente, para
    // a camada de aplicação recebida.
    protected void Output(Mensagem message)
    {
    }
    
    // Esta rotina será chamada sempre que um pacote enviado do receptor
    // (isto é, como resultado de um udtSend () sendo feito por um procedimento de receptor)
    // chega ao remetente. "pacote" é o pacote (possivelmente corrompido)
    // enviado do receptor.
    protected void Input(Pacote packet)
    {
    }
    
    // Esta rotina será chamada quando o temporizador do remetente expirar (assim
    // gerando uma interrupção do temporizador). Você provavelmente vai querer usar essa rotina
    // para controlar a retransmissão de pacotes. Veja startTimer () e
    // stopTimer (), acima, para saber como o temporizador é iniciado e parado. 
    protected void TimerInterrupt()
    {
    }
    
    // Esta rotina será chamada uma vez, antes de qualquer outro lado do remetente
    // rotinas são chamadas. Deve ser usado para fazer qualquer requisito
    // inicialização (por exemplo, de variáveis ​​de membros que você adiciona para controlar o estado
    // do remetente).
    protected void Init()
    {
    }

}
