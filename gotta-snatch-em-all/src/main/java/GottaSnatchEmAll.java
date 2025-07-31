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
        HashSet<String> new_myCollection = new HashSet<>(myCollection);
        HashSet<String> new_theirCollection = new HashSet<>(theirCollection);
        new_myCollection.removeAll(theirCollection);
        new_theirCollection.removeAll(myCollection);
        return new_myCollection.size() > 0 && new_theirCollection.size() > 0;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        HashSet<String> copy = new HashSet<String>(collections.get(0));
        for (Set<String> coll : collections) {
            copy.retainAll(coll);
        }
        return copy;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        HashSet<String> copy = new HashSet<String>(collections.get(0));
        for (Set<String> coll : collections) {
            copy.addAll(coll);
        }
        return copy;
    }
}
