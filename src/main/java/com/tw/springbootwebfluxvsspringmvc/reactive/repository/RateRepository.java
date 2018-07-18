package com.tw.springbootwebfluxvsspringmvc.reactive.repository;

import com.tw.springbootwebfluxvsspringmvc.domain.Rate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class RateRepository {
    private Map<String, List<Rate>> rateMap = new HashMap<String, List<Rate>>();


    @PostConstruct
    public void initIt() throws Exception {

        List<Rate> mmt = getRandomRates("MMT");
        List<Rate> agoda = getRandomRates("AGODA");
        List<Rate> goibibo = getRandomRates("GOIBIBO");


        Stream<Rate> combinedStream = Stream.of(mmt, agoda,goibibo)
                .flatMap(Collection::stream);
        List<Rate> collectionCombined =
                combinedStream.collect(Collectors.toList());


        rateMap.put("TAJ",
                collectionCombined);

        rateMap.put("HILTON",
                collectionCombined);

        rateMap.put("HYATT",
                collectionCombined);

        rateMap.put("MARRIOTT", collectionCombined);
    }

    public List<Rate> getRandomRates(String provider){
        return Arrays.asList(new Rate(provider,"SINGLE", getRandomDoubleBetweenRange(100,1000), "$", (double) getRandomDoubleBetweenRange(0,14)),
                new Rate(provider,"DOUBLE", getRandomDoubleBetweenRange(100,1000), "$",getRandomDoubleBetweenRange(0,14) ),
                new Rate(provider,"MASTER SUITE", getRandomDoubleBetweenRange(100,1000), "$", getRandomDoubleBetweenRange(0,14)),
                new Rate(provider,"TRIPLE", getRandomDoubleBetweenRange(100,1000), "$", getRandomDoubleBetweenRange(0,14))
        );
    }

    public static double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;

        return round(x,2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public Flux<Rate> getRatesByHotel(String hotelCode,String provider){
        if(!rateMap.keySet().contains(hotelCode)) {
            throw new IllegalArgumentException("Rates not available");
        }


        return Flux.fromIterable(rateMap.get(hotelCode)).filter(rate -> rate.getProvider() == provider);
    }


}
