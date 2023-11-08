import java.util.*;

  /**
    * The Quicksort class provides a static method to sort a CardPile using the Quicksort algorithm.
    * It also includes a main method for demonstration purposes.
    */
public class Quicksort {

     /**
     * Sorts a CardPile using the Quicksort algorithm and records the sorting process.
     * 
     * @param unsorted The unsorted CardPile to be sorted.
     * @param record   A SortRecorder object to record the sorting process.
     * @return         The sorted CardPile.
     */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

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

    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************

    //recursive call and putting it together 
    result.append(sort(smaller, record));
    result.add(pivot);
    result.append(sort(bigger, record));


    // record the sorted result
    record.add(result);
    record.next();

        // return the sorted result here
    return result;
  }
    
  /**
   * Starts the program running. It sets up a class to record and display the sorting results,
   * sets up the deck of cards, and demonstrates the Quicksort algorithm.
   * 
   * @param args The command-line arguments (not used in this program).
   */
  
  public static void main(String[] args) {
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
    cards = Quicksort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: FakeSort");
  }
}