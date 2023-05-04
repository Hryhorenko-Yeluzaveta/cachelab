package ua.com.cache.cachelab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.cache.cachelab.entity.Category;
import ua.com.cache.cachelab.entity.Rate;
import ua.com.cache.cachelab.repository.RateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RateService {

    public static final String KEY = "cacheKey";
    private final RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    //    @Cacheable("rate")
    @CacheEvict(cacheNames = "dog", key = "#root.target.KEY")
    public void saveNewRate(Rate rate) {
        rateRepository.save(rate);
    }


    @Cacheable(value = "dog", key = "#root.target.KEY")
    public List<Rate> getAllRate() {
        return rateRepository.findAll();
    }

    @Cacheable(cacheNames = "rate", key = "#id")
    public Rate findRateById(Long id) {
        Optional<Rate> rate = rateRepository.findById(id);

        if (rate.isPresent()) {
            return rate.get();
        } else {
            return rate.orElseThrow();
        }

    }

    @CacheEvict(cacheNames = "dog", key = "#root.target.KEY")
    public void updateRate(Rate rate) {
        rateRepository.save(rate);
    }


    @CacheEvict(cacheNames = "dog", key = "#root.target.KEY")
    public void deleteRate(Long id) {
        rateRepository.deleteById(id);
    }



}
