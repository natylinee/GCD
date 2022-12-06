/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.zadanie10.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


/**
 * Model class, which contain given numbers, algorithm to calculate the greatest common divisor and result of it
 * @author NataliaMendera
 * @version 2.0
 */

public class Model implements NumericTest {
    /**
     * Non-parametrer constructor of class Model
     */
    public Model()
    {
        //result="";
    }
    /**
     * first given number
     */
    private int number1; 
    /**
     * second given number
     */
    private int number2; 
    
    /**
     * the greatest common divisor in int format
     */
    private int result;
    /**
     * List that cointains a model objects
     */
    private List<Model> dataResults = new ArrayList<>();
    /**
     * Model constructor that takes 3 parameters
     * @param num1
     * @param num2
     * @param resultCal 
     */
    private Model(int num1, int num2, int resultCal) {
        this.number1=num1;
        this.number2=num2;
        this.result=resultCal;
    }
    /**
     * Method that override method toString() in ordert to display object of the class Model
     * @return 
     */
    @Override
    public String toString() {
    return number1 + " " + number2 + " " + result;
  }
    /**
     * Get value of first given number
     * @return number1 first given number
     */ 
    public int getNumber1()
    {
    return number1;
    }
    /**
     * Get value of second given number
     * @return number2 second given number
     */
    
    public int getNumber2()
    {
    return number2;
    }
    
    /**
     * Get value of result
     * @return result the greatest common divisor
     */
    
    public int getResult()
    {
    return result;
    }
    
    /**
     * Set value
     * @param number1 first given number
     */ 
    
    public void setNumber1(int number1)
    {
            this.number1=number1;
    }
    /**
     * Set value
     * @param number2 second given number
     */
    
    public void setNumber2(int number2)
    {
        this.number2=number2;
    }
    
    /**
     * Set value
     * @param result the greatest common divisor
     */
    
    public void setResult(int result)
    {
        this.result=result;
    }
    
    /**
     * Method that checks if first given number is correct
     * @param number1 argument first number
     * @return true if number is correct and false if number is not correct
     * @throws InputException if given number is null or number is empty
     */
    public boolean checkFirstArgumentNumber(String number1) throws InputException{
       if(number1 == null){
           throw new InputException("String is a Null");
        }
       if(number1.length() == 0){
           throw new InputException("String is empty");
        }
       if(number1.matches("[\\d]*")){
            int temp = Integer.parseInt(number1);
            this.setNumber1(temp);
            return true;
        }
       else{
            return false;
        } 
    }
    
    /**
     * Method that checks if second given number is correct
     * @param number2 argument first number
     * @return true if number is correct and false if number is not correct
     * @throws InputException if given number is null or number is empty 
     */
    public boolean checkSecondArgumentNumber(String number2) throws InputException{
       if(number2 == null){
           throw new InputException("String is a Null");
        }
       if(number2.length() == 0){
           throw new InputException("String is empty");
        }
       if(number2.matches("[\\d]*")){
            int temp = Integer.parseInt(number2);
            this.setNumber2(temp);
            return true;    
        }
       else{
            return false;
        } 
    }
    
    /**
     * Method that calculate value of the greatest common divisor and return it
     * @param number1 fist given number
     * @param number2 second given number
     * @return the greatest common divisor
     * @throws pl.polsl.zadanie10.model.InputException
     */
    
    public int calculateResult(int number1, int number2) throws InputException
    {
        int num1 = number1;
        int num2 = number2;
        int resultCal;
        NumericTest isEven = (n) -> n==0;
        if(number1 ==0 & number2 == 0)
        {
        throw new InputException("You can not divide by zero");
        }
        while(number1 != number2)
    {
        if(number1 > number2)
        {
            number1 = number1 - number2;
        }
        else
        {
            number2 = number2 - number1;
        }
    }
        this.setResult(number1);
        resultCal=number1;
        //add num1,num2,result to the list
        Model model = new Model(num1, num2, resultCal);
        dataResults.add(model);
        return number1;
    }
    /**
     * Method change type of variable 'result' from int to String
     * @return result
     */
    public String getStringResult()
    {
        result = getResult();
        String s=String.valueOf(result);
        return s;
    }
    /**
     * Get value of dataResults
     * @return dataResults
     */
    public List<Model> getDataResults()
    {
    return dataResults;
    }
    
    //STREAM
    //console version, GUI will be added later
    /**
     * Method that shows all values that were already calculated and the result in the console,
     * later it will be transformed to GUI version
     */
    public void showCalculatedData()
    {
        Stream<Model> calculatedDataStream = dataResults.stream();
        
        Stream<String> changeToStringCalculatedData = calculatedDataStream
                .map(e -> e.toString());
        changeToStringCalculatedData.forEach(s -> System.out.println(s));
    
    }

    @Override
    public boolean test(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
