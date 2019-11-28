package Abstract;

import Controller.controller;
import Exception.MyException;
public class RunExample extends Command {
    private controller ctr;
    public RunExample(String key, String desc,controller ctr){
        super(key, desc);
        this.ctr=ctr;
    }
    @Override
    public void execute() throws MyException{
        try{
            ctr.allStep(); }
        catch (Exception exp) {throw new MyException("exception");} //here you must treat the exceptions that can not be solved in the controller
    }
}