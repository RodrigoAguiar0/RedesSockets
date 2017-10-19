
/**
 * Contrato que será estabelecido para executar as ações de
 * entrada e saída de mensagem e pacotes, bem como interrupção
 * de temporizador ou inicialização de uma rotina.
 * Os métodos para envio de mensagens terão implementação diferente
 * dos métodos de envio de pacotes
 */
public interface Rotinas {
    public void A_saida(Mensagem msg);
    public void A_entrada(Pacote pkt);
    public void A_temporizador();
    public void A_inicie();
    
    public void B_entrada(Pacote pkt);
    public void B_inicie();
}
