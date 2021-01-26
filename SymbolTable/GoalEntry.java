package SymbolTable;
import java.util.*;

public class GoalEntry extends SymbolTableEntry
{
    public GoalEntry(String name, String type, SymbolTableEntry parent_tableEntry)
    {
        super(name, type, parent_tableEntry);
        classes = new HashMap<>();
    }

    //given a class's name, return its class entry object
    @Override
    public SymbolTableEntry get_tableEntry(String className) 
    { 
        return classes.get(className);
    }

    @Override
    public void insert_methodEntry(String methodName, MethodEntry methodEntry) { return; }

    @Override
    public void insert_variableEntry(String variableName, VariableEntry variableEntry) { return; }

    @Override
    public void print()
    {
        System.out.println("\n\n\nClasses:");
        classes.forEach( (key, value) -> 
        {
            if (value.parent_className.isEmpty())
                System.out.println("\t" + key);
            else
                System.out.println("\t" + key + " extends " + value.parent_className);
            value.print();
        });
    }
}
