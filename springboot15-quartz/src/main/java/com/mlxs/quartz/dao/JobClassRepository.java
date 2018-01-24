package com.mlxs.quartz.dao;


import com.mlxs.quartz.bean.JobClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TaskRepository类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/22
 */
public interface JobClassRepository extends JpaRepository<JobClass, String>{
    JobClass findOneByFullClass(String fullClass);
}
