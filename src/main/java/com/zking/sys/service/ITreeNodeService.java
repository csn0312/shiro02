package com.zking.sys.service;

import com.zking.sys.model.TreeNode;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ITreeNodeService {

    /*局部优先级更高 只读*/
    @Transactional(readOnly = true)
    public List<TreeNode> listAll();

    public void initChildren(TreeNode treeNode);

}
