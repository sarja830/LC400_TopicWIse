//package Hashing;
//import java.util.*;
//public class WorstTradeReporter {
//    public static void main(String[] args) {
//
//    }
//
//    class Trade
//    {
//        long tradeId;
//        BuySell buySell;
//        long price;
//        long volume;
//        public Trade(long tradeId, BuySell byuSell, long price,long volume)
//        {
//            this.tradeId= tradeId;
//            this.buySell=buySell;
//            this.price=price;
//            this.volume= volume;
//        }
//    }
//    HashMap<String,Long> stockPrice = new HashMap();
//    HashMap<Long,Long> tradeIdLoss = new HashMap<>();
//    //instrument id and list of transactions
//    HashMap<String,List<Trade>> transactions = new HashMap<>();
//    //instrument id and trade id
//    HashMap<String,Long> ans = new HashMap<>();
//    void processTrade(long tradeId, String instrumentId, BuySell buySell, long price,long volume)
//    {
//        long loss=0;
//        if(buySell=='BUY')
//        {
//            loss= price-stockPrice.get(instrumentId);
//        }
//        else {
//            loss = stockPrice.get(instrumentId) - price;
//        }
//        if(transactions.containsKey(instrumentId))
//        {
//            List<Trade> list = transactions.get(instrumentId);
//            list.add(new Trade(tradeId,buySell,price,volume));
//            transactions.put(instrumentId,list);
//        }
//        else {
//            List<Trade> l1 = new LinkedList<>();
//            l1.add(new Trade(tradeId,buySell,price,volume));
//            transactions.put(instrumentId,l1);
//        }
//        tradeIdLoss.put(tradeId,loss);
//
//    }
//    void recalculate(String instrumentId)
//    {
//        long max =0;
//        if(transactions.containsKey(instrumentId)) {
//
//            List<Trade> list = transactions.get(instrumentId);
//            for(int i=0;i<list.size();i++)
//            {
//                Trade temp = list.get(i);
//                long loss =0;
//                if(temp.buySell=='BUY')
//                {
//                    loss= temp.price-stockPrice.get(instrumentId);
//                }
//                else {
//                    loss = stockPrice.get(instrumentId) - temp.price;
//                }
//                if(loss>max)
//                    max =loss;
//                tradeIdLoss.put(temp.tradeId,loss);
//            }
//            ans.put(instrumentId,max);
//        }
//    }
//    void processPriceUpdate(String instrumentId, long price)
//    {
//        stockPrice.put(instrumentId,price);
//        recalculate(instrumentId);
//
//    }
//    public String outputWorstTrade(String instrumentId)
//    {
//        if(tradeIdLoss.get(ans.get(instrumentId))<=0)
//        {
//            return "NO BAD TRADES";
//        }
//        else
//        {
//            return ans.get(instrumentId);
//        }
//        return "";
//    }
//}
