package Main;

import Abstract.ExitCommand;
import Abstract.RunExample;
import Controller.controller;
import Model.Expressions.*;
import Model.Expressions.WriteHeapStmt;
import Model.Stack_and_others.*;
import Model.Stmt.*;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Type.RefType;
import Model.Type.StringType;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.StringValue;
import Model.Value.Value;
import Repository.MyRepo;

import java.io.BufferedReader;
import java.util.Scanner;
import View.View;
public class Main {

    public static void main(String args[]) throws Exception {
        System.out.print("choose between example 1,example2 and example 3\n");
        System.out.print("ex1: int v; v=2;Print(v)\n");
        System.out.print("ex2:int a;int b; a=2+3*5;b=a+1;Print(b)\n");
        System.out.print("ex3:bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v)\n");
        IStmt ex1= new CompStmt(new VarDeclStmt("v",new IntType()),
                new CompStmt(new AssignStmt("v",new ValueExp(new IntValue(2))), new PrintStmt(new
                        VarExp("v"))));
        MyIStack<IStmt> stk1= new
                MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl1=new MyDictionary<String, Value>();
        MyIList<Value> out1=new MyList<Value>();
        MyIFileTable<String, BufferedReader> FT1=new MyFileTable<String,BufferedReader>();
        MyIHeap<Integer,Value> H1=new MyHeap<Integer,Value>();
        PrgState state1=new PrgState(stk1,symtbl1,out1,FT1,H1,ex1);
        controller ctrl1=new controller(new MyRepo(state1,"C:\\Users\\Bubu\\IdeaProjects\\lab2\\src\\test1.txt"));


        IStmt ex2 = new CompStmt( new VarDeclStmt("a",new IntType()),
                new CompStmt(new VarDeclStmt("b",new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp("+",new ValueExp(new IntValue(2)),new
                                ArithExp("*",new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                                new CompStmt(new AssignStmt("b",new ArithExp("+",new VarExp("a"), new
                                        ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));
        MyIStack<IStmt> stk2= new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl2=new MyDictionary<String, Value>();
        MyIList<Value> out2=new MyList<Value>();
        MyIFileTable<String, BufferedReader> FT2=new MyFileTable<String,BufferedReader>();
        MyIHeap<Integer,Value> H2=new MyHeap<Integer,Value>();
        PrgState state2= new PrgState(stk2,symtbl2,out2,FT2,H2,ex2);
        controller ctrl2=new controller(new MyRepo(state2,"C:\\Users\\Bubu\\IdeaProjects\\lab2\\src\\test2.txt"));


        IStmt ex3 = new CompStmt(new VarDeclStmt("a",new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new
                                        IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new
                                        VarExp("v"))))));
        MyIStack<IStmt> stk3= new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl3=new MyDictionary<String, Value>();
        MyIList<Value> out3=new MyList<Value>();
        MyIFileTable<String, BufferedReader> FT3=new MyFileTable<String,BufferedReader>();
        MyIHeap<Integer,Value> H3=new MyHeap<Integer,Value>();
        PrgState state3=new PrgState(stk3,symtbl3,out3,FT3,H3,ex3);
        controller ctrl3=new controller(new MyRepo(state1,"C:\\Users\\Bubu\\IdeaProjects\\lab2\\src\\test3.txt"));

        IStmt ex4= new CompStmt(new VarDeclStmt("varf",new StringType()),
                new CompStmt(new AssignStmt("varf",new ValueExp(new StringValue("C:\\Users\\Bubu\\IdeaProjects\\lab2\\src\\test.txt"))),
                    new CompStmt(new openRFile(new VarExp("varf")),
                            new CompStmt(new VarDeclStmt("varc",new IntType()),
                                    new CompStmt(new readFile(new VarExp("varf"),"varc"),
                                            new CompStmt(new PrintStmt(new VarExp("varc")),
                                                    new CompStmt(new readFile(new VarExp("varf"),"varc"),
                                                            new CompStmt(new PrintStmt(new VarExp("varc")),
                                                                    new closeRFile(new VarExp("varf"))))))))));
        MyIStack<IStmt> stk4= new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl4=new MyDictionary<String, Value>();
        MyIList<Value> out4=new MyList<Value>();
        MyIFileTable<String, BufferedReader> FT4=new MyFileTable<String,BufferedReader>();
        MyIHeap<Integer,Value> H4=new MyHeap<Integer,Value>();
        PrgState state4=new PrgState(stk4,symtbl4,out4,FT4,H4,ex4);
        controller ctrl4=new controller(new MyRepo(state4,"C:\\Users\\Bubu\\IdeaProjects\\lab2\\src\\test4.txt"));


        /*IStmt ex5 = new CompStmt(new VarDeclStmt(
                "v",new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))),
                        new CompStmt(new VarDeclStmt("w", new IntType()),
                                new CompStmt(new AssignStmt("w", new ValueExp(new IntValue(3))),
                                        new PrintStmt(new ValueExp(new BoolValue(new RelExp(">",new VarExp("v"),new VarExp("w")).eval()))))));*/
        IStmt ex5=new VarDeclStmt("v",new IntType());
        MyIStack<IStmt> stk5= new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl5=new MyDictionary<String, Value>();
        MyIList<Value> out5=new MyList<Value>();
        MyIFileTable<String, BufferedReader> FT5=new MyFileTable<String,BufferedReader>();
        MyIHeap<Integer,Value> H5=new MyHeap<Integer,Value>();
        PrgState state5=new PrgState(stk5,symtbl5,out5,FT5,H5,ex5);
        controller ctrl5=new controller(new MyRepo(state5,"C:\\Users\\Bubu\\IdeaProjects\\lab2\\src\\test5.txt"));

        IStmt ex6 = new CompStmt(new VarDeclStmt("v", new RefType(new IntType())),
                new CompStmt(new HeapAllocStmt("v", new ValueExp(new IntValue(20))),
                        new CompStmt(new PrintStmt(new ReadHeapExp(new VarExp("v"))),
                                new CompStmt(new WriteHeapStmt(new ValueExp(new IntValue(30)),"v"),
                                        new PrintStmt(
                                                new ArithExp("+", new ReadHeapExp(new VarExp("v")), new ValueExp(new IntValue(5))))))));


        MyIStack<IStmt> stk6= new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl6=new MyDictionary<String, Value>();
        MyIList<Value> out6=new MyList<Value>();
        MyIFileTable<String, BufferedReader> FT6=new MyFileTable<String,BufferedReader>();
        MyIHeap<Integer,Value> H6=new MyHeap<Integer,Value>();
        PrgState state6=new PrgState(stk6,symtbl6,out6,FT6,H6,ex6);
        controller ctrl6=new controller(new MyRepo(state6,"C:\\Users\\Bubu\\IdeaProjects\\lab2\\src\\test Garbage.txt"));

        IStmt ex7=new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(4))),
                        new CompStmt(
                                new WhileStmt(new RelExp(">", new VarExp("v"), new ValueExp(new IntValue(0))),
                                        new CompStmt(new PrintStmt(new VarExp("v")),
                                                new AssignStmt("v", new ArithExp("-", new VarExp("v"), new ValueExp(new IntValue(1)))))),
                                new PrintStmt(new VarExp("v")))));

        MyIStack<IStmt> stk7= new MyStack<IStmt>();
        MyIDictionary<String, Value> symtbl7=new MyDictionary<String, Value>();
        MyIList<Value> out7=new MyList<Value>();
        MyIFileTable<String, BufferedReader> FT7=new MyFileTable<String,BufferedReader>();
        MyIHeap<Integer,Value> H7=new MyHeap<Integer,Value>();
        PrgState state7=new PrgState(stk7,symtbl7,out7,FT7,H7,ex7);
        controller ctrl7=new controller(new MyRepo(state7,"C:\\Users\\Bubu\\IdeaProjects\\lab2\\src\\test While.txt"));




        View menu = new View();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctrl3));
        menu.addCommand(new RunExample("4",ex4.toString(),ctrl4));
        menu.addCommand(new RunExample("5",ex5.toString(),ctrl5));
        menu.addCommand(new RunExample("6",ex6.toString(),ctrl6));
        menu.addCommand(new RunExample("7",ex7.toString(),ctrl7));
        menu.show();

    }
}
