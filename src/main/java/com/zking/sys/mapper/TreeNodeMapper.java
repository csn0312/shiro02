package com.zking.sys.mapper;

import com.zking.sys.model.TreeNode;

import java.util.List;

public interface TreeNodeMapper {
    int deleteByPrimaryKey(Integer treeNodeId);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer treeNodeId);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);


    /*父节点*/
    public List<TreeNode> listAll() ;


    //根据父节点查字节点
    public List<TreeNode> initChildren(TreeNode treeNode);
}