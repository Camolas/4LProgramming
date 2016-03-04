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
public class Heroi extends Personagem
{

    private boolean armado;
    
 


    public boolean estaArmado()
    {
        return armado;
    }

    public void darArma()
    {
        armado = true;
    }

    public void retirarArma()
    {
        armado = false;
    }

}
