package com.ArjunCode.reviewms.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    //If we need custom methods. we can declare it in Repository
    List<Review> findByCompanyId(Long companyId);
}
