DROP DATABASE IF EXISTS test_quartz;
CREATE DATABASE test_quartz DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE test_quartz;

/**create table quartz_job**/
CREATE TABLE `quartz_job` (
   `id` varchar(16) NOT NULL,
   `create_time` datetime DEFAULT NULL,
   `cron_expression` varchar(255) DEFAULT NULL,
   `full_class` varchar(255) DEFAULT NULL,
   `job_group` varchar(255) DEFAULT NULL,
   `job_name` varchar(255) DEFAULT NULL,
   `trigger_group` varchar(255) DEFAULT NULL,
   `trigger_name` varchar(255) DEFAULT NULL,
   `update_time` datetime DEFAULT NULL,
   `status` varchar(2) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/**create table job_class**/
create table
CREATE TABLE `job_class` (
   `id` varchar(16) NOT NULL,
   `full_class` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;