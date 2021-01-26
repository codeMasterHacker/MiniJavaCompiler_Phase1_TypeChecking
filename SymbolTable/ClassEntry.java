package SymbolTable;
import java.util.*;

public class ClassEntry extends SymbolTableEntry 
{
    public boolean is_mainClass;
    public String parent_className; //in case the class extends another class, inheritence

    public ClassEntry(String className, String type, SymbolTableEntry parent_tableEntry, boolean is_mainClass, String parent_className)
    {
        super(className, type, parent_tableEntry);

        this.is_mainClass = is_mainClass;
        this.parent_className = parent_className;
        
        methods = new HashMap<>();
        fields = new HashMap<>();
    }

    //given a name, return the appropriate type of symbol table entry
    @Override
    public SymbolTableEntry get_tableEntry(String name)
    {
        VariableEntry variableEntry = fields.get(name);
        MethodEntry methodEntry;
    
        if (variableEntry != null) 
            return variableEntry; 
        else 
	    { 
            methodEntry = methods.get(name);
        
            if (methodEntry != null) 
                return methodEntry; 
            else 
                return parent_tableEntry.get_tableEntry(name); //return a class entry object
	    }
    }

    @Override
    public void insert_classEntry(String className, ClassEntry classEntry) { return; }

    @Override
    public void insert_variableEntry(String fieldName, VariableEntry variableEntry)
    {
        fields.put(fieldName, variableEntry);
    }

    public void insert_FieldsMethods(ClassEntry parentClass_entry)
    {
        parentClass_entry.fields.forEach( (key, value) -> { insert_variableEntry(key, value); });
        parentClass_entry.methods.forEach( (key, value) -> { insert_methodEntry(key, value); });
    }

    @Override
    public void print()
    {
        System.out.println("\t\tFields:");
        fields.forEach( (key, value) -> 
        {
            System.out.println("\t\t\t" + value.type + " " + key);
            value.print();
        });

        System.out.println("\t\tMethods:");
        methods.forEach( (key, value) -> 
        {
            System.out.println("\t\t\t" + value.type + " " + key);
            value.print();
        });
    }
}
