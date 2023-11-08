import java.util.*;
import java.util.Collections;

  /**
   * The SelectionSortTimer class provides a static method to sort a CardPile using the Selection Sort algorithm.
   * It also includes a main method to demonstrate the sorting process and measure the execution time.
   */
public class SelectionSortTimer {

   /**
   * Sorts a CardPile using the Selection Sort algorithm.
   * 
   * @param unsorted The unsorted CardPile to be sorted.
   * @return         The sorted CardPile.
   */
  
  public static CardPile sort(CardPile unsorted) {
    

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
    // ***********************************************************

    
   // cardpile == ll and card == node
    while(!unsorted.isEmpty()){
     Card min = unsorted.getFirst(); 
     for( Card i: unsorted){
      if(min.compareTo(i) > 0){ //comparing a & b.. if it returns a positive that means a is bigger and it it returns a negative b is bigger
        min = i;    // if i(currentcard we're looking at is greater 0 meaning it return a positive we make the current the new min)
      }
     }
      sorted.add(min);      // add the min to sorted
      unsorted.remove(min); //remove from unsorted
       
      /* This part allows to see it  */
    
    }
    // return the sorted result here
    return sorted;
  
  }
   /**
   * Starts the program running. It takes a command-line argument specifying the number of cards to sort.
   * 
   * @param args The command-line arguments. args[0] should contain the number of cards to sort.
   */
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
