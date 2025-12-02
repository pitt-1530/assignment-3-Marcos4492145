package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        //Reject bad cases
        if(bpms == null){
            return "ERROR! List cannot be NULL";
        }
        else if(bpms.size() == 0){
            return "ERROR! List cannot be empty";
        }
        //Calculate average
        int total = 0;
        for(int i = 0; i <= bpms.size(); i++){
            total += bpms.get(i);
        }
        int average = total/bpms.size();
        //Diffrentiate outcomes
        if(average >= 140){
            return "HIGH";
        }
        else if(average >= 100){
            return "MEDIUM";
        }
        else{
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        //reject bad cases
        if(title == null){
            return false;
        }
        else if(title.length() == 0){
            return false;
        }
        else if(title.length() > 30){
            return false;
        }
        //ensure the title only contains letters and spaces
        char[] charArray = title.toCharArray();
        for(int i = 0; i <= title.length(); i++){
            if(!Character.isLetter(charArray[i]) && (charArray[i] != ' ')){
                return false;
            }
        }
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        int clamp = volumeDb + 10;
        return clamp * 100 / 130;
    }
}
