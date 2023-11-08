import java.util.ArrayDeque;
import java.util.Collections;

/**
 * The MergeSortTimer class provides a static method to sort a CardPile using the Merge Sort algorithm.
 * It also includes a main method to demonstrate the sorting process and measure the execution time.
 */
public class MergeSortTimer {
  /**
   * Sorts a CardPile using the Merge Sort algorithm.
   * 
   * @param unsorted The unsorted CardPile to be sorted.
   * @return         The sorted CardPile.
   */
  public static CardPile sort(CardPile unsorted) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************

     // Step 1: Create singleton piles and add them to the queue
      for( Card i: unsorted){ // try to iterate through
        CardPile singleton = new CardPile();
        singleton.add(i);
        queue.add(singleton);
      }
       while(queue.size() > 1){
        CardPile lists1 = queue.remove();
        CardPile lists2 = queue.remove();
        CardPile merged = new CardPile();

        while(!lists1.isEmpty() && !lists2.isEmpty()){
          if( lists1.peek().compareTo(lists2.peek()) <= 0){
            merged.add(lists1.remove());
          } else {
            merged.add(lists2.remove());
          }
        }
        while(!lists1.isEmpty()) {
          merged.add(lists1.remove());
        } 
        while(!lists2.isEmpty()){
          merged.add(lists2.remove());
        }
        queue.add(merged);
      }
      // return the sorted result here
      return queue.remove();
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
