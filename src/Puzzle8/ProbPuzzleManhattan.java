package Puzzle8;


/**
 * Write a description of class ProbPuzzleManhattan here.
 * 
 * @author Juan Jose Gomez Morales
 */
public class ProbPuzzleManhattan extends ProbPuzzleH0
{
    public ProbPuzzleManhattan(Puzzle p)
    {
        super(p);
    }
    
    @Override
    public int h(Puzzle p) {
        return p.getManhattan();
    }
}
