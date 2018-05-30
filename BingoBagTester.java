/*
 * BingoBag tester java
 */


public class BingoBagTester
{
  public static void main(String args[]) throws InvalidBingoSymbolException, InvalidBingoValueException
  {
    //try{
    BingoBag game= new BingoBag();
    
    game.draw();
    game.draw();
    System.out.println(game.toString());
    //}
    //catch(Exception e)
    //{
      System.out.println("Error");
    //}
  }
}