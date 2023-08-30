package service;
import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

public class CategoryService {

    CategoryDAO categoryDao = new CategoryDAO();
    RecordDAO recordDao = new RecordDAO();

    //返回了一个按消费记录条数降序排序的消费类别表
    public List<Category> list() {
        //得到消费记录对象，并在消费记录中根据消费对象的主键查询对应的消费记录
        List<Category> cs= categoryDao.list();
        for (Category c : cs) {
            List<Record> rs =recordDao.list(c.id);
            c.recordNumber=rs.size();
        }
        Collections.sort(cs,(c1,c2)->c2.recordNumber-c1.recordNumber);

        return cs;
    }
     //更加对应的消费类别
    public void add(String name) {
        Category c = new Category();
        c.setName(name);
        categoryDao.add(c);
    }

    //更新对应的消费类别
    public void update(int id, String name) {
        Category c = new Category();
        c.setName(name);
        c.setId(id);
        categoryDao.update(c);
    }

    //删除对应的消费类别
    public void delete(int id) {
        categoryDao.delete(id);
    }

}
