/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project;



/**
 *  Name: Duncan Harris
 *  Student Number: 220110530
 *  Assignment 3
 */
public class RunFiles
{
    
    public static void main(String[] args)
    {
        
        ReadAndWrite obj = new ReadAndWrite();
        obj.openFile();
        obj.readFromFile();
        obj.closeFile();
        obj.writeCustomer();
        obj.writeSupplier();
    }
}
