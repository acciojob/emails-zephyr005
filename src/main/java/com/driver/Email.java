package com.driver;

import java.util.Arrays;
import java.util.HashSet;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(password)){
            int size = newPassword.length();
            boolean hasSize = false;
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean specialChar = false;

            if(size >= 8)
                hasSize = true;

            HashSet<Character> set = new HashSet<>(Arrays.asList('!','@','#','$','%','^','&','*','(',')','-',',','+'));

            for(char i : newPassword.toCharArray()){
                if(Character.isUpperCase(i))
                    hasUpper = true;

                if(Character.isLowerCase(i))
                    hasLower = true;

                if(Character.isDigit(i))
                    hasDigit = true;

                if(set.contains(i))
                    specialChar = true;

            }

            if(hasSize && hasUpper && hasLower && hasDigit && specialChar){
                this.password = newPassword;
            }
        }
    }
}
