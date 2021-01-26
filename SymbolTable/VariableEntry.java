package SymbolTable;

public class VariableEntry extends SymbolTableEntry 
{
    public boolean isParameter;

    public VariableEntry(String variableName, String type, SymbolTableEntry parent_tableEntry, boolean isParameter)
    {
        super(variableName, type, parent_tableEntry);

        this.isParameter = isParameter;
    }

    @Override
    public SymbolTableEntry get_tableEntry(String name) 
    { 
        return parent_tableEntry.get_tableEntry(name); 
    }

    @Override
    public void insert_classEntry(String className, ClassEntry classEntry) { return; }

    @Override
    public void insert_methodEntry(String methodName, MethodEntry methodEntry) { return; }
}
