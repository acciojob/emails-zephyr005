package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        this.calendar=new ArrayList<>();


        // The inboxCapacity is equal to the maximum value an integer can store.
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        Collections.sort(calendar, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if((o1.getStartTime()).compareTo(o2.getStartTime())!=0)
                    return  (o1.getStartTime()).compareTo(o2.getStartTime());

                return  (o2.getEndTime()).compareTo(o1.getEndTime());
            }
        });

        int x=0;
        int ans=0;
        Meeting m=calendar.get(0);
        for(int i=1;i<calendar.size();i++){
            if((calendar.get(i)).getStartTime().compareTo(m.getEndTime())>0){
                x++;
                m=calendar.get(i);
            }
            ans=Math.max(ans,x);
            m=calendar.get(i);
        }

        return ans;
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

    }
}