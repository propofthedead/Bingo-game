import java.util.*;
import java.lang.*;
public class BingoBag extends BingoBall
{
  private LinkedList<BingoBall> bagOfBalls= new LinkedList<BingoBall>();
  public LinkedList<BingoBall> calledBalls= new LinkedList<BingoBall>();
  
  public BingoBag()throws InvalidBingoSymbolException, InvalidBingoValueException 
  {
    //String n="B";
    char column='B';

      for(int i=0;i<16;i++)
      {
        BingoBall bagged = new BingoBall(column,i);
        bagOfBalls.addLast(bagged);
      }
    column='I';
    for(int i=16;i<31;i++)
    {
      BingoBall bagged= new BingoBall(column,i);
      bagOfBalls.addLast(bagged);
    }
    
    column='N';
    for(int i=31;i<46;i++)
    {
      BingoBall bagged= new BingoBall(column,i);
      bagOfBalls.addLast(bagged);
    }
    column='G';
    for(int i=46;i<61;i++)
    {
      BingoBall bagged= new BingoBall(column,i);
      bagOfBalls.addLast(bagged);
    }
    
    column='O';
    for(int i=61;i<76;i++)
    {
      BingoBall bagged= new BingoBall(column,i);
      bagOfBalls.addLast(bagged); 
    }
    
    
  }
  
  public BingoBall draw()
  {
    Random rand= new Random();
    int draw= rand.nextInt(bagOfBalls.size());
    BingoBall drawnOut=bagOfBalls.get(draw);
    bagOfBalls.remove(draw);
    drawnOut.setMarked(true);
    calledBalls.addLast(drawnOut);
    return drawnOut;
    
  }
  private boolean isEmpty()
  {
    int size=bagOfBalls.size();
    if(size>0)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  
  public LinkedList getCalled()
  {
    return calledBalls;
  }
  public LinkedList getBingoBag()
  {
    return bagOfBalls;
  }
  public String toString()
  {
    String answer="Balls in the bag \n";
    int nice=0;
    for(int i=0;i<bagOfBalls.size();i++)
    {
      BingoBall string=bagOfBalls.get(i);
      answer+= string.getColumn()+string.getValue()+" - "+string.getMarked()+" ,  ";
      if (i%10==0)
      {
        answer+='\n';
      }
    }
    answer+='\n';
    answer+="Balls that have been called \n";
    for(int i=0; i<calledBalls.size();i++)
    {
      BingoBall string=calledBalls.get(i);
      answer+= string.getColumn()+string.getValue()+" - "+string.getMarked()+" ,  ";
      if (i%10==0)
      {
        answer+='\n';
      }
    }
    
    
    return answer;
  }
  
}