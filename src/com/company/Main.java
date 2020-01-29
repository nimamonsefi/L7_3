package com.company;

import com.company.entity.CarpetEnt;
import com.company.service.CarpetServ;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choose;
        String color,color2;
        int year,year2;
        long number,number2,number3;
        System.out.println("\t\tCarpet Office");
        System.out.println("\n1.InsertCarpet\n2.UpdateCarpet\n3.DeleteCarpet\n4.ShowCarpets");
        choose = input.nextInt();
        switch (choose){

            case 1:{
                try {
                    System.out.println("__________________________\nINSERTING");
                    System.out.print("Number:");
                    number = input.nextLong();
                    System.out.print("Year:");
                    year = input.nextInt();
                    System.out.print("Color:");
                    color = input.next();
                    CarpetServ.getInstance().save(new CarpetEnt().setNum(number).setYear(year).setColor(color));
                    System.out.println("\n\tSaved Successfully");
                } catch (Exception e) {
                    System.out.println("Fail to save!"+e.getMessage());
                }
                break;
            }

            case 2:{
                try {
                    System.out.println("__________________________\nUPDATING");
                    System.out.print("Number(previous one):");
                    number2 = input.nextLong();
                    System.out.print("Year:");
                    year2 = input.nextInt();
                    System.out.print("Color:");
                    color2 = input.next();
                    CarpetServ.getInstance().edit(new CarpetEnt().setNum(number2).setYear(year2).setColor(color2));
                    System.out.println("\n\tEdited Successfully");
                } catch (Exception e) {
                    System.out.println("Fail to edit!"+e.getMessage());
                }
                break;
            }

            case 3:{
                try {
                    System.out.println("__________________________\nDELETING");
                    System.out.print("Number:");
                    number3 = input.nextLong();
                    CarpetServ.getInstance().remove(number3);
                    System.out.println("\n\tDeleted Successfully");
                } catch (Exception e) {
                    System.out.println("Fail to delete!"+e.getMessage());
                }
                break;
            }

            case 4:{
                try {
                    System.out.println("__________________________\nCarpetsInformation");
                    List<CarpetEnt> carpetList = CarpetServ.getInstance().report();
                    for(CarpetEnt carpetEnt : carpetList){
                        System.out.println(carpetEnt.getNum());
                        System.out.println(carpetEnt.getYear());
                        System.out.println(carpetEnt.getColor());
                    }
                } catch (Exception e) {
                    System.out.println("Fail to Show!"+e.getMessage());
                }
                break;
            }
        }
    }
}