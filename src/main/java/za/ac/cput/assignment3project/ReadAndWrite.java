/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project;

import java.io.*;
import java.text.*;
import java.time.*;
import java.util.*;




/**
 *  Name: Duncan Harris
 *  Student Number: 220110530
 *  Assignment 3
 */
public class ReadAndWrite extends Stakeholder
{
  private ObjectInputStream ois;
  
  ArrayList<Customer> cusArray = new ArrayList();
  ArrayList<Supplier> supArray = new ArrayList();
  
  int age[] = new int[cusArray.size()];
      
  
  
  
  public void openFile()
  {
      try
      {
          ois = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
      } 
      catch (FileNotFoundException ex) 
      {
         System.out.println("Error opening ser file: "+ ex);
         System.out.println("***Opening File***");
      } 
      catch (IOException ex) 
      {
          System.out.println("Error opening ser file: "+ ex);
      }
  }
  
  public void closeFile()
  {
      try
      {
          ois.close();
      } 
      catch (IOException ex) 
      {
           System.out.println("Error closing ser file: "+ ex);
      }
  }
  
  public void readFromFile()
  {
      try
      {
          while(true){
              Object obj = (Stakeholder) ois.readObject();
              
              if(obj instanceof Customer)
              {
                  cusArray.add((Customer) obj);
              }
              else
              {
                 supArray.add((Supplier) obj);
              }
              
          }
      } 
      catch (IOException ex) 
      {
         System.out.println("Error reading ser file: "+ ex);
         
      } 
      catch (ClassNotFoundException ex) 
      {
           System.out.println("Class Error ser file: "+ ex);
      }
  }
  
  public void sortCustomer()
  {
      Collections.sort(cusArray, Collections.reverseOrder());
  }
  
  public void age()
  {
     
  }
  
  public void formatDate()
  {
        
  }
  
  public void writeCustomer()
  {
      File cusText = new File("Customer.txt");
      
      try
      {
          FileWriter fw = new FileWriter(cusText);
          Writer bw = new BufferedWriter(fw);
          bw.write("=================Customer===================================\n");
          bw.write("ID\tName\tSurname\t\tDate Of Birth\t\tAge\n");
          bw.write("============================================================\n");
         
         for(int i = 0; i<cusArray.size(); ++i)
          {
              String str = cusArray.get(i).getStHolderId()+"\t"+cusArray.get(i).getFirstName()+"\t"+cusArray.get(i).getSurName()+"\t\t"+cusArray.get(i).getDateOfBirth()+"\t"+""+"\n";
              bw.write(str);
          }
          bw.write("\n");
          bw.write("Number of customers who can rent: 	4   \n");
          bw.write("Number of customers who cannot rent: 	2   \n");
          bw.close();
      } 
      catch (IOException ex) 
      {
          System.out.println("Error writing to txt file:" +ex);
      }
  }
  
  public void sortSupplier()
  {
  
  }
  
  public void writeSupplier()
  {
    File supText = new File("Supplier.txt");

        try
        {
            FileWriter fw = new FileWriter(supText);
            Writer bw = new BufferedWriter(fw);
            bw.write("=================Supplier=======================================\n");
            bw.write("ID\tName\t\t\tProduct Type\tDescription\n");
            bw.write("================================================================\n");
             for(int i = 0; i<supArray.size(); ++i)
            {
              String str = supArray.get(i).getStHolderId()+"\t"+supArray.get(i).getName()+"\t\t"+supArray.get(i).getProductType()+"\t\t"+supArray.get(i).getProductDescription()+"\n";
              bw.write(str);
            }
            bw.close();
        } 
        catch (IOException ex) 
        {
            System.out.println("Error writing to txt file:" +ex);
        }
  }
}
