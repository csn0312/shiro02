package com.zking.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dict")
public class DictController {

    @RequiresPermissions("system:dict:add")
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("msg", "dict add");
        return "msg";
    }

    @RequiresPermissions("system:dict:edit")
    @RequestMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("msg", "dict edit");
        return "msg";
    }

    @RequiresPermissions("system:dict:del")
    @RequestMapping("/del")
    public String del(Model model) {
        model.addAttribute("msg", "dict del");
        return "msg";
    }

    @RequiresPermissions("system:dict:view")
    @RequestMapping("/load")
    public String load(Model model) {
        model.addAttribute("msg", "dict load");
        return "msg";
    }

    @RequiresPermissions("system:dict:view")
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("msg", "dict list");
        return "msg";
    }

}
