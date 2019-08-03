package question3;

public class Element 
{
	
	private char symbol;
    private int base;

    Element(char symbol, int base)
    {
        this.symbol = symbol;
        this.base = base;
    }
    
   
    char getSymbol()
    {
        return symbol;
    }
   
    int getBase()
    {
        return base;
    }
}