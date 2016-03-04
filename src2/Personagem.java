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
public class Personagem
{
	
    private int posicao[] = new int[2];
    private boolean viva;
    private char sigla;
    

    public Personagem()
    {
        posicao[0] = posicao[1] = 1;
        viva = true;
    }

    public Personagem(int[] _posicao)
    {
        posicao = _posicao;
        viva = true;
        sigla = ' ';
    }

    public Personagem(int[] _posicao, boolean _viva)
    {
        posicao = _posicao;
        viva = _viva;
    }

    public Personagem(boolean _viva)
    {
        posicao[0] = posicao[1] = 0;
        viva = _viva;
    }

    public void Matar()
    {
        viva = false;
    }

    public void Reviver()
    {
        viva = true;
    }

    public boolean estaViva()
    {
        return viva;
    }

    public int[] getPosicao()
    {
        return posicao;
    }
    
    
    public char getSigla()
    {
    	return sigla;
    }
    
    public void setSigla(char newsigla)
    {
    	sigla = newsigla;
    }
    

    public boolean setPosicao(int[] new_posicao)
    {
        posicao = new_posicao;
        return true;
    }

    public void moveRight()
    {
        posicao[1]++;
    }

    public void moveLeft()
    {
        posicao[1]--;
    }

    public void moveUp()
    {
        posicao[0]--;
    }

    public void moveDown()
    {
        posicao[0]++;
    }

}
