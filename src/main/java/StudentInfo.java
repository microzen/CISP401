import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String school;
        String units;

        System.out.println("Enter your name: ");
        name = scanner.nextLine();
        System.out.println("Enter your school: ");
        school = scanner.nextLine();
        System.out.println("How many units are you taking?");
        units = scanner.nextLine();

        System.out.println();
        System.out.println("Name: "+name);
        System.out.println("School: "+school);
        System.out.println("Units: "+units);
    }
}
