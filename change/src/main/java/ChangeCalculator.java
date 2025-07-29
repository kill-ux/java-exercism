import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ChangeCalculator {
    private List<Integer> coins;

    ChangeCalculator(List<Integer> currencyCoins) {
        currencyCoins.sort(Comparator.reverseOrder());
        this.coins = currencyCoins;
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }
        
        if (grandTotal == 0) {
            return new ArrayList<>();
        }

        // This array will store the minimum number of coins needed for each amount
        int[] minCoins = new int[grandTotal + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE - 1);
        minCoins[0] = 0;

        // This array will store the last coin used to reach each amount
        int[] lastCoin = new int[grandTotal + 1];

        for (int amount = 1; amount <= grandTotal; amount++) {
            for (int coin : coins) {
                if (coin <= amount && minCoins[amount - coin] + 1 < minCoins[amount]) {
                    minCoins[amount] = minCoins[amount - coin] + 1;
                    lastCoin[amount] = coin;
                }
            }
        }

        // If we couldn't make the amount with given coins
        if (minCoins[grandTotal] == Integer.MAX_VALUE - 1) {
            throw new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency.");
        }

        // Reconstruct the solution
        List<Integer> result = new ArrayList<>();
        int remaining = grandTotal;
        while (remaining > 0) {
            int coin = lastCoin[remaining];
            result.add(coin);
            remaining -= coin;
        }

        // Sort the result in ascending order for consistent output
        Collections.sort(result);
        return result;
    }
}