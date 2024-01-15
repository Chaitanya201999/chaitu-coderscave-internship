import java.util.Scanner;

class numbergame {
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

String secretword = "9";
String guess = "";
int guessCount = 0;
int guessLimit = 3;
boolean outOfGuesses = false;

while (!guess.equals(secretword) && !outOfGuesses) {

if (guessCount < guessLimit) {
   System.out.print("Enter guess: ");
   guess = sc.nextLine();
   guessCount++;
} else {
   outOfGuesses = true;
}
}
if (outOfGuesses) {
    System.out.println("You Lose! No more guesses");
} else {
    System.out.println("You Win!");
}    
}
}