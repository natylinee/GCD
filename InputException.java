/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.zadanie10.model;

/**
 *The NumberFormatException occurs when an attempt is made to convert a string with
 * improper format into a numeric value
 * @author Natalia
 */
public class InputException extends Exception {
    /**
     * 
     * @param message information about exception
     */
    InputException(String message) {
    super(message);
    }
}
