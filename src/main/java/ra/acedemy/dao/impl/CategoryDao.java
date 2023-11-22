package ra.acedemy.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ra.acedemy.dao.ICategoryDao;
import ra.acedemy.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

public class CategoryDao implements ICategoryDao {


    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> findAll() {
        String sql = "select * from category";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Category c = new Category();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("name"));
            c.setDes(rs.getString("des"));
            c.setCreateDate(rs.getTimestamp("createDate").toLocalDateTime().toLocalDate());
            return c;
        });
    }

    @Override
    public Category findById(Long id) {
        String sql = "select * from category where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new BeanPropertyRowMapper<>(Category.class));
    }
    @Override
    public List<Category> findByName(String name) {
        String sql = "select * from category where name like ?";
        return jdbcTemplate.query(sql, new Object[]{"%"+name+"%"},(rs, rowNum) -> {
            Category c = new Category();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("name"));
            c.setDes(rs.getString("des"));
            c.setCreateDate(rs.getTimestamp("createDate").toLocalDateTime().toLocalDate());
            return c;
        });
    }

    @Override
    public int save(Category category) {
        String sql = "insert into category(name,des,createDate) values (?,?,?)";
        return jdbcTemplate.update(sql,category.getName(),category.getDes(), Timestamp.valueOf(category.getCreateDate().atTime(0,0,0)));
    }

    @Override
    public int update(Category category) {
        String sql = "update category set name = ? , des = ? where id =?";
        return jdbcTemplate.update(sql,category.getName(),category.getDes(),category.getId());
    }
    @Override
    public int delete(Long id) {
        String sql = "delete from category where id = ?";
        return jdbcTemplate.update(sql,id);
    }
}
