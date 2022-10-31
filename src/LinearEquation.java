public class LinearEquation {

    //variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    //constructor
    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    //roundedToHundredth to nearest 100th
    public double roundedToHundredth(double num){
        return (Math.round(num*100))/100.0;
    }

    //distance between
    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow(x2-x1 , 2) + Math.pow(y2-y1 , 2)));

    }

    //string fraction slope
    public String calcSlope(){
        String slope = (y2-y1) + "/" + (x2-x1);
        //check double negative
        if (((y2-y1) < 0) && ((x2-x1) < 0)){
            slope = Math.abs(y2-y1) + "/" + Math.abs(x2-x1);
        } else if (((y2-y1) < 0) || ((x2-x1) < 0)){   //negative in front
            slope = "-" + Math.abs(y2-y1) + "/" + Math.abs(x2-x1);
        }
        return slope;
    }

    //number slope
    public double slope(){
        return roundedToHundredth(((double)y2-y1)/((double)x2-x1));
    }

    //y int
    public double yIntercept(){
        return roundedToHundredth(y1 - slope()*x1);
    }

    //slope intercept form
    public String equation(){

        /*y = part*/

        String equation = "y = ";

        /*slope part*/

        //check slope = 0
        if (slope() == 0) {
            equation += "";
        } else {
            //check x = 1 or -1
            if (slope() != 1 && slope() != -1) {
                //check whole number
                if (slope() % 1 == 0) {
                    equation += (int) slope();
                } else {
                    equation += calcSlope();
                }
            } else {
                // add the negative sign for x = -1
                if (slope() < 0){
                    equation += "-";
                } else {
                    equation += "";
                }
            }

            /*x part*/

            equation += "x ";
        }

        /*y int part*/

        //check negative y int
        if (yIntercept() < 0){
            if (slope() == 0){
                equation += (int)yIntercept();
            } else {
                equation += "- " + Math.abs(yIntercept());
            }
        } else if (yIntercept() == 0) { //check y int = 0
            equation += "";
        } else {
            if (slope() == 0){
                equation += (int)yIntercept();
            } else {
                equation += "+ " + yIntercept();
            }
        }
        return equation;
    }

    //calculate using x value
    public String coordinateForX(double x){
        double y = slope()*x + yIntercept();
        return "(" + roundedToHundredth(x) + ", " + roundedToHundredth(y) + ")";
    }

    //info
    public String lineInfo(){
        return "\nThe two points are: " + "(" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")" + "\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The y-intercept of this line is: " + yIntercept() + "\n" +
                "The distance between the two points is: " + distance() + "\n";
    }
}


