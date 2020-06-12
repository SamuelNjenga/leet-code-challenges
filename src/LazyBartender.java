import java.util.*;

public class LazyBartender {

    public static void main(String[] args) {

        HashMap<String, Set<String>> custMap = new HashMap<String, Set<String>>();

        custMap.put("cust1", new HashSet<String>(Arrays.asList("n3", "n7", "n5", "n2", "n9")));
        custMap.put("cust2", new HashSet<String>(Arrays.asList("n5")));
        custMap.put("cust3", new HashSet<String>(Arrays.asList("n2", "n3")));
        custMap.put("cust4", new HashSet<String>(Arrays.asList("n4")));
        custMap.put("cust5", new HashSet<String>(Arrays.asList("n3", "n4", "n5", "n7")));

        System.out.println("total number of drinks required: " + countDrinks(custMap));
    }

    private static int countDrinks(HashMap custMap) {
        int count =0;
        HashMap<String, Set<String>> drinksMap = new HashMap<String, Set<String>>();
        HashMap<String,Integer> drinksvscustcount = new HashMap<String, Integer>();
        Iterator custvsdrinksIt = custMap.keySet().iterator();
        //Prepare drink map
        while(custvsdrinksIt.hasNext()){
            String customer = (String) custvsdrinksIt.next();
            Set<String> drinks = (Set<String>) custMap.get(customer);
            for (String drink : drinks) {
                if(drinksMap.containsKey(drink)){
                    drinksMap.get(drink).add(customer);
                }else{
                    Set<String> custs = new HashSet<String>();
                    custs.add(customer);
                    drinksMap.put(drink, custs);
                }
                drinksvscustcount.put(drink, drinksMap.get(drink).size());
            }
        }
        Set<String> finalDrinks = new HashSet<String>();
        Set<String> finalCusts = new HashSet<String>();
        while(finalCusts.size() < custMap.size()){
            String drink = getDrinkWithMaxCustomers(drinksvscustcount);
            Set<String> custs = drinksMap.get(drink);
            for(String cust : custs){
                if(finalCusts.contains(cust)){
                    continue;
                }else{
                    finalDrinks.add(drink);
                    finalCusts.add(cust);
                }
            }
            drinksvscustcount.remove(drink);
        }
        System.out.println("finalDrinks"+finalDrinks);
        return finalDrinks.size();
    }

    public static String getDrinkWithMaxCustomers(HashMap<String, Integer> drinksvscustcount){
        int maxCustomersForADrink = 0;
        String maxDrink = "";
        Set<String> drinks = drinksvscustcount.keySet();
        for(String drink : drinks){
            if(drinksvscustcount.get(drink) > maxCustomersForADrink){
                maxCustomersForADrink = drinksvscustcount.get(drink);
                maxDrink = drink;
            }
        }
        return maxDrink;
    }
}
