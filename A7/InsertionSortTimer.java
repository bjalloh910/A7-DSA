import java.util.ListIterator;
import java.util.*;

  /**
  * The InsertionSortTimer class provides a static method to sort a CardPile using the Insertion Sort algorithm.
  * It also includes a main method to demonstrate the sorting process and measure the execution time.
  */
public class InsertionSortTimer {

   /**
   * Sorts a CardPile using the Insertion Sort algorithm.
   * 
   * @param unsorted The unsorted CardPile to be sorted.
   * @return         The sorted CardPile.
   */
  
  public static CardPile sort(CardPile unsorted) {
    

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:

    // ***********************************************************

    // return the sorted result here

    Card firstCard = unsorted.remove(); 
    sorted.add(firstCard);

    while(!unsorted.isEmpty()){
      Card c = unsorted.remove();

      if(c.compareTo(sorted.getFirst()) > 0){ //if the currentcard is less than c 
        sorted.addFirst(c); // then make it the first card
      } else {
        ListIterator<Card> pos = sorted.listIterator(sorted.size()); //going to iterate starting from the back of sorted 
        Card lastCard = pos.previous();
        while(pos.hasPrevious() && c.compareTo(lastCard) < 0){
          lastCard = pos.previous();
        }
        sorted.insertAfter(c, lastCard);
        
      
      }
    }
    return sorted;
  }
  /**
   * Starts the program running. It takes a command-line argument specifying the number of cards to sort.
   * 
   * @param args The command-line arguments. args[0] should contain the number of cards to sort.
   */
  /** Starts the program running */
  public static void main(String args[]) {
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }

      System.out.println(cards.size());

      sort(cards);
      
    }
   
  }
}