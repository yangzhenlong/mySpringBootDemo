package com.mlxs.quartz.dao;


import com.mlxs.quartz.bean.QuartzJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * TaskRepository类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/22
 */
public interface QuartzJobRepository extends JpaRepository<QuartzJob, String>{

    List<QuartzJob> findByStatus(String status);

    @Query(value = "select max(q.id) from quartz_job q", nativeQuery = true)
    int getMaxId();
}
