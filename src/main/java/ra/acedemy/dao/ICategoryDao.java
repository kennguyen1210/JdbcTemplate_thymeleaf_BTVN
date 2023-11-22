package ra.acedemy.dao;

import ra.acedemy.model.Category;

import java.util.List;
import java.util.Locale;

public interface ICategoryDao extends IGenericDao<Category,Long>{
    List<Category> findByName(String name);
}
