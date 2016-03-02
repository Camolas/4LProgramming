import java.util.Scanner;

public class Tabuleiro {

	//public static void main(String[] args) {
	
	public static void main(String[] args)
	{
		int[] pos = {5, 5};
		Heroi hero = new Heroi();
		hero.setSigla('H');
		Dragao drago = new Dragao();
		drago.setSigla('D');
		drago.setPosicao(pos);
		
		char[][] tabuleiro =
			/*tabuleiro = new char[][]*/ { 
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
		
		printTabuleiro(tabuleiro);
		heroiNoTabuleiro(hero, tabuleiro);
		dragaoNoTabuleiro(drago, tabuleiro);
		printTabuleiro(tabuleiro);
		System.out.print("\n\n");
		movePersonagem(hero, tabuleiro);
		System.out.print("\n\n");
		movePersonagem(hero, tabuleiro);
		
		
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void printTabuleiro(char[][] tab){
			for(int i=0; i<10; i++){
				for(int j=0; j<10; j++){
					System.out.print(tab[i][j]);
					//System.out.print(tab[i][j]);
					//System.out.print(' ');
				}
				System.out.print('\n');
			}
		}
	
	public static void heroiNoTabuleiro(Heroi hero, char[][] tab){
		//tab[hero.x][hero.y] = hero.estado;
		tab[hero.getPosicao()[0]][hero.getPosicao()[1]] = 'H';
	}

	public static void dragaoNoTabuleiro(Dragao drago, char[][] tab){
		tab[drago.getPosicao()[0]][drago.getPosicao()[1]] = 'D';
	}
	
	public static void personagemNoTabuleiro(Personagem person, char[][] tab){
		tab[person.getPosicao()[0]][person.getPosicao()[1]] = person.getSigla();
	}
	
	public static void apagaPersonagem(Personagem person, char[][] tab){
		tab[person.getPosicao()[0]][person.getPosicao()[1]] = ' ';
	}
	
	
	public static void movePersonagem(Personagem person, char[][] tab){
	
		//0 = cima
		//1 = baixo
		//2 = esquerda
		//3 = direita
		
		System.out.print("Passo a tomar:\n 0 - cima\n 1 - baixo\n 2 - esquerda\n 3 - direita\n\nSua decisao:");
		Scanner scan = new Scanner(System.in);
		int step = scan.nextInt();
		
		/*
		if(passo == "cima")
			step = 0;
		else if(passo == "baixo")
			step = 1;
		else if(passo == "esquerda")
			step = 2;
		else if(passo == "direita")
			step = 3;
		else System.out.print("\ndirecao invalida!\n");
		*/
		
		switch(step){
		
		case 0:
			if(tab[person.getPosicao()[0]-1][person.getPosicao()[1]] == 'X')
			{
				printTabuleiro(tab);
				System.out.print("\npasso invalido!\n");
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
				System.out.print("\npasso invalido!\n");
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
				System.out.print("\npasso invalido!\n");
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
				System.out.print("\npasso invalido!\n");
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
	
	
	
	
}
	


