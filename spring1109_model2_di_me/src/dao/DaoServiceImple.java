package dao;

import java.sql.SQLException;

import vo.MjoinVO;

public class DaoServiceImple implements DaoService {

	@Override
	public void transactionTest(MjoinVO vo) throws SQLException {
		System.out.println(vo.getId()+"등을 입력처리합니다.");
		
	}

}
