package com.mlxs.quartz.bean;



import javax.persistence.*;
import java.util.Date;

/**
 * TaskBean类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/15
 */
@Entity
@Table(name = "quartz_job")
public class QuartzJob {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "jobName") private String jobName;
    @Column(name = "jobGroup") private String jobGroup;
    @Column(name = "triggerName") private String triggerName;
    @Column(name = "triggerGroup") private String triggerGroup;
    @Column(name = "cronExpression") private String cronExpression;
    @Column(name = "fullClass") private String fullClass;
    @Column(name = "status") private String status;//0未运行 1运行中 2暂停中
    @Column(name = "createTime") private Date createTime;
    @Column(name = "updateTime")private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getFullClass() {
        return fullClass;
    }

    public void setFullClass(String fullClass) {
        this.fullClass = fullClass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TaskBean{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerGroup='" + triggerGroup + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
