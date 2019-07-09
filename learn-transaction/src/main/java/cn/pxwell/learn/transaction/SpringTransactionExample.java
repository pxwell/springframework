package cn.pxwell.learn.transaction;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SpringTransactionExample {


	private static String url = "jdbc:mysql://127.0.0.1:3306/test";
	private static String user = "root";
	private static String password = "123456";

	private static  String driver="com.mysql.jdbc.Driver";

	public static void main(String[] args) {

		//获取数据源
		final DataSource ds =new DriverManagerDataSource(url,user,password);
		((DriverManagerDataSource) ds).setDriverClassName( driver );
		//编程式事务
		final TransactionTemplate template = new TransactionTemplate();
		//设置事务管理器
		template.setTransactionManager( new DataSourceTransactionManager( ds ) );

		template.execute( (status)-> {
				Connection conn = DataSourceUtils.getConnection( ds );

				Object savePoint = null;

				try {
					{
						PreparedStatement preparedStatement = conn.prepareStatement(
								"insert into account(name,sale) values (?,?)" );
						preparedStatement.setString( 1, "aaa" );
						preparedStatement.setDouble( 2, 1000 );
						preparedStatement.execute();
					}
					savePoint = status.createSavepoint();

					{
						PreparedStatement preparedStatement = conn.prepareStatement(
								"insert into account(name,sale) values (?,?)" );
						preparedStatement.setString( 1, "bbb" );
						preparedStatement.setDouble( 2, 1001 );
						preparedStatement.execute();
					}

					{
						PreparedStatement preparedStatement = conn.prepareStatement(
								"update  account set sale=sale+1 where name=?" );
						preparedStatement.setString( 1, "bbb" );
						preparedStatement.execute();
						int i = 1/0;
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e){
					System.out.println( "======更新失败=======" );
					if(savePoint==null){
						status.rollbackToSavepoint( savePoint );
					}else {
						status.isRollbackOnly();
					}
				}


				return null;
			}
		 );



	}
}
