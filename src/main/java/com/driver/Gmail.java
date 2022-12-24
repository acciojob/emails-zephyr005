package com.driver;

import java.util.ArrayList;
import java.util.Date;



public class Gmail extends Email {

    int inboxCapacity;
    ArrayList<Date> inbox1;
    ArrayList<String> inbox2;
    ArrayList<Date> trash;

    //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
        this.inbox1=new ArrayList<Date>();
        inbox2=new ArrayList<String>();
        trash=new ArrayList<Date>();
    }

    public void receiveMail(Date date, String sender, String message){
        inbox1.add(date);
        inbox2.add(message);
        if(inbox1.size()>inboxCapacity) {
            trash.add(inbox1.get(0));
            //System.out.println((inbox2.get(0)));
            inbox1.remove(0);
            inbox2.remove(0);
        }

        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        if(inbox2.contains(message)){
            int pos=inbox2.indexOf(message);
            trash.add(inbox1.get(pos));
            inbox1.remove(pos);
            inbox2.remove(pos);
        }
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){
        if(inbox2.size()!=0)
            return inbox2.get(inbox2.size()-1);

        return null;
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        if(inbox2.size()!=0)
            return inbox2.get(0);

        return null;
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

    }

    public int findMailsBetweenDates(Date start, Date end){
        int x=0;
        for(Date d:inbox1){
            if(start.compareTo(d)<=0 && end.compareTo(d)>=0)
                x++;
        }
        return x;
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        return inbox1.size();
        // Return number of mails in inbox

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();

    }

    public void emptyTrash(){
        trash.clear();
        // clear all mails in the trash

    }

    public int getInboxCapacity() {
        return inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
}