package com.example.demo.source;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class Dao {

	private DataSource dataSource = MyDataSource.getDataSource();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	public List<Model> findAll() {

		List<Model> result = jdbcTemplate.query("select title,c_id,description,ref_link from kmbuzz.blog_details",
				(rs, rowNum) -> new Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
// 		List<Model> result = jdbcTemplate.query(
//                "SELECT user_id,user_name,password FROM public.admin_profile",
//                (rs, rowNum) -> new Model(rs.getInt("user_id"),
//                        rs.getString("user_name"), rs.getString("password"))
//        );

		return result;

	}
}
