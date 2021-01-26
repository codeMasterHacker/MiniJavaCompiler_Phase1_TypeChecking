import SymbolTable.*;
import syntaxtree.*;
import visitor.*;

public class TypeChecker 
{
    public static void main(String [] args) 
    {
        try 
        {
            MiniJavaParser mjp = new MiniJavaParser(System.in);
            Goal root = mjp.Goal();
            GoalEntry goalEntry = new GoalEntry("", "", null);
            root.accept(new SymbolTableVisitor(), goalEntry);
            root.accept(new TypeCheckerVisitor(), goalEntry);
            //goalEntry.print();
        }
        catch (ParseException e) 
        {
            System.out.println(e.toString());
        }
    }
}