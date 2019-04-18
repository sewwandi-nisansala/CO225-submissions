

public class Client {
    private String date;
    private String time;
    private String name;
    private String symbol;
    private double new_price;
    private double pre_price;

    public Client(String name,String date,String time,String symbol,double pre_price,double new_price){
        this.date=date;
        this.time=time;
        this.name=name;
        this.symbol=symbol;
        this.new_price=new_price;
        this.pre_price=pre_price;
    }


    public void setName(String name) {
        this.name = name;
    }//Set name

    public String getName() {
        return name;
    }//Get name


    public void setDate(String date) {
        this.date = date;
    }//Set date

    public String getDate() {
        return date;
    }//Get date


    public void setTime(String time) {
        this.time = time;
    }//Set time

    public String getTime() {
        return time;
    }//Get time


    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }//Set symbol

    public String getSymbol() {
        return symbol;
    }//Get symbol


    public void setPre_price(double pre_price) {
        this.pre_price = pre_price;
    }//Set previous price

    public double getPre_price() {
        return pre_price;
    }//Get previous price


    public void setNew_price(double new_price) {
        this.new_price = new_price;
    }//Set new price

    public double getNew_price() {
        return new_price;
    }//Get new price

}
