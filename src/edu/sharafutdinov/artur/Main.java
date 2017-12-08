package edu.sharafutdinov.artur;

public class Main {

    public static void main(String[] args) {
        ResourceReader resourceReader = new ResourceReader();

       Thread thread = new Thread(new Runnable() {
           @Override
           public void run() {

               resourceReader.readString("user1 -> sdfdfd@mail.ru, dfdvfdvf@mail.ru, ghj@mail.ru user2 -> sdfdfd@mail.ru, dfdvhdvf@mail.ru, ggj@mail.ru user3 -> dff@mail.ru");
               resourceReader.ask();
           }
       });
       thread.start();
    }
}
