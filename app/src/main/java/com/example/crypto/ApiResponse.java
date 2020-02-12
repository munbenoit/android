package com.example.crypto;


import java.util.List;

public class ApiResponse {

    public class Data{
        protected class Stats{
            private int total;

            public int getTotal(){
                return total;
            }
        }
        private Stats stats;
        private List<Coin> coins;

        public Stats getStats(){
            return stats;
        }
        public List<Coin> getCoins(){
            return coins;
        }

        protected class Coin{
            private int id;

            public String getSlug() {
                return slug;
            }

            private String slug;

            public String getSymbol() {
                return symbol;
            }

            private String symbol;

            public String getDescription() {
                return description;
            }

            private String description;

            public int getId() {
                return id;
            }

            public String getWebsiteUrl() {
                return websiteUrl;
            }

            private String websiteUrl;

            public String getPrice() {
                return price;
            }

            private String price;

            public String toString(){
                return symbol + " " + price;
            }


        }
    }



    private Data data;

    public Data getData(){
        return data;
    }



}
