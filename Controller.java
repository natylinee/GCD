/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.zadanie10.controller;

import java.util.List;
import pl.polsl.zadanie10.model.Model;
import pl.polsl.zadanie10.view.View;
import pl.polsl.zadanie10.model.InputException;

/**
 * Controller class that controls data flow and user interaction
 * @author NataliaMendera
 * @version 2.0
 */

public class Controller {
    /**
     * An object of a class that update a data
     */
    private final Model model;
    /**
     * An object of a class that interact with user
     */
    private final View view;
    
    
    /**
     * Class constructor without parameters
     */
    public Controller()
    {
        this.model = new Model();
        this.view = new View();
    }
 
    /**
     * Set value
     * @param number1 first given number
     */
    
    public void setModelNumber1(int number1){
        model.setNumber1(number1);
    }
    /**
     * Set value
     * @param number2 second given number
     */
    
    public void setModelNumber2(int number2){
        model.setNumber2(number2);
    }
    /**
     * Set value
     * @param result the greatest common divisor
     */
    
    public void setModelResult(int result){
        model.setResult(result);
    }
    
    /**
     * Get value
     * @return number1 first given number
     */
    
    public int getModelNumber1(){
        return model.getNumber1();
    }
    /**
     * Get value
     * @return number2 second given number
     */
    
    public int getModelNumber2(){
        return model.getNumber2();
    }
    /**
     * Get result
     * @param number1 second given number
     * @param number2 second given number
     * @return result the greatest common divisor
     * @throws pl.polsl.zadanie10.model.InputException
     */
    
    public int getModelResult(int number1, int number2) throws InputException{
        return model.calculateResult(number1, number2);
    }
    
//    public String getStringModelResult(int number1, int number2){
//        int result = model.calculateResult(number1, number2);
//        String resultString = model.getStringResult();
//        return resultString;
//    }
    /**
     * Method that let user set numbers to calculate their greatest common divisor
     */
    public void setVariables() {
    boolean isChecked = false;
        while(!isChecked){
            try{
                String number1 = view.inputData("Enter first number: ");        
                if(model.checkFirstArgumentNumber(number1)){
                    isChecked=true;
                }
                else{
                    view.showError("Wrong Number");
                }
            }
            catch(InputException e){
               view.showError(e.toString());
            } 
        }
        isChecked = false;
        while(!isChecked){
            try{
                String number2 = view.inputData("Enter second number: ");        
                if(model.checkSecondArgumentNumber(number2)){
                    isChecked=true;
                }
                else{
                    view.showError("Wrong Number");
                }
            }
            catch(InputException e){
               view.showError(e.toString());
            }
        }
    }
    /**
     * Method that check if user has given proper predifined arguments in the command line, if not
     * user has to input new arguments
     * @param args data given from the command line
     */
    public void acceptArguments(String[] args){    
        if(!(args[0].matches("[\\d]*")&&args[1].matches("[\\d]*"))){
           view.showError("Wrong arguments");
           this.setVariables();
        }
        else{
            this.setModelNumber1(Integer.parseInt(args[0]));  
            this.setModelNumber2(Integer.parseInt(args[1]));
        }
    }
    /**
     * Method shows results of calculation
     * @throws pl.polsl.zadanie10.model.InputException
     */
    public void showResults() throws InputException {
        int number1 = model.getNumber1();
        int number2 = model.getNumber2();
        int result;
        //Map<Model, Integer> dataResults = model.getDataResults();
        List<Model> dataResults =model.getDataResults();
        //if the result for that numbers was already calculated look for it in the list,
        //otherwise execute method calculateResult()
        if(dataResults.size()>= 1)
        {
            boolean resultIsFinded =false;
        for(Model modelVar: dataResults)
        {
            int num1Temp= modelVar.getNumber1();
            int num2Temp=modelVar.getNumber2();
            
            if((number1==num1Temp && number2==num2Temp)
                    || (number1 == num2Temp && number2==num1Temp))
            {
                result = modelVar.getResult();
                resultIsFinded =true;
                break;
            }
//            else{
//                result = model.calculateResult(number1, number2);
//                break;
//            }
        }
        if(resultIsFinded==false)
        {
            result = model.calculateResult(number1, number2);
        }
        }
        else
        {
        result = model.calculateResult(number1, number2);
        }
       //int result = model.calculateResult(number1, number2);
        String resultString = model.getStringResult();
        //func printResult(String) calculateResult-> add to a List 
        //get converted result to String
        view.printResult(resultString);
        //view.printResult(model.calculateResult(number1, number2));
    }
    /**
     * Method that print calculatedData in the console
     */
    public void showCalculatedData()
    {
        model.showCalculatedData();
    }
    
    };

