package ua.com.cache.cachelab.my_cache;


import ua.com.cache.cachelab.entity.Category;
import ua.com.cache.cachelab.entity.Rate;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("Опалення");
        category1.setDescription("Київтеплоенерго");
        category1.setImage("/static/images/category/opalennya.jpg");

        Category category2 = new Category();
        category2.setId(2L);
        category2.setName("Гаряча вода");
        category2.setDescription("ДТЕК");
        category2.setImage("/static/images/category/hotwater.jpg");

        CategoryCache cache = new CategoryCache();

        cache.getCache().put(1L, category1);
        cache.getCache().put(2L, category2);

        cache.print();

        cache.getCache().clear();

        cache.print();


        Rate rate1 = new Rate();
        rate1.setId(1L);
        rate1.setName("ДТЕК");
        rate1.setPrice(BigDecimal.valueOf(12));
        rate1.setImage("/static/images/rate/dtek.png");

        Rate rate2 = new Rate();
        rate2.setId(2L);
        rate2.setName("Нафтогаз");
        rate2.setPrice(BigDecimal.valueOf(56));
        rate2.setImage("/static/images/rate/naftogas.png");

        RateCache cache2 = new RateCache();

        cache2.getCache().put(1L, rate1);
        cache2.getCache().put(2L, rate2);

        cache2.print();

        cache2.getCache().clear();

        cache2.print();

    }
}