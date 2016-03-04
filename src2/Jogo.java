import java.util.Scanner;
import java.util.Random;

public class Jogo {
	
	//Constructor do Jogo
	public Jogo()
	{
	}
	
	//Atribui a sigla ao Dragao
	public static void siglaDragao(Dragao drago){
		if (drago.estaDormir() == true)
			drago.setSigla('S');
		else drago.setSigla('D');
	}
	
	//Atribui a sigla ao Heroi
	public static void siglaHeroi(Heroi hero){
		if(hero.estaArmado() == true)
			hero.setSigla('E');
		else hero.setSigla('H');
	}
	
	
	//Imprime Tabuleiro
	public static void printTabuleiro(char[][] tab){
			for(int i=0; i<10; i++){
				for(int j=0; j<10; j++){
					System.out.print(tab[i][j]);
				}
				System.out.print('\n');
			}
		}
	
	//coloca o Heroi no Tabuleiro
	public static void heroiNoTabuleiro(Heroi hero, char[][] tab){
		tab[hero.getPosicao()[0]][hero.getPosicao()[1]] = 'H';
	}
	
	//coloca o Dragao no Tabuleiro
	public static void dragaoNoTabuleiro(Dragao drago, char[][] tab){
		tab[drago.getPosicao()[0]][drago.getPosicao()[1]] = 'D';
	}
	
	//coloca uma Personagem generica no Tabuleiro
	public static void personagemNoTabuleiro(Personagem person, char[][] tab){
		tab[person.getPosicao()[0]][person.getPosicao()[1]] = person.getSigla();
	}
	
	//apaga uma Personagem generica do Tabuleiro
	public static void apagaPersonagem(Personagem person, char[][] tab){
		tab[person.getPosicao()[0]][person.getPosicao()[1]] = ' ';
	}
	
	//move uma Personagem generica
	public static void movePersonagem(Personagem person, char[][] tab){
		
		//0 = cima
		//1 = baixo
		//2 = esquerda
		//3 = direita
		
		System.out.print("Passo a tomar:\n 0 - cima\n 1 - baixo\n 2 - esquerda\n 3 - direita\n\nSua decisao:");
		Scanner scan = new Scanner(System.in);
		int step = scan.nextInt();
		
		
		switch(step){
		
		case 0:
			if(tab[person.getPosicao()[0]-1][person.getPosicao()[1]] == 'X')
			{
				printTabuleiro(tab);
				//System.out.print("\npasso invalido!\n");
				return;
			}
			else{
				apagaPersonagem(person, tab);
				person.moveUp();
				personagemNoTabuleiro(person, tab);
				printTabuleiro(tab);
			}
			break;
			
		case 1:
			if(tab[person.getPosicao()[0]+1][person.getPosicao()[1]] == 'X')
			{
				printTabuleiro(tab);
				//System.out.print("\npasso invalido!\n");
				return;
			}
			else{
				apagaPersonagem(person, tab);
				person.moveDown();
				personagemNoTabuleiro(person, tab);
				printTabuleiro(tab);
			}
			break;
			
		case 2:
			if(tab[person.getPosicao()[0]][person.getPosicao()[1]-1] == 'X'){
				printTabuleiro(tab);
				//System.out.print("\npasso invalido!\n");
				return;
			}
			else{
				apagaPersonagem(person, tab);
				person.moveLeft();
				personagemNoTabuleiro(person, tab);
				printTabuleiro(tab);
			}
			break;
			
		case 3:
			if(tab[person.getPosicao()[0]][person.getPosicao()[1]+1] == 'X')
			{
				printTabuleiro(tab);
				//System.out.print("\npasso invalido!\n");
				return;
			}
			else{
				apagaPersonagem(person, tab);
				person.moveRight();
				personagemNoTabuleiro(person, tab);
				printTabuleiro(tab);
			}
			break;
		default:
			break;
		}
	}
	
	//move uma Personagem aleatoriamente, 1 vez
	public static void randomMovePersonagem(Personagem person, char[][] tab)
	{
	
	Random randomGenerator = new Random();
	int randomstep = randomGenerator.nextInt(4);
	
	
	switch(randomstep){
	
	case 0:
		if(tab[person.getPosicao()[0]-1][person.getPosicao()[1]] != ' ')
		{
			printTabuleiro(tab);
			//System.out.print("\npasso invalido!\n");
			return;
		}
		else{
			apagaPersonagem(person, tab);
			person.moveUp();
			personagemNoTabuleiro(person, tab);
			printTabuleiro(tab);
		}
		break;
		
	case 1:
		if(tab[person.getPosicao()[0]+1][person.getPosicao()[1]] != ' ')
		{
			printTabuleiro(tab);
			//System.out.print("\npasso invalido!\n");
			return;
		}
		else{
			apagaPersonagem(person, tab);
			person.moveDown();
			personagemNoTabuleiro(person, tab);
			printTabuleiro(tab);
		}
		break;
		
	case 2:
		if(tab[person.getPosicao()[0]][person.getPosicao()[1]-1] != ' '){
			printTabuleiro(tab);
			//System.out.print("\npasso invalido!\n");
			return;
		}
		else{
			apagaPersonagem(person, tab);
			person.moveLeft();
			personagemNoTabuleiro(person, tab);
			printTabuleiro(tab);
		}
		break;
		
	case 3:
		if(tab[person.getPosicao()[0]][person.getPosicao()[1]+1] != ' ')
		{
			printTabuleiro(tab);
			//System.out.print("\npasso invalido!\n");
			return;
		}
		else{
			apagaPersonagem(person, tab);
			person.moveRight();
			personagemNoTabuleiro(person, tab);
			printTabuleiro(tab);
		}
		break;
	default:
		break;
	}
}
	
	
	
	
	
	//verifica se as condicoes para o dragao morrer se verificam, matando-o se sim
	public static void mataDragao(Heroi hero, Dragao drago)
	{
		if(hero.getSigla() == 'E' && drago.getSigla() == 'd')
		{
		if(Math.abs(hero.getPosicao()[0] - drago.getPosicao()[0]) < 1
				|| Math.abs(hero.getPosicao()[1] - drago.getPosicao()[1]) < 1)
			drago.Matar();
	} else return;
	}
	
	
	//verifica se as condicoes para o jogo acabar se verificam, acaba o jogo se sim
	public static void jogoAcaba(Heroi hero, Dragao drago, char[][] tab){
		if(hero.getSigla() == 'H')
		{
			if(Math.abs(hero.getPosicao()[0] - drago.getPosicao()[0]) < 1
				|| Math.abs(hero.getPosicao()[1] - drago.getPosicao()[1]) < 1)
				System.out.print("\n\n\n\nSUCUMBISTE, FALECESTE, AZOIGASTE\n\n\n\n");
		}
		if(hero.getSigla() == 'E' && drago.getSigla() == 'd')
		{
			if(drago.estaViva() == false || tab[hero.getPosicao()[0]][hero.getPosicao()[1]] == 'S')
				System.out.print("\n\n\n\nO GANHADOR ES TUn\n\n\n");
			}
		else return;		
	}
	
	

	

}
