package com.vue.service;

import com.vue.mapper.VueMapper;
import com.vue.model.Vue;
import com.vue.model.VueExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    @Autowired
    VueMapper vueMapper;

    public List<Vue> list() {
        VueExample vueExample = new VueExample();
        List<Vue> vues = vueMapper.selectByExample(vueExample);
        for (Vue vue : vues) {
            System.out.println(vue.toString());
        }
        return vues;
    }

    public void insert(Vue vue) {
        vueMapper.insert(vue);
    }

    public void update(Vue vueUpdate) {
        vueMapper.updateByPrimaryKeySelective(vueUpdate);
    }

    public void delete(Integer id) {
        vueMapper.deleteByPrimaryKey(id);
    }
}
