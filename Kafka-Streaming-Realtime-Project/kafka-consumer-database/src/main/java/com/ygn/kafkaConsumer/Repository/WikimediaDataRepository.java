package com.ygn.kafkaConsumer.Repository;

import com.ygn.kafkaConsumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long> {
}
