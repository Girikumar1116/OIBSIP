import java.util.*;
class Number_Guessing_Game
{
    Number_Guessing_Game()
    {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        int random_value=random.nextInt(100);
        int attempts=1;
        while (attempts<=5)
        {
            System.out.println("Guess the value between (1-100)");
            int user_value=sc.nextInt();
            if (user_value==random_value)
            {   
                System.out.println("Hurray you won the game");
                switch (attempts)
                {
                    case 1:
                        System.out.println("your score is 100");
                        break;
                    case 2:
                        System.out.println("you score is 80");
                        break;
                    case 3:
                        System.out.println("you score is 60");
                        break;
                    case 4:
                        System.out.println("you score is 40");
                        break;
                    case 5:
                        System.out.println("you score is 20");
                        break;
                }
                System.out.println("Next round click 1");
  
            }
            else if (random_value > user_value)
            {
                System.out.println("Random number  is greater than your guessing value");
            }
            else
            {
                System.out.println("Random number  is lower  than your guessing value");
            }
            attempts++;
        }
        System.out.println("Random value is"+ random_value);
        System.out.println("Better luck for next time!");
    }
}
class Main
{
    static{
        System.out.println("Number Guessing Game");
    }
    
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("play click 1 ");
        System.out.println("quit click 0");
        int play=sc.nextInt();
        int con;
        if (play==1)
        {
            do{
            System.out.println("lets started the game!");
            Number_Guessing_Game n=new Number_Guessing_Game();
            System.out.println("Enter 1 to continue or enter 0 exit");
            con=sc.nextInt();
        }
            while(con!=0);

        }
        else{
            System.out.println();
        }
    }
}