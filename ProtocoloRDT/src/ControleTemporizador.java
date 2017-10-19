/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fer
 */
public interface ControleTemporizador {
    public void iniciarTemporizador(int binario, float tempo);
    public void pareTemporizador(int binario, float tempo);
    
    public void vaParaCamadaTres(int binario, Pacote pkt);
    public void vaParaCamadaCinco(int binario, Pacote mensagem);
}
