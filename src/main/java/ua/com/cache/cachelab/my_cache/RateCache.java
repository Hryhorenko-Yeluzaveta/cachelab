package ua.com.cache.cachelab.my_cache;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.cache.cachelab.entity.Rate;

import java.util.HashMap;
import java.util.Map;

@Data
public class RateCache implements MyCache<Long, Rate>{

    private static final Logger logger = LoggerFactory.getLogger(RateCache.class);
    private Map<Long, Rate> cache = new HashMap<>();

    @Override
    public Rate getCache(Long key) {
        logger.info("rate from cache", cache.get(key).toString());
        return cache.get(key);
    }

    @Override
    public Rate putCache(Long key, Rate value) {
        cache.put(key, value);
        Rate c = cache.get(key);
        logger.info("value from cache", c);
        return c;
    }

    public void print(){

        for (Map.Entry<Long, Rate> el :
                cache.entrySet()) {
            logger.info(el.getKey() +" :" + el.getValue() + ",");
        }
    }


}