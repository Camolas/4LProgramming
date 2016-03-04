/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package jogolpoo2016;

/**
 *
 * @author ShoterXX
 */
public class Dragao extends Personagem
{
    private boolean sleep;
    
    
    public boolean estaDormir(){
    	return sleep;
    }
    
    void adormeceDragao(){
    	sleep = true;
    }
    
    void acordaDragao(){
    	sleep = false;
    }
}
