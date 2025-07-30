import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return Set.copyOf(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        int can = 0;
        for (String card : myCollection) {
            if (!theirCollection.contains(card)) {
                can++;
                break;
            }
        }
        for (String card : theirCollection) {
            if (!myCollection.contains(card)) {
                can++;
                break;
            }
        }
        return can == 2;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        HashSet<String> copy = new HashSet<String>(collections.get(0));
        for (Set<String> coll : collections) {
            copy.retainAll(coll);
        }
        return copy;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        throw new UnsupportedOperationException("Please implement the (static) GottaSnatchEmAll.allCards() method");
    }
}
