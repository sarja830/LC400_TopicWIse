package DesignQuestions;

import java.util.*;

public class TradeScores {

    class Trade
    {

        String TraderName ;
        int Asset, Quantity;
        double Price;

        Trade( String TraderName, int Asset, int Quantity, double Price)
        {
            this.TraderName =  TraderName;
            this.Asset =  Asset;
            this.Quantity =  Quantity;
            this.Price =  Price;
        }
    }


    HashMap<Integer,Double> theoPrice = new HashMap<>();
    HashMap<String, Double> scores = new HashMap<>();


    void processTrade(Trade t )
    {
        double edgeScore = calculateEdgeScore(t);
        double currentScore = scores.getOrDefault(t.TraderName,0.0);
        scores.put(t.TraderName,currentScore+edgeScore);
    }
    void reportScore()
    {

    }

    double calculateEdgeScore(Trade t)
    {
        double AssetPrice  =theoPrice.getOrDefault(t.Asset, t.Price);
        double edge;
        double edgeScore;
        if(t.Quantity>0)
        {
            edge = AssetPrice-t.Price;
        }
        else {
            edge = t.Price-AssetPrice;
        }

        edgeScore =edge>0?  edge*edge*Math.abs(t.Quantity):-1 * edge*edge*Math.abs(t.Quantity);
        return edgeScore;
    }
    void processTheoUpdate(int Asset, double price )
    {
        theoPrice.put(Asset,price);
    }




}
