package homework.own_exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter your Name ");
            String Name = input.nextLine().toLowerCase();
            System.out.println("Enter you password");
            String password = input.nextLine().toLowerCase();

            if (Name == null || Name.isEmpty() || password == null || password.isEmpty()) {
                throw new EmptyInputException("Name or password are empty");
            }

            if (password.length() < 6){
                throw new ShortPasswordException("Password less thant 6 symbols");
            }

            if (Name.equals("admin") && password.equals("password")){
                throw new InvalidCredentialsException("Invalid credentials");
            }
            System.out.println("You successfully enter to the system");
        }
        catch (EmptyInputException | InvalidCredentialsException | ShortPasswordException exception) {
            System.err.println("Something went wrong " + exception.getMessage());
        }
    }
}