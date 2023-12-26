import java.util.Scanner;

public class bmicalculation {
    //main Method
public static void main(String[] args) {
    //Scanner for reading input from User
Scanner input = new Scanner (System.in);

System.out.println("BMI Calculator");
System.out.print("Enter your weight in Kilograms: ");
double weight = input.nextDouble();

System.out.println("Enter your height in meters: ");
double height = input.nextDouble();

double bmi = calculateBMI(weight,height);
String interpretation = interpretBMIvalue(bmi);

System.out.println("Your Body Mass Index is: " + bmi);
System.out.println("Interpretation: " + interpretation);

input.close();
}

//formula for calculating BMI(bmi = weight/height*height)

public static double calculateBMI(double weight,double height) { return weight/ (height * height); }

//function for interpret BMI value

public static String interpretBMIvalue(double bmi) {
    if (bmi < 18.5) {
        return "underweight";
    } else if (bmi >= 18.5 && bmi <24.9) {
        return "healthy weight ";
    } else if (bmi >= 25 && bmi < 29.9) {
        return "over weight";
    } else {
        return "obesity";
        }    
    }
}
