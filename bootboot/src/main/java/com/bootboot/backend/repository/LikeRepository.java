package com.bootboot.backend.repository;

import com.bootboot.backend.entity.Like;
import com.bootboot.backend.entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, LikeId> {

    Optional<Like> findByIdPostIdAndIdUserId(Long postId, Long userId);

    boolean existsByIdPostIdAndIdUserId(Long postId, Long userId);

}
