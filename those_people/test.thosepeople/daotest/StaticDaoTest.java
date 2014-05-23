package daotest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thosepeople.dao.StaticsDao;
import com.thosepeople.exception.BusinessException;

/**
 * 
 * @author xuyingjie
 * 一个简单的测试类，对 StaticsDao中的方法进行了基本的测试
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/application-*.xml")
public class StaticDaoTest{

	@Autowired
	private StaticsDao staticsDao;

	@Test
	public void test() throws BusinessException
	{	
		//测试增加访问量
		
		for(int i=0;i<10;i++)
		{
			boolean flag =staticsDao.addVisit(39, 2);
			assertEquals(true,flag);
		}
		//测试getStaticsInfoByUid

//		Map<Integer,UserStaticsInfo> result= staticsDao.getStaticsInfoByUid(39);
//		assertEquals(3, result.size());
//		assertEquals("", result.get(1).getLikes());
//		staticsDao.add(39, 9, 2, "likes");
//		result= staticsDao.getStaticsInfoByUid(39);
//		assertEquals(3, result.size());
//		assertEquals("9", result.get(2).getLikes());
		
		
		//单个用户测试：uid= 38
		//点赞
//		boolean flag = staticsDao.add(38, 9, 2, "likes");
//		assertEquals(true, flag);
//		//取消赞
//		flag = staticsDao.minus(38, 9, 2, "likes");
//		assertEquals(true, flag);
//		//在未点赞的情况下取消赞
//		staticsDao.minus(38, 9, 2, "likes");

		//2.点job赞，点house赞，取消job赞，取消house赞
//		boolean flag1 = staticsDao.add(38, 9, 1, "likes");
//		boolean flag2 = staticsDao.add(38, 9, 2, "likes");
//		boolean flag3 = staticsDao.add(38, 9, 3, "likes");
//		assertEquals(true,flag1);
//		assertEquals(true,flag2);
//		assertEquals(true,flag3);
		
		//取消赞
//		boolean flag1 = staticsDao.minus(38, 9, 1, "likes");
//		assertEquals(true,flag1);	
//		boolean flag2 = staticsDao.minus(38, 9, 2, "likes");
//		assertEquals(true,flag2);
//		boolean flag3 = staticsDao.minus(38, 9, 3, "likes");
//		assertEquals(true,flag3);
		
		//3.点赞，点collect。
//		boolean flag1 = staticsDao.add(38, 9, 1, "likes");
//		assertEquals(true,flag1);	
//		boolean flag2 = staticsDao.add(38, 9, 1, "collects");
//		assertEquals(true,flag2);
//		boolean flag1 = staticsDao.add(38, 9, 1, "likes");
//		assertEquals(true,flag1);	
//		boolean flag2 = staticsDao.minus(38, 9, 1, "collects");
//		assertEquals(true,flag2);
		
		
		//测试多用户对统一文章的操作
//		boolean flag1 = staticsDao.add(38, 9, 1, "likes");
//		boolean flag2 = staticsDao.add(39, 9, 1, "likes");
//		boolean flag3 = staticsDao.add(40, 9, 1, "likes");
//		assertEquals(true,flag1);	
//		assertEquals(true,flag2);	
//		assertEquals(true,flag3);	
		
//		boolean flag1 = staticsDao.minus(38, 9, 1, "likes");
//		boolean flag2 = staticsDao.minus(39, 9, 1, "likes");
//		boolean flag3 = staticsDao.minus(40, 9, 1, "likes");
//		assertEquals(true,flag1);	
//		assertEquals(true,flag2);	
//		assertEquals(true,flag3);	
		
	}

}
