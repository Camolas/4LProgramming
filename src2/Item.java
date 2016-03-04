
public class Item
{
	
    private int posicao[] = new int[2];
    private char sigla;
    

    public Item()
    {
        posicao[0] = posicao[1] = 1;
    }

    public Item(int[] _posicao)
    {
        posicao = _posicao;
        sigla = ' ';
    }

    public Item(int[] _posicao, boolean _viva)
    {
        posicao = _posicao;
    }

    public Item(boolean _viva)
    {
        posicao[0] = posicao[1] = 0;
    }

    public void apagaItem(char[][] tab)
    {
    	tab[this.getPosicao()[0]][this.getPosicao()[1]] = ' ';
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
