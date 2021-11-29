package com.ghassan;

public class Main {
    //This example uses the Map to store data about items in basket and items in stock
    // it uses the treeMap to provide a sorted collection
    //There is a stockList which is consists of items,
    //The basket is full of items from the stockList
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.9, 200);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("chair", 1.10, 190);
        stockList.addStock(temp);
        temp = new StockItem("shoes", 16.3, 50);
        stockList.addStock(temp);
        temp = new StockItem("tea", 1.0, 90);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.30, 97);
        stockList.addStock(temp);
        temp = new StockItem("phone", 200, 7);
        stockList.addStock(temp);
        temp = new StockItem("towel", 5, 70);
        stockList.addStock(temp);
        temp = new StockItem("vase", 12.50, 13);
        stockList.addStock(temp);
        temp = new StockItem("glasses", 100, 15);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket basket = new Basket("Ghassan");
        sellItem(basket, "bread", 3);
        System.out.println(basket);

//         sellItem(basket, "glasses", 1);
//        sellItem(basket, "vase", 1);
//        sellItem(basket, "car", 1);
//        System.out.println(basket);

    }

    public static int sellItem(Basket basket, String item , int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null ){
            System.out.println(" We dont sell " + item);
            return 0;
        }
        if (stockList.sellStock(item,quantity) != 0 ){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
