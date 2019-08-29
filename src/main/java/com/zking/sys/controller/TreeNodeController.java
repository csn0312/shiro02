package com.zking.sys.controller;


import com.zking.sys.model.TreeNode;
import com.zking.sys.service.ITreeNodeService;
import com.zking.sys.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//窄化路径/treenode
@Controller
@RequestMapping("/treenode")
public class TreeNodeController {

    private TreeNode treenode=new TreeNode();

    @Autowired
    private ITreeNodeService treeNodeService;



    public TreeNodeController() {

    }


    @RequestMapping("/listall")
    @ResponseBody
    public JsonData listAll(){
        JsonData json=new JsonData();
        List<TreeNode> listAll = treeNodeService.listAll();
        Map<String,Object> map=new HashMap<String,Object>();
        json.put("data", listAll);
        return json;
    }
}
