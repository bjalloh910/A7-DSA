import java.util.ArrayDeque;
import java.util.Collections;

/**
 * The MergeSort class provides a static method to sort a CardPile using the Merge Sort algorithm.
 * It also includes a main method for demonstration purposes.
 */

public class MergeSort {
  
   /**
   * Sorts a CardPile using the Merge Sort algorithm and records the sorting process.
   * 
   * @param unsorted The unsorted CardPile to be sorted.
   * @param record   A SortRecorder object to record the sorting process.
   * @return         The sorted CardPile.
   */

  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
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

        // register the new state with the recorder:
        record.next(); // tell it this is a new step
        record.add(queue.getLast()); // the allegedly sorted pile
        record.add(unsorted); // the unsorted pile
      }
      // return the sorted result here
      return queue.remove();
    }
     /**
     * Starts the program running. It sets up a class to record and display the sorting results,
     * sets up the deck of cards, and demonstrates the merge sort algorithm.
     * 
     * @param args The command-line arguments (not used in this program).
     */
    
/** Starts the program running */
  public static void main(String args[]) {

    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = MergeSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: FakeSort");
  }
}

