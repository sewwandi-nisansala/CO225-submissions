

import java.lang.String;

public class Stock {
    private String symbol;
    private String securityName;
    private double price;

    public Stock(String symbol,String securityName,double price){
        this.symbol=symbol;
        this.securityName=securityName;
        this.price=price;
    }


    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }//Set symbol

    public String getSymbol() {
        return symbol;
    }//Get symbol


    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }//Set Security name

    public String getSecurityName() {
        return securityName;
    }//Get Security name


    public void setPrice(double price) {
        this.price = price;
    }//Set price

    public double getPrice() {
        return price;
    }//Get price

}
