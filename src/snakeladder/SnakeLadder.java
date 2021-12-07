package snakeladder;

public class SnakeLadder {


	static int PLYER1_POINTS = 0;
	static int PLYER2_POINTS = 0;
	static int COUNTS = 0;
	static int LUCK=0;
	
	static int random_value(int maxi) {
		int die_value = (int)(Math.floor(Math.random()*10) % (maxi)) + 1;
		
		return die_value;
	}

	static int snake(int die, int player){

		System.out.println("snake = " + die);
		int temp = player - die;
		if (temp <= 0){
			player -= 0;
			
		}

		else {
			player = temp;
		}
		return player;
	}

	static int ladder(int die, int player){
		System.out.println("ladder = " + die);
		int temp = player + die;
		
		if (temp <= 100){
			player = temp;
		}

		return player;
	}

	static int calculation(int player){
		System.out.println("current points of player = " + player);
		int die_number = random_value(6);
		System.out.println("dice number" + die_number);
			
		int option = random_value(3);
		System.out.println("option is" + option);
		
		if (option == 1){
			int result = ladder(die_number, player);
			LUCK = 1;
			return result;
		}

		else if(option == 2){
			
			int result = snake(die_number, player);
			return result;
		}

		else {
			System.out.println("no play=0");
			return player;
		}

	}

	public static void main(String[] args) {
		int play_again1 = 0;
		int play_again2 = 0;
		

		while (PLYER1_POINTS < 100 && PLYER2_POINTS < 100){
			
			
			
			while (play_again1 == 0){
				LUCK = 0;
				play_again1 = 1;
				System.out.println("player one executing");
				PLYER1_POINTS= calculation(PLYER1_POINTS);
				System.out.println("points of player 1 is " + PLYER1_POINTS);

				if (LUCK == 1){
					System.out.println("=================================================================");
					System.out.println("player can play again");
					play_again1 = 0;
					System.out.println("=================================================================");
				}
				COUNTS += 1;
			}

			while(play_again2 == 0){
				LUCK = 0;
				play_again2 = 1;
				System.out.println("==============================================================");
				System.out.println("player two executing");
				PLYER2_POINTS= calculation(PLYER2_POINTS);
				System.out.println("points of player 2 is " + PLYER2_POINTS);
				System.out.println("=================================================================");

				if (LUCK == 1){
					System.out.println("=================================================================");
					System.out.println("player can play again");
					play_again2 = 0;
					System.out.println("=================================================================");
				}
				COUNTS += 1;
			}
			play_again1 = 0;
			play_again2 = 0;

		}

		if (PLYER1_POINTS == 100){
			System.out.println("player 1 won the match");
		}
		else{
			System.out.println("player 2 won the match");
		}

		System.out.println("total tossed= " + COUNTS);
			 
	}

}
