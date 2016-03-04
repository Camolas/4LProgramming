
import java.util.Random;


public class Espada extends Item
{

    private boolean drop;
    private char sigla;
    
    public char returnSigla()
    {
    	return sigla;
    }
    
    public boolean returnDrop()
    {
    	return drop;
    }

    public void armaPersonagem(Personagem person, Jogo game, char[][] tab)
    {
    	if(Math.abs(person.getPosicao()[0] - this.getPosicao()[0])<1
    			|| Math.abs(person.getPosicao()[1] - this.getPosicao()[1])<1)
    	{
    		person.setSigla('E');
    		game.personagemNoTabuleiro(person, tab);
    	}
    	else return;
    }
    
    public void spawnEspada(char[][] tab)
    {
    	Random randomGenerator = new Random();
    	int x = randomGenerator.nextInt(10);
    	int y = randomGenerator.nextInt(10);
    	int[] pos = {x, y};
    	this.setPosicao(pos);
    	if(tab[this.getPosicao()[0]][this.getPosicao()[1]] == ' ')
    	{
    		tab[this.getPosicao()[0]][this.getPosicao()[1]] = 'E';
    		return;
    	}
    	else spawnEspada(tab);
    }

}
