package ca.durhamcollege;

import java.time.LocalDate;

public class WorkTicket
{
    // PRIVATE INSTANCE VARIABLES

    private int workTicketNumber;
    private String clientID;
    private LocalDate workTicketDate;
    private String issueDescription;

    // PUBLIC PROPERTIES (MUTATORS AND ACCESSORS)

    public int getWorkTicketNumber()
    {
        return workTicketNumber;
    }

    public void setWorkTicketNumber(int workTicketNumber) throws IllegalArgumentException
    {
        if(workTicketNumber <= 0)
            throw new IllegalArgumentException("ERROR: Work ticket number must be a whole number greater than 0");
        this.workTicketNumber = workTicketNumber;
    }

    public String getClientID()
    {
        return clientID;
    }

    public void setClientID(String clientID)
    {
        this.clientID = clientID;
    }

    public LocalDate getWorkTicketDate()
    {
        return workTicketDate;
    }

    public void setWorkTicketDate(LocalDate workTicketDate) throws IllegalArgumentException
    {
        int ticketYear = workTicketDate.getYear();
        if (ticketYear < 2000 || ticketYear > 2099)
            throw new IllegalArgumentException("ERROR: The work ticket date must be between the years 2000 and 2099");
        this.workTicketDate = workTicketDate;
    }

    public String getIssueDescription()
    {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription)
    {
        this.issueDescription = issueDescription;
    }

    // sets all attributes of an object to the following parameters, if successful return true, if not return false
    public boolean SetWorkTicket(int ticketNumber, String id, LocalDate date, String description)
    {
        try
        {
            // see if any exceptions arise in a dummy ticket
            WorkTicket dummyTicket = new WorkTicket(ticketNumber, id, date, description);

            // client number and description must not be empty or simply whitespace
            if ((id.isBlank()) || (description.isBlank()))
            {
                return false;
            }
            // no exceptions, can mutate the existing ticket now
            setWorkTicketNumber(ticketNumber);
            setClientID(id);
            setWorkTicketDate(date);
            setIssueDescription(description);
        }
        catch (IllegalArgumentException illegalArgumentEx)
        {
            return false;
        }
        return true;
    }

    // CONSTRUCTORS

    WorkTicket()
    {
        workTicketNumber = 0;
        clientID = null;
        workTicketDate = null;
        issueDescription = null;
    }

    WorkTicket(int ticketNumber, String id, LocalDate date, String description)
    {
        setWorkTicketNumber(ticketNumber);
        clientID = id;
        setWorkTicketDate(date);
        issueDescription = description;
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

        return output;
    }
}
