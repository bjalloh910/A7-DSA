import java.util.*;

  /**
   * The QuickSortTimer class provides a static method to sort a CardPile using the QuickSort algorithm.
   * It also includes a main method to demonstrate the sorting process and measure the execution time.
   */
public class QuickSortTimer {

  /**
   * Sorts a CardPile using the QuickSort algorithm.
   * 
   * @param unsorted The unsorted CardPile to be sorted.
   * @return         The sorted CardPile.
   */
  public static CardPile sort(CardPile unsorted) {

    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    
    if( unsorted.size() == 0 || unsorted.size() == 1){
      return unsorted;
    } 
    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    
    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    Card pivot = unsorted.remove();  // edit this!

     for( Card c : unsorted){
      if(c.compareTo(pivot) < 0 ){ // meaning c is less than pivot. 
        smaller.add(c);
      } else {
        bigger.add(c);
      }
    }


    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************

    //recursive call and putting it together 
    result.append(sort(smaller));
    result.add(pivot);
    result.append(sort(bigger));

        // return the sorted result here
    return result;
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
