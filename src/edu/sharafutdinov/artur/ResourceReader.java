package edu.sharafutdinov.artur;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ResourceReader {
    final UserAndMailUnique userAndMailUnique = new UserAndMailUnique();
    private String user;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }




    public List<String> readResources(String  fileName) throws IOException{
       return Files.readAllLines(Paths.get(fileName));
    }

    public void readString(String str) throws NullPointerException {
        Scanner scanner = new Scanner(str);

        while (scanner.hasNext()) {
            String userAndEmails = scanner.next();
            if(!userAndEmails.contains("@") && !userAndEmails.contains("->")){
                user = userAndEmails;
            }
            else if (!userAndEmails.contains("->"))
                setEmail(userAndEmails.replaceAll("^\\[|\\]$", "")
                        .replaceAll(",|\\d|!|\\?", ""));
            if(getEmail() != null){
                userAndMailUnique.getMapUniques(getUser(), getEmail());
            }


        }

    }
    public void ask() {
        userAndMailUnique.printUserUnique();
    }

}
