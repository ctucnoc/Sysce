package com.sys.mype.sysce.pe.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.sys.mype.sysce.pe.model.BConsumer;
import com.sys.mype.sysce.pe.model.BModule;
import com.sys.mype.sysce.pe.model.BModuleScreen;
import com.sys.mype.sysce.pe.model.BScreen;
import com.sys.mype.sysce.pe.model.BSubsidiary;

public class GenericDAOImpl implements GenericDAO {

	final DataSource dataSource;

	public GenericDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<BModuleScreen> findByModuleScreenUser(String userId, String state) {
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List<BModuleScreen> list = null;
		try {
			list = new ArrayList<>();
			int count = 1;
			cn = dataSource.getConnection();
			cs = cn.prepareCall("{call dbasgu.sp_s_get_module_screen(?,?)}");
			cs.setString(1, userId);
			cs.setString(2, state);
			cs.execute();
			rs = cs.getResultSet();
			while (rs.next()) {
				BModule module = new BModule();
				BScreen screen = new BScreen();
				BModuleScreen moduleScreen = new BModuleScreen();
				module.setModuleId(rs.getInt("o_cd_module"));
				module.setModuleName(rs.getString("o_nm_module"));
				module.setModuleIcon(rs.getString("o_img_module"));
				module.setModuleCode(rs.getString("o_ds_mcode"));
				module.setModuleUri(rs.getString("o_ds_muri"));
				screen.setScreenId(rs.getInt("o_cd_screen"));
				screen.setScreenName(rs.getString("o_nm_screen"));
				screen.setScreenCode(rs.getString("o_ds_scode"));
				screen.setScreenIcon(rs.getString("o_img_screen"));
				screen.setScreenUri(rs.getString("o_ds_suri"));
				moduleScreen.setModuleScreenId(count);
				moduleScreen.setBScreen(screen);
				moduleScreen.setBModule(module);
				count++;
				list.add(moduleScreen);
			}
		} catch (Exception e) {
			list = null;
			System.out.println(e.getMessage());
		} finally {
			try {
				if (cs != null)
					cs.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
		return list;
	}

	@Override
	public Optional<String> GeneratedProductId(int subsidiaryId) {
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			String rpta = "";
			cn = dataSource.getConnection();
			cs = cn.prepareCall("{call sysce.sp_s_get_product_id(?)}");
			cs.setInt(1, subsidiaryId);
			cs.execute();
			rs = cs.getResultSet();
			if (rs.next()) {
				rpta = rs.getString(1);
			}
			return Optional.of(rpta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Optional.empty();
		}
	}

	@Override
	public List<BConsumer> findConsumerByKeyWord(String key_word) {
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		List<BConsumer> list = null;
		try {
			list = new ArrayList<>();
			cn = dataSource.getConnection();
			cs = cn.prepareCall("{call sysce.sp_s_get_consumer(?)}");
			cs.setString(1, key_word);
			cs.execute();
			rs = cs.getResultSet();
			while (rs.next()) {
				BConsumer bConsumer = new BConsumer();
				BSubsidiary bSubsidiary = new BSubsidiary();
				bConsumer.setConsumerId(rs.getString("o_cd_consumer"));
				bConsumer.setConsumerName(rs.getString("o_nm_consumer"));
				bConsumer.setConsumerAmountVisit(rs.getInt("o_qt_visit"));
				bConsumer.setConsumerLastName(rs.getString("o_nm_last"));
				bConsumer.setConsumerMail(rs.getString("o_ds_mail"));
				bConsumer.setConsumerDirection(rs.getString("o_ds_direction"));
				bConsumer.setConsumerCell(rs.getString("o_nr_cell"));
				bConsumer.setConsumerBirthday(rs.getDate("o_dt_birthday"));
				bSubsidiary.setSubsidiaryId(rs.getInt("o_cd_subsidiary"));
				bSubsidiary.setSubsidiaryName(rs.getString("o_nm_subsidiary"));
				bConsumer.setBSubsidiary(bSubsidiary);
				list.add(bConsumer);
			}

		} catch (Exception e) {
			list = null;
			System.out.println(e.getMessage());
		} finally {
			try {
				if (cs != null)
					cs.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
		return list;
	}

	@Override
	public Optional<String> GeneratedConsumerId(int subsidiaryId) {
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			String rpta = "";
			cn = dataSource.getConnection();
			cs = cn.prepareCall("{call sysce.sp_s_get_consumer_id(?)}");
			cs.setInt(1, subsidiaryId);
			cs.execute();
			rs = cs.getResultSet();
			if (rs.next()) {
				rpta = rs.getString(1);
			}
			return Optional.of(rpta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Optional.empty();
		}
	}

	@Override
	public Optional<String> GeneratedOrderId(int subsidiaryId) {
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			String rpta = "";
			cn = dataSource.getConnection();
			cs = cn.prepareCall("{call sysce.sp_s_get_order_id(?)}");
			cs.setInt(1, subsidiaryId);
			cs.execute();
			rs = cs.getResultSet();
			if (rs.next()) {
				rpta = rs.getString(1);
			}
			return Optional.of(rpta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Optional.empty();
		}
	}

}
