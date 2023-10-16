package skor;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SkorRepository extends JpaRepository <skor, Integer>{
    
    @Query(value = "SELECT count(*) FROM skor WHERE skor_1 IS NOT NULL",
        countQuery = "SELECT count(*) FROM skor WHERE skor_1 IS NOT NULL",
        nativeQuery = true)
    Long countproblem1 ();

    @Query(value = "SELECT count(*) FROM skor WHERE skor_2 IS NOT NULL",
        countQuery = "SELECT count(*) FROM skor WHERE skor_2 IS NOT NULL",
        nativeQuery = true)
    Long countproblem2 ();
    @Query(value = "SELECT count(*) FROM skor WHERE skor_3 IS NOT NULL",
        countQuery = "SELECT count(*) FROM skor WHERE skor_3 IS NOT NULL",
        nativeQuery = true)
    Long countproblem3 ();
}
