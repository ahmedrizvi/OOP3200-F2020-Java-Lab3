/*
 * File Name     : OOP3200-F2020-Java-Lab3
 * Student Names : Ahmed Rizvi[100698429], Jordan Wriker[100445715]
 * Date          : 2020-12-06
 */

package ca.durhamcollege;

import java.time.LocalDate;

public class ExtendedWorkTicket extends WorkTicket
{
    // PRIVATE INSTANCE VARIABLES
    boolean myOpen;

    // CONSTRUCTORS
    ExtendedWorkTicket()
    {
        super();
        this.myOpen = true;
    }

    ExtendedWorkTicket(int ticketNumber, String id, LocalDate date, String description, boolean status)
    {
        setWorkTicketNumber(ticketNumber);
        setClientID(id);
        setWorkTicketDate(date);
        setIssueDescription(description);
        myOpen = status;
    }

    ExtendedWorkTicket(WorkTicket ticket, boolean status)
    {
        setWorkTicketNumber(ticket.getWorkTicketNumber());
        setClientID(ticket.getClientID());
        setWorkTicketDate(ticket.getWorkTicketDate());
        setIssueDescription(ticket.getIssueDescription());
        myOpen = status;
    }

    // MUTATORS
    public boolean isOpen()
    {
        return myOpen;
    }

    public void openTicket()
    {
        this.myOpen = true;
    }

    public void closeTicket()
    {
        this.myOpen = false;
    }

    public boolean SetWorkTicket(int ticketNumber, String id, LocalDate date, String description, boolean status)
    {
        if(super.SetWorkTicket(ticketNumber, id, date, description))
        {
            this.myOpen = status;
            return true;
        }
        else
        {
            return false;
        }

    }

    // PUBLIC METHODS
    @Override
    public String toString()
    {
        String output = "";

        output = ("Ticket Number: " + this.getWorkTicketNumber());
        output += ("\n----------------------");
        output += ("\nClient ID: " + this.getClientID());
        output += ("\nTicket Date: " + this.getWorkTicketDate());
        output += ("\nIssue Description: " + this.getIssueDescription() + "\n");

        if(this.isOpen())
        {
            output += ("Ticket: OPEN");
        }
        else
        {
            output += ("Ticket: CLOSED");
        }

        return output;
    }
}
