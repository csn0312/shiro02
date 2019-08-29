package com.zking.sys.service.impl;

import com.zking.sys.mapper.TreeNodeMapper;
import com.zking.sys.model.TreeNode;
import com.zking.sys.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//将业务逻辑丢到上下文
@Service

/*protetype多例模式  默认singleton*/
@Scope("prototype")
public class ITreeNodeServiceImpl implements ITreeNodeService {

    @Autowired
    private TreeNodeMapper treeNodeMapper;


    /**
     * 查询父节点为空的节点（树节点）  调用initChildren查相应叶节点
     */
    @Override
    public List<TreeNode> listAll() {
        //String hql = "from TreeNode n where n. parentNodeId is null order by n.position";// 查一级节点，根节点
        //List<TreeNode> rootList = this.excuteQuery(hql, null, null);

        List<TreeNode>rootList = treeNodeMapper.listAll();

        for (TreeNode n : rootList) {
            this.initChildren(n);
        }

        return rootList;
    }

    //根据父节点查叶节点 二级菜单
    @Override

    public void initChildren(TreeNode treeNode) {
       // String hql = "from TreeNode n where n. parentNodeId =:pid  order by n. position";
        //Map<String, Object> args = new HashMap<String, Object>();

        //args.put("pid", treeNode.getTreeNodeId());
//this.excuteQuery(hql, args, null);
       List<TreeNode> children =treeNodeMapper.initChildren(treeNode);

        treeNode.setChildNodes(children);
		/*
		 * for(TreeNode n:children) {//递归加载子节点 this.initChildren(n); }
		 */
    }
}
