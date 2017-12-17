package hellospringboot;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class AppController {
	@Resource
	private SessionFactory factory;
	
	@RequestMapping("test")
	public void test(HttpServletResponse response){
		Session session = factory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("select * from user");
        List list = sqlQuery.list();
        System.out.printf(list.size()+"");
        try {
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"msg\":\"调用成功\"}");
        } catch (IOException e) {
            e.printStackTrace();
        }

		
	}
}
