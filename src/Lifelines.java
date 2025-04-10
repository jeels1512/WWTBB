//Lifelines class is used to store and use FiftyFifty that has been created in another class.
//Constructor without any parameters
//The logic is to make 50/50 start just once and after time say Now 50/50 noy available.

public class Lifelines {
    private boolean fiftyfiftyused;  // Type boolean



//    Constructor without paramters
    public Lifelines(){
        this.fiftyfiftyused=false;
    }

//    Setter
    public void setFiftyfiftyused(boolean fiftyfiftyused){
        this.fiftyfiftyused=fiftyfiftyused;
    }

//    Getter

    public boolean getFiftyfiftyused(){
        return fiftyfiftyused;
    }

//    Calling from another class and using it to make 50/50 code run just for once
    public void FiftyFifty(Question Questions){
        if (!fiftyfiftyused){
            Questions.fiftyFifty();
            fiftyfiftyused=true; // value that is stored changed
        }
    }

//    Method Overloading
    public void FiftyFifty() {
        System.out.println(" Now 50/50 is not available ");
    }


}
