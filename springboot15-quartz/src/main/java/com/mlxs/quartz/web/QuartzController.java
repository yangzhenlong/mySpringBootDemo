package com.mlxs.quartz.web;


import com.mlxs.quartz.bean.JobClass;
import com.mlxs.quartz.bean.QuartzJob;
import com.mlxs.quartz.config.QuartzManager;
import com.mlxs.quartz.service.QuartzJobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * QuartzResource类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/15
 */
@Controller
public class QuartzController {

    @Autowired
    private QuartzJobService quartzJobService;

    @RequestMapping(value = {"/", "/index"})
    public String index(ModelMap modelMap){
        modelMap.addAttribute("hello", "欢迎来到SpringBootQuartzDemo");
        modelMap.addAttribute("href_quartzList", "/quartz/list");
        return "index";
    }

    @RequestMapping("/quartz/list")
    public String list(ModelMap modelMap){
        modelMap.addAttribute("allJob", quartzJobService.getAllJob());
        return "quartz/list";
    }

    @RequestMapping("/quartz/classList")
    @ResponseBody
    public List<JobClass> classList(){
        return quartzJobService.getAllClass();
    }

    @RequestMapping("/quartz/addClass")
    @ResponseBody
    public Result addClass(String className){
        return quartzJobService.addJobClass(className);
    }

    @RequestMapping("/quartz/add")
    public String add(QuartzJob quartzJob){
        Result result = quartzJobService.addJob(quartzJob);
        return "redirect:/quartz/list";
    }

    @RequestMapping("/quartz/start/{id}")
    @ResponseBody
    public Result startJob(@PathVariable String id) throws SchedulerException {
        return quartzJobService.startJob(id);
    }

    @RequestMapping("/quartz/pause/{id}")
    @ResponseBody
    public Result pauseJob(@PathVariable String id) throws SchedulerException {
        return quartzJobService.pauseJob(id);
    }

    @RequestMapping("/quartz/resume/{id}")
    @ResponseBody
    public Result resumeJob(@PathVariable String id) throws SchedulerException {
        return quartzJobService.resumeJob(id);
    }

    @RequestMapping("/quartz/updateCron")
    public String updateJobCron(String id, String cron) throws SchedulerException {
        quartzJobService.updateJobCron(id, cron);
        return "redirect:/quartz/list";
    }
    @RequestMapping("/quartz/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable String id) throws SchedulerException {
        return quartzJobService.delete(id);
    }

}
