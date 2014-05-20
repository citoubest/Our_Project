/**
 * 
 */
package com.thosepeople.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.UserDao;
import com.thosepeople.vo.UserInfo;

/**
 * @author chenzhuo
 * 
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	private static final BeanPropertyRowMapper<UserInfo> rowMapper = new BeanPropertyRowMapper<UserInfo>(
			UserInfo.class);
	static {
		rowMapper.setPrimitivesDefaultedForNullValue(true);
	}
	private static final String REGISTER_USER = " insert into user(realName,nickName,passWord,email) value(?,?,?,?) ";
	private static final String GET_UID = " select id from user where email=? ";

	@Override
	public int registUser(String realName, String nickName, String email,
			String passWord) {
		int updateResult = this.getJdbcTemplate().update(REGISTER_USER,
				new Object[] { realName, nickName, passWord, email });
		if (updateResult == 1) {
			List<Integer> result = this.getJdbcTemplate().queryForList(GET_UID,
					Integer.class, new Object[] { email });
			return result.get(0);
		} else {
			return -1;
		}
	}

	private static final String VERIFY_EMAIL = " select count(0) from user where email=? ";

	@Override
	public int ifEmailHasBeenRegistered(String email) {
		return this.getJdbcTemplate().queryForObject(VERIFY_EMAIL,
				new Object[] { email }, Integer.class);
	}

	private static final String GET_PASSWORD_BY_EMAIL = " select password from user where email=? limit 1 ";

	@Override
	public String getPassWordByEmail(String email) {
		List<String> result = this.getJdbcTemplate().queryForList(
				GET_PASSWORD_BY_EMAIL, String.class, new Object[] { email });
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	private static final String COMPLETE_USER_DETAIL = " insert into user_detail(uid,gender,city,school,major,"
			+ "enrollmentDate,signature,showType,company,headPicPath) value(?,?,?,?,?,?,?,?,?,?) ";

	@Override
	public int completeUserInfoDetail(int uid, boolean gender, String city,
			String school, String major, Date enrollmentDate, String signature,
			boolean showType, String company, String headPicPath) {
		return this.getJdbcTemplate().update(
				COMPLETE_USER_DETAIL,
				new Object[] { uid, gender, city, school, major,
						enrollmentDate, signature, showType, company,
						headPicPath });
	}

	@Override
	public void saveHeadPicPath(int uid, String path) {
		// TODO Auto-generated method stub

	}

	private static final String GET_USER_DETAIL = " select U.realName,U.nickName,UD.uid,UD.gender,UD.city,UD.school, "
			+ " UD.major,UD.enrollmentDate,UD.signature,UD.showType,UD.company,UD.headPicPath from"
			+ " user U,user_detail UD where U.email=? and U.id=UD.uid ";
	
	@Override
	public UserInfo getDetailUserInfo(String email) {
		List<UserInfo> result = this.getJdbcTemplate().query(GET_USER_DETAIL,
				new Object[] { email }, rowMapper);
		if (!CollectionUtils.isEmpty(result)) {
			return result.get(0);
		}
		return null;
	}

	private static final String GET_NICKNAME = " select nickName from user where id=? ";

	@Override
	public String getUserNickNameById(int id) {
		return this.getJdbcTemplate().queryForObject(GET_NICKNAME,
				new Object[] { id }, String.class);
	}
}
