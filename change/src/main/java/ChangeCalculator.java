import java.util.*;

class ChangeCalculator {
    private List<Integer> list;

    ChangeCalculator(List<Integer> currencyCoins) {
        currencyCoins.sort(Comparator.reverseOrder());
        this.list = currencyCoins;
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {
        List<Integer> new_list = new ArrayList<>();
        int res = 0;
        int coins = 0;
        for (int e : this.list) {
            if (res == grandTotal) {
                break;
            }
            if (e <= grandTotal) {
                boolean add = false;
                while (grandTotal >= e + res) {
                    res += e;
                    coins++;
                    add = true;
                }
                if (add) {
                    new_list.add(e);
                }
            }
        }
        new_list.sort(null);
        return new_list;
    }

}
