package Puzzle8;


/**
 * Write a description of class ProbPuzzleDes here.
 * 
 * @author Juan Jose Gomez Morales
 */
public class ProbPuzzleDes extends ProbPuzzleH0
{
    public ProbPuzzleDes(Puzzle p)
    {
        super(p);
    }
    
    @Override
    public int h(Puzzle p) {
        return p.getDescolocadas();
    }
}
