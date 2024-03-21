import java.util.*;

class Solution {

    private static final int[] DISCOUNT_POLICIES = {10, 20, 30, 40};

    private int[][] users;
    private int[] emoticons;
    private int maxSubscriber = 0;
    private int maxPrice = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;

        dfs(new ArrayList<>());

        return new int[]{maxSubscriber, maxPrice};
    }

    private void dfs(List<Integer> discounts) {
        if (discounts.size() == emoticons.length) {
            calculateResult(discounts);
            return;
        }

        for (int discount : DISCOUNT_POLICIES) {
            discounts.add(discount);
            dfs(discounts);
            discounts.remove(discounts.size() - 1);
        }
    }

    private void calculateResult(final List<Integer> discounts) {
        int subscriber = 0;
        int totalPrice = 0;

        for (int[] user : users) {
            int targetDiscount = user[0];
            int targetPrice = user[1];

            int price = 0;
            for (int i = 0; i < emoticons.length; i++) {
                if (targetDiscount <= discounts.get(i)) {
                    price += emoticons[i] * (100 - discounts.get(i)) / 100;
                }
            }

            if (price < targetPrice) {
                totalPrice += price;
                continue;
            }
            subscriber++;
        }

        if (subscriber > maxSubscriber) {
            maxSubscriber = subscriber;
            maxPrice = totalPrice;
            return;
        }
        if (subscriber == maxSubscriber) {
            maxPrice = Math.max(maxPrice, totalPrice);
        }
    }

}
