/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pl.polsl.zadanie10;

import pl.polsl.zadanie10.controller.Controller;
import pl.polsl.zadanie10.model.InputException;

public class Zadanie10 {
    
    /**
     * Main function.When you want to run the program from the command line, you have to go to the folder where .jar file exists and write:
 java -jar NataliaMenderaZadanie10.jar firstArgument secondArgument
 If there is more or less number of arguments or wrong type of arguments, program will ask user to write new arguments.
 To close the program simply write arguments that equals "0".
     * The order of arguments doesn't count in the case of calculating greatest common divisor.
     * @param args arguments given in command line 
     * @throws pl.polsl.zadanie10.model.InputException 
     */
    public static void main(String[] args) throws InputException {
        Controller controller = new Controller();
        System.out.println(args.length);
        if(args.length == 2)
        {
            controller.acceptArguments(args);
        }
        else
        {
            controller.setVariables();
        }
        controller.showResults();
        do{
        controller.setVariables();
        controller.showResults();
        controller.showCalculatedData();
        }
        while(true);
    }
}
