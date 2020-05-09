package chapter11;

public class ExchangeService {
    public Double getRate(Money type1,Money type2 ){
        if(type1==Money.EUR && type2==Money.USD)
           return 1.084;
        return 1.0;
    }
}
