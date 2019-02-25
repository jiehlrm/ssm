package com.how2java.test;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSMTest {

    //测试git提交项目

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void testAdd() {
        for (int i = 0; i < 100; i++) {
            Category category = new Category();
            category.setName("new Category");
            categoryMapper.add(category);
        }
    }

    @Test
    public void total() {
        int total = categoryMapper.total();
        System.out.println(total);
    }

    @Test
    public void testList() {
        Page page = new Page();
        page.setStart(2);
        page.setCount(3);
        List<Category> cs = categoryMapper.list(page);
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }
}
