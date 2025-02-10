package org.example.gameplay;

import java.util.*;
import java.util.regex.Pattern;

public class InputManager {

    private final Scanner scanner = new Scanner(System.in);

    private static final InputManager inputManager = new InputManager();

    private InputManager() {
    }

    ;

    public Integer inputLoopForInteger() {
        String userInput;
        while (true) {
            userInput = scanner.nextLine();
            if (isUserInputParsable(userInput)) {
                System.out.print(userInput + ": ");
                return Integer.parseInt(userInput);
            } else {
                System.out.print(userInput + ": ");
                System.out.println("please insert a valid number ");
            }
        }
    }

    public static InputManager getInstance() {
        return Objects.requireNonNullElseGet(inputManager, InputManager::new);
    }

    public Boolean isUserInputParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String userInputString() {
        String input = this.scanner.nextLine();
        System.out.print(input + ": ");
        return input;
    }

    public String userInputWithNoNums() {
        String input;
        while (true) {
            input = scanner.nextLine();
            if (isUserInputAReadableString(input)) {
                System.out.print(input + ": ") ;
                return input;
            } else {
                System.out.print( input + ": ");
                System.out.println("please insert a valid name");
            }
        }
    }

    private boolean isUserInputAReadableString(String input) {
        return Pattern.compile("[^0-9]").matcher(input).find();
    }


}
