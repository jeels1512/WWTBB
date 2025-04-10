// Main class in which the whole game is run inside main method


// WWTBM GAME !
// You have 10 Questions and with every question the level of difficulty increases
//You have 2 Lifelines but cannot be used for 10th Question
// 1 50/50 - Can be used just once
// 2 Audience Poll
//For every correct answer you get $100000 as prize money
// If you enter incorrect option , you have to start from Question 1
//Thank You

public class Main {
    public static void main(String[] args) {
        Millionarie millionarie= new Millionarie();
        millionarie.startQuiz();
    }
}
