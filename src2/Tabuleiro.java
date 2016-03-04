import java.util.Scanner;
import java.util.Random;



public class Tabuleiro {

	//public static void main(String[] args) {
	
	public static void main(String[] args)
	{
		
		Jogo game = new Jogo();
		
		int[] pos = {5, 5};
		Heroi hero = new Heroi();
		game.siglaHeroi(hero);
		
		Dragao drago = new Dragao();
		game.siglaDragao(drago);
		
		Espada sword = new Espada();
		sword.setSigla('E');
		
		char[][] tabuleiro ={ 
				 {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
				 {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
				 {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				 {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				 {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				 {'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'S'},
				 {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				 {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
				 {'X', ' ', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
	             {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
		};
		
		drago.setPosicao(pos);
		game.heroiNoTabuleiro(hero, tabuleiro);
		game.dragaoNoTabuleiro(drago, tabuleiro);		
		sword.spawnEspada(tabuleiro);
		game.printTabuleiro(tabuleiro);

int oi=0;
while(oi==0)
{
	game.movePersonagem(hero, tabuleiro);
	game.randomMovePersonagem(drago, tabuleiro);
	sword.armaPersonagem(hero, game, tabuleiro);
	game.jogoAcaba(hero, drago, tabuleiro);
}

		
		
		
	}
}
	

