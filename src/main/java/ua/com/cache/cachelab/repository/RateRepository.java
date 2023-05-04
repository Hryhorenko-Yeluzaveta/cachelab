package ua.com.cache.cachelab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.cache.cachelab.entity.Rate;


@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

}
