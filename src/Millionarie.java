import java.util.Random;
import java.util.Scanner;


//Question and Lifelines class both are called in this class and the methods and var that we created in both those are used.
//There are total que 10
//prize is total 1M
// To use lifelines if-else is used along with scanner.
//Try and catch is used to if everything is going smoothly
public class Millionarie {
    private int MAX_QUiZ = 10;  // type int with value already assigned
    private int PRIZE_INCR=100000; // type int with value already assigned

    private Question[] Questions;   //type of Question array Questions are called
    private Integer prizeMoney;  //Wrapper Class
    private Lifelines lifelines; //Lifelines class is called

    // Constructor is created without parameters
    public Millionarie(){
        this.Questions=allQuestions(); //allQuestions method created below
        this.prizeMoney=0;   // prize money set 0
        this.lifelines= new Lifelines(); //class Lifelines is called
    }

    // random
    Random random = new Random();

    // all questions are created and stored in an array
    private Question[] allQuestions(){
        return new Question[]{
                new Question(" Which country has won the most World cups?",new String[][]{{"1","India"},{"2","Brazil"},{"3","Pakistan"},{"4","Australia"}},2),
                new Question("Which phone company has produced the 3310?",new String[][]{{"1","Nokia"},{"2","Samsung"},{"3","MicroMax"},{"4","Carbon"}},1),
                new Question("Which programming language is used for developing android apps?",new String[][]{{"1","Python"},{"2","Java"},{"3","Javascript"},{"4","Ruby"}},2),
                new Question("Where is the strongest human muscle located?",new String[][]{{"1","Jaw"},{"2","buttocks"},{"3","thigh"},{"4","calf"}},1),
                new Question("What is the name of the biggest technology company in South Korea?",new String[][]{{"1","Sony"},{"2","Xiaomi"},{"3","Samsung"},{"4","Oneplus"}},3),
                new Question("The earth is approximately how many miles away from the sun?",new String[][]{{"1","9.3 Million"},{"2","39 Million"},{"3","93 Million"},{"4","193 Million"}},3),
                new Question("Pink Ladies and Granny Smiths are types of what fruit?",new String[][]{{"1","Strawberry"},{"2","Mango"},{"3","Apple"},{"4","Peach"}},3),
                new Question("What device was announcement in 2007 with the following slogan?-'This is only the beginning'?",new String[][]{{"1","Samsung "},{"2","Iphone"},{"3","Xiaomi"},{"4","Sony"}},2),
                new Question("Which of these U.S Presidents appeared on the television series-'Laugh-In'? ",new String[][]{{"1","Lyndon Johnson"},{"2","Richard Nixon"},{"3","Jimmy Carter"},{"4","Gerald Ford"}},2),
                new Question("Choose any number from below options",new String[][]{{"5","(1)"},{"10","(2)"},{"15","(3)"},{"20","(4)"}},random.nextInt(1,30))
        };
    }

    //Setter
    public void setPrizeMoney(int prizeMoney){
        this.prizeMoney=prizeMoney;
    }

    //Getter
    public int getPrizeMoney(){
        return prizeMoney;
    }

    //Setter
    public void setLifelines(Lifelines lifelines){
        this.lifelines=lifelines;
    }

    //Getter
    public Lifelines getLifelines(){
        return lifelines;
    }


    public void startQuiz(){
        //takes user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's start the Game: 'Who Wants to Be a Millionaire?'");
        //loops all the questions
        for (int i=0;i<MAX_QUiZ;i++){
            System.out.println("Question " +(i+1) + " : "+Questions[i].getQuestions());
            for (String[] option : Questions[i].getOptions()){ // to loop options are they are in an array
                System.out.println(option[0] + " : "+option[1]);
            }

            System.out.println("Choose correct option or type '0' for 50/50 ( not for 10th question !) or '100' for Audience Poll :");

            // below code  for lifelines
            // used try catch to check any error / exception
            try{
                String val = scanner.next();
                //for 50/50
                if (val.equalsIgnoreCase("0")){ //ignores spacing , capital letters and check the input if its equal
                    lifelines.FiftyFifty(Questions[i]);  //
                    for (String[] option : Questions[i].getOptions()) { //to show options
                        System.out.println(option[0] + ": " + option[1]);
                    }
                    lifelines.FiftyFifty(); //print mess

                    String half=scanner.next();
                    int newval=Integer.parseInt(half);
                    if (newval==Questions[i].getCorrectOptions()){
                        prizeMoney+=PRIZE_INCR; // incr prize money if answer is correct
                        System.out.println("Bravo ! You won : $ "+prizeMoney + " till now");
                    }else {
                        // if its wrong
                        System.out.println("Better Luck Next Time ! Game over . You won : $ " +prizeMoney);
                        break;
                    }
                    // for audience poll
                } else if (val.equalsIgnoreCase("100")) {
                    String poll = scanner.nextLine();
                    for (String[] option : Questions[i].getOptions()) {
                        System.out.println(option[0] + ": " + option[1]);
                    }
                    String gotval=scanner.next();
                    int new2val=Integer.parseInt(gotval);
                    if (new2val==Questions[i].getCorrectOptions()){
                        prizeMoney+=PRIZE_INCR;
                        System.out.println("Bravo ! You won : $ "+prizeMoney + " till now");
                    }else {
                        System.out.println("Better Luck Next Time ! Game over . You won : $ " +prizeMoney);
                        break;
                    }
                } else {
                    //if the liefeline is not used
                    int answer=Integer.parseInt(val);
                    if (answer==Questions[i].getCorrectOptions()){
                        prizeMoney+=PRIZE_INCR;
                        System.out.println("Bravo ! You won : "+prizeMoney + " till now");
                    }else {
                        System.out.println("Better Luck Next Time ! Game over . You won : " +prizeMoney);
                        break;
                    }
                }
            }catch (NumberFormatException e){ // exception
                System.out.println("Invalid value. Please enter a number between 1 and 4.");
                scanner.next();
            }

            // end statement
            System.out.println("Thank you ! You won : $ " + prizeMoney);

        }
        // scanner closed
        scanner.close();
    }


}
