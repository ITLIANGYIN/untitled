package com.jxcia.dao.impl;

import com.jxcia.dao.AccountDao;
import com.jxcia.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
/**
 * 数据库操作
 */
public class AccountDaoImpl  implements AccountDao {
    QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {

        this.queryRunner = queryRunner;
    }
    public int addAccount(Account account) {
        try {
            queryRunner.update("insert into account values (null,?,?)",account.getName(),
                    account.getBalance());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public List<Account> findAll() {
        try{
//List<Account> lists= queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
            return queryRunner.query("select * from account",
                    new BeanListHandler<Account>(Account.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
