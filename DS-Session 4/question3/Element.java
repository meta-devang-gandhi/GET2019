package question3;

/**
 *Represent the organic chemistry compound. 
 */
public class Element 
{	
	private char symbol;
    private int base;

    Element(char symbol, int base)
    {
        this.symbol = symbol;
        this.base = base;
    }
    
   // Return the symbol of compound.
    char getSymbol()
    {
        return symbol;
    }
   
    //Return the base of symbol.
    int getBase()
    {
        return base;
    }
}