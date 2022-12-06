/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.zadanie10.view;
import javax.swing.JOptionPane;
/**
 * View class that interact with user and visual data
 * @author NataliaMendera
 * @version 1.0
 */

public class View {
    /**
     * Method that let user write in data to program
     * @param question message to user
     * @return data written by user
     */
    public String inputData(String question){
        return JOptionPane.showInputDialog(null, question, "Number", JOptionPane.QUESTION_MESSAGE);
    }
    /**
     * Method that show a error message to user
     * @param message message to user
     */
    public void showError(String message){
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Method that shows to the user the greatest common divisor of given numbers
     * @param message  message to user
     */
    public void printResult(String message){
        JOptionPane.showMessageDialog(null, message, "The greatest common divisor", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
