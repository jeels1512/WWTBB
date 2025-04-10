// Question class
//store Questions , Options and correct Options alaong with fifityfifty
//A parametrized constructor is used with the parameters .
//Setters and Getters are created for all three instance variables
//FiftyFifty is created , so that the Lifeline 50/50 remove only 2 incorrect options .
//Thr class is used in Lifelines and Millionarie classes.
public class Question {
    private String Questions; //Type String
    private String[][] Options; // 2D Arrays of type String
    private int correctOptions;

//    Constructor
    public Question(String Questions , String[][] Options , int correctOptions){
        this.Questions=Questions;
        this.Options=Options;
        this.correctOptions=correctOptions;
    }

//    Setter
    public void setQuestions(String Questions){
        this.Questions=Questions;
    }

//    Getter
    public String getQuestions() {
        return Questions;
    }

//  Setter

    public void setOptions(String[][] Options){
        this.Options=Options;
    }

//    Getter
    public String[][] getOptions(){
        return Options;
    }
//    Setter

    public void setCorrectOptions(int correctOptions){
        this.correctOptions=correctOptions;
    }

//    Getter
    public int getCorrectOptions(){
        return correctOptions;
    }

//    method for 50/50lifeline
    public void fiftyFifty(){
        int count =0;
        int i=0;
        while (i< Options.length){
            if (i!=correctOptions-1 && count<2){
                Options[i][1]="";
                count++;
            }
            i++;
        }
    }


}
