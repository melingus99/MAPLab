package View;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Repository.MyRepo;
import Controller.controller;
import Abstract.Command;
import Exception.MyException;
public class View {
    private Map<String, Command> commands;
    public View(){ commands=new HashMap<>(); }
    public void addCommand(Command c){ commands.put(c.getKey(),c);}
    private void printMenu(){
        for(Command com : commands.values()){
                String line=String.format("%4s : %s", com.getKey(), com.getDescription());
                System.out.println(line);
        }
    }
    public void show() throws MyException {
        Scanner scanner=new Scanner(System.in);
        while(true){
            printMenu();
            System.out.printf("Input the option: ");
            String key=scanner.nextLine();
            Command com=commands.get(key);
            if (com==null){
                System.out.println("Invalid Option");
                continue; }
            com.execute();
        }
    }


}
