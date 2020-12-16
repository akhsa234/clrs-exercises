package com.bahar.blog.repository;

import com.bahar.blog.model.Comment;
import com.bahar.blog.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository  extends JpaRepository<Paper,Long> {
    void deleteById(Long id);

    Paper findPaperBodyById(Long id);

    @Query(value = "SELECT title,body FROM Paper pp WHERE pp.id = :id",nativeQuery = true)
    Paper findPaperBodyAndTitleById(@Param("id")Long id);
    //  Paper findBodyById(Long id);

 //   @Query(value = "SELECT title,body FROM Paper pp WHERE pp.id = :id",nativeQuery = true)
 //   Paper findBodyAndTitleById(@Param("id") Long id);
}

/*
@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
User findUserByStatusAndNameNamedParams(
  @Param("status") Integer status,
  @Param("name") String name);
 */