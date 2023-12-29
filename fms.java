import java.util.ArrayList;
import java.util.Scanner;

class collegeStudent {

    // variable declaration
    private String studentregno;
    private String name;
    private double totalFees;
    private double paidfee;

    public collegeStudent(String studentID, String name, double totalFees) {
        this.studentregno = studentID;
        this.name = name;
        this.totalFees = totalFees;
        this.paidfee = 0;
    }

    //constructor
    public String getstudentregno() {
        return studentregno;
    }

    //constructor
    public String getName() {
        return name;
    }

    //constructor
    public double getTotalFees() {
        return totalFees;
    }

    //constructor
    public double getpaidfee() {
        return paidfee;
    }

    //method payment processing
    public void Paymentprocessing (double amount) {
        paidfee += amount;
    }

    //constructor
    public double getbalanceFees() {
        return totalFees - paidfee;
    }
}

class FeeManagementSystem {
    private ArrayList<collegeStudent> students = new ArrayList<>();

    //method for adding students
    public void addStudent(collegeStudent student) {
        students.add(student);
    }

    //method for recording payments
    public void recordPayment(String studentID, double amount) {
        for (collegeStudent student : students) {
            if (student.getstudentregno().equals(studentID)) {
                student.Paymentprocessing(amount);
                System.out.println("Payment recorded successfully.");
                return;
            }
        }
        System.out.println("Student not found with the given Register no.");
    }

    //method for viewing student profile
    public void Studentprofile(String studentID) {
        for (collegeStudent student : students) {
            if (student.getstudentregno().equals(studentID)) {
                System.out.println("Student Register no: " + student.getstudentregno());
                System.out.println("Name: " + student.getName());
                System.out.println("Pending Fee: Rs " + student.getTotalFees());
                System.out.println("Paid Fee: Rs " + student.getpaidfee());
                System.out.println("Balance Fee: Rs " + student.getbalanceFees());
                return;
            }
        }
        System.out.println("Student not found with the given Register no.");
    }
}

//main class
public class fms {
    //main method for calling all function
    public static void main(String[] args) {

        //object creation
        FeeManagementSystem feeSystem = new FeeManagementSystem();
        collegeStudent student1 = new collegeStudent("22303091", "Ramesh", 12800.0);
        collegeStudent student2 = new collegeStudent("22303092", "Chaitanya", 25600.0);
        collegeStudent student3 = new collegeStudent("22303093", "Koushik", 15800.0);
        collegeStudent student4 = new collegeStudent("22303094", "Surendra", 20300.0);
        feeSystem.addStudent(student1);
        feeSystem.addStudent(student2);
        feeSystem.addStudent(student3);
        feeSystem.addStudent(student4);

        // scanner implementation
        Scanner scanner = new Scanner(System.in);
        //variable declaration
        int choice;

        //do while & switch case used for selecting choice
        do {
            System.out.println("\n    College Fees Management System    ");
            System.out.println("------------------------------------------");
            System.out.println("1. Payment Record's");
            System.out.println("2. Student Profile");
            System.out.println("3. Stop Program");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Register no: ");
                    String studentID = scanner.next();
                    System.out.print("Enter Payment Amount: Rs ");
                    double amount = scanner.nextDouble();
                    feeSystem.recordPayment(studentID, amount);
                    System.out.println("------------------------------------------");
                    break;
                case 2:
                    System.out.print("Enter Register no: ");
                    studentID = scanner.next();
                    feeSystem.Studentprofile(studentID);
                    System.out.println("------------------------------------------");
                    break;
                case 3:
                    System.out.println("Stoping the program.");
                    System.out.println("------------------------------------------");
                    break;
                default:
                    System.out.println("SomeThing Went Wrong.");
                    System.out.println("------------------------------------------");
            }


        }

        // stoping the program
        while (choice != 3);
        scanner.close();

        System.out.println("------------------------------------------");
    }
}