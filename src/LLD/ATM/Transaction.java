//package LLD.ATM;
//
//public interface Transaction {
//    int commit();
//    int rollback();
//}
//
//
//public class Deposit implements Transaction
//{
//    int commit(int amount, Account accountId){
//        accountId.setBalance(amount);
//    }
//    int rollback(){
//        return 1;
//    }
//
//}
//public class Withdraw implements Transaction
//{
//    int commit(){
//        return 0;
//    }
//    int rollback(){
//        return 1;
//    }
//
//}
//public class GetBalance implements Transaction
//{
//    int commit(){
//        return 0;
//    }
//    int rollback(){
//        return 1;
//    }
//
//}