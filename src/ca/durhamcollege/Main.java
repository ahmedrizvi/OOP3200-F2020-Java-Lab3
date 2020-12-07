/*
 * File Name     : OOP3200-F2020-Java-Lab3
 * Student Names : Ahmed Rizvi[100698429], Jordan Wriker[100445715]
 * Date          : 2020-12-06
 */
package ca.durhamcollege;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // work ticket that uses default constructor
        WorkTicket defaultTicket = new WorkTicket();
        System.out.println(defaultTicket.toString());

        // work ticket that uses parameterized constructor (NO PARAMETER ERROR)
        WorkTicket testTicket1 = new WorkTicket(1, "TT01", LocalDate.now(), "There should be no errors with this ticket.");
        System.out.println(testTicket1.toString());

        // work ticket with incorrect ticket number (ERROR HERE)
        try
        {
            WorkTicket testTicket2 = new WorkTicket(-5, "TT02", LocalDate.now(), "Incorrect ticket number.");
        }
        catch (IllegalArgumentException illegalArgumentException)
        {
            System.out.println(illegalArgumentException.toString());
        }

        // work ticket with incorrect date (ERROR HERE)
        try
        {
            WorkTicket testTicket3 = new WorkTicket(3, "TT02", LocalDate.of(1999,10,10), "incorrect date");
        }
        catch (IllegalArgumentException illegalArgumentException)
        {
            System.out.println(illegalArgumentException.toString());
        }

        // mutating a work ticket correctly
        testTicket1.SetWorkTicket(1, "TT01", LocalDate.of(2000,1,6), "This ticket was successfully revised");
        System.out.println("\n" + testTicket1.toString());

        // mutating a work ticket incorrectly
        boolean ticketHasChanged;
        ticketHasChanged = testTicket1.SetWorkTicket(-1, "TT01", LocalDate.of(1997,1,6), "");
        if (ticketHasChanged)
        {
            System.out.println("The ticket was successfully altered.");
            ticketHasChanged = false;
        }
        else
            System.out.println("The ticket could not be altered.");
        System.out.println("\n" + testTicket1.toString());

        // mutating a work ticket to an empty description (not possible)
        ticketHasChanged = testTicket1.SetWorkTicket(1, "TT01", LocalDate.now(), "");
        if (ticketHasChanged)
        {
            System.out.println("The ticket was successfully altered.");
            ticketHasChanged = false;
        }
        else
            System.out.println("The ticket could not be altered.");
        System.out.println("\n" + testTicket1.toString());

        // Creates three extended work tickets using the three different constructors
        ExtendedWorkTicket extTicket1 = new ExtendedWorkTicket();
        ExtendedWorkTicket extTicket2 = new ExtendedWorkTicket(4, "TT03", LocalDate.now(), "extended test 2", false);
        ExtendedWorkTicket extTicket3 = new ExtendedWorkTicket(testTicket1, false);

        // Displays the three extended work tickets using the toString that was overridden
        System.out.println("\n" + extTicket1.toString());
        System.out.println("\n" + extTicket2.toString());
        System.out.println("\n" + extTicket3.toString());

        // Demos SetWorkTicket and openTicket methods
        extTicket1.SetWorkTicket(5, "TT05", LocalDate.now(),"extended test 4", true);
        extTicket3.openTicket();
        System.out.println("\n" + extTicket1.toString());
        System.out.println("\n" + extTicket3.toString());

        // Demos close ticket method
        extTicket1.closeTicket();
        System.out.println("\n" + extTicket1.toString());
    }
}
