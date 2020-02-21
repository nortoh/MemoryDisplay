/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorydisplay;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Christian
 */
public class MemoryDisplay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter a value in hex.");
        do {
            System.out.print("> ");
            String input = s.nextLine();
            String output = new BigInteger(input, 16).toString(2);
            
            if(output.length() < 32) {
                int add = 32 - output.length();
                System.out.println("Adding " + add + " zeros");
                String appendZeros = "";
                for(int i = 0; i < add; i ++) {
                    appendZeros += "0";
                }
                output = appendZeros + output;
            }
            /**
             * 000000 00101 00100 00101 00000100000
             */
            System.out.println("Result: " + output);
            
            System.out.println("[31:26] " + output.substring(0, 6) + " V:" + Integer.parseInt(output.substring(0, 6), 2));
            System.out.println("[25:21] " + output.substring(6, 11) + " V:" + Integer.parseInt(output.substring(6, 11), 2));
            System.out.println("[20:16] " + output.substring(11, 16) + " V:" + Integer.parseInt(output.substring(11, 16), 2));
            System.out.println("[15:11] " + output.substring(16, 21) + " V:" + Integer.parseInt(output.substring(16, 21), 2));
            System.out.println("[15:0] " + output.substring(16, 32) + " V:" + Integer.parseInt(output.substring(16, 32), 2));
            System.out.println("[5:0 (funcCode)] " + output.substring(26, 32));            
        } while (true);
    }

}